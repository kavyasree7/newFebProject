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

import com.newfebproject.wmstudio.BooleanDefaultValues;
import com.newfebproject.wmstudio.service.BooleanDefaultValuesService;


/**
 * Controller object for domain model class BooleanDefaultValues.
 * @see BooleanDefaultValues
 */
@RestController("WMSTUDIO.BooleanDefaultValuesController")
@Api(value = "BooleanDefaultValuesController", description = "Exposes APIs to work with BooleanDefaultValues resource.")
@RequestMapping("/WMSTUDIO/BooleanDefaultValues")
public class BooleanDefaultValuesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooleanDefaultValuesController.class);

    @Autowired
	@Qualifier("WMSTUDIO.BooleanDefaultValuesService")
	private BooleanDefaultValuesService booleanDefaultValuesService;

	@ApiOperation(value = "Creates a new BooleanDefaultValues instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public BooleanDefaultValues createBooleanDefaultValues(@RequestBody BooleanDefaultValues booleanDefaultValues) {
		LOGGER.debug("Create BooleanDefaultValues with information: {}" , booleanDefaultValues);

		booleanDefaultValues = booleanDefaultValuesService.create(booleanDefaultValues);
		LOGGER.debug("Created BooleanDefaultValues with information: {}" , booleanDefaultValues);

	    return booleanDefaultValues;
	}


    @ApiOperation(value = "Returns the BooleanDefaultValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BooleanDefaultValues getBooleanDefaultValues(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting BooleanDefaultValues with id: {}" , id);

        BooleanDefaultValues foundBooleanDefaultValues = booleanDefaultValuesService.getById(id);
        LOGGER.debug("BooleanDefaultValues details with id: {}" , foundBooleanDefaultValues);

        return foundBooleanDefaultValues;
    }

    @ApiOperation(value = "Updates the BooleanDefaultValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BooleanDefaultValues editBooleanDefaultValues(@PathVariable("id") Integer id, @RequestBody BooleanDefaultValues booleanDefaultValues) throws EntityNotFoundException {
        LOGGER.debug("Editing BooleanDefaultValues with id: {}" , booleanDefaultValues.getBooleanId());

        booleanDefaultValues.setBooleanId(id);
        booleanDefaultValues = booleanDefaultValuesService.update(booleanDefaultValues);
        LOGGER.debug("BooleanDefaultValues details with id: {}" , booleanDefaultValues);

        return booleanDefaultValues;
    }

    @ApiOperation(value = "Deletes the BooleanDefaultValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteBooleanDefaultValues(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting BooleanDefaultValues with id: {}" , id);

        BooleanDefaultValues deletedBooleanDefaultValues = booleanDefaultValuesService.delete(id);

        return deletedBooleanDefaultValues != null;
    }

    /**
     * @deprecated Use {@link #findBooleanDefaultValues(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of BooleanDefaultValues instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BooleanDefaultValues> searchBooleanDefaultValuesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering BooleanDefaultValues list");
        return booleanDefaultValuesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of BooleanDefaultValues instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BooleanDefaultValues> findBooleanDefaultValues(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BooleanDefaultValues list");
        return booleanDefaultValuesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of BooleanDefaultValues instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BooleanDefaultValues> filterBooleanDefaultValues(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BooleanDefaultValues list");
        return booleanDefaultValuesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportBooleanDefaultValues(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return booleanDefaultValuesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of BooleanDefaultValues instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countBooleanDefaultValues( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting BooleanDefaultValues");
		return booleanDefaultValuesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getBooleanDefaultValuesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return booleanDefaultValuesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BooleanDefaultValuesService instance
	 */
	protected void setBooleanDefaultValuesService(BooleanDefaultValuesService service) {
		this.booleanDefaultValuesService = service;
	}

}

