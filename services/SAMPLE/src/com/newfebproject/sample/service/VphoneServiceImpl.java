/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.sample.Vphone;
import com.newfebproject.sample.VphoneId;


/**
 * ServiceImpl object for domain model class Vphone.
 *
 * @see Vphone
 */
@Service("SAMPLE.VphoneService")
public class VphoneServiceImpl implements VphoneService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VphoneServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.VphoneDao")
    private WMGenericDao<Vphone, VphoneId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Vphone, VphoneId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Vphone create(Vphone vphone) {
        LOGGER.debug("Creating a new Vphone with information: {}", vphone);
        Vphone vphoneCreated = this.wmGenericDao.create(vphone);
        return vphoneCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Vphone getById(VphoneId vphoneId) throws EntityNotFoundException {
        LOGGER.debug("Finding Vphone by id: {}", vphoneId);
        Vphone vphone = this.wmGenericDao.findById(vphoneId);
        if (vphone == null){
            LOGGER.debug("No Vphone found with id: {}", vphoneId);
            throw new EntityNotFoundException(String.valueOf(vphoneId));
        }
        return vphone;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Vphone findById(VphoneId vphoneId) {
        LOGGER.debug("Finding Vphone by id: {}", vphoneId);
        return this.wmGenericDao.findById(vphoneId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Vphone update(Vphone vphone) throws EntityNotFoundException {
        LOGGER.debug("Updating Vphone with information: {}", vphone);
        this.wmGenericDao.update(vphone);

        VphoneId vphoneId = new VphoneId();
        vphoneId.setLastname(vphone.getLastname());
        vphoneId.setFirstname(vphone.getFirstname());
        vphoneId.setMiddleinitial(vphone.getMiddleinitial());
        vphoneId.setPhonenumber(vphone.getPhonenumber());
        vphoneId.setEmployeenumber(vphone.getEmployeenumber());
        vphoneId.setDeptnumber(vphone.getDeptnumber());
        vphoneId.setDeptname(vphone.getDeptname());

        return this.wmGenericDao.findById(vphoneId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Vphone delete(VphoneId vphoneId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Vphone with id: {}", vphoneId);
        Vphone deleted = this.wmGenericDao.findById(vphoneId);
        if (deleted == null) {
            LOGGER.debug("No Vphone found with id: {}", vphoneId);
            throw new EntityNotFoundException(String.valueOf(vphoneId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Vphone> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Vphones");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Vphone> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Vphones");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Vphone to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
