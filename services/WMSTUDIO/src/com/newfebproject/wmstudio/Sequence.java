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
 * Sequence generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Sequence`")
@IdClass(SequenceId.class)
public class Sequence implements Serializable {

    private String column1;
    private BigInteger shortColumn;
    private BigInteger bigintegerColumn;

    @Id
    @Column(name = "`COLUMN1`", nullable = true, length = 20)
    public String getColumn1() {
        return this.column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    @Id
    @Column(name = "`SHORT COLUMN`", nullable = true, scale = 0, precision = 38)
    public BigInteger getShortColumn() {
        return this.shortColumn;
    }

    public void setShortColumn(BigInteger shortColumn) {
        this.shortColumn = shortColumn;
    }

    @Id
    @Column(name = "`BIGINTEGER COLUMN`", nullable = true, scale = 0, precision = 32)
    public BigInteger getBigintegerColumn() {
        return this.bigintegerColumn;
    }

    public void setBigintegerColumn(BigInteger bigintegerColumn) {
        this.bigintegerColumn = bigintegerColumn;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sequence)) return false;
        final Sequence sequence = (Sequence) o;
        return Objects.equals(getColumn1(), sequence.getColumn1()) &&
                Objects.equals(getShortColumn(), sequence.getShortColumn()) &&
                Objects.equals(getBigintegerColumn(), sequence.getBigintegerColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn1(),
                getShortColumn(),
                getBigintegerColumn());
    }
}
