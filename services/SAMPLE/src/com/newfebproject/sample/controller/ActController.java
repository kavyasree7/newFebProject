/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.controller;

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

import com.newfebproject.sample.Act;
import com.newfebproject.sample.service.ActService;


/**
 * Controller object for domain model class Act.
 * @see Act
 */
@RestController("SAMPLE.ActController")
@Api(value = "ActController", description = "Exposes APIs to work with Act resource.")
@RequestMapping("/SAMPLE/Act")
public class ActController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActController.class);

    @Autowired
	@Qualifier("SAMPLE.ActService")
	private ActService actService;

	@ApiOperation(value = "Creates a new Act instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Act createAct(@RequestBody Act act) {
		LOGGER.debug("Create Act with information: {}" , act);

		act = actService.create(act);
		LOGGER.debug("Created Act with information: {}" , act);

	    return act;
	}


    @ApiOperation(value = "Returns the Act instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Act getAct(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Getting Act with id: {}" , id);

        Act foundAct = actService.getById(id);
        LOGGER.debug("Act details with id: {}" , foundAct);

        return foundAct;
    }

    @ApiOperation(value = "Updates the Act instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Act editAct(@PathVariable("id") Short id, @RequestBody Act act) throws EntityNotFoundException {
        LOGGER.debug("Editing Act with id: {}" , act.getActno());

        act.setActno(id);
        act = actService.update(act);
        LOGGER.debug("Act details with id: {}" , act);

        return act;
    }

    @ApiOperation(value = "Deletes the Act instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAct(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Act with id: {}" , id);

        Act deletedAct = actService.delete(id);

        return deletedAct != null;
    }

    @RequestMapping(value = "/actno-actkwd", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Act with given unique key values.")
    public Act getByActnoAndActkwd(@RequestParam("actno") short actno, @RequestParam("actkwd") String actkwd) {
        LOGGER.debug("Getting Act with uniques key ActnoAndActkwd");
        return actService.getByActnoAndActkwd(actno, actkwd);
    }

    /**
     * @deprecated Use {@link #findActs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Act instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Act> searchActsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Acts list");
        return actService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Act instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Act> findActs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Acts list");
        return actService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Act instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Act> filterActs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Acts list");
        return actService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportActs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return actService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Act instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countActs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Acts");
		return actService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getActAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return actService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ActService instance
	 */
	protected void setActService(ActService service) {
		this.actService = service;
	}

}
