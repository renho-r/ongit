package com.renho;

import javax.persistence.*;

/**
 * @author renho
 * @since: 2017/8/20
 */
@Entity
@Table(name = "com_user", schema = "aiddos", catalog = "")
public class ComUserEntity {
    private int userid;
    private String loginname;
    private String loginpwd;
    private String username;
    private String email;
    private String fixedphone;
    private String mobilephone;
    private String userdesc;
    private Integer expired;
    private String fromaddr;
    private String domainCode;
    private Integer locked;
    private Integer modifytime;
    private Integer lastlogin;
    private String department;
    private String jobno;
    private String duty;

    @Id
    @Column(name = "USERID")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "LOGINNAME")
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Basic
    @Column(name = "LOGINPWD")
    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "FIXEDPHONE")
    public String getFixedphone() {
        return fixedphone;
    }

    public void setFixedphone(String fixedphone) {
        this.fixedphone = fixedphone;
    }

    @Basic
    @Column(name = "MOBILEPHONE")
    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    @Basic
    @Column(name = "USERDESC")
    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc;
    }

    @Basic
    @Column(name = "EXPIRED")
    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    @Basic
    @Column(name = "FROMADDR")
    public String getFromaddr() {
        return fromaddr;
    }

    public void setFromaddr(String fromaddr) {
        this.fromaddr = fromaddr;
    }

    @Basic
    @Column(name = "DOMAIN_CODE")
    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    @Basic
    @Column(name = "LOCKED")
    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    @Basic
    @Column(name = "MODIFYTIME")
    public Integer getModifytime() {
        return modifytime;
    }

    public void setModifytime(Integer modifytime) {
        this.modifytime = modifytime;
    }

    @Basic
    @Column(name = "LASTLOGIN")
    public Integer getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Integer lastlogin) {
        this.lastlogin = lastlogin;
    }

    @Basic
    @Column(name = "DEPARTMENT")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "JOBNO")
    public String getJobno() {
        return jobno;
    }

    public void setJobno(String jobno) {
        this.jobno = jobno;
    }

    @Basic
    @Column(name = "DUTY")
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComUserEntity that = (ComUserEntity) o;

        if (userid != that.userid) return false;
        if (loginname != null ? !loginname.equals(that.loginname) : that.loginname != null) return false;
        if (loginpwd != null ? !loginpwd.equals(that.loginpwd) : that.loginpwd != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fixedphone != null ? !fixedphone.equals(that.fixedphone) : that.fixedphone != null) return false;
        if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
        if (userdesc != null ? !userdesc.equals(that.userdesc) : that.userdesc != null) return false;
        if (expired != null ? !expired.equals(that.expired) : that.expired != null) return false;
        if (fromaddr != null ? !fromaddr.equals(that.fromaddr) : that.fromaddr != null) return false;
        if (domainCode != null ? !domainCode.equals(that.domainCode) : that.domainCode != null) return false;
        if (locked != null ? !locked.equals(that.locked) : that.locked != null) return false;
        if (modifytime != null ? !modifytime.equals(that.modifytime) : that.modifytime != null) return false;
        if (lastlogin != null ? !lastlogin.equals(that.lastlogin) : that.lastlogin != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (jobno != null ? !jobno.equals(that.jobno) : that.jobno != null) return false;
        if (duty != null ? !duty.equals(that.duty) : that.duty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (loginname != null ? loginname.hashCode() : 0);
        result = 31 * result + (loginpwd != null ? loginpwd.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fixedphone != null ? fixedphone.hashCode() : 0);
        result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
        result = 31 * result + (userdesc != null ? userdesc.hashCode() : 0);
        result = 31 * result + (expired != null ? expired.hashCode() : 0);
        result = 31 * result + (fromaddr != null ? fromaddr.hashCode() : 0);
        result = 31 * result + (domainCode != null ? domainCode.hashCode() : 0);
        result = 31 * result + (locked != null ? locked.hashCode() : 0);
        result = 31 * result + (modifytime != null ? modifytime.hashCode() : 0);
        result = 31 * result + (lastlogin != null ? lastlogin.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (jobno != null ? jobno.hashCode() : 0);
        result = 31 * result + (duty != null ? duty.hashCode() : 0);
        return result;
    }
}
