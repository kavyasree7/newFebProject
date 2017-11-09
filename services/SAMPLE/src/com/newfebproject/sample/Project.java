/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Project generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PROJECT`")
public class Project implements Serializable {

    private String projno;
    private String projname;
    private String deptno;
    private String respemp;
    private Float prstaff;
    private Date prstdate;
    private Date prendate;
    private String majproj;
    private List<Projact> projacts;
    private Department department;
    private Employee employee;
    private Project projectByMajproj;
    private List<Project> projectsForMajproj;

    @Id
    @Column(name = "`PROJNO`", nullable = false, length = 6)
    public String getProjno() {
        return this.projno;
    }

    public void setProjno(String projno) {
        this.projno = projno;
    }

    @Column(name = "`PROJNAME`", nullable = false, length = 24)
    public String getProjname() {
        return this.projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    @Column(name = "`DEPTNO`", nullable = false, length = 3)
    public String getDeptno() {
        return this.deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    @Column(name = "`RESPEMP`", nullable = false, length = 6)
    public String getRespemp() {
        return this.respemp;
    }

    public void setRespemp(String respemp) {
        this.respemp = respemp;
    }

    @Column(name = "`PRSTAFF`", nullable = true, scale = 2, precision = 5)
    public Float getPrstaff() {
        return this.prstaff;
    }

    public void setPrstaff(Float prstaff) {
        this.prstaff = prstaff;
    }

    @Column(name = "`PRSTDATE`", nullable = true)
    public Date getPrstdate() {
        return this.prstdate;
    }

    public void setPrstdate(Date prstdate) {
        this.prstdate = prstdate;
    }

    @Column(name = "`PRENDATE`", nullable = true)
    public Date getPrendate() {
        return this.prendate;
    }

    public void setPrendate(Date prendate) {
        this.prendate = prendate;
    }

    @Column(name = "`MAJPROJ`", nullable = true, length = 6)
    public String getMajproj() {
        return this.majproj;
    }

    public void setMajproj(String majproj) {
        this.majproj = majproj;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Projact> getProjacts() {
        return this.projacts;
    }

    public void setProjacts(List<Projact> projacts) {
        this.projacts = projacts;
    }

    
    
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        if(department != null) {
            this.deptno = department.getDeptno();
        }

        this.department = department;
    }

    
    
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        if(employee != null) {
            this.respemp = employee.getEmpno();
        }

        this.employee = employee;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"projectByMajproj", "projectsForMajproj"})
    
    
    public Project getProjectByMajproj() {
        return this.projectByMajproj;
    }

    public void setProjectByMajproj(Project projectByMajproj) {
        if(projectByMajproj != null) {
            this.majproj = projectByMajproj.getProjno();
        }

        this.projectByMajproj = projectByMajproj;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"projectByMajproj", "projectsForMajproj"})
    @JsonInclude(Include.NON_EMPTY)
    
    public List<Project> getProjectsForMajproj() {
        return this.projectsForMajproj;
    }

    public void setProjectsForMajproj(List<Project> projectsForMajproj) {
        this.projectsForMajproj = projectsForMajproj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        final Project project = (Project) o;
        return Objects.equals(getProjno(), project.getProjno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjno());
    }
}
