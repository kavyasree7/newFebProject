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

import com.newfebproject.viewsdb.Table37;


/**
 * ServiceImpl object for domain model class Table37.
 *
 * @see Table37
 */
@Service("viewsdb.Table37Service")
public class Table37ServiceImpl implements Table37Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table37ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table37Dao")
    private WMGenericDao<Table37, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table37, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table37 create(Table37 table37) {
        LOGGER.debug("Creating a new Table37 with information: {}", table37);
        Table37 table37Created = this.wmGenericDao.create(table37);
        return table37Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table37 getById(String table37Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table37 by id: {}", table37Id);
        Table37 table37 = this.wmGenericDao.findById(table37Id);
        if (table37 == null){
            LOGGER.debug("No Table37 found with id: {}", table37Id);
            throw new EntityNotFoundException(String.valueOf(table37Id));
        }
        return table37;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table37 findById(String table37Id) {
        LOGGER.debug("Finding Table37 by id: {}", table37Id);
        return this.wmGenericDao.findById(table37Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table37 update(Table37 table37) throws EntityNotFoundException {
        LOGGER.debug("Updating Table37 with information: {}", table37);
        this.wmGenericDao.update(table37);

        String table37Id = table37.getColumn2();

        return this.wmGenericDao.findById(table37Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table37 delete(String table37Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table37 with id: {}", table37Id);
        Table37 deleted = this.wmGenericDao.findById(table37Id);
        if (deleted == null) {
            LOGGER.debug("No Table37 found with id: {}", table37Id);
            throw new EntityNotFoundException(String.valueOf(table37Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table37> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table37s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table37> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table37s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table37 to {} format", exportType);
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

