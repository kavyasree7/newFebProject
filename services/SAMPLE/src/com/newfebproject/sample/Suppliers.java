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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Suppliers generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SUPPLIERS`")
public class Suppliers implements Serializable {

    private String sid;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] addr;

    @Id
    @Column(name = "`SID`", nullable = false, length = 10)
    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Column(name = "`ADDR`", nullable = true)
    public byte[] getAddr() {
        return this.addr;
    }

    public void setAddr(byte[] addr) {
        this.addr = addr;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Suppliers)) return false;
        final Suppliers suppliers = (Suppliers) o;
        return Objects.equals(getSid(), suppliers.getSid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSid());
    }
}

