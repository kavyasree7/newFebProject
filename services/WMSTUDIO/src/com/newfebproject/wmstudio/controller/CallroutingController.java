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

import com.newfebproject.wmstudio.Callrouting;
import com.newfebproject.wmstudio.service.CallroutingService;


/**
 * Controller object for domain model class Callrouting.
 * @see Callrouting
 */
@RestController("WMSTUDIO.CallroutingController")
@Api(value = "CallroutingController", description = "Exposes APIs to work with Callrouting resource.")
@RequestMapping("/WMSTUDIO/Callrouting")
public class CallroutingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallroutingController.class);

    @Autowired
	@Qualifier("WMSTUDIO.CallroutingService")
	private CallroutingService callroutingService;

	@ApiOperation(value = "Creates a new Callrouting instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Callrouting createCallrouting(@RequestBody Callrouting callrouting) {
		LOGGER.debug("Create Callrouting with information: {}" , callrouting);

		callrouting = callroutingService.create(callrouting);
		LOGGER.debug("Created Callrouting with information: {}" , callrouting);

	    return callrouting;
	}


    @ApiOperation(value = "Returns the Callrouting instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Callrouting getCallrouting(@PathVariable("id") Double id) throws EntityNotFoundException {
        LOGGER.debug("Getting Callrouting with id: {}" , id);

        Callrouting foundCallrouting = callroutingService.getById(id);
        LOGGER.debug("Callrouting details with id: {}" , foundCallrouting);

        return foundCallrouting;
    }

    @ApiOperation(value = "Updates the Callrouting instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Callrouting editCallrouting(@PathVariable("id") Double id, @RequestBody Callrouting callrouting) throws EntityNotFoundException {
        LOGGER.debug("Editing Callrouting with id: {}" , callrouting.getId());

        callrouting.setId(id);
        callrouting = callroutingService.update(callrouting);
        LOGGER.debug("Callrouting details with id: {}" , callrouting);

        return callrouting;
    }

    @ApiOperation(value = "Deletes the Callrouting instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCallrouting(@PathVariable("id") Double id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Callrouting with id: {}" , id);

        Callrouting deletedCallrouting = callroutingService.delete(id);

        return deletedCallrouting != null;
    }

    /**
     * @deprecated Use {@link #findCallroutings(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Callrouting instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Callrouting> searchCallroutingsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Callroutings list");
        return callroutingService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Callrouting instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Callrouting> findCallroutings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Callroutings list");
        return callroutingService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Callrouting instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Callrouting> filterCallroutings(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Callroutings list");
        return callroutingService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCallroutings(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return callroutingService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Callrouting instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCallroutings( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Callroutings");
		return callroutingService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCallroutingAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return callroutingService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CallroutingService instance
	 */
	protected void setCallroutingService(CallroutingService service) {
		this.callroutingService = service;
	}

}

