/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

public class JobHistoryId implements Serializable {

    private Integer employeeId;
    @Type(type = "DateTime")
    private LocalDateTime startDate;

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHistory)) return false;
        final JobHistory jobHistory = (JobHistory) o;
        return Objects.equals(getEmployeeId(), jobHistory.getEmployeeId()) &&
                Objects.equals(getStartDate(), jobHistory.getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(),
                getStartDate());
    }
}