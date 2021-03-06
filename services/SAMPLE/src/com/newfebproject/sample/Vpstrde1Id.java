/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class Vpstrde1Id implements Serializable {

    private String proj1no;
    private String proj1name;
    private String resp1no;
    private String resp1fn;
    private String resp1mi;
    private String resp1ln;
    private String proj2no;
    private String proj2name;
    private String resp2no;
    private String resp2fn;
    private String resp2mi;
    private String resp2ln;

    public String getProj1no() {
        return this.proj1no;
    }

    public void setProj1no(String proj1no) {
        this.proj1no = proj1no;
    }

    public String getProj1name() {
        return this.proj1name;
    }

    public void setProj1name(String proj1name) {
        this.proj1name = proj1name;
    }

    public String getResp1no() {
        return this.resp1no;
    }

    public void setResp1no(String resp1no) {
        this.resp1no = resp1no;
    }

    public String getResp1fn() {
        return this.resp1fn;
    }

    public void setResp1fn(String resp1fn) {
        this.resp1fn = resp1fn;
    }

    public String getResp1mi() {
        return this.resp1mi;
    }

    public void setResp1mi(String resp1mi) {
        this.resp1mi = resp1mi;
    }

    public String getResp1ln() {
        return this.resp1ln;
    }

    public void setResp1ln(String resp1ln) {
        this.resp1ln = resp1ln;
    }

    public String getProj2no() {
        return this.proj2no;
    }

    public void setProj2no(String proj2no) {
        this.proj2no = proj2no;
    }

    public String getProj2name() {
        return this.proj2name;
    }

    public void setProj2name(String proj2name) {
        this.proj2name = proj2name;
    }

    public String getResp2no() {
        return this.resp2no;
    }

    public void setResp2no(String resp2no) {
        this.resp2no = resp2no;
    }

    public String getResp2fn() {
        return this.resp2fn;
    }

    public void setResp2fn(String resp2fn) {
        this.resp2fn = resp2fn;
    }

    public String getResp2mi() {
        return this.resp2mi;
    }

    public void setResp2mi(String resp2mi) {
        this.resp2mi = resp2mi;
    }

    public String getResp2ln() {
        return this.resp2ln;
    }

    public void setResp2ln(String resp2ln) {
        this.resp2ln = resp2ln;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vpstrde1)) return false;
        final Vpstrde1 vpstrde1 = (Vpstrde1) o;
        return Objects.equals(getProj1no(), vpstrde1.getProj1no()) &&
                Objects.equals(getProj1name(), vpstrde1.getProj1name()) &&
                Objects.equals(getResp1no(), vpstrde1.getResp1no()) &&
                Objects.equals(getResp1fn(), vpstrde1.getResp1fn()) &&
                Objects.equals(getResp1mi(), vpstrde1.getResp1mi()) &&
                Objects.equals(getResp1ln(), vpstrde1.getResp1ln()) &&
                Objects.equals(getProj2no(), vpstrde1.getProj2no()) &&
                Objects.equals(getProj2name(), vpstrde1.getProj2name()) &&
                Objects.equals(getResp2no(), vpstrde1.getResp2no()) &&
                Objects.equals(getResp2fn(), vpstrde1.getResp2fn()) &&
                Objects.equals(getResp2mi(), vpstrde1.getResp2mi()) &&
                Objects.equals(getResp2ln(), vpstrde1.getResp2ln());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProj1no(),
                getProj1name(),
                getResp1no(),
                getResp1fn(),
                getResp1mi(),
                getResp1ln(),
                getProj2no(),
                getProj2name(),
                getResp2no(),
                getResp2fn(),
                getResp2mi(),
                getResp2ln());
    }
}
