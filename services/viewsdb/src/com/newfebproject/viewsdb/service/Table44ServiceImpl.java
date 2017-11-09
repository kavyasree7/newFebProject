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

import com.newfebproject.viewsdb.Table44;


/**
 * ServiceImpl object for domain model class Table44.
 *
 * @see Table44
 */
@Service("viewsdb.Table44Service")
public class Table44ServiceImpl implements Table44Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table44ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table44Dao")
    private WMGenericDao<Table44, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table44, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table44 create(Table44 table44) {
        LOGGER.debug("Creating a new Table44 with information: {}", table44);
        Table44 table44Created = this.wmGenericDao.create(table44);
        return table44Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table44 getById(Integer table44Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table44 by id: {}", table44Id);
        Table44 table44 = this.wmGenericDao.findById(table44Id);
        if (table44 == null){
            LOGGER.debug("No Table44 found with id: {}", table44Id);
            throw new EntityNotFoundException(String.valueOf(table44Id));
        }
        return table44;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table44 findById(Integer table44Id) {
        LOGGER.debug("Finding Table44 by id: {}", table44Id);
        return this.wmGenericDao.findById(table44Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table44 update(Table44 table44) throws EntityNotFoundException {
        LOGGER.debug("Updating Table44 with information: {}", table44);
        this.wmGenericDao.update(table44);

        Integer table44Id = table44.getId();

        return this.wmGenericDao.findById(table44Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table44 delete(Integer table44Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table44 with id: {}", table44Id);
        Table44 deleted = this.wmGenericDao.findById(table44Id);
        if (deleted == null) {
            LOGGER.debug("No Table44 found with id: {}", table44Id);
            throw new EntityNotFoundException(String.valueOf(table44Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table44> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table44s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table44> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table44s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table44 to {} format", exportType);
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
