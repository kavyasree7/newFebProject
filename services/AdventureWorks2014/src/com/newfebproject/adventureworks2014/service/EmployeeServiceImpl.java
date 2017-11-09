/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.adventureworks2014.service;

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

import com.newfebproject.adventureworks2014.Employee;


/**
 * ServiceImpl object for domain model class Employee.
 *
 * @see Employee
 */
@Service("AdventureWorks2014.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2014.EmployeeDao")
    private WMGenericDao<Employee, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Employee, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
    @Override
	public Employee create(Employee employee) {
        LOGGER.debug("Creating a new Employee with information: {}", employee);
        Employee employeeCreated = this.wmGenericDao.create(employee);
        return employeeCreated;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Employee getById(String employeeId) throws EntityNotFoundException {
        LOGGER.debug("Finding Employee by id: {}", employeeId);
        Employee employee = this.wmGenericDao.findById(employeeId);
        if (employee == null){
            LOGGER.debug("No Employee found with id: {}", employeeId);
            throw new EntityNotFoundException(String.valueOf(employeeId));
        }
        return employee;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Employee findById(String employeeId) {
        LOGGER.debug("Finding Employee by id: {}", employeeId);
        return this.wmGenericDao.findById(employeeId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "AdventureWorks2014TransactionManager")
	@Override
	public Employee update(Employee employee) throws EntityNotFoundException {
        LOGGER.debug("Updating Employee with information: {}", employee);
        this.wmGenericDao.update(employee);

        String employeeId = employee.getFirstName();

        return this.wmGenericDao.findById(employeeId);
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
	@Override
	public Employee delete(String employeeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Employee with id: {}", employeeId);
        Employee deleted = this.wmGenericDao.findById(employeeId);
        if (deleted == null) {
            LOGGER.debug("No Employee found with id: {}", employeeId);
            throw new EntityNotFoundException(String.valueOf(employeeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<Employee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Employees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<Employee> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Employees");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table Employee to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
