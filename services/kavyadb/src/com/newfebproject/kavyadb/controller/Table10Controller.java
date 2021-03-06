/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.kavyadb.controller;

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

import com.newfebproject.kavyadb.Table10;
import com.newfebproject.kavyadb.service.Table10Service;


/**
 * Controller object for domain model class Table10.
 * @see Table10
 */
@RestController("kavyadb.Table10Controller")
@Api(value = "Table10Controller", description = "Exposes APIs to work with Table10 resource.")
@RequestMapping("/kavyadb/Table10")
public class Table10Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table10Controller.class);

    @Autowired
	@Qualifier("kavyadb.Table10Service")
	private Table10Service table10Service;

	@ApiOperation(value = "Creates a new Table10 instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Table10 createTable10(@RequestBody Table10 table10) {
		LOGGER.debug("Create Table10 with information: {}" , table10);

		table10 = table10Service.create(table10);
		LOGGER.debug("Created Table10 with information: {}" , table10);

	    return table10;
	}


    @ApiOperation(value = "Returns the Table10 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table10 getTable10(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table10 with id: {}" , id);

        Table10 foundTable10 = table10Service.getById(id);
        LOGGER.debug("Table10 details with id: {}" , foundTable10);

        return foundTable10;
    }

    @ApiOperation(value = "Updates the Table10 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table10 editTable10(@PathVariable("id") Integer id, @RequestBody Table10 table10) throws EntityNotFoundException {
        LOGGER.debug("Editing Table10 with id: {}" , table10.getId());

        table10.setId(id);
        table10 = table10Service.update(table10);
        LOGGER.debug("Table10 details with id: {}" , table10);

        return table10;
    }

    @ApiOperation(value = "Deletes the Table10 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable10(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table10 with id: {}" , id);

        Table10 deletedTable10 = table10Service.delete(id);

        return deletedTable10 != null;
    }

    /**
     * @deprecated Use {@link #findTable10s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table10 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table10> searchTable10sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table10s list");
        return table10Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table10 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table10> findTable10s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table10s list");
        return table10Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table10 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table10> filterTable10s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table10s list");
        return table10Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable10s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table10Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table10 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable10s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table10s");
		return table10Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable10AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table10Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table10Service instance
	 */
	protected void setTable10Service(Table10Service service) {
		this.table10Service = service;
	}

}

