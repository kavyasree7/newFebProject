/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.newfebproject.wmstudio.Employee1;
import com.newfebproject.wmstudio.service.Employee1Service;


/**
 * Controller object for domain model class Employee1.
 * @see Employee1
 */
@RestController("WMSTUDIO.Employee1Controller")
@Api(value = "Employee1Controller", description = "Exposes APIs to work with Employee1 resource.")
@RequestMapping("/WMSTUDIO/Employee1")
public class Employee1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Employee1Controller.class);

    @Autowired
	@Qualifier("WMSTUDIO.Employee1Service")
	private Employee1Service employee1Service;

	@ApiOperation(value = "Creates a new Employee1 instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Employee1 createEmployee1(@RequestBody Employee1 employee1) {
		LOGGER.debug("Create Employee1 with information: {}" , employee1);

		employee1 = employee1Service.create(employee1);
		LOGGER.debug("Created Employee1 with information: {}" , employee1);

	    return employee1;
	}


    @ApiOperation(value = "Returns the Employee1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Employee1 getEmployee1(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Employee1 with id: {}" , id);

        Employee1 foundEmployee1 = employee1Service.getById(id);
        LOGGER.debug("Employee1 details with id: {}" , foundEmployee1);

        return foundEmployee1;
    }

    @ApiOperation(value = "Updates the Employee1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Employee1 editEmployee1(@PathVariable("id") Integer id, @RequestBody Employee1 employee1) throws EntityNotFoundException {
        LOGGER.debug("Editing Employee1 with id: {}" , employee1.getId());

        employee1.setId(id);
        employee1 = employee1Service.update(employee1);
        LOGGER.debug("Employee1 details with id: {}" , employee1);

        return employee1;
    }

    @ApiOperation(value = "Deletes the Employee1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteEmployee1(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Employee1 with id: {}" , id);

        Employee1 deletedEmployee1 = employee1Service.delete(id);

        return deletedEmployee1 != null;
    }

    /**
     * @deprecated Use {@link #findEmployee1s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Employee1 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Employee1> searchEmployee1sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Employee1s list");
        return employee1Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Employee1 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Employee1> findEmployee1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Employee1s list");
        return employee1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Employee1 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Employee1> filterEmployee1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Employee1s list");
        return employee1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportEmployee1s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return employee1Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Employee1 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countEmployee1s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Employee1s");
		return employee1Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getEmployee1AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return employee1Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Employee1Service instance
	 */
	protected void setEmployee1Service(Employee1Service service) {
		this.employee1Service = service;
	}

}
