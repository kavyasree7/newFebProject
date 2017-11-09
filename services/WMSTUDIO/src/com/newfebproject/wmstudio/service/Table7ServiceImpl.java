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

import com.newfebproject.wmstudio.Table7;


/**
 * ServiceImpl object for domain model class Table7.
 *
 * @see Table7
 */
@Service("WMSTUDIO.Table7Service")
public class Table7ServiceImpl implements Table7Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table7ServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.Table7Dao")
    private WMGenericDao<Table7, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table7, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Table7 create(Table7 table7) {
        LOGGER.debug("Creating a new Table7 with information: {}", table7);
        Table7 table7Created = this.wmGenericDao.create(table7);
        return table7Created;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Table7 getById(Integer table7Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table7 by id: {}", table7Id);
        Table7 table7 = this.wmGenericDao.findById(table7Id);
        if (table7 == null){
            LOGGER.debug("No Table7 found with id: {}", table7Id);
            throw new EntityNotFoundException(String.valueOf(table7Id));
        }
        return table7;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Table7 findById(Integer table7Id) {
        LOGGER.debug("Finding Table7 by id: {}", table7Id);
        return this.wmGenericDao.findById(table7Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Table7 update(Table7 table7) throws EntityNotFoundException {
        LOGGER.debug("Updating Table7 with information: {}", table7);
        this.wmGenericDao.update(table7);

        Integer table7Id = table7.getId();

        return this.wmGenericDao.findById(table7Id);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Table7 delete(Integer table7Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table7 with id: {}", table7Id);
        Table7 deleted = this.wmGenericDao.findById(table7Id);
        if (deleted == null) {
            LOGGER.debug("No Table7 found with id: {}", table7Id);
            throw new EntityNotFoundException(String.valueOf(table7Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Table7> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table7s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Table7> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table7s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Table7 to {} format", exportType);
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
