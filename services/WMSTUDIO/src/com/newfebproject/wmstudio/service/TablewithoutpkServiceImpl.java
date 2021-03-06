/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
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

import com.newfebproject.wmstudio.Tablewithoutpk;
import com.newfebproject.wmstudio.TablewithoutpkId;


/**
 * ServiceImpl object for domain model class Tablewithoutpk.
 *
 * @see Tablewithoutpk
 */
@Service("WMSTUDIO.TablewithoutpkService")
public class TablewithoutpkServiceImpl implements TablewithoutpkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TablewithoutpkServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.TablewithoutpkDao")
    private WMGenericDao<Tablewithoutpk, TablewithoutpkId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Tablewithoutpk, TablewithoutpkId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Tablewithoutpk create(Tablewithoutpk tablewithoutpk) {
        LOGGER.debug("Creating a new Tablewithoutpk with information: {}", tablewithoutpk);
        Tablewithoutpk tablewithoutpkCreated = this.wmGenericDao.create(tablewithoutpk);
        return tablewithoutpkCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Tablewithoutpk getById(TablewithoutpkId tablewithoutpkId) throws EntityNotFoundException {
        LOGGER.debug("Finding Tablewithoutpk by id: {}", tablewithoutpkId);
        Tablewithoutpk tablewithoutpk = this.wmGenericDao.findById(tablewithoutpkId);
        if (tablewithoutpk == null){
            LOGGER.debug("No Tablewithoutpk found with id: {}", tablewithoutpkId);
            throw new EntityNotFoundException(String.valueOf(tablewithoutpkId));
        }
        return tablewithoutpk;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Tablewithoutpk findById(TablewithoutpkId tablewithoutpkId) {
        LOGGER.debug("Finding Tablewithoutpk by id: {}", tablewithoutpkId);
        return this.wmGenericDao.findById(tablewithoutpkId);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Tablewithoutpk getByUniqueColumn(String uniqueColumn) {
        Map<String, Object> uniqueColumnMap = new HashMap<>();
        uniqueColumnMap.put("uniqueColumn", uniqueColumn);

        LOGGER.debug("Finding Tablewithoutpk by unique keys: {}", uniqueColumnMap);
        Tablewithoutpk tablewithoutpk = this.wmGenericDao.findByUniqueKey(uniqueColumnMap);

        if (tablewithoutpk == null){
            LOGGER.debug("No Tablewithoutpk found with given unique key values: {}", uniqueColumnMap);
            throw new EntityNotFoundException(String.valueOf(uniqueColumnMap));
        }

        return tablewithoutpk;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Tablewithoutpk update(Tablewithoutpk tablewithoutpk) throws EntityNotFoundException {
        LOGGER.debug("Updating Tablewithoutpk with information: {}", tablewithoutpk);
        this.wmGenericDao.update(tablewithoutpk);

        TablewithoutpkId tablewithoutpkId = new TablewithoutpkId();
        tablewithoutpkId.setIdColumn(tablewithoutpk.getIdColumn());
        tablewithoutpkId.setPkColumn(tablewithoutpk.getPkColumn());
        tablewithoutpkId.setStringColumn(tablewithoutpk.getStringColumn());
        tablewithoutpkId.setUniqueColumn(tablewithoutpk.getUniqueColumn());
        tablewithoutpkId.setNotNullColumn(tablewithoutpk.getNotNullColumn());
        tablewithoutpkId.setDefaultValueColumn(tablewithoutpk.getDefaultValueColumn());

        return this.wmGenericDao.findById(tablewithoutpkId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Tablewithoutpk delete(TablewithoutpkId tablewithoutpkId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Tablewithoutpk with id: {}", tablewithoutpkId);
        Tablewithoutpk deleted = this.wmGenericDao.findById(tablewithoutpkId);
        if (deleted == null) {
            LOGGER.debug("No Tablewithoutpk found with id: {}", tablewithoutpkId);
            throw new EntityNotFoundException(String.valueOf(tablewithoutpkId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Tablewithoutpk> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Tablewithoutpks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Tablewithoutpk> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Tablewithoutpks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Tablewithoutpk to {} format", exportType);
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

