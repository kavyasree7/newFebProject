/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Vempdpt1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`VEMPDPT1`")
@IdClass(Vempdpt1Id.class)
public class Vempdpt1 implements Serializable {

    private String deptno;
    private String deptname;
    private String empno;
    private String frstinit;
    private String midinit;
    private String lastname;
    private String workdept;

    @Id
    @Column(name = "`DEPTNO`", nullable = true, length = 3)
    public String getDeptno() {
        return this.deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    @Id
    @Column(name = "`DEPTNAME`", nullable = true, length = 36)
    public String getDeptname() {
        return this.deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Id
    @Column(name = "`EMPNO`", nullable = false, length = 6)
    public String getEmpno() {
        return this.empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    @Id
    @Column(name = "`FRSTINIT`", nullable = false, length = 1)
    public String getFrstinit() {
        return this.frstinit;
    }

    public void setFrstinit(String frstinit) {
        this.frstinit = frstinit;
    }

    @Id
    @Column(name = "`MIDINIT`", nullable = true, length = 1)
    public String getMidinit() {
        return this.midinit;
    }

    public void setMidinit(String midinit) {
        this.midinit = midinit;
    }

    @Id
    @Column(name = "`LASTNAME`", nullable = false, length = 15)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Id
    @Column(name = "`WORKDEPT`", nullable = true, length = 3)
    public String getWorkdept() {
        return this.workdept;
    }

    public void setWorkdept(String workdept) {
        this.workdept = workdept;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vempdpt1)) return false;
        final Vempdpt1 vempdpt1 = (Vempdpt1) o;
        return Objects.equals(getDeptno(), vempdpt1.getDeptno()) &&
                Objects.equals(getDeptname(), vempdpt1.getDeptname()) &&
                Objects.equals(getEmpno(), vempdpt1.getEmpno()) &&
                Objects.equals(getFrstinit(), vempdpt1.getFrstinit()) &&
                Objects.equals(getMidinit(), vempdpt1.getMidinit()) &&
                Objects.equals(getLastname(), vempdpt1.getLastname()) &&
                Objects.equals(getWorkdept(), vempdpt1.getWorkdept());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeptno(),
                getDeptname(),
                getEmpno(),
                getFrstinit(),
                getMidinit(),
                getLastname(),
                getWorkdept());
    }
}
