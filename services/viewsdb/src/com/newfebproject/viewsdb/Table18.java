/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Table18 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE18`")
@IdClass(Table18Id.class)
public class Table18 implements Serializable {

    private String column2;
    private String column3;
    private String column4;

    @Id
    @Column(name = "`COLUMN2`", nullable = false, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Id
    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Id
    @Column(name = "`COLUMN4`", nullable = true, length = 255)
    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table18)) return false;
        final Table18 table18 = (Table18) o;
        return Objects.equals(getColumn2(), table18.getColumn2()) &&
                Objects.equals(getColumn3(), table18.getColumn3()) &&
                Objects.equals(getColumn4(), table18.getColumn4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn2(),
                getColumn3(),
                getColumn4());
    }
}

