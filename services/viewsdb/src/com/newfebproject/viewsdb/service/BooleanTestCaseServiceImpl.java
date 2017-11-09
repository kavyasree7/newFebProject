/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb.service;

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

import com.newfebproject.viewsdb.BooleanTestCase;


/**
 * ServiceImpl object for domain model class BooleanTestCase.
 *
 * @see BooleanTestCase
 */
@Service("viewsdb.BooleanTestCaseService")
public class BooleanTestCaseServiceImpl implements BooleanTestCaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooleanTestCaseServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.BooleanTestCaseDao")
    private WMGenericDao<BooleanTestCase, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<BooleanTestCase, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public BooleanTestCase create(BooleanTestCase booleanTestCase) {
        LOGGER.debug("Creating a new BooleanTestCase with information: {}", booleanTestCase);
        BooleanTestCase booleanTestCaseCreated = this.wmGenericDao.create(booleanTestCase);
        return booleanTestCaseCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public BooleanTestCase getById(Integer booleantestcaseId) throws EntityNotFoundException {
        LOGGER.debug("Finding BooleanTestCase by id: {}", booleantestcaseId);
        BooleanTestCase booleanTestCase = this.wmGenericDao.findById(booleantestcaseId);
        if (booleanTestCase == null){
            LOGGER.debug("No BooleanTestCase found with id: {}", booleantestcaseId);
            throw new EntityNotFoundException(String.valueOf(booleantestcaseId));
        }
        return booleanTestCase;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public BooleanTestCase findById(Integer booleantestcaseId) {
        LOGGER.debug("Finding BooleanTestCase by id: {}", booleantestcaseId);
        return this.wmGenericDao.findById(booleantestcaseId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public BooleanTestCase update(BooleanTestCase booleanTestCase) throws EntityNotFoundException {
        LOGGER.debug("Updating BooleanTestCase with information: {}", booleanTestCase);
        this.wmGenericDao.update(booleanTestCase);

        Integer booleantestcaseId = booleanTestCase.getId();

        return this.wmGenericDao.findById(booleantestcaseId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public BooleanTestCase delete(Integer booleantestcaseId) throws EntityNotFoundException {
        LOGGER.debug("Deleting BooleanTestCase with id: {}", booleantestcaseId);
        BooleanTestCase deleted = this.wmGenericDao.findById(booleantestcaseId);
        if (deleted == null) {
            LOGGER.debug("No BooleanTestCase found with id: {}", booleantestcaseId);
            throw new EntityNotFoundException(String.valueOf(booleantestcaseId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<BooleanTestCase> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all BooleanTestCases");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<BooleanTestCase> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all BooleanTestCases");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table BooleanTestCase to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

