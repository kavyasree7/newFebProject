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
import com.newfebproject.wmstudio.Locations;


/**
 * ServiceImpl object for domain model class Locations.
 *
 * @see Locations
 */
@Service("WMSTUDIO.LocationsService")
public class LocationsServiceImpl implements LocationsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationsServiceImpl.class);

    @Autowired
	@Qualifier("WMSTUDIO.DepartmentsService")
	private DepartmentsService departmentsService;

    @Autowired
    @Qualifier("WMSTUDIO.LocationsDao")
    private WMGenericDao<Locations, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Locations, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Locations create(Locations locations) {
        LOGGER.debug("Creating a new Locations with information: {}", locations);
        Locations locationsCreated = this.wmGenericDao.create(locations);
        if(locationsCreated.getDepartmentses() != null) {
            for(Departments departmentse : locationsCreated.getDepartmentses()) {
                departmentse.setLocations(locationsCreated);
                LOGGER.debug("Creating a new child Departments with information: {}", departmentse);
                departmentsService.create(departmentse);
            }
        }
        return locationsCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Locations getById(Short locationsId) throws EntityNotFoundException {
        LOGGER.debug("Finding Locations by id: {}", locationsId);
        Locations locations = this.wmGenericDao.findById(locationsId);
        if (locations == null){
            LOGGER.debug("No Locations found with id: {}", locationsId);
            throw new EntityNotFoundException(String.valueOf(locationsId));
        }
        return locations;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Locations findById(Short locationsId) {
        LOGGER.debug("Finding Locations by id: {}", locationsId);
        return this.wmGenericDao.findById(locationsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Locations update(Locations locations) throws EntityNotFoundException {
        LOGGER.debug("Updating Locations with information: {}", locations);
        this.wmGenericDao.update(locations);

        Short locationsId = locations.getLocationId();

        return this.wmGenericDao.findById(locationsId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Locations delete(Short locationsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Locations with id: {}", locationsId);
        Locations deleted = this.wmGenericDao.findById(locationsId);
        if (deleted == null) {
            LOGGER.debug("No Locations found with id: {}", locationsId);
            throw new EntityNotFoundException(String.valueOf(locationsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Locations> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Locations");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Locations> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Locations");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Locations to {} format", exportType);
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
    public Page<Departments> findAssociatedDepartmentses(Short locationId, Pageable pageable) {
        LOGGER.debug("Fetching all associated departmentses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("locations.locationId = '" + locationId + "'");

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

}
