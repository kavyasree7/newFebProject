/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.newfebproject.sample.Vdepmg1;
import com.newfebproject.sample.Vdepmg1Id;

/**
 * Specifies methods used to obtain and modify Vdepmg1 related information
 * which is stored in the database.
 */
@Repository("SAMPLE.Vdepmg1Dao")
public class Vdepmg1Dao extends WMGenericDaoImpl<Vdepmg1, Vdepmg1Id> {

    @Autowired
    @Qualifier("SAMPLETemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

