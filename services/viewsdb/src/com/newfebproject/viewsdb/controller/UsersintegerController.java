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

import com.newfebproject.viewsdb.Usersinteger;
import com.newfebproject.viewsdb.service.UsersintegerService;


/**
 * Controller object for domain model class Usersinteger.
 * @see Usersinteger
 */
@RestController("viewsdb.UsersintegerController")
@Api(value = "UsersintegerController", description = "Exposes APIs to work with Usersinteger resource.")
@RequestMapping("/viewsdb/Usersinteger")
public class UsersintegerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersintegerController.class);

    @Autowired
	@Qualifier("viewsdb.UsersintegerService")
	private UsersintegerService usersintegerService;

	@ApiOperation(value = "Creates a new Usersinteger instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Usersinteger createUsersinteger(@RequestBody Usersinteger usersinteger) {
		LOGGER.debug("Create Usersinteger with information: {}" , usersinteger);

		usersinteger = usersintegerService.create(usersinteger);
		LOGGER.debug("Created Usersinteger with information: {}" , usersinteger);

	    return usersinteger;
	}


    @ApiOperation(value = "Returns the Usersinteger instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Usersinteger getUsersinteger(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Usersinteger with id: {}" , id);

        Usersinteger foundUsersinteger = usersintegerService.getById(id);
        LOGGER.debug("Usersinteger details with id: {}" , foundUsersinteger);

        return foundUsersinteger;
    }

    @ApiOperation(value = "Updates the Usersinteger instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Usersinteger editUsersinteger(@PathVariable("id") Integer id, @RequestBody Usersinteger usersinteger) throws EntityNotFoundException {
        LOGGER.debug("Editing Usersinteger with id: {}" , usersinteger.getUserid());

        usersinteger.setUserid(id);
        usersinteger = usersintegerService.update(usersinteger);
        LOGGER.debug("Usersinteger details with id: {}" , usersinteger);

        return usersinteger;
    }

    @ApiOperation(value = "Deletes the Usersinteger instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUsersinteger(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Usersinteger with id: {}" , id);

        Usersinteger deletedUsersinteger = usersintegerService.delete(id);

        return deletedUsersinteger != null;
    }

    /**
     * @deprecated Use {@link #findUsersintegers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Usersinteger instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Usersinteger> searchUsersintegersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Usersintegers list");
        return usersintegerService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Usersinteger instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Usersinteger> findUsersintegers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Usersintegers list");
        return usersintegerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Usersinteger instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Usersinteger> filterUsersintegers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Usersintegers list");
        return usersintegerService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUsersintegers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return usersintegerService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Usersinteger instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUsersintegers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Usersintegers");
		return usersintegerService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUsersintegerAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return usersintegerService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UsersintegerService instance
	 */
	protected void setUsersintegerService(UsersintegerService service) {
		this.usersintegerService = service;
	}

}

