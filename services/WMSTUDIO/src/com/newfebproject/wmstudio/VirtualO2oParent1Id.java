/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class VirtualO2oParent1Id implements Serializable {

    private BigInteger id;
    private String stringColumn;
    private BigDecimal bigdecimalColumn;
    private String descColumn;

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getStringColumn() {
        return this.stringColumn;
    }

    public void setStringColumn(String stringColumn) {
        this.stringColumn = stringColumn;
    }

    public BigDecimal getBigdecimalColumn() {
        return this.bigdecimalColumn;
    }

    public void setBigdecimalColumn(BigDecimal bigdecimalColumn) {
        this.bigdecimalColumn = bigdecimalColumn;
    }

    public String getDescColumn() {
        return this.descColumn;
    }

    public void setDescColumn(String descColumn) {
        this.descColumn = descColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualO2oParent1)) return false;
        final VirtualO2oParent1 virtualO2oParent1 = (VirtualO2oParent1) o;
        return Objects.equals(getId(), virtualO2oParent1.getId()) &&
                Objects.equals(getStringColumn(), virtualO2oParent1.getStringColumn()) &&
                Objects.equals(getBigdecimalColumn(), virtualO2oParent1.getBigdecimalColumn()) &&
                Objects.equals(getDescColumn(), virtualO2oParent1.getDescColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getStringColumn(),
                getBigdecimalColumn(),
                getDescColumn());
    }
}
