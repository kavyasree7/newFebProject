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

import com.newfebproject.viewsdb.Table45;


/**
 * ServiceImpl object for domain model class Table45.
 *
 * @see Table45
 */
@Service("viewsdb.Table45Service")
public class Table45ServiceImpl implements Table45Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table45ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table45Dao")
    private WMGenericDao<Table45, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table45, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table45 create(Table45 table45) {
        LOGGER.debug("Creating a new Table45 with information: {}", table45);
        Table45 table45Created = this.wmGenericDao.create(table45);
        return table45Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table45 getById(Integer table45Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table45 by id: {}", table45Id);
        Table45 table45 = this.wmGenericDao.findById(table45Id);
        if (table45 == null){
            LOGGER.debug("No Table45 found with id: {}", table45Id);
            throw new EntityNotFoundException(String.valueOf(table45Id));
        }
        return table45;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table45 findById(Integer table45Id) {
        LOGGER.debug("Finding Table45 by id: {}", table45Id);
        return this.wmGenericDao.findById(table45Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table45 update(Table45 table45) throws EntityNotFoundException {
        LOGGER.debug("Updating Table45 with information: {}", table45);
        this.wmGenericDao.update(table45);

        Integer table45Id = table45.getId();

        return this.wmGenericDao.findById(table45Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table45 delete(Integer table45Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table45 with id: {}", table45Id);
        Table45 deleted = this.wmGenericDao.findById(table45Id);
        if (deleted == null) {
            LOGGER.debug("No Table45 found with id: {}", table45Id);
            throw new EntityNotFoundException(String.valueOf(table45Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table45> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table45s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table45> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table45s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table45 to {} format", exportType);
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

