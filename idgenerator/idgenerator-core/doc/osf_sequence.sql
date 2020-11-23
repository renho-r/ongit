CREATE TABLE `osf_sequence`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `start` bigint(255) NULL DEFAULT NULL,
  `increment` bigint(255) NULL DEFAULT NULL,
  `max` bigint(255) NULL DEFAULT NULL,
  `current` bigint(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_name`(`name`) USING BTREE
) ENGINE = InnoDB;