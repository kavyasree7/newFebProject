/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.kavyadb.service;

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

import com.newfebproject.kavyadb.Table25;


/**
 * ServiceImpl object for domain model class Table25.
 *
 * @see Table25
 */
@Service("kavyadb.Table25Service")
public class Table25ServiceImpl implements Table25Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table25ServiceImpl.class);


    @Autowired
    @Qualifier("kavyadb.Table25Dao")
    private WMGenericDao<Table25, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table25, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "kavyadbTransactionManager")
    @Override
	public Table25 create(Table25 table25) {
        LOGGER.debug("Creating a new Table25 with information: {}", table25);
        Table25 table25Created = this.wmGenericDao.create(table25);
        return table25Created;
    }

	@Transactional(readOnly = true, value = "kavyadbTransactionManager")
	@Override
	public Table25 getById(Integer table25Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table25 by id: {}", table25Id);
        Table25 table25 = this.wmGenericDao.findById(table25Id);
        if (table25 == null){
            LOGGER.debug("No Table25 found with id: {}", table25Id);
            throw new EntityNotFoundException(String.valueOf(table25Id));
        }
        return table25;
    }

    @Transactional(readOnly = true, value = "kavyadbTransactionManager")
	@Override
	public Table25 findById(Integer table25Id) {
        LOGGER.debug("Finding Table25 by id: {}", table25Id);
        return this.wmGenericDao.findById(table25Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "kavyadbTransactionManager")
	@Override
	public Table25 update(Table25 table25) throws EntityNotFoundException {
        LOGGER.debug("Updating Table25 with information: {}", table25);
        this.wmGenericDao.update(table25);

        Integer table25Id = table25.getId();

        return this.wmGenericDao.findById(table25Id);
    }

    @Transactional(value = "kavyadbTransactionManager")
	@Override
	public Table25 delete(Integer table25Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table25 with id: {}", table25Id);
        Table25 deleted = this.wmGenericDao.findById(table25Id);
        if (deleted == null) {
            LOGGER.debug("No Table25 found with id: {}", table25Id);
            throw new EntityNotFoundException(String.valueOf(table25Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "kavyadbTransactionManager")
	@Override
	public Page<Table25> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table25s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "kavyadbTransactionManager")
    @Override
    public Page<Table25> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table25s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "kavyadbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service kavyadb for table Table25 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "kavyadbTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "kavyadbTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
