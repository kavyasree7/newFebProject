/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TestnumbertypesId implements Serializable {

    private BigDecimal deccol;
    private BigDecimal numericcol;
    private Double floatcol;
    private Float realcol;
    private Double doupcol;

    public BigDecimal getDeccol() {
        return this.deccol;
    }

    public void setDeccol(BigDecimal deccol) {
        this.deccol = deccol;
    }

    public BigDecimal getNumericcol() {
        return this.numericcol;
    }

    public void setNumericcol(BigDecimal numericcol) {
        this.numericcol = numericcol;
    }

    public Double getFloatcol() {
        return this.floatcol;
    }

    public void setFloatcol(Double floatcol) {
        this.floatcol = floatcol;
    }

    public Float getRealcol() {
        return this.realcol;
    }

    public void setRealcol(Float realcol) {
        this.realcol = realcol;
    }

    public Double getDoupcol() {
        return this.doupcol;
    }

    public void setDoupcol(Double doupcol) {
        this.doupcol = doupcol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Testnumbertypes)) return false;
        final Testnumbertypes testnumbertypes = (Testnumbertypes) o;
        return Objects.equals(getDeccol(), testnumbertypes.getDeccol()) &&
                Objects.equals(getNumericcol(), testnumbertypes.getNumericcol()) &&
                Objects.equals(getFloatcol(), testnumbertypes.getFloatcol()) &&
                Objects.equals(getRealcol(), testnumbertypes.getRealcol()) &&
                Objects.equals(getDoupcol(), testnumbertypes.getDoupcol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeccol(),
                getNumericcol(),
                getFloatcol(),
                getRealcol(),
                getDoupcol());
    }
}
