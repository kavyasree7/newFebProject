/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Nopk3 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`NOPK3`")
public class Nopk3 implements Serializable {

    private Integer column1;
    private Integer column2;
    private Integer column3;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"NOPK3_COLUMN1_seq\"" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`COLUMN1`", nullable = false, scale = 0, precision = 10)
    public Integer getColumn1() {
        return this.column1;
    }

    public void setColumn1(Integer column1) {
        this.column1 = column1;
    }

    @Column(name = "`COLUMN2`", nullable = true, scale = 0, precision = 10)
    public Integer getColumn2() {
        return this.column2;
    }

    public void setColumn2(Integer column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = true, scale = 0, precision = 10)
    public Integer getColumn3() {
        return this.column3;
    }

    public void setColumn3(Integer column3) {
        this.column3 = column3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nopk3)) return false;
        final Nopk3 nopk3 = (Nopk3) o;
        return Objects.equals(getColumn1(), nopk3.getColumn1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn1());
    }
}

