/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class EmpPhotoId implements Serializable {

    private String empno;
    private String photoFormat;

    public String getEmpno() {
        return this.empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getPhotoFormat() {
        return this.photoFormat;
    }

    public void setPhotoFormat(String photoFormat) {
        this.photoFormat = photoFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpPhoto)) return false;
        final EmpPhoto empPhoto = (EmpPhoto) o;
        return Objects.equals(getEmpno(), empPhoto.getEmpno()) &&
                Objects.equals(getPhotoFormat(), empPhoto.getPhotoFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpno(),
                getPhotoFormat());
    }
}
