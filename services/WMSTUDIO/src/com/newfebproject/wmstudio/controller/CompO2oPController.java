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

import com.newfebproject.wmstudio.CompO2oP;
import com.newfebproject.wmstudio.CompO2oPId;
import com.newfebproject.wmstudio.service.CompO2oPService;


/**
 * Controller object for domain model class CompO2oP.
 * @see CompO2oP
 */
@RestController("WMSTUDIO.CompO2oPController")
@Api(value = "CompO2oPController", description = "Exposes APIs to work with CompO2oP resource.")
@RequestMapping("/WMSTUDIO/CompO2oP")
public class CompO2oPController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompO2oPController.class);

    @Autowired
	@Qualifier("WMSTUDIO.CompO2oPService")
	private CompO2oPService compO2oPService;

	@ApiOperation(value = "Creates a new CompO2oP instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public CompO2oP createCompO2oP(@RequestBody CompO2oP compO2oP) {
		LOGGER.debug("Create CompO2oP with information: {}" , compO2oP);

		compO2oP = compO2oPService.create(compO2oP);
		LOGGER.debug("Created CompO2oP with information: {}" , compO2oP);

	    return compO2oP;
	}

    @ApiOperation(value = "Returns the CompO2oP instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompO2oP getCompO2oP(@RequestParam("id") Integer id,@RequestParam("column2") String column2) throws EntityNotFoundException {

        CompO2oPId compo2opId = new CompO2oPId();
        compo2opId.setId(id);
        compo2opId.setColumn2(column2);

        LOGGER.debug("Getting CompO2oP with id: {}" , compo2opId);
        CompO2oP compO2oP = compO2oPService.getById(compo2opId);
        LOGGER.debug("CompO2oP details with id: {}" , compO2oP);

        return compO2oP;
    }



    @ApiOperation(value = "Updates the CompO2oP instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public CompO2oP editCompO2oP(@RequestParam("id") Integer id,@RequestParam("column2") String column2, @RequestBody CompO2oP compO2oP) throws EntityNotFoundException {

        compO2oP.setId(id);
        compO2oP.setColumn2(column2);

        LOGGER.debug("CompO2oP details with id is updated with: {}" , compO2oP);

        return compO2oPService.update(compO2oP);
    }


    @ApiOperation(value = "Deletes the CompO2oP instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteCompO2oP(@RequestParam("id") Integer id,@RequestParam("column2") String column2) throws EntityNotFoundException {

        CompO2oPId compo2opId = new CompO2oPId();
        compo2opId.setId(id);
        compo2opId.setColumn2(column2);

        LOGGER.debug("Deleting CompO2oP with id: {}" , compo2opId);
        CompO2oP compO2oP = compO2oPService.delete(compo2opId);

        return compO2oP != null;
    }


    /**
     * @deprecated Use {@link #findCompO2oPs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of CompO2oP instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompO2oP> searchCompO2oPsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CompO2oPs list");
        return compO2oPService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompO2oP instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompO2oP> findCompO2oPs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompO2oPs list");
        return compO2oPService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of CompO2oP instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<CompO2oP> filterCompO2oPs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompO2oPs list");
        return compO2oPService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportCompO2oPs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return compO2oPService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of CompO2oP instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countCompO2oPs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting CompO2oPs");
		return compO2oPService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getCompO2oPAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return compO2oPService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CompO2oPService instance
	 */
	protected void setCompO2oPService(CompO2oPService service) {
		this.compO2oPService = service;
	}

}

