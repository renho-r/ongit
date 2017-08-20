package com.renho;

import javax.persistence.*;

/**
 * @author renho
 * @since: 2017/8/20
 */
@Entity
@Table(name = "com_res", schema = "aiddos", catalog = "")
public class ComResEntity {
    private int id;
    private String name;
    private String typeCode;
    private Integer resStatus;
    private String specInfo;
    private String domainCode;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "TYPE_CODE")
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Basic
    @Column(name = "RES_STATUS")
    public Integer getResStatus() {
        return resStatus;
    }

    public void setResStatus(Integer resStatus) {
        this.resStatus = resStatus;
    }

    @Basic
    @Column(name = "SPEC_INFO")
    public String getSpecInfo() {
        return specInfo;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo;
    }

    @Basic
    @Column(name = "domain_code")
    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComResEntity that = (ComResEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (typeCode != null ? !typeCode.equals(that.typeCode) : that.typeCode != null) return false;
        if (resStatus != null ? !resStatus.equals(that.resStatus) : that.resStatus != null) return false;
        if (specInfo != null ? !specInfo.equals(that.specInfo) : that.specInfo != null) return false;
        if (domainCode != null ? !domainCode.equals(that.domainCode) : that.domainCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (typeCode != null ? typeCode.hashCode() : 0);
        result = 31 * result + (resStatus != null ? resStatus.hashCode() : 0);
        result = 31 * result + (specInfo != null ? specInfo.hashCode() : 0);
        result = 31 * result + (domainCode != null ? domainCode.hashCode() : 0);
        return result;
    }
}
