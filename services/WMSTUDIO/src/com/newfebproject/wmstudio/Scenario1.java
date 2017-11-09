/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Scenario1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SCENARIO1`")
public class Scenario1 implements Serializable {

    private Integer id;
    private String column1;
    private String column2;
    private String column3Optional;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COLUMN1`", nullable = false, length = 255)
    public String getColumn1() {
        return this.column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    @Column(name = "`COLUMN2`", nullable = false, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3_OPTIONAL`", nullable = true, length = 255)
    public String getColumn3Optional() {
        return this.column3Optional;
    }

    public void setColumn3Optional(String column3Optional) {
        this.column3Optional = column3Optional;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scenario1)) return false;
        final Scenario1 scenario1 = (Scenario1) o;
        return Objects.equals(getId(), scenario1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
