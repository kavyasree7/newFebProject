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

import com.newfebproject.wmstudio.CallRouting;
import com.newfebproject.wmstudio.CallRoutingId;


/**
 * ServiceImpl object for domain model class CallRouting.
 *
 * @see CallRouting
 */
@Service("WMSTUDIO.CallRoutingService")
public class CallRoutingServiceImpl implements CallRoutingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallRoutingServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.CallRoutingDao")
    private WMGenericDao<CallRouting, CallRoutingId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CallRouting, CallRoutingId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public CallRouting create(CallRouting callRouting) {
        LOGGER.debug("Creating a new CallRouting with information: {}", callRouting);
        CallRouting callRoutingCreated = this.wmGenericDao.create(callRouting);
        return callRoutingCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public CallRouting getById(CallRoutingId callroutingId) throws EntityNotFoundException {
        LOGGER.debug("Finding CallRouting by id: {}", callroutingId);
        CallRouting callRouting = this.wmGenericDao.findById(callroutingId);
        if (callRouting == null){
            LOGGER.debug("No CallRouting found with id: {}", callroutingId);
            throw new EntityNotFoundException(String.valueOf(callroutingId));
        }
        return callRouting;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public CallRouting findById(CallRoutingId callroutingId) {
        LOGGER.debug("Finding CallRouting by id: {}", callroutingId);
        return this.wmGenericDao.findById(callroutingId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public CallRouting update(CallRouting callRouting) throws EntityNotFoundException {
        LOGGER.debug("Updating CallRouting with information: {}", callRouting);
        this.wmGenericDao.update(callRouting);

        CallRoutingId callroutingId = new CallRoutingId();
        callroutingId.setId(callRouting.getId());
        callroutingId.setCategoryId(callRouting.getCategoryId());
        callroutingId.setCategoryDefault(callRouting.getCategoryDefault());
        callroutingId.setKeyName(callRouting.getKeyName());
        callroutingId.setRoutingPointId(callRouting.getRoutingPointId());
        callroutingId.setBuId(callRouting.getBuId());
        callroutingId.setDescription(callRouting.getDescription());
        callroutingId.setLastModifiedUserId(callRouting.getLastModifiedUserId());
        callroutingId.setVqCategoryId(callRouting.getVqCategoryId());
        callroutingId.setSkillId(callRouting.getSkillId());

        return this.wmGenericDao.findById(callroutingId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public CallRouting delete(CallRoutingId callroutingId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CallRouting with id: {}", callroutingId);
        CallRouting deleted = this.wmGenericDao.findById(callroutingId);
        if (deleted == null) {
            LOGGER.debug("No CallRouting found with id: {}", callroutingId);
            throw new EntityNotFoundException(String.valueOf(callroutingId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<CallRouting> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CallRoutings");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<CallRouting> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CallRoutings");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table CallRouting to {} format", exportType);
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
