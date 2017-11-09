/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class VactId implements Serializable {

    private Short actno;
    private String actkwd;
    private String actdesc;

    public Short getActno() {
        return this.actno;
    }

    public void setActno(Short actno) {
        this.actno = actno;
    }

    public String getActkwd() {
        return this.actkwd;
    }

    public void setActkwd(String actkwd) {
        this.actkwd = actkwd;
    }

    public String getActdesc() {
        return this.actdesc;
    }

    public void setActdesc(String actdesc) {
        this.actdesc = actdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vact)) return false;
        final Vact vact = (Vact) o;
        return Objects.equals(getActno(), vact.getActno()) &&
                Objects.equals(getActkwd(), vact.getActkwd()) &&
                Objects.equals(getActdesc(), vact.getActdesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActno(),
                getActkwd(),
                getActdesc());
    }
}
