/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Vproj generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`VPROJ`")
@IdClass(VprojId.class)
public class Vproj implements Serializable {

    private String projno;
    private String projname;
    private String deptno;
    private String respemp;
    private Float prstaff;
    private Date prstdate;
    private Date prendate;
    private String majproj;

    @Id
    @Column(name = "`PROJNO`", nullable = false, length = 6)
    public String getProjno() {
        return this.projno;
    }

    public void setProjno(String projno) {
        this.projno = projno;
    }

    @Id
    @Column(name = "`PROJNAME`", nullable = false, length = 24)
    public String getProjname() {
        return this.projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    @Id
    @Column(name = "`DEPTNO`", nullable = false, length = 3)
    public String getDeptno() {
        return this.deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    @Id
    @Column(name = "`RESPEMP`", nullable = false, length = 6)
    public String getRespemp() {
        return this.respemp;
    }

    public void setRespemp(String respemp) {
        this.respemp = respemp;
    }

    @Id
    @Column(name = "`PRSTAFF`", nullable = true, scale = 2, precision = 5)
    public Float getPrstaff() {
        return this.prstaff;
    }

    public void setPrstaff(Float prstaff) {
        this.prstaff = prstaff;
    }

    @Id
    @Column(name = "`PRSTDATE`", nullable = true)
    public Date getPrstdate() {
        return this.prstdate;
    }

    public void setPrstdate(Date prstdate) {
        this.prstdate = prstdate;
    }

    @Id
    @Column(name = "`PRENDATE`", nullable = true)
    public Date getPrendate() {
        return this.prendate;
    }

    public void setPrendate(Date prendate) {
        this.prendate = prendate;
    }

    @Id
    @Column(name = "`MAJPROJ`", nullable = true, length = 6)
    public String getMajproj() {
        return this.majproj;
    }

    public void setMajproj(String majproj) {
        this.majproj = majproj;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vproj)) return false;
        final Vproj vproj = (Vproj) o;
        return Objects.equals(getProjno(), vproj.getProjno()) &&
                Objects.equals(getProjname(), vproj.getProjname()) &&
                Objects.equals(getDeptno(), vproj.getDeptno()) &&
                Objects.equals(getRespemp(), vproj.getRespemp()) &&
                Objects.equals(getPrstaff(), vproj.getPrstaff()) &&
                Objects.equals(getPrstdate(), vproj.getPrstdate()) &&
                Objects.equals(getPrendate(), vproj.getPrendate()) &&
                Objects.equals(getMajproj(), vproj.getMajproj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjno(),
                getProjname(),
                getDeptno(),
                getRespemp(),
                getPrstaff(),
                getPrstdate(),
                getPrendate(),
                getMajproj());
    }
}

