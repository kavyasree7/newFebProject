/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.kavyadb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Table7 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE7`")
public class Table7 implements Serializable {

    private Integer id;
    private String column2;
    private Hemanth hemanth;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"TABLE7_ID_seq\"" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "table7")
    public Hemanth getHemanth() {
        return this.hemanth;
    }

    public void setHemanth(Hemanth hemanth) {
        this.hemanth = hemanth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table7)) return false;
        final Table7 table7 = (Table7) o;
        return Objects.equals(getId(), table7.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

