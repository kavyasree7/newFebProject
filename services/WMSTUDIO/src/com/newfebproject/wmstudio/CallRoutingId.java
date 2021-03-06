/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class CallRoutingId implements Serializable {

    private Double id;
    private Double categoryId;
    private String categoryDefault;
    private String keyName;
    private Double routingPointId;
    private String buId;
    private String description;
    private Double lastModifiedUserId;
    private Double vqCategoryId;
    private Double skillId;

    public Double getId() {
        return this.id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Double categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryDefault() {
        return this.categoryDefault;
    }

    public void setCategoryDefault(String categoryDefault) {
        this.categoryDefault = categoryDefault;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Double getRoutingPointId() {
        return this.routingPointId;
    }

    public void setRoutingPointId(Double routingPointId) {
        this.routingPointId = routingPointId;
    }

    public String getBuId() {
        return this.buId;
    }

    public void setBuId(String buId) {
        this.buId = buId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLastModifiedUserId() {
        return this.lastModifiedUserId;
    }

    public void setLastModifiedUserId(Double lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }

    public Double getVqCategoryId() {
        return this.vqCategoryId;
    }

    public void setVqCategoryId(Double vqCategoryId) {
        this.vqCategoryId = vqCategoryId;
    }

    public Double getSkillId() {
        return this.skillId;
    }

    public void setSkillId(Double skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CallRouting)) return false;
        final CallRouting callRouting = (CallRouting) o;
        return Objects.equals(getId(), callRouting.getId()) &&
                Objects.equals(getCategoryId(), callRouting.getCategoryId()) &&
                Objects.equals(getCategoryDefault(), callRouting.getCategoryDefault()) &&
                Objects.equals(getKeyName(), callRouting.getKeyName()) &&
                Objects.equals(getRoutingPointId(), callRouting.getRoutingPointId()) &&
                Objects.equals(getBuId(), callRouting.getBuId()) &&
                Objects.equals(getDescription(), callRouting.getDescription()) &&
                Objects.equals(getLastModifiedUserId(), callRouting.getLastModifiedUserId()) &&
                Objects.equals(getVqCategoryId(), callRouting.getVqCategoryId()) &&
                Objects.equals(getSkillId(), callRouting.getSkillId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getCategoryId(),
                getCategoryDefault(),
                getKeyName(),
                getRoutingPointId(),
                getBuId(),
                getDescription(),
                getLastModifiedUserId(),
                getVqCategoryId(),
                getSkillId());
    }
}
