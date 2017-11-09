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

import com.newfebproject.wmstudio.UdIfUtNullWithOutValues;


/**
 * ServiceImpl object for domain model class UdIfUtNullWithOutValues.
 *
 * @see UdIfUtNullWithOutValues
 */
@Service("WMSTUDIO.UdIfUtNullWithOutValuesService")
public class UdIfUtNullWithOutValuesServiceImpl implements UdIfUtNullWithOutValuesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdIfUtNullWithOutValuesServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.UdIfUtNullWithOutValuesDao")
    private WMGenericDao<UdIfUtNullWithOutValues, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<UdIfUtNullWithOutValues, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public UdIfUtNullWithOutValues create(UdIfUtNullWithOutValues udIfUtNullWithOutValues) {
        LOGGER.debug("Creating a new UdIfUtNullWithOutValues with information: {}", udIfUtNullWithOutValues);
        UdIfUtNullWithOutValues udIfUtNullWithOutValuesCreated = this.wmGenericDao.create(udIfUtNullWithOutValues);
        return udIfUtNullWithOutValuesCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public UdIfUtNullWithOutValues getById(Integer udifutnullwithoutvaluesId) throws EntityNotFoundException {
        LOGGER.debug("Finding UdIfUtNullWithOutValues by id: {}", udifutnullwithoutvaluesId);
        UdIfUtNullWithOutValues udIfUtNullWithOutValues = this.wmGenericDao.findById(udifutnullwithoutvaluesId);
        if (udIfUtNullWithOutValues == null){
            LOGGER.debug("No UdIfUtNullWithOutValues found with id: {}", udifutnullwithoutvaluesId);
            throw new EntityNotFoundException(String.valueOf(udifutnullwithoutvaluesId));
        }
        return udIfUtNullWithOutValues;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public UdIfUtNullWithOutValues findById(Integer udifutnullwithoutvaluesId) {
        LOGGER.debug("Finding UdIfUtNullWithOutValues by id: {}", udifutnullwithoutvaluesId);
        return this.wmGenericDao.findById(udifutnullwithoutvaluesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public UdIfUtNullWithOutValues update(UdIfUtNullWithOutValues udIfUtNullWithOutValues) throws EntityNotFoundException {
        LOGGER.debug("Updating UdIfUtNullWithOutValues with information: {}", udIfUtNullWithOutValues);
        this.wmGenericDao.update(udIfUtNullWithOutValues);

        Integer udifutnullwithoutvaluesId = udIfUtNullWithOutValues.getId();

        return this.wmGenericDao.findById(udifutnullwithoutvaluesId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public UdIfUtNullWithOutValues delete(Integer udifutnullwithoutvaluesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting UdIfUtNullWithOutValues with id: {}", udifutnullwithoutvaluesId);
        UdIfUtNullWithOutValues deleted = this.wmGenericDao.findById(udifutnullwithoutvaluesId);
        if (deleted == null) {
            LOGGER.debug("No UdIfUtNullWithOutValues found with id: {}", udifutnullwithoutvaluesId);
            throw new EntityNotFoundException(String.valueOf(udifutnullwithoutvaluesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<UdIfUtNullWithOutValues> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UdIfUtNullWithOutValues");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<UdIfUtNullWithOutValues> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UdIfUtNullWithOutValues");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table UdIfUtNullWithOutValues to {} format", exportType);
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
