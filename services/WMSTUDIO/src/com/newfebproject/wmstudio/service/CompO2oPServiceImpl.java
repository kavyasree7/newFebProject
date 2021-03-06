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
import com.newfebproject.wmstudio.CompO2oP;
import com.newfebproject.wmstudio.CompO2oPId;


/**
 * ServiceImpl object for domain model class CompO2oP.
 *
 * @see CompO2oP
 */
@Service("WMSTUDIO.CompO2oPService")
public class CompO2oPServiceImpl implements CompO2oPService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompO2oPServiceImpl.class);

    @Autowired
	@Qualifier("WMSTUDIO.CompO2oCService")
	private CompO2oCService compO2oCService;

    @Autowired
    @Qualifier("WMSTUDIO.CompO2oPDao")
    private WMGenericDao<CompO2oP, CompO2oPId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<CompO2oP, CompO2oPId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public CompO2oP create(CompO2oP compO2oP) {
        LOGGER.debug("Creating a new CompO2oP with information: {}", compO2oP);
        CompO2oP compO2oPCreated = this.wmGenericDao.create(compO2oP);
        if(compO2oPCreated.getCompO2oC() != null) {
            CompO2oC compO2oC = compO2oPCreated.getCompO2oC();
            LOGGER.debug("Creating a new child CompO2oC with information: {}", compO2oC);
            compO2oC.setCompO2oP(compO2oPCreated);
            compO2oCService.create(compO2oC);
        }
        return compO2oPCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public CompO2oP getById(CompO2oPId compo2opId) throws EntityNotFoundException {
        LOGGER.debug("Finding CompO2oP by id: {}", compo2opId);
        CompO2oP compO2oP = this.wmGenericDao.findById(compo2opId);
        if (compO2oP == null){
            LOGGER.debug("No CompO2oP found with id: {}", compo2opId);
            throw new EntityNotFoundException(String.valueOf(compo2opId));
        }
        return compO2oP;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public CompO2oP findById(CompO2oPId compo2opId) {
        LOGGER.debug("Finding CompO2oP by id: {}", compo2opId);
        return this.wmGenericDao.findById(compo2opId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public CompO2oP update(CompO2oP compO2oP) throws EntityNotFoundException {
        LOGGER.debug("Updating CompO2oP with information: {}", compO2oP);
        this.wmGenericDao.update(compO2oP);

        CompO2oPId compo2opId = new CompO2oPId();
        compo2opId.setId(compO2oP.getId());
        compo2opId.setColumn2(compO2oP.getColumn2());

        return this.wmGenericDao.findById(compo2opId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public CompO2oP delete(CompO2oPId compo2opId) throws EntityNotFoundException {
        LOGGER.debug("Deleting CompO2oP with id: {}", compo2opId);
        CompO2oP deleted = this.wmGenericDao.findById(compo2opId);
        if (deleted == null) {
            LOGGER.debug("No CompO2oP found with id: {}", compo2opId);
            throw new EntityNotFoundException(String.valueOf(compo2opId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<CompO2oP> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all CompO2oPs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<CompO2oP> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all CompO2oPs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table CompO2oP to {} format", exportType);
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


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CompO2oCService instance
	 */
	protected void setCompO2oCService(CompO2oCService service) {
        this.compO2oCService = service;
    }

}

