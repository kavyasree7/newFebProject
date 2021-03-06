/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * UdBothIuWithValues generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`UD BothIU With Values`")
public class UdBothIuWithValues implements Serializable {

    private Integer idCol;
    private String textCol;
    private String clobCol;
    private Integer integerCol;
    private Long longCol;
    private Float floatCol;
    private Double doubleCol;
    private Long bigintegerCol;
    private BigDecimal bigdecimalCol;
    private String characterCol;
    @Type(type = "DateTime")
    private LocalDateTime dateCol;
    private Timestamp timestampCol;
    private String booleanCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;
    private Integer intCol;
    private String stringCol;

    @Id
    @Column(name = "`id col`", nullable = false, scale = 0, precision = 10)
    public Integer getIdCol() {
        return this.idCol;
    }

    public void setIdCol(Integer idCol) {
        this.idCol = idCol;
    }

    @Column(name = "`text col`", nullable = true, length = 4000)
    public String getTextCol() {
        return this.textCol;
    }

    public void setTextCol(String textCol) {
        this.textCol = textCol;
    }

    @Column(name = "`clob col`", nullable = true, length = 4000)
    public String getClobCol() {
        return this.clobCol;
    }

    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
    }

    @Column(name = "`integer col`", nullable = true, scale = 0, precision = 10)
    public Integer getIntegerCol() {
        return this.integerCol;
    }

    public void setIntegerCol(Integer integerCol) {
        this.integerCol = integerCol;
    }

    @Column(name = "`long col`", nullable = true, scale = 0, precision = 19)
    public Long getLongCol() {
        return this.longCol;
    }

    public void setLongCol(Long longCol) {
        this.longCol = longCol;
    }

    @Column(name = "`float col`", nullable = true, scale = 4, precision = 6)
    public Float getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Float floatCol) {
        this.floatCol = floatCol;
    }

    @Column(name = "`double col`", nullable = true, scale = 6, precision = 19)
    public Double getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(Double doubleCol) {
        this.doubleCol = doubleCol;
    }

    @Column(name = "`biginteger col`", nullable = true, scale = 0, precision = 19)
    public Long getBigintegerCol() {
        return this.bigintegerCol;
    }

    public void setBigintegerCol(Long bigintegerCol) {
        this.bigintegerCol = bigintegerCol;
    }

    @Column(name = "`bigdecimal col`", nullable = true, scale = 6, precision = 33)
    public BigDecimal getBigdecimalCol() {
        return this.bigdecimalCol;
    }

    public void setBigdecimalCol(BigDecimal bigdecimalCol) {
        this.bigdecimalCol = bigdecimalCol;
    }

    @Column(name = "`character col`", nullable = true, length = 1)
    public String getCharacterCol() {
        return this.characterCol;
    }

    public void setCharacterCol(String characterCol) {
        this.characterCol = characterCol;
    }

    @Column(name = "`date col`", nullable = true)
    public LocalDateTime getDateCol() {
        return this.dateCol;
    }

    public void setDateCol(LocalDateTime dateCol) {
        this.dateCol = dateCol;
    }

    @Column(name = "`timestamp col`", nullable = true)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Column(name = "`boolean col`", nullable = true, length = 1)
    public String getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(String booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`blob col`", nullable = true)
    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }

    @Column(name = "`int col`", nullable = true, scale = 0, precision = 10)
    public Integer getIntCol() {
        return this.intCol;
    }

    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    @Column(name = "`string col`", nullable = true, length = 40)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UdBothIuWithValues)) return false;
        final UdBothIuWithValues udBothIuWithValues = (UdBothIuWithValues) o;
        return Objects.equals(getIdCol(), udBothIuWithValues.getIdCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCol());
    }
}

