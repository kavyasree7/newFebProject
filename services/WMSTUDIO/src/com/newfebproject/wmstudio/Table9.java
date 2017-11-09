/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table9 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE9`")
public class Table9 implements Serializable {

    private Integer id;
    private String column2;
    private String column3;
    private BigDecimal column1Float;
    private BigDecimal column1Doubleprecision;

    @Id
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 1)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    @Column(name = "`COLUMN1_FLOAT`", nullable = true, scale = 4, precision = 38)
    public BigDecimal getColumn1Float() {
        return this.column1Float;
    }

    public void setColumn1Float(BigDecimal column1Float) {
        this.column1Float = column1Float;
    }

    @Column(name = "`COLUMN1_DOUBLEPRECISION`", nullable = true, scale = 4, precision = 38)
    public BigDecimal getColumn1Doubleprecision() {
        return this.column1Doubleprecision;
    }

    public void setColumn1Doubleprecision(BigDecimal column1Doubleprecision) {
        this.column1Doubleprecision = column1Doubleprecision;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table9)) return false;
        final Table9 table9 = (Table9) o;
        return Objects.equals(getId(), table9.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
