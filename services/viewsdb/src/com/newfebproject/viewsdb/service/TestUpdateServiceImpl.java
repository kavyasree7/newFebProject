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

import com.newfebproject.viewsdb.TestUpdate;


/**
 * ServiceImpl object for domain model class TestUpdate.
 *
 * @see TestUpdate
 */
@Service("viewsdb.TestUpdateService")
public class TestUpdateServiceImpl implements TestUpdateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUpdateServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.TestUpdateDao")
    private WMGenericDao<TestUpdate, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TestUpdate, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public TestUpdate create(TestUpdate testUpdate) {
        LOGGER.debug("Creating a new TestUpdate with information: {}", testUpdate);
        TestUpdate testUpdateCreated = this.wmGenericDao.create(testUpdate);
        return testUpdateCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public TestUpdate getById(Short testupdateId) throws EntityNotFoundException {
        LOGGER.debug("Finding TestUpdate by id: {}", testupdateId);
        TestUpdate testUpdate = this.wmGenericDao.findById(testupdateId);
        if (testUpdate == null){
            LOGGER.debug("No TestUpdate found with id: {}", testupdateId);
            throw new EntityNotFoundException(String.valueOf(testupdateId));
        }
        return testUpdate;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public TestUpdate findById(Short testupdateId) {
        LOGGER.debug("Finding TestUpdate by id: {}", testupdateId);
        return this.wmGenericDao.findById(testupdateId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public TestUpdate update(TestUpdate testUpdate) throws EntityNotFoundException {
        LOGGER.debug("Updating TestUpdate with information: {}", testUpdate);
        this.wmGenericDao.update(testUpdate);

        Short testupdateId = testUpdate.getId();

        return this.wmGenericDao.findById(testupdateId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public TestUpdate delete(Short testupdateId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TestUpdate with id: {}", testupdateId);
        TestUpdate deleted = this.wmGenericDao.findById(testupdateId);
        if (deleted == null) {
            LOGGER.debug("No TestUpdate found with id: {}", testupdateId);
            throw new EntityNotFoundException(String.valueOf(testupdateId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<TestUpdate> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TestUpdates");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<TestUpdate> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TestUpdates");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table TestUpdate to {} format", exportType);
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

