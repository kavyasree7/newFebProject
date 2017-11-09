/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class CompO2oPId implements Serializable {

    private Integer id;
    private String column2;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompO2oP)) return false;
        final CompO2oP compO2oP = (CompO2oP) o;
        return Objects.equals(getId(), compO2oP.getId()) &&
                Objects.equals(getColumn2(), compO2oP.getColumn2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getColumn2());
    }
}