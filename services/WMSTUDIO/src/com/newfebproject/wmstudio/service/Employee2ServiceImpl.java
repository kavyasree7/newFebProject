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

import com.newfebproject.wmstudio.Employee2;


/**
 * ServiceImpl object for domain model class Employee2.
 *
 * @see Employee2
 */
@Service("WMSTUDIO.Employee2Service")
public class Employee2ServiceImpl implements Employee2Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Employee2ServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.Employee2Dao")
    private WMGenericDao<Employee2, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Employee2, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Employee2 create(Employee2 employee2) {
        LOGGER.debug("Creating a new Employee2 with information: {}", employee2);
        Employee2 employee2Created = this.wmGenericDao.create(employee2);
        return employee2Created;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Employee2 getById(Integer employee2Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Employee2 by id: {}", employee2Id);
        Employee2 employee2 = this.wmGenericDao.findById(employee2Id);
        if (employee2 == null){
            LOGGER.debug("No Employee2 found with id: {}", employee2Id);
            throw new EntityNotFoundException(String.valueOf(employee2Id));
        }
        return employee2;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Employee2 findById(Integer employee2Id) {
        LOGGER.debug("Finding Employee2 by id: {}", employee2Id);
        return this.wmGenericDao.findById(employee2Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Employee2 update(Employee2 employee2) throws EntityNotFoundException {
        LOGGER.debug("Updating Employee2 with information: {}", employee2);
        this.wmGenericDao.update(employee2);

        Integer employee2Id = employee2.getId();

        return this.wmGenericDao.findById(employee2Id);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Employee2 delete(Integer employee2Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Employee2 with id: {}", employee2Id);
        Employee2 deleted = this.wmGenericDao.findById(employee2Id);
        if (deleted == null) {
            LOGGER.debug("No Employee2 found with id: {}", employee2Id);
            throw new EntityNotFoundException(String.valueOf(employee2Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Employee2> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Employee2s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Employee2> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Employee2s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Employee2 to {} format", exportType);
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

