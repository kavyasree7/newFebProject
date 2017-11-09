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

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * Test generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Test`")
public class Test implements Serializable {

    private Integer id;
    private String column2;
    private Boolean column3;
    private String column4;
    @Type(type = "DateTime")
    private LocalDateTime column5;
    @Type(type = "DateTime")
    private LocalDateTime column6;
    @Type(type = "DateTime")
    private LocalDateTime column7;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"Test_ID_seq\"" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = true)
    public Boolean getColumn3() {
        return this.column3;
    }

    public void setColumn3(Boolean column3) {
        this.column3 = column3;
    }

    @Column(name = "`COLUMN4`", nullable = true, length = 255)
    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    @Column(name = "`COLUMN5`", nullable = true)
    public LocalDateTime getColumn5() {
        return this.column5;
    }

    public void setColumn5(LocalDateTime column5) {
        this.column5 = column5;
    }

    @Column(name = "`COLUMN6`", nullable = true)
    public LocalDateTime getColumn6() {
        return this.column6;
    }

    public void setColumn6(LocalDateTime column6) {
        this.column6 = column6;
    }

    @Column(name = "`COLUMN7`", nullable = true)
    public LocalDateTime getColumn7() {
        return this.column7;
    }

    public void setColumn7(LocalDateTime column7) {
        this.column7 = column7;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        final Test test = (Test) o;
        return Objects.equals(getId(), test.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
