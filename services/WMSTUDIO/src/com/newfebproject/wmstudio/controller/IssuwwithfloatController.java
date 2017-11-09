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

import com.newfebproject.wmstudio.Issuwwithfloat;
import com.newfebproject.wmstudio.service.IssuwwithfloatService;


/**
 * Controller object for domain model class Issuwwithfloat.
 * @see Issuwwithfloat
 */
@RestController("WMSTUDIO.IssuwwithfloatController")
@Api(value = "IssuwwithfloatController", description = "Exposes APIs to work with Issuwwithfloat resource.")
@RequestMapping("/WMSTUDIO/Issuwwithfloat")
public class IssuwwithfloatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IssuwwithfloatController.class);

    @Autowired
	@Qualifier("WMSTUDIO.IssuwwithfloatService")
	private IssuwwithfloatService issuwwithfloatService;

	@ApiOperation(value = "Creates a new Issuwwithfloat instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Issuwwithfloat createIssuwwithfloat(@RequestBody Issuwwithfloat issuwwithfloat) {
		LOGGER.debug("Create Issuwwithfloat with information: {}" , issuwwithfloat);

		issuwwithfloat = issuwwithfloatService.create(issuwwithfloat);
		LOGGER.debug("Created Issuwwithfloat with information: {}" , issuwwithfloat);

	    return issuwwithfloat;
	}


    @ApiOperation(value = "Returns the Issuwwithfloat instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Issuwwithfloat getIssuwwithfloat(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting Issuwwithfloat with id: {}" , id);

        Issuwwithfloat foundIssuwwithfloat = issuwwithfloatService.getById(id);
        LOGGER.debug("Issuwwithfloat details with id: {}" , foundIssuwwithfloat);

        return foundIssuwwithfloat;
    }

    @ApiOperation(value = "Updates the Issuwwithfloat instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Issuwwithfloat editIssuwwithfloat(@PathVariable("id") BigInteger id, @RequestBody Issuwwithfloat issuwwithfloat) throws EntityNotFoundException {
        LOGGER.debug("Editing Issuwwithfloat with id: {}" , issuwwithfloat.getColumn1());

        issuwwithfloat.setColumn1(id);
        issuwwithfloat = issuwwithfloatService.update(issuwwithfloat);
        LOGGER.debug("Issuwwithfloat details with id: {}" , issuwwithfloat);

        return issuwwithfloat;
    }

    @ApiOperation(value = "Deletes the Issuwwithfloat instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteIssuwwithfloat(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Issuwwithfloat with id: {}" , id);

        Issuwwithfloat deletedIssuwwithfloat = issuwwithfloatService.delete(id);

        return deletedIssuwwithfloat != null;
    }

    /**
     * @deprecated Use {@link #findIssuwwithfloats(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Issuwwithfloat instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Issuwwithfloat> searchIssuwwithfloatsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Issuwwithfloats list");
        return issuwwithfloatService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Issuwwithfloat instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Issuwwithfloat> findIssuwwithfloats(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Issuwwithfloats list");
        return issuwwithfloatService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Issuwwithfloat instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Issuwwithfloat> filterIssuwwithfloats(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Issuwwithfloats list");
        return issuwwithfloatService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportIssuwwithfloats(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return issuwwithfloatService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Issuwwithfloat instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countIssuwwithfloats( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Issuwwithfloats");
		return issuwwithfloatService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getIssuwwithfloatAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return issuwwithfloatService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service IssuwwithfloatService instance
	 */
	protected void setIssuwwithfloatService(IssuwwithfloatService service) {
		this.issuwwithfloatService = service;
	}

}

