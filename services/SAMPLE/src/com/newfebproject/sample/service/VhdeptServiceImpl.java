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

import com.newfebproject.sample.Vhdept;
import com.newfebproject.sample.VhdeptId;


/**
 * ServiceImpl object for domain model class Vhdept.
 *
 * @see Vhdept
 */
@Service("SAMPLE.VhdeptService")
public class VhdeptServiceImpl implements VhdeptService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VhdeptServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.VhdeptDao")
    private WMGenericDao<Vhdept, VhdeptId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Vhdept, VhdeptId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Vhdept create(Vhdept vhdept) {
        LOGGER.debug("Creating a new Vhdept with information: {}", vhdept);
        Vhdept vhdeptCreated = this.wmGenericDao.create(vhdept);
        return vhdeptCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Vhdept getById(VhdeptId vhdeptId) throws EntityNotFoundException {
        LOGGER.debug("Finding Vhdept by id: {}", vhdeptId);
        Vhdept vhdept = this.wmGenericDao.findById(vhdeptId);
        if (vhdept == null){
            LOGGER.debug("No Vhdept found with id: {}", vhdeptId);
            throw new EntityNotFoundException(String.valueOf(vhdeptId));
        }
        return vhdept;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Vhdept findById(VhdeptId vhdeptId) {
        LOGGER.debug("Finding Vhdept by id: {}", vhdeptId);
        return this.wmGenericDao.findById(vhdeptId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Vhdept update(Vhdept vhdept) throws EntityNotFoundException {
        LOGGER.debug("Updating Vhdept with information: {}", vhdept);
        this.wmGenericDao.update(vhdept);

        VhdeptId vhdeptId = new VhdeptId();
        vhdeptId.setDeptno(vhdept.getDeptno());
        vhdeptId.setDeptname(vhdept.getDeptname());
        vhdeptId.setMgrno(vhdept.getMgrno());
        vhdeptId.setAdmrdept(vhdept.getAdmrdept());
        vhdeptId.setLocation(vhdept.getLocation());

        return this.wmGenericDao.findById(vhdeptId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Vhdept delete(VhdeptId vhdeptId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Vhdept with id: {}", vhdeptId);
        Vhdept deleted = this.wmGenericDao.findById(vhdeptId);
        if (deleted == null) {
            LOGGER.debug("No Vhdept found with id: {}", vhdeptId);
            throw new EntityNotFoundException(String.valueOf(vhdeptId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Vhdept> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Vhdepts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Vhdept> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Vhdepts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Vhdept to {} format", exportType);
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
