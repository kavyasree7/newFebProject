/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigInteger;
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

import com.newfebproject.wmstudio.Testbigdectab;


/**
 * ServiceImpl object for domain model class Testbigdectab.
 *
 * @see Testbigdectab
 */
@Service("WMSTUDIO.TestbigdectabService")
public class TestbigdectabServiceImpl implements TestbigdectabService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestbigdectabServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.TestbigdectabDao")
    private WMGenericDao<Testbigdectab, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Testbigdectab, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Testbigdectab create(Testbigdectab testbigdectab) {
        LOGGER.debug("Creating a new Testbigdectab with information: {}", testbigdectab);
        Testbigdectab testbigdectabCreated = this.wmGenericDao.create(testbigdectab);
        return testbigdectabCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Testbigdectab getById(BigInteger testbigdectabId) throws EntityNotFoundException {
        LOGGER.debug("Finding Testbigdectab by id: {}", testbigdectabId);
        Testbigdectab testbigdectab = this.wmGenericDao.findById(testbigdectabId);
        if (testbigdectab == null){
            LOGGER.debug("No Testbigdectab found with id: {}", testbigdectabId);
            throw new EntityNotFoundException(String.valueOf(testbigdectabId));
        }
        return testbigdectab;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Testbigdectab findById(BigInteger testbigdectabId) {
        LOGGER.debug("Finding Testbigdectab by id: {}", testbigdectabId);
        return this.wmGenericDao.findById(testbigdectabId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Testbigdectab update(Testbigdectab testbigdectab) throws EntityNotFoundException {
        LOGGER.debug("Updating Testbigdectab with information: {}", testbigdectab);
        this.wmGenericDao.update(testbigdectab);

        BigInteger testbigdectabId = testbigdectab.getNumbercol();

        return this.wmGenericDao.findById(testbigdectabId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Testbigdectab delete(BigInteger testbigdectabId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Testbigdectab with id: {}", testbigdectabId);
        Testbigdectab deleted = this.wmGenericDao.findById(testbigdectabId);
        if (deleted == null) {
            LOGGER.debug("No Testbigdectab found with id: {}", testbigdectabId);
            throw new EntityNotFoundException(String.valueOf(testbigdectabId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Testbigdectab> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Testbigdectabs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Testbigdectab> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Testbigdectabs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Testbigdectab to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

