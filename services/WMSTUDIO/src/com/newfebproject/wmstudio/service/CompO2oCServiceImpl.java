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

import com.newfebproject.wmstudio.CompO2oC;
import com.newfebproject.wmstudio.CompO2oPId;


/**
 * ServiceImpl object for domain model class CompO2oC.
 *
 * @see CompO2oC
 */
@Service("WMSTUDIO.CompO2oCService")
public class CompO2oCServiceImpl implements CompO2oCService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompO2oCServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.CompO2oCDao")
    private WMGenericDao<CompO2oC, CompO2oPId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CompO2oC, CompO2oPId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public CompO2oC create(CompO2oC compO2oC) {
        LOGGER.debug("Creating a new CompO2oC with information: {}", compO2oC);
        CompO2oC compO2oCCreated = this.wmGenericDao.create(compO2oC);
        return compO2oCCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public CompO2oC getById(CompO2oPId compo2ocId) throws EntityNotFoundException {
        LOGGER.debug("Finding CompO2oC by id: {}", compo2ocId);
        CompO2oC compO2oC = this.wmGenericDao.findById(compo2ocId);
        if (compO2oC == null){
            LOGGER.debug("No CompO2oC found with id: {}", compo2ocId);
            throw new EntityNotFoundException(String.valueOf(compo2ocId));
        }
        return compO2oC;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public CompO2oC findById(CompO2oPId compo2ocId) {
        LOGGER.debug("Finding CompO2oC by id: {}", compo2ocId);
        return this.wmGenericDao.findById(compo2ocId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public CompO2oC update(CompO2oC compO2oC) throws EntityNotFoundException {
        LOGGER.debug("Updating CompO2oC with information: {}", compO2oC);
        this.wmGenericDao.update(compO2oC);

        CompO2oPId compo2ocId = new CompO2oPId();
        compo2ocId.setId(compO2oC.getId());
        compo2ocId.setColumn2(compO2oC.getColumn2());

        return this.wmGenericDao.findById(compo2ocId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public CompO2oC delete(CompO2oPId compo2ocId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CompO2oC with id: {}", compo2ocId);
        CompO2oC deleted = this.wmGenericDao.findById(compo2ocId);
        if (deleted == null) {
            LOGGER.debug("No CompO2oC found with id: {}", compo2ocId);
            throw new EntityNotFoundException(String.valueOf(compo2ocId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<CompO2oC> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CompO2oCs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<CompO2oC> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CompO2oCs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table CompO2oC to {} format", exportType);
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

