/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.service;

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

import com.newfebproject.sample.Empmdc;
import com.newfebproject.sample.EmpmdcId;


/**
 * ServiceImpl object for domain model class Empmdc.
 *
 * @see Empmdc
 */
@Service("SAMPLE.EmpmdcService")
public class EmpmdcServiceImpl implements EmpmdcService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpmdcServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.EmpmdcDao")
    private WMGenericDao<Empmdc, EmpmdcId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Empmdc, EmpmdcId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Empmdc create(Empmdc empmdc) {
        LOGGER.debug("Creating a new Empmdc with information: {}", empmdc);
        Empmdc empmdcCreated = this.wmGenericDao.create(empmdc);
        return empmdcCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Empmdc getById(EmpmdcId empmdcId) throws EntityNotFoundException {
        LOGGER.debug("Finding Empmdc by id: {}", empmdcId);
        Empmdc empmdc = this.wmGenericDao.findById(empmdcId);
        if (empmdc == null){
            LOGGER.debug("No Empmdc found with id: {}", empmdcId);
            throw new EntityNotFoundException(String.valueOf(empmdcId));
        }
        return empmdc;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Empmdc findById(EmpmdcId empmdcId) {
        LOGGER.debug("Finding Empmdc by id: {}", empmdcId);
        return this.wmGenericDao.findById(empmdcId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Empmdc update(Empmdc empmdc) throws EntityNotFoundException {
        LOGGER.debug("Updating Empmdc with information: {}", empmdc);
        this.wmGenericDao.update(empmdc);

        EmpmdcId empmdcId = new EmpmdcId();
        empmdcId.setEmpno(empmdc.getEmpno());
        empmdcId.setDept(empmdc.getDept());
        empmdcId.setDiv(empmdc.getDiv());

        return this.wmGenericDao.findById(empmdcId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Empmdc delete(EmpmdcId empmdcId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Empmdc with id: {}", empmdcId);
        Empmdc deleted = this.wmGenericDao.findById(empmdcId);
        if (deleted == null) {
            LOGGER.debug("No Empmdc found with id: {}", empmdcId);
            throw new EntityNotFoundException(String.valueOf(empmdcId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Empmdc> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Empmdcs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Empmdc> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Empmdcs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Empmdc to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

