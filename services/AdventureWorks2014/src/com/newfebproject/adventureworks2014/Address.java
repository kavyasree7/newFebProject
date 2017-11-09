/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.adventureworks2014;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Address generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Address`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`rowguid`"}),
        @UniqueConstraint(columnNames = {"`AddressLine1`", "`AddressLine2`", "`City`", "`StateProvinceID`", "`PostalCode`"})})
public class Address implements Serializable {

    private Integer addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private int stateProvinceId;
    private String postalCode;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] spatialLocation;
    private String rowguid;
    @Type(type = "DateTime")
    private LocalDateTime modifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`AddressID`", nullable = false, scale = 0, precision = 10)
    public Integer getAddressId() {
        return this.addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Column(name = "`AddressLine1`", nullable = false, length = 60)
    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Column(name = "`AddressLine2`", nullable = true, length = 60)
    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Column(name = "`City`", nullable = false, length = 30)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "`StateProvinceID`", nullable = false, scale = 0, precision = 10)
    public int getStateProvinceId() {
        return this.stateProvinceId;
    }

    public void setStateProvinceId(int stateProvinceId) {
        this.stateProvinceId = stateProvinceId;
    }

    @Column(name = "`PostalCode`", nullable = false, length = 15)
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "`SpatialLocation`", nullable = true)
    public byte[] getSpatialLocation() {
        return this.spatialLocation;
    }

    public void setSpatialLocation(byte[] spatialLocation) {
        this.spatialLocation = spatialLocation;
    }

    @Column(name = "`rowguid`", nullable = false, length = 32)
    public String getRowguid() {
        return this.rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    @Column(name = "`ModifiedDate`", nullable = false)
    public LocalDateTime getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        final Address address = (Address) o;
        return Objects.equals(getAddressId(), address.getAddressId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId());
    }
}

