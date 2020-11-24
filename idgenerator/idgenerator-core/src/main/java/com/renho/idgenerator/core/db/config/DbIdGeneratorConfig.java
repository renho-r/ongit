package com.renho.idgenerator.core.db.config;

/**
 * @author renho
 * @date 2020/10/26
 */
public class DbIdGeneratorConfig {

    private String sequenceName;
    private Long start;
    private Integer increment;
    private Long max;

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }
}
