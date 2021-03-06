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

import com.newfebproject.wmstudio.ServerdefinedI;


/**
 * ServiceImpl object for domain model class ServerdefinedI.
 *
 * @see ServerdefinedI
 */
@Service("WMSTUDIO.ServerdefinedIService")
public class ServerdefinedIServiceImpl implements ServerdefinedIService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerdefinedIServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.ServerdefinedIDao")
    private WMGenericDao<ServerdefinedI, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ServerdefinedI, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public ServerdefinedI create(ServerdefinedI serverdefinedI) {
        LOGGER.debug("Creating a new ServerdefinedI with information: {}", serverdefinedI);
        ServerdefinedI serverdefinedICreated = this.wmGenericDao.create(serverdefinedI);
        return serverdefinedICreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public ServerdefinedI getById(Integer serverdefinediId) throws EntityNotFoundException {
        LOGGER.debug("Finding ServerdefinedI by id: {}", serverdefinediId);
        ServerdefinedI serverdefinedI = this.wmGenericDao.findById(serverdefinediId);
        if (serverdefinedI == null){
            LOGGER.debug("No ServerdefinedI found with id: {}", serverdefinediId);
            throw new EntityNotFoundException(String.valueOf(serverdefinediId));
        }
        return serverdefinedI;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public ServerdefinedI findById(Integer serverdefinediId) {
        LOGGER.debug("Finding ServerdefinedI by id: {}", serverdefinediId);
        return this.wmGenericDao.findById(serverdefinediId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public ServerdefinedI update(ServerdefinedI serverdefinedI) throws EntityNotFoundException {
        LOGGER.debug("Updating ServerdefinedI with information: {}", serverdefinedI);
        this.wmGenericDao.update(serverdefinedI);

        Integer serverdefinediId = serverdefinedI.getServerdefinedId();

        return this.wmGenericDao.findById(serverdefinediId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public ServerdefinedI delete(Integer serverdefinediId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ServerdefinedI with id: {}", serverdefinediId);
        ServerdefinedI deleted = this.wmGenericDao.findById(serverdefinediId);
        if (deleted == null) {
            LOGGER.debug("No ServerdefinedI found with id: {}", serverdefinediId);
            throw new EntityNotFoundException(String.valueOf(serverdefinediId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<ServerdefinedI> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ServerdefinedIs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<ServerdefinedI> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ServerdefinedIs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table ServerdefinedI to {} format", exportType);
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

