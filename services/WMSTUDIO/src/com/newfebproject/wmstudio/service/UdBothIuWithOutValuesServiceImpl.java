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

import com.newfebproject.wmstudio.UdBothIuWithOutValues;


/**
 * ServiceImpl object for domain model class UdBothIuWithOutValues.
 *
 * @see UdBothIuWithOutValues
 */
@Service("WMSTUDIO.UdBothIuWithOutValuesService")
public class UdBothIuWithOutValuesServiceImpl implements UdBothIuWithOutValuesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdBothIuWithOutValuesServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.UdBothIuWithOutValuesDao")
    private WMGenericDao<UdBothIuWithOutValues, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<UdBothIuWithOutValues, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public UdBothIuWithOutValues create(UdBothIuWithOutValues udBothIuWithOutValues) {
        LOGGER.debug("Creating a new UdBothIuWithOutValues with information: {}", udBothIuWithOutValues);
        UdBothIuWithOutValues udBothIuWithOutValuesCreated = this.wmGenericDao.create(udBothIuWithOutValues);
        return udBothIuWithOutValuesCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public UdBothIuWithOutValues getById(Integer udbothiuwithoutvaluesId) throws EntityNotFoundException {
        LOGGER.debug("Finding UdBothIuWithOutValues by id: {}", udbothiuwithoutvaluesId);
        UdBothIuWithOutValues udBothIuWithOutValues = this.wmGenericDao.findById(udbothiuwithoutvaluesId);
        if (udBothIuWithOutValues == null){
            LOGGER.debug("No UdBothIuWithOutValues found with id: {}", udbothiuwithoutvaluesId);
            throw new EntityNotFoundException(String.valueOf(udbothiuwithoutvaluesId));
        }
        return udBothIuWithOutValues;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public UdBothIuWithOutValues findById(Integer udbothiuwithoutvaluesId) {
        LOGGER.debug("Finding UdBothIuWithOutValues by id: {}", udbothiuwithoutvaluesId);
        return this.wmGenericDao.findById(udbothiuwithoutvaluesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public UdBothIuWithOutValues update(UdBothIuWithOutValues udBothIuWithOutValues) throws EntityNotFoundException {
        LOGGER.debug("Updating UdBothIuWithOutValues with information: {}", udBothIuWithOutValues);
        this.wmGenericDao.update(udBothIuWithOutValues);

        Integer udbothiuwithoutvaluesId = udBothIuWithOutValues.getIdCol();

        return this.wmGenericDao.findById(udbothiuwithoutvaluesId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public UdBothIuWithOutValues delete(Integer udbothiuwithoutvaluesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting UdBothIuWithOutValues with id: {}", udbothiuwithoutvaluesId);
        UdBothIuWithOutValues deleted = this.wmGenericDao.findById(udbothiuwithoutvaluesId);
        if (deleted == null) {
            LOGGER.debug("No UdBothIuWithOutValues found with id: {}", udbothiuwithoutvaluesId);
            throw new EntityNotFoundException(String.valueOf(udbothiuwithoutvaluesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<UdBothIuWithOutValues> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UdBothIuWithOutValues");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<UdBothIuWithOutValues> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UdBothIuWithOutValues");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table UdBothIuWithOutValues to {} format", exportType);
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

