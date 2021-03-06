/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table8big123 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE8BIG123`")
public class Table8big123 implements Serializable {

    private BigInteger id;
    private String column2;
    private String column3;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 38)
    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table8big123)) return false;
        final Table8big123 table8big123 = (Table8big123) o;
        return Objects.equals(getId(), table8big123.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

