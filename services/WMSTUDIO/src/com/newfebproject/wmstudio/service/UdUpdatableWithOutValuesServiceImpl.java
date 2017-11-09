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

import com.newfebproject.wmstudio.UdUpdatableWithOutValues;


/**
 * ServiceImpl object for domain model class UdUpdatableWithOutValues.
 *
 * @see UdUpdatableWithOutValues
 */
@Service("WMSTUDIO.UdUpdatableWithOutValuesService")
public class UdUpdatableWithOutValuesServiceImpl implements UdUpdatableWithOutValuesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdUpdatableWithOutValuesServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.UdUpdatableWithOutValuesDao")
    private WMGenericDao<UdUpdatableWithOutValues, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<UdUpdatableWithOutValues, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public UdUpdatableWithOutValues create(UdUpdatableWithOutValues udUpdatableWithOutValues) {
        LOGGER.debug("Creating a new UdUpdatableWithOutValues with information: {}", udUpdatableWithOutValues);
        UdUpdatableWithOutValues udUpdatableWithOutValuesCreated = this.wmGenericDao.create(udUpdatableWithOutValues);
        return udUpdatableWithOutValuesCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public UdUpdatableWithOutValues getById(Integer udupdatablewithoutvaluesId) throws EntityNotFoundException {
        LOGGER.debug("Finding UdUpdatableWithOutValues by id: {}", udupdatablewithoutvaluesId);
        UdUpdatableWithOutValues udUpdatableWithOutValues = this.wmGenericDao.findById(udupdatablewithoutvaluesId);
        if (udUpdatableWithOutValues == null){
            LOGGER.debug("No UdUpdatableWithOutValues found with id: {}", udupdatablewithoutvaluesId);
            throw new EntityNotFoundException(String.valueOf(udupdatablewithoutvaluesId));
        }
        return udUpdatableWithOutValues;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public UdUpdatableWithOutValues findById(Integer udupdatablewithoutvaluesId) {
        LOGGER.debug("Finding UdUpdatableWithOutValues by id: {}", udupdatablewithoutvaluesId);
        return this.wmGenericDao.findById(udupdatablewithoutvaluesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public UdUpdatableWithOutValues update(UdUpdatableWithOutValues udUpdatableWithOutValues) throws EntityNotFoundException {
        LOGGER.debug("Updating UdUpdatableWithOutValues with information: {}", udUpdatableWithOutValues);
        this.wmGenericDao.update(udUpdatableWithOutValues);

        Integer udupdatablewithoutvaluesId = udUpdatableWithOutValues.getIdCol();

        return this.wmGenericDao.findById(udupdatablewithoutvaluesId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public UdUpdatableWithOutValues delete(Integer udupdatablewithoutvaluesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting UdUpdatableWithOutValues with id: {}", udupdatablewithoutvaluesId);
        UdUpdatableWithOutValues deleted = this.wmGenericDao.findById(udupdatablewithoutvaluesId);
        if (deleted == null) {
            LOGGER.debug("No UdUpdatableWithOutValues found with id: {}", udupdatablewithoutvaluesId);
            throw new EntityNotFoundException(String.valueOf(udupdatablewithoutvaluesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<UdUpdatableWithOutValues> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UdUpdatableWithOutValues");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<UdUpdatableWithOutValues> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UdUpdatableWithOutValues");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table UdUpdatableWithOutValues to {} format", exportType);
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
