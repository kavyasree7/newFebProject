/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.math.BigInteger;
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

import com.newfebproject.wmstudio.Table8big123;
import com.newfebproject.wmstudio.service.Table8big123Service;


/**
 * Controller object for domain model class Table8big123.
 * @see Table8big123
 */
@RestController("WMSTUDIO.Table8big123Controller")
@Api(value = "Table8big123Controller", description = "Exposes APIs to work with Table8big123 resource.")
@RequestMapping("/WMSTUDIO/Table8big123")
public class Table8big123Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table8big123Controller.class);

    @Autowired
	@Qualifier("WMSTUDIO.Table8big123Service")
	private Table8big123Service table8big123Service;

	@ApiOperation(value = "Creates a new Table8big123 instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Table8big123 createTable8big123(@RequestBody Table8big123 table8big123) {
		LOGGER.debug("Create Table8big123 with information: {}" , table8big123);

		table8big123 = table8big123Service.create(table8big123);
		LOGGER.debug("Created Table8big123 with information: {}" , table8big123);

	    return table8big123;
	}


    @ApiOperation(value = "Returns the Table8big123 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table8big123 getTable8big123(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table8big123 with id: {}" , id);

        Table8big123 foundTable8big123 = table8big123Service.getById(id);
        LOGGER.debug("Table8big123 details with id: {}" , foundTable8big123);

        return foundTable8big123;
    }

    @ApiOperation(value = "Updates the Table8big123 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table8big123 editTable8big123(@PathVariable("id") BigInteger id, @RequestBody Table8big123 table8big123) throws EntityNotFoundException {
        LOGGER.debug("Editing Table8big123 with id: {}" , table8big123.getId());

        table8big123.setId(id);
        table8big123 = table8big123Service.update(table8big123);
        LOGGER.debug("Table8big123 details with id: {}" , table8big123);

        return table8big123;
    }

    @ApiOperation(value = "Deletes the Table8big123 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable8big123(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table8big123 with id: {}" , id);

        Table8big123 deletedTable8big123 = table8big123Service.delete(id);

        return deletedTable8big123 != null;
    }

    /**
     * @deprecated Use {@link #findTable8big123s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table8big123 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table8big123> searchTable8big123sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table8big123s list");
        return table8big123Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table8big123 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table8big123> findTable8big123s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table8big123s list");
        return table8big123Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table8big123 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table8big123> filterTable8big123s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table8big123s list");
        return table8big123Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable8big123s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table8big123Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table8big123 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable8big123s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table8big123s");
		return table8big123Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable8big123AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table8big123Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table8big123Service instance
	 */
	protected void setTable8big123Service(Table8big123Service service) {
		this.table8big123Service = service;
	}

}
