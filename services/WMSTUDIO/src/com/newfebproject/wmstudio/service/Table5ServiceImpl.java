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

import com.newfebproject.wmstudio.Table5;


/**
 * ServiceImpl object for domain model class Table5.
 *
 * @see Table5
 */
@Service("WMSTUDIO.Table5Service")
public class Table5ServiceImpl implements Table5Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table5ServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.Table5Dao")
    private WMGenericDao<Table5, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table5, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Table5 create(Table5 table5) {
        LOGGER.debug("Creating a new Table5 with information: {}", table5);
        Table5 table5Created = this.wmGenericDao.create(table5);
        return table5Created;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Table5 getById(Integer table5Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table5 by id: {}", table5Id);
        Table5 table5 = this.wmGenericDao.findById(table5Id);
        if (table5 == null){
            LOGGER.debug("No Table5 found with id: {}", table5Id);
            throw new EntityNotFoundException(String.valueOf(table5Id));
        }
        return table5;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Table5 findById(Integer table5Id) {
        LOGGER.debug("Finding Table5 by id: {}", table5Id);
        return this.wmGenericDao.findById(table5Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Table5 update(Table5 table5) throws EntityNotFoundException {
        LOGGER.debug("Updating Table5 with information: {}", table5);
        this.wmGenericDao.update(table5);

        Integer table5Id = table5.getId();

        return this.wmGenericDao.findById(table5Id);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Table5 delete(Integer table5Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table5 with id: {}", table5Id);
        Table5 deleted = this.wmGenericDao.findById(table5Id);
        if (deleted == null) {
            LOGGER.debug("No Table5 found with id: {}", table5Id);
            throw new EntityNotFoundException(String.valueOf(table5Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Table5> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table5s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Table5> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table5s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Table5 to {} format", exportType);
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
