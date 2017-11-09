/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * VirtualO2oChild generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`VirtualO2O_Child`")
@IdClass(VirtualO2oChildId.class)
public class VirtualO2oChild implements Serializable {

    private BigInteger id;
    private String stringColumn;
    private BigDecimal bigdecimalColumn;
    private String descColumn;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 38)
    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Id
    @Column(name = "`StringColumn`", nullable = true, length = 20)
    public String getStringColumn() {
        return this.stringColumn;
    }

    public void setStringColumn(String stringColumn) {
        this.stringColumn = stringColumn;
    }

    @Id
    @Column(name = "`BigdecimalColumn`", nullable = true, scale = 16, precision = 32)
    public BigDecimal getBigdecimalColumn() {
        return this.bigdecimalColumn;
    }

    public void setBigdecimalColumn(BigDecimal bigdecimalColumn) {
        this.bigdecimalColumn = bigdecimalColumn;
    }

    @Id
    @Column(name = "`DescColumn`", nullable = true, length = 25)
    public String getDescColumn() {
        return this.descColumn;
    }

    public void setDescColumn(String descColumn) {
        this.descColumn = descColumn;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualO2oChild)) return false;
        final VirtualO2oChild virtualO2oChild = (VirtualO2oChild) o;
        return Objects.equals(getId(), virtualO2oChild.getId()) &&
                Objects.equals(getStringColumn(), virtualO2oChild.getStringColumn()) &&
                Objects.equals(getBigdecimalColumn(), virtualO2oChild.getBigdecimalColumn()) &&
                Objects.equals(getDescColumn(), virtualO2oChild.getDescColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getStringColumn(),
                getBigdecimalColumn(),
                getDescColumn());
    }
}

