/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb.controller;

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

import com.newfebproject.viewsdb.Table278;
import com.newfebproject.viewsdb.service.Table278Service;


/**
 * Controller object for domain model class Table278.
 * @see Table278
 */
@RestController("viewsdb.Table278Controller")
@Api(value = "Table278Controller", description = "Exposes APIs to work with Table278 resource.")
@RequestMapping("/viewsdb/Table278")
public class Table278Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table278Controller.class);

    @Autowired
	@Qualifier("viewsdb.Table278Service")
	private Table278Service table278Service;

	@ApiOperation(value = "Creates a new Table278 instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Table278 createTable278(@RequestBody Table278 table278) {
		LOGGER.debug("Create Table278 with information: {}" , table278);

		table278 = table278Service.create(table278);
		LOGGER.debug("Created Table278 with information: {}" , table278);

	    return table278;
	}


    @ApiOperation(value = "Returns the Table278 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table278 getTable278(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table278 with id: {}" , id);

        Table278 foundTable278 = table278Service.getById(id);
        LOGGER.debug("Table278 details with id: {}" , foundTable278);

        return foundTable278;
    }

    @ApiOperation(value = "Updates the Table278 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table278 editTable278(@PathVariable("id") Integer id, @RequestBody Table278 table278) throws EntityNotFoundException {
        LOGGER.debug("Editing Table278 with id: {}" , table278.getId());

        table278.setId(id);
        table278 = table278Service.update(table278);
        LOGGER.debug("Table278 details with id: {}" , table278);

        return table278;
    }

    @ApiOperation(value = "Deletes the Table278 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable278(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table278 with id: {}" , id);

        Table278 deletedTable278 = table278Service.delete(id);

        return deletedTable278 != null;
    }

    /**
     * @deprecated Use {@link #findTable278s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table278 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table278> searchTable278sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table278s list");
        return table278Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table278 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table278> findTable278s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table278s list");
        return table278Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table278 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table278> filterTable278s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table278s list");
        return table278Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable278s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table278Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table278 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable278s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table278s");
		return table278Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable278AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table278Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table278Service instance
	 */
	protected void setTable278Service(Table278Service service) {
		this.table278Service = service;
	}

}
