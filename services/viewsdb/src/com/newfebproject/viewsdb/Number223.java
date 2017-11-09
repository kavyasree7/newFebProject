/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Number223 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`number223`")
@IdClass(Number223Id.class)
public class Number223 implements Serializable {

    private Integer id;
    private Short integerCol;
    private Short shortCol;
    private Integer longCol;
    private Integer bigintegerCol;
    private BigDecimal byteCol;
    private Short floatCol;
    private Double doubleCol;

    @Id
    @Column(name = "`id`", nullable = true, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "`integer col`", nullable = true, scale = 0, precision = 4)
    public Short getIntegerCol() {
        return this.integerCol;
    }

    public void setIntegerCol(Short integerCol) {
        this.integerCol = integerCol;
    }

    @Id
    @Column(name = "`short col`", nullable = true, scale = 0, precision = 5)
    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    @Id
    @Column(name = "`long col`", nullable = true, scale = 0, precision = 8)
    public Integer getLongCol() {
        return this.longCol;
    }

    public void setLongCol(Integer longCol) {
        this.longCol = longCol;
    }

    @Id
    @Column(name = "`biginteger col`", nullable = true, scale = 0, precision = 8)
    public Integer getBigintegerCol() {
        return this.bigintegerCol;
    }

    public void setBigintegerCol(Integer bigintegerCol) {
        this.bigintegerCol = bigintegerCol;
    }

    @Id
    @Column(name = "`byte col`", nullable = true, scale = 15, precision = 38)
    public BigDecimal getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(BigDecimal byteCol) {
        this.byteCol = byteCol;
    }

    @Id
    @Column(name = "`float col`", nullable = true, scale = 0, precision = 4)
    public Short getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Short floatCol) {
        this.floatCol = floatCol;
    }

    @Id
    @Column(name = "`double col`", nullable = true, scale = 17, precision = 17)
    public Double getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(Double doubleCol) {
        this.doubleCol = doubleCol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number223)) return false;
        final Number223 number223 = (Number223) o;
        return Objects.equals(getId(), number223.getId()) &&
                Objects.equals(getIntegerCol(), number223.getIntegerCol()) &&
                Objects.equals(getShortCol(), number223.getShortCol()) &&
                Objects.equals(getLongCol(), number223.getLongCol()) &&
                Objects.equals(getBigintegerCol(), number223.getBigintegerCol()) &&
                Objects.equals(getByteCol(), number223.getByteCol()) &&
                Objects.equals(getFloatCol(), number223.getFloatCol()) &&
                Objects.equals(getDoubleCol(), number223.getDoubleCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getIntegerCol(),
                getShortCol(),
                getLongCol(),
                getBigintegerCol(),
                getByteCol(),
                getFloatCol(),
                getDoubleCol());
    }
}

