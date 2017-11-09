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

import com.newfebproject.kavyadb.Hemanth;
import com.newfebproject.kavyadb.service.HemanthService;


/**
 * Controller object for domain model class Hemanth.
 * @see Hemanth
 */
@RestController("kavyadb.HemanthController")
@Api(value = "HemanthController", description = "Exposes APIs to work with Hemanth resource.")
@RequestMapping("/kavyadb/Hemanth")
public class HemanthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HemanthController.class);

    @Autowired
	@Qualifier("kavyadb.HemanthService")
	private HemanthService hemanthService;

	@ApiOperation(value = "Creates a new Hemanth instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Hemanth createHemanth(@RequestBody Hemanth hemanth) {
		LOGGER.debug("Create Hemanth with information: {}" , hemanth);

		hemanth = hemanthService.create(hemanth);
		LOGGER.debug("Created Hemanth with information: {}" , hemanth);

	    return hemanth;
	}


    @ApiOperation(value = "Returns the Hemanth instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Hemanth getHemanth(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Hemanth with id: {}" , id);

        Hemanth foundHemanth = hemanthService.getById(id);
        LOGGER.debug("Hemanth details with id: {}" , foundHemanth);

        return foundHemanth;
    }

    @ApiOperation(value = "Updates the Hemanth instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Hemanth editHemanth(@PathVariable("id") Integer id, @RequestBody Hemanth hemanth) throws EntityNotFoundException {
        LOGGER.debug("Editing Hemanth with id: {}" , hemanth.getId());

        hemanth.setId(id);
        hemanth = hemanthService.update(hemanth);
        LOGGER.debug("Hemanth details with id: {}" , hemanth);

        return hemanth;
    }

    @ApiOperation(value = "Deletes the Hemanth instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteHemanth(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Hemanth with id: {}" , id);

        Hemanth deletedHemanth = hemanthService.delete(id);

        return deletedHemanth != null;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Hemanth with given unique key values.")
    public Hemanth getByUniqueKeyId(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Hemanth with uniques key UniqueKeyId");
        return hemanthService.getByUniqueKeyId(id);
    }

    /**
     * @deprecated Use {@link #findHemanths(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Hemanth instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Hemanth> searchHemanthsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Hemanths list");
        return hemanthService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Hemanth instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Hemanth> findHemanths(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Hemanths list");
        return hemanthService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Hemanth instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Hemanth> filterHemanths(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Hemanths list");
        return hemanthService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportHemanths(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return hemanthService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Hemanth instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countHemanths( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Hemanths");
		return hemanthService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getHemanthAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return hemanthService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service HemanthService instance
	 */
	protected void setHemanthService(HemanthService service) {
		this.hemanthService = service;
	}

}

