/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * Alltypeswithdefaults generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`alltypeswithdefaults`")
@IdClass(AlltypeswithdefaultsId.class)
public class Alltypeswithdefaults implements Serializable {

    private Boolean booleancol;
    private Short smallintcol;
    private Integer intcol;
    private Long bigintcol;
    private Float floatcol;
    private Double doublecol;
    private BigDecimal numericcol;
    private Float realcol;
    private Double doublepreccol;
    private Integer serialcol;
    private Double plainfloatcol;
    private String charcol;
    private String quotedcharcol;
    private String varcharcol;
    private String textcol;
    private Date datecol;
    private Time timecol;
    private Time timetzcol;
    private Time timewotzcol;
    @Type(type = "DateTime")
    private LocalDateTime timestampcol;
    private Timestamp timestamptzcol;
    @Type(type = "DateTime")
    private LocalDateTime timestampwotzcol;

    @Id
    @Column(name = "`booleancol`", nullable = true)
    public Boolean getBooleancol() {
        return this.booleancol;
    }

    public void setBooleancol(Boolean booleancol) {
        this.booleancol = booleancol;
    }

    @Id
    @Column(name = "`smallintcol`", nullable = true, scale = 0, precision = 5)
    public Short getSmallintcol() {
        return this.smallintcol;
    }

    public void setSmallintcol(Short smallintcol) {
        this.smallintcol = smallintcol;
    }

    @Id
    @Column(name = "`intcol`", nullable = false, scale = 0, precision = 10)
    public Integer getIntcol() {
        return this.intcol;
    }

    public void setIntcol(Integer intcol) {
        this.intcol = intcol;
    }

    @Id
    @Column(name = "`bigintcol`", nullable = true, scale = 0, precision = 19)
    public Long getBigintcol() {
        return this.bigintcol;
    }

    public void setBigintcol(Long bigintcol) {
        this.bigintcol = bigintcol;
    }

    @Id
    @Column(name = "`floatcol`", nullable = true, scale = 2, precision = 6)
    public Float getFloatcol() {
        return this.floatcol;
    }

    public void setFloatcol(Float floatcol) {
        this.floatcol = floatcol;
    }

    @Id
    @Column(name = "`doublecol`", nullable = true, scale = 4, precision = 12)
    public Double getDoublecol() {
        return this.doublecol;
    }

    public void setDoublecol(Double doublecol) {
        this.doublecol = doublecol;
    }

    @Id
    @Column(name = "`numericcol`", nullable = true, scale = 15, precision = 38)
    public BigDecimal getNumericcol() {
        return this.numericcol;
    }

    public void setNumericcol(BigDecimal numericcol) {
        this.numericcol = numericcol;
    }

    @Id
    @Column(name = "`realcol`", nullable = true, scale = 8, precision = 8)
    public Float getRealcol() {
        return this.realcol;
    }

    public void setRealcol(Float realcol) {
        this.realcol = realcol;
    }

    @Id
    @Column(name = "`doublepreccol`", nullable = true, scale = 17, precision = 17)
    public Double getDoublepreccol() {
        return this.doublepreccol;
    }

    public void setDoublepreccol(Double doublepreccol) {
        this.doublepreccol = doublepreccol;
    }

    @Id
    @Column(name = "`serialcol`", nullable = false, scale = 0, precision = 10)
    public Integer getSerialcol() {
        return this.serialcol;
    }

    public void setSerialcol(Integer serialcol) {
        this.serialcol = serialcol;
    }

    @Id
    @Column(name = "`plainfloatcol`", nullable = true, scale = 17, precision = 17)
    public Double getPlainfloatcol() {
        return this.plainfloatcol;
    }

    public void setPlainfloatcol(Double plainfloatcol) {
        this.plainfloatcol = plainfloatcol;
    }

    @Id
    @Column(name = "`charcol`", nullable = true, length = 1)
    public String getCharcol() {
        return this.charcol;
    }

    public void setCharcol(String charcol) {
        this.charcol = charcol;
    }

    @Id
    @Column(name = "`quotedcharcol`", nullable = true, length = 1)
    public String getQuotedcharcol() {
        return this.quotedcharcol;
    }

    public void setQuotedcharcol(String quotedcharcol) {
        this.quotedcharcol = quotedcharcol;
    }

    @Id
    @Column(name = "`varcharcol`", nullable = true, length = 10)
    public String getVarcharcol() {
        return this.varcharcol;
    }

    public void setVarcharcol(String varcharcol) {
        this.varcharcol = varcharcol;
    }

    @Id
    @Column(name = "`textcol`", nullable = true, length = 2147483647)
    public String getTextcol() {
        return this.textcol;
    }

    public void setTextcol(String textcol) {
        this.textcol = textcol;
    }

