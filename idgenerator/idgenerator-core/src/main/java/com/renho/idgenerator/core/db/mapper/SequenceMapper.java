package com.renho.idgenerator.core.db.mapper;

import com.renho.idgenerator.core.db.entity.po.Sequence;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author renho
 * @date 2020/10/26
 */
@Mapper
public interface SequenceMapper {

    /**
     * selectByName
     * @param name
     * @return
     */
    @Select("SELECT id, name, start, increment, max, current FROM sys_sequence WHERE name = #{name} FOR UPDATE")
    Sequence selectByName(String name);

    /**
     * insertSeq
     * @param sequence
     * @return
     */
    @Insert("INSERT INTO sys_sequence(name, start, increment, max, current) VALUES (#{name}, #{start}, #{increment}, #{max}, #{current})")
    Integer insertSequence(Sequence sequence);

    /**
     * updateCurrent
     * @param dbSequence
     */
    @Update("UPDATE sys_sequence SET current = ${current} WHERE name = #{name}")
    void updateCurrent(Sequence dbSequence);

    /**
     * createTable
     * @param dbSequence
     */
    @Insert("CREATE TABLE `sys_sequence`  (\n" +
            "  `id` bigint(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,\n" +
            "  `start` bigint(255) NULL DEFAULT NULL,\n" +
            "  `increment` bigint(255) NULL DEFAULT NULL,\n" +
            "  `max` bigint(255) NULL DEFAULT NULL,\n" +
            "  `current` bigint(255) NULL DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`) USING BTREE,\n" +
            "  UNIQUE INDEX `uni_name`(`name`) USING BTREE\n" +
            ") ENGINE = InnoDB")
    void createTable(Sequence dbSequence);
}
