/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class StaffgId implements Serializable {

    private Short id;
    private String name;
    private Short dept;
    private String job;
    private Short years;
    private Integer salary;
    private Integer comm;

    public Short getId() {
        return this.id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getDept() {
        return this.dept;
    }

    public void setDept(Short dept) {
        this.dept = dept;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Short getYears() {
        return this.years;
    }

    public void setYears(Short years) {
        this.years = years;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getComm() {
        return this.comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staffg)) return false;
        final Staffg staffg = (Staffg) o;
        return Objects.equals(getId(), staffg.getId()) &&
                Objects.equals(getName(), staffg.getName()) &&
                Objects.equals(getDept(), staffg.getDept()) &&
                Objects.equals(getJob(), staffg.getJob()) &&
                Objects.equals(getYears(), staffg.getYears()) &&
                Objects.equals(getSalary(), staffg.getSalary()) &&
                Objects.equals(getComm(), staffg.getComm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getName(),
                getDept(),
                getJob(),
                getYears(),
                getSalary(),
                getComm());
    }
}
