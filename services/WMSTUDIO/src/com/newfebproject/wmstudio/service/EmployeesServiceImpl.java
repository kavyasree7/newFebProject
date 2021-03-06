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

import com.newfebproject.wmstudio.Departments;
import com.newfebproject.wmstudio.Employees;
import com.newfebproject.wmstudio.JobHistory;


/**
 * ServiceImpl object for domain model class Employees.
 *
 * @see Employees
 */
@Service("WMSTUDIO.EmployeesService")
public class EmployeesServiceImpl implements EmployeesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesServiceImpl.class);

    @Autowired
	@Qualifier("WMSTUDIO.DepartmentsService")
	private DepartmentsService departmentsService;

    @Autowired
	@Qualifier("WMSTUDIO.JobHistoryService")
	private JobHistoryService jobHistoryService;

    @Autowired
    @Qualifier("WMSTUDIO.EmployeesDao")
    private WMGenericDao<Employees, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Employees, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Employees create(Employees employees) {
        LOGGER.debug("Creating a new Employees with information: {}", employees);
        Employees employeesCreated = this.wmGenericDao.create(employees);
        if(employeesCreated.getJobHistories() != null) {
            for(JobHistory jobHistorie : employeesCreated.getJobHistories()) {
                jobHistorie.setEmployees(employeesCreated);
                LOGGER.debug("Creating a new child JobHistory with information: {}", jobHistorie);
                jobHistoryService.create(jobHistorie);
            }
        }

        if(employeesCreated.getEmployeesesForManagerId() != null) {
            for(Employees employeesesForManagerId : employeesCreated.getEmployeesesForManagerId()) {
                employeesesForManagerId.setEmployeesByManagerId(employeesCreated);
                LOGGER.debug("Creating a new child Employees with information: {}", employeesesForManagerId);
                create(employeesesForManagerId);
            }
        }

        if(employeesCreated.getDepartmentsesForManagerId() != null) {
            for(Departments departmentsesForManagerId : employeesCreated.getDepartmentsesForManagerId()) {
                departmentsesForManagerId.setEmployeesByManagerId(employeesCreated);
                LOGGER.debug("Creating a new child Departments with information: {}", departmentsesForManagerId);
                departmentsService.create(departmentsesForManagerId);
            }
        }
        return employeesCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Employees getById(Integer employeesId) throws EntityNotFoundException {
        LOGGER.debug("Finding Employees by id: {}", employeesId);
        Employees employees = this.wmGenericDao.findById(employeesId);
        if (employees == null){
            LOGGER.debug("No Employees found with id: {}", employeesId);
            throw new EntityNotFoundException(String.valueOf(employeesId));
        }
        return employees;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Employees findById(Integer employeesId) {
        LOGGER.debug("Finding Employees by id: {}", employeesId);
        return this.wmGenericDao.findById(employeesId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Employees update(Employees employees) throws EntityNotFoundException {
        LOGGER.debug("Updating Employees with information: {}", employees);
        this.wmGenericDao.update(employees);

        Integer employeesId = employees.getEmployeeId();

        return this.wmGenericDao.findById(employeesId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Employees delete(Integer employeesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Employees with id: {}", employeesId);
        Employees deleted = this.wmGenericDao.findById(employeesId);
        if (deleted == null) {
            LOGGER.debug("No Employees found with id: {}", employeesId);
            throw new EntityNotFoundException(String.valueOf(employeesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Employees> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Employees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Employees> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Employees");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Employees to {} format", exportType);
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

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<JobHistory> findAssociatedJobHistories(Integer employeeId, Pageable pageable) {
        LOGGER.debug("Fetching all associated jobHistories");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("employees.employeeId = '" + employeeId + "'");

        return jobHistoryService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Employees> findAssociatedEmployeesesForManagerId(Integer employeeId, Pageable pageable) {
        LOGGER.debug("Fetching all associated employeesesForManagerId");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("employeesByManagerId.employeeId = '" + employeeId + "'");

        return findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Departments> findAssociatedDepartmentsesForManagerId(Integer employeeId, Pageable pageable) {
        LOGGER.debug("Fetching all associated departmentsesForManagerId");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("employeesByManagerId.employeeId = '" + employeeId + "'");

        return departmentsService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DepartmentsService instance
	 */
	protected void setDepartmentsService(DepartmentsService service) {
        this.departmentsService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service JobHistoryService instance
	 */
	protected void setJobHistoryService(JobHistoryService service) {
        this.jobHistoryService = service;
    }

}

