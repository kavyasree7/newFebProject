/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.newfebproject.wmstudio.Noprecision;
import com.newfebproject.wmstudio.NoprecisionId;

/**
 * Specifies methods used to obtain and modify Noprecision related information
 * which is stored in the database.
 */
@Repository("WMSTUDIO.NoprecisionDao")
public class NoprecisionDao extends WMGenericDaoImpl<Noprecision, NoprecisionId> {

    @Autowired
    @Qualifier("WMSTUDIOTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

