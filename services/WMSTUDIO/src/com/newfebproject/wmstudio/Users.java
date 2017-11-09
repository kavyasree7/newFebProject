/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Users generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`USERS`")
public class Users implements Serializable {

    private Integer userid;
    private String uusername;
    private String password;
    private String role;
    private JoiningDetails joiningDetails;
    private List<SalaryDetails> salaryDetailses;
    private List<UserDetails> userDetailses;

    @Id
    @Column(name = "`USERID`", nullable = false, scale = 0, precision = 8)
    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Column(name = "`UUSERNAME`", nullable = true, length = 9)
    public String getUusername() {
        return this.uusername;
    }

    public void setUusername(String uusername) {
        this.uusername = uusername;
    }

    @Column(name = "`PASSWORD`", nullable = true, length = 20)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "`ROLE`", nullable = true, length = 1)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "users")
    public JoiningDetails getJoiningDetails() {
        return this.joiningDetails;
    }

    public void setJoiningDetails(JoiningDetails joiningDetails) {
        this.joiningDetails = joiningDetails;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<SalaryDetails> getSalaryDetailses() {
        return this.salaryDetailses;
    }

    public void setSalaryDetailses(List<SalaryDetails> salaryDetailses) {
        this.salaryDetailses = salaryDetailses;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<UserDetails> getUserDetailses() {
        return this.userDetailses;
    }

    public void setUserDetailses(List<UserDetails> userDetailses) {
        this.userDetailses = userDetailses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        final Users users = (Users) o;
        return Objects.equals(getUserid(), users.getUserid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid());
    }
}
