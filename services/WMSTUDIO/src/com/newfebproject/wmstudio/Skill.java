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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Skill generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SKILL`")
public class Skill implements Serializable {

    private Double id;
    private double cfgSkillId;
    private String code;
    private Double lastModifiedUserId;
    private CfgSkill1 cfgSkill1;
    private List<Callrouting> callroutings;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 2, precision = 19)
    public Double getId() {
        return this.id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    @Column(name = "`CFG_SKILL_ID`", nullable = false, scale = 2, precision = 19)
    public double getCfgSkillId() {
        return this.cfgSkillId;
    }

    public void setCfgSkillId(double cfgSkillId) {
        this.cfgSkillId = cfgSkillId;
    }

    @Column(name = "`CODE`", nullable = true, length = 4)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "`LAST_MODIFIED_USER_ID`", nullable = true, scale = 2, precision = 19)
    public Double getLastModifiedUserId() {
        return this.lastModifiedUserId;
    }

    public void setLastModifiedUserId(Double lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }

    
    
    public CfgSkill1 getCfgSkill1() {
        return this.cfgSkill1;
    }

    public void setCfgSkill1(CfgSkill1 cfgSkill1) {
        if(cfgSkill1 != null) {
            this.cfgSkillId = cfgSkill1.getId();
        }

        this.cfgSkill1 = cfgSkill1;
    }

    @JsonInclude(Include.NON_EMPTY)
    
    public List<Callrouting> getCallroutings() {
        return this.callroutings;
    }

    public void setCallroutings(List<Callrouting> callroutings) {
        this.callroutings = callroutings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        final Skill skill = (Skill) o;
        return Objects.equals(getId(), skill.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

