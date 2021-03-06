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
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Noprecision generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`NOPRECISION`")
@IdClass(NoprecisionId.class)
public class Noprecision implements Serializable {

    private BigInteger noprecision;
    private String stringColumn;

    @Id
    @Column(name = "`NOPRECISION`", nullable = true, scale = 0, precision = 38)
    public BigInteger getNoprecision() {
        return this.noprecision;
    }

    public void setNoprecision(BigInteger noprecision) {
        this.noprecision = noprecision;
    }

    @Id
    @Column(name = "`STRING COLUMN`", nullable = false, length = 20)
    public String getStringColumn() {
        return this.stringColumn;
    }

    public void setStringColumn(String stringColumn) {
        this.stringColumn = stringColumn;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Noprecision)) return false;
        final Noprecision noprecisionInstance = (Noprecision) o;
        return Objects.equals(getNoprecision(), noprecisionInstance.getNoprecision()) &&
                Objects.equals(getStringColumn(), noprecisionInstance.getStringColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNoprecision(),
                getStringColumn());
    }
}

