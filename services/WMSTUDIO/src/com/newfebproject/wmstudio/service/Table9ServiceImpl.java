/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.service;

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

import com.newfebproject.wmstudio.Table9;


/**
 * ServiceImpl object for domain model class Table9.
 *
 * @see Table9
 */
@Service("WMSTUDIO.Table9Service")
public class Table9ServiceImpl implements Table9Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table9ServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.Table9Dao")
    private WMGenericDao<Table9, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table9, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Table9 create(Table9 table9) {
        LOGGER.debug("Creating a new Table9 with information: {}", table9);
        Table9 table9Created = this.wmGenericDao.create(table9);
        return table9Created;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Table9 getById(Integer table9Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table9 by id: {}", table9Id);
        Table9 table9 = this.wmGenericDao.findById(table9Id);
        if (table9 == null){
            LOGGER.debug("No Table9 found with id: {}", table9Id);
            throw new EntityNotFoundException(String.valueOf(table9Id));
        }
        return table9;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Table9 findById(Integer table9Id) {
        LOGGER.debug("Finding Table9 by id: {}", table9Id);
        return this.wmGenericDao.findById(table9Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Table9 update(Table9 table9) throws EntityNotFoundException {
        LOGGER.debug("Updating Table9 with information: {}", table9);
        this.wmGenericDao.update(table9);

        Integer table9Id = table9.getId();

        return this.wmGenericDao.findById(table9Id);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Table9 delete(Integer table9Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table9 with id: {}", table9Id);
        Table9 deleted = this.wmGenericDao.findById(table9Id);
        if (deleted == null) {
            LOGGER.debug("No Table9 found with id: {}", table9Id);
            throw new EntityNotFoundException(String.valueOf(table9Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Table9> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table9s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Table9> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table9s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Table9 to {} format", exportType);
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

