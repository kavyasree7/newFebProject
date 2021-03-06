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

import com.newfebproject.sample.Department;
import com.newfebproject.sample.EmpPhoto;
import com.newfebproject.sample.EmpResume;
import com.newfebproject.sample.Employee;
import com.newfebproject.sample.Project;


/**
 * ServiceImpl object for domain model class Employee.
 *
 * @see Employee
 */
@Service("SAMPLE.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
	@Qualifier("SAMPLE.ProjectService")
	private ProjectService projectService;

    @Autowired
	@Qualifier("SAMPLE.EmpResumeService")
	private EmpResumeService empResumeService;

    @Autowired
	@Qualifier("SAMPLE.DepartmentService")
	private DepartmentService departmentService;

    @Autowired
	@Qualifier("SAMPLE.EmpPhotoService")
	private EmpPhotoService empPhotoService;

    @Autowired
    @Qualifier("SAMPLE.EmployeeDao")
    private WMGenericDao<Employee, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Employee, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Employee create(Employee employee) {
        LOGGER.debug("Creating a new Employee with information: {}", employee);
        Employee employeeCreated = this.wmGenericDao.create(employee);
        if(employeeCreated.getEmpPhotos() != null) {
            for(EmpPhoto empPhoto : employeeCreated.getEmpPhotos()) {
                empPhoto.setEmployee(employeeCreated);
                LOGGER.debug("Creating a new child EmpPhoto with information: {}", empPhoto);
                empPhotoService.create(empPhoto);
            }
        }

        if(employeeCreated.getDepartmentsForMgrno() != null) {
            for(Department departmentsForMgrno : employeeCreated.getDepartmentsForMgrno()) {
                departmentsForMgrno.setEmployeeByMgrno(employeeCreated);
                LOGGER.debug("Creating a new child Department with information: {}", departmentsForMgrno);
                departmentService.create(departmentsForMgrno);
            }
        }

        if(employeeCreated.getEmpResumes() != null) {
            for(EmpResume empResume : employeeCreated.getEmpResumes()) {
                empResume.setEmployee(employeeCreated);
                LOGGER.debug("Creating a new child EmpResume with information: {}", empResume);
                empResumeService.create(empResume);
            }
        }

        if(employeeCreated.getProjects() != null) {
            for(Project project : employeeCreated.getProjects()) {
                project.setEmployee(employeeCreated);
                LOGGER.debug("Creating a new child Project with information: {}", project);
                projectService.create(project);
            }
        }
        return employeeCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
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

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Employee findById(String employeeId) {
        LOGGER.debug("Finding Employee by id: {}", employeeId);
        return this.wmGenericDao.findById(employeeId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Employee update(Employee employee) throws EntityNotFoundException {
        LOGGER.debug("Updating Employee with information: {}", employee);
        this.wmGenericDao.update(employee);

        String employeeId = employee.getEmpno();

        return this.wmGenericDao.findById(employeeId);
    }

    @Transactional(value = "SAMPLETransactionManager")
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

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Employee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Employees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Employee> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Employees");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Employee to {} format", exportType);
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

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<EmpPhoto> findAssociatedEmpPhotos(String empno, Pageable pageable) {
        LOGGER.debug("Fetching all associated empPhotos");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("employee.empno = '" + empno + "'");

        return empPhotoService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Department> findAssociatedDepartmentsForMgrno(String empno, Pageable pageable) {
        LOGGER.debug("Fetching all associated departmentsForMgrno");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("employeeByMgrno.empno = '" + empno + "'");

        return departmentService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<EmpResume> findAssociatedEmpResumes(String empno, Pageable pageable) {
        LOGGER.debug("Fetching all associated empResumes");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("employee.empno = '" + empno + "'");

        return empResumeService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Project> findAssociatedProjects(String empno, Pageable pageable) {
        LOGGER.debug("Fetching all associated projects");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("employee.empno = '" + empno + "'");

        return projectService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProjectService instance
	 */
	protected void setProjectService(ProjectService service) {
        this.projectService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmpResumeService instance
	 */
	protected void setEmpResumeService(EmpResumeService service) {
        this.empResumeService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DepartmentService instance
	 */
	protected void setDepartmentService(DepartmentService service) {
        this.departmentService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmpPhotoService instance
	 */
	protected void setEmpPhotoService(EmpPhotoService service) {
        this.empPhotoService = service;
    }

}

