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

import com.newfebproject.wmstudio.UdInsertableWithValues;


/**
 * ServiceImpl object for domain model class UdInsertableWithValues.
 *
 * @see UdInsertableWithValues
 */
@Service("WMSTUDIO.UdInsertableWithValuesService")
public class UdInsertableWithValuesServiceImpl implements UdInsertableWithValuesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdInsertableWithValuesServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.UdInsertableWithValuesDao")
    private WMGenericDao<UdInsertableWithValues, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<UdInsertableWithValues, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public UdInsertableWithValues create(UdInsertableWithValues udInsertableWithValues) {
        LOGGER.debug("Creating a new UdInsertableWithValues with information: {}", udInsertableWithValues);
        UdInsertableWithValues udInsertableWithValuesCreated = this.wmGenericDao.create(udInsertableWithValues);
        return udInsertableWithValuesCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public UdInsertableWithValues getById(Integer udinsertablewithvaluesId) throws EntityNotFoundException {
        LOGGER.debug("Finding UdInsertableWithValues by id: {}", udinsertablewithvaluesId);
        UdInsertableWithValues udInsertableWithValues = this.wmGenericDao.findById(udinsertablewithvaluesId);
        if (udInsertableWithValues == null){
            LOGGER.debug("No UdInsertableWithValues found with id: {}", udinsertablewithvaluesId);
            throw new EntityNotFoundException(String.valueOf(udinsertablewithvaluesId));
        }
        return udInsertableWithValues;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public UdInsertableWithValues findById(Integer udinsertablewithvaluesId) {
        LOGGER.debug("Finding UdInsertableWithValues by id: {}", udinsertablewithvaluesId);
        return this.wmGenericDao.findById(udinsertablewithvaluesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public UdInsertableWithValues update(UdInsertableWithValues udInsertableWithValues) throws EntityNotFoundException {
        LOGGER.debug("Updating UdInsertableWithValues with information: {}", udInsertableWithValues);
        this.wmGenericDao.update(udInsertableWithValues);

        Integer udinsertablewithvaluesId = udInsertableWithValues.getIdCol();

        return this.wmGenericDao.findById(udinsertablewithvaluesId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public UdInsertableWithValues delete(Integer udinsertablewithvaluesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting UdInsertableWithValues with id: {}", udinsertablewithvaluesId);
        UdInsertableWithValues deleted = this.wmGenericDao.findById(udinsertablewithvaluesId);
        if (deleted == null) {
            LOGGER.debug("No UdInsertableWithValues found with id: {}", udinsertablewithvaluesId);
            throw new EntityNotFoundException(String.valueOf(udinsertablewithvaluesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<UdInsertableWithValues> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UdInsertableWithValues");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<UdInsertableWithValues> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UdInsertableWithValues");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table UdInsertableWithValues to {} format", exportType);
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

