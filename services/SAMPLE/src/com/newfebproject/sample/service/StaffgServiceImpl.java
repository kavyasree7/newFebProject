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

import com.newfebproject.sample.Staffg;
import com.newfebproject.sample.StaffgId;


/**
 * ServiceImpl object for domain model class Staffg.
 *
 * @see Staffg
 */
@Service("SAMPLE.StaffgService")
public class StaffgServiceImpl implements StaffgService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaffgServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.StaffgDao")
    private WMGenericDao<Staffg, StaffgId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Staffg, StaffgId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Staffg create(Staffg staffg) {
        LOGGER.debug("Creating a new Staffg with information: {}", staffg);
        Staffg staffgCreated = this.wmGenericDao.create(staffg);
        return staffgCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Staffg getById(StaffgId staffgId) throws EntityNotFoundException {
        LOGGER.debug("Finding Staffg by id: {}", staffgId);
        Staffg staffg = this.wmGenericDao.findById(staffgId);
        if (staffg == null){
            LOGGER.debug("No Staffg found with id: {}", staffgId);
            throw new EntityNotFoundException(String.valueOf(staffgId));
        }
        return staffg;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Staffg findById(StaffgId staffgId) {
        LOGGER.debug("Finding Staffg by id: {}", staffgId);
        return this.wmGenericDao.findById(staffgId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Staffg update(Staffg staffg) throws EntityNotFoundException {
        LOGGER.debug("Updating Staffg with information: {}", staffg);
        this.wmGenericDao.update(staffg);

        StaffgId staffgId = new StaffgId();
        staffgId.setId(staffg.getId());
        staffgId.setName(staffg.getName());
        staffgId.setDept(staffg.getDept());
        staffgId.setJob(staffg.getJob());
        staffgId.setYears(staffg.getYears());
        staffgId.setSalary(staffg.getSalary());
        staffgId.setComm(staffg.getComm());

        return this.wmGenericDao.findById(staffgId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Staffg delete(StaffgId staffgId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Staffg with id: {}", staffgId);
        Staffg deleted = this.wmGenericDao.findById(staffgId);
        if (deleted == null) {
            LOGGER.debug("No Staffg found with id: {}", staffgId);
            throw new EntityNotFoundException(String.valueOf(staffgId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Staffg> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Staffgs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Staffg> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Staffgs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Staffg to {} format", exportType);
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