    @Id
    @Column(name = "`datecol`", nullable = true)
    public Date getDatecol() {
        return this.datecol;
    }

    public void setDatecol(Date datecol) {
        this.datecol = datecol;
    }

    @Id
    @Column(name = "`timecol`", nullable = true)
    public Time getTimecol() {
        return this.timecol;
    }

    public void setTimecol(Time timecol) {
        this.timecol = timecol;
    }

    @Id
    @Column(name = "`timetzcol`", nullable = true)
    public Time getTimetzcol() {
        return this.timetzcol;
    }

    public void setTimetzcol(Time timetzcol) {
        this.timetzcol = timetzcol;
    }

    @Id
    @Column(name = "`timewotzcol`", nullable = true)
    public Time getTimewotzcol() {
        return this.timewotzcol;
    }

    public void setTimewotzcol(Time timewotzcol) {
        this.timewotzcol = timewotzcol;
    }

    @Id
    @Column(name = "`timestampcol`", nullable = true)
    public LocalDateTime getTimestampcol() {
        return this.timestampcol;
    }

    public void setTimestampcol(LocalDateTime timestampcol) {
        this.timestampcol = timestampcol;
    }

    @Id
    @Column(name = "`timestamptzcol`", nullable = true)
    public Timestamp getTimestamptzcol() {
        return this.timestamptzcol;
    }

    public void setTimestamptzcol(Timestamp timestamptzcol) {
        this.timestamptzcol = timestamptzcol;
    }

    @Id
    @Column(name = "`timestampwotzcol`", nullable = true)
    public LocalDateTime getTimestampwotzcol() {
        return this.timestampwotzcol;
    }

    public void setTimestampwotzcol(LocalDateTime timestampwotzcol) {
        this.timestampwotzcol = timestampwotzcol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alltypeswithdefaults)) return false;
        final Alltypeswithdefaults alltypeswithdefaults = (Alltypeswithdefaults) o;
        return Objects.equals(getBooleancol(), alltypeswithdefaults.getBooleancol()) &&
                Objects.equals(getSmallintcol(), alltypeswithdefaults.getSmallintcol()) &&
                Objects.equals(getIntcol(), alltypeswithdefaults.getIntcol()) &&
                Objects.equals(getBigintcol(), alltypeswithdefaults.getBigintcol()) &&
                Objects.equals(getFloatcol(), alltypeswithdefaults.getFloatcol()) &&
                Objects.equals(getDoublecol(), alltypeswithdefaults.getDoublecol()) &&
                Objects.equals(getNumericcol(), alltypeswithdefaults.getNumericcol()) &&
                Objects.equals(getRealcol(), alltypeswithdefaults.getRealcol()) &&
                Objects.equals(getDoublepreccol(), alltypeswithdefaults.getDoublepreccol()) &&
                Objects.equals(getSerialcol(), alltypeswithdefaults.getSerialcol()) &&
                Objects.equals(getPlainfloatcol(), alltypeswithdefaults.getPlainfloatcol()) &&
                Objects.equals(getCharcol(), alltypeswithdefaults.getCharcol()) &&
                Objects.equals(getQuotedcharcol(), alltypeswithdefaults.getQuotedcharcol()) &&
                Objects.equals(getVarcharcol(), alltypeswithdefaults.getVarcharcol()) &&
                Objects.equals(getTextcol(), alltypeswithdefaults.getTextcol()) &&
                Objects.equals(getDatecol(), alltypeswithdefaults.getDatecol()) &&
                Objects.equals(getTimecol(), alltypeswithdefaults.getTimecol()) &&
                Objects.equals(getTimetzcol(), alltypeswithdefaults.getTimetzcol()) &&
                Objects.equals(getTimewotzcol(), alltypeswithdefaults.getTimewotzcol()) &&
                Objects.equals(getTimestampcol(), alltypeswithdefaults.getTimestampcol()) &&
                Objects.equals(getTimestamptzcol(), alltypeswithdefaults.getTimestamptzcol()) &&
                Objects.equals(getTimestampwotzcol(), alltypeswithdefaults.getTimestampwotzcol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooleancol(),
                getSmallintcol(),
                getIntcol(),
                getBigintcol(),
                getFloatcol(),
                getDoublecol(),
                getNumericcol(),
                getRealcol(),
                getDoublepreccol(),
                getSerialcol(),
                getPlainfloatcol(),
                getCharcol(),
                getQuotedcharcol(),
                getVarcharcol(),
                getTextcol(),
                getDatecol(),
                getTimecol(),
                getTimetzcol(),
                getTimewotzcol(),
                getTimestampcol(),
                getTimestamptzcol(),
                getTimestampwotzcol());
    }
}

