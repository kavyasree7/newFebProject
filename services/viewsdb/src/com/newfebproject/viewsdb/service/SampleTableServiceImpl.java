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

import com.newfebproject.viewsdb.SampleTable;
import com.newfebproject.viewsdb.SampleTableId;


/**
 * ServiceImpl object for domain model class SampleTable.
 *
 * @see SampleTable
 */
@Service("viewsdb.SampleTableService")
public class SampleTableServiceImpl implements SampleTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleTableServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.SampleTableDao")
    private WMGenericDao<SampleTable, SampleTableId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SampleTable, SampleTableId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public SampleTable create(SampleTable sampleTable) {
        LOGGER.debug("Creating a new SampleTable with information: {}", sampleTable);
        SampleTable sampleTableCreated = this.wmGenericDao.create(sampleTable);
        return sampleTableCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public SampleTable getById(SampleTableId sampletableId) throws EntityNotFoundException {
        LOGGER.debug("Finding SampleTable by id: {}", sampletableId);
        SampleTable sampleTable = this.wmGenericDao.findById(sampletableId);
        if (sampleTable == null){
            LOGGER.debug("No SampleTable found with id: {}", sampletableId);
            throw new EntityNotFoundException(String.valueOf(sampletableId));
        }
        return sampleTable;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public SampleTable findById(SampleTableId sampletableId) {
        LOGGER.debug("Finding SampleTable by id: {}", sampletableId);
        return this.wmGenericDao.findById(sampletableId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public SampleTable update(SampleTable sampleTable) throws EntityNotFoundException {
        LOGGER.debug("Updating SampleTable with information: {}", sampleTable);
        this.wmGenericDao.update(sampleTable);

        SampleTableId sampletableId = new SampleTableId();
        sampletableId.setColumn3(sampleTable.getColumn3());
        sampletableId.setColumn4(sampleTable.getColumn4());
        sampletableId.setColumn5(sampleTable.getColumn5());
        sampletableId.setId(sampleTable.getId());

        return this.wmGenericDao.findById(sampletableId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public SampleTable delete(SampleTableId sampletableId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SampleTable with id: {}", sampletableId);
        SampleTable deleted = this.wmGenericDao.findById(sampletableId);
        if (deleted == null) {
            LOGGER.debug("No SampleTable found with id: {}", sampletableId);
            throw new EntityNotFoundException(String.valueOf(sampletableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<SampleTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SampleTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<SampleTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SampleTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table SampleTable to {} format", exportType);
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

