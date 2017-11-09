/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.sql.Date;
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

import com.newfebproject.sample.Empprojact;
import com.newfebproject.sample.Projact;
import com.newfebproject.sample.ProjactId;
import com.newfebproject.sample.service.ProjactService;


/**
 * Controller object for domain model class Projact.
 * @see Projact
 */
@RestController("SAMPLE.ProjactController")
@Api(value = "ProjactController", description = "Exposes APIs to work with Projact resource.")
@RequestMapping("/SAMPLE/Projact")
public class ProjactController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjactController.class);

    @Autowired
	@Qualifier("SAMPLE.ProjactService")
	private ProjactService projactService;

	@ApiOperation(value = "Creates a new Projact instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Projact createProjact(@RequestBody Projact projact) {
		LOGGER.debug("Create Projact with information: {}" , projact);

		projact = projactService.create(projact);
		LOGGER.debug("Created Projact with information: {}" , projact);

	    return projact;
	}

    @ApiOperation(value = "Returns the Projact instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Projact getProjact(@RequestParam("projno") String projno,@RequestParam("actno") Short actno,@RequestParam("acstdate") Date acstdate) throws EntityNotFoundException {

        ProjactId projactId = new ProjactId();
        projactId.setProjno(projno);
        projactId.setActno(actno);
        projactId.setAcstdate(acstdate);

        LOGGER.debug("Getting Projact with id: {}" , projactId);
        Projact projact = projactService.getById(projactId);
        LOGGER.debug("Projact details with id: {}" , projact);

        return projact;
    }



    @ApiOperation(value = "Updates the Projact instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Projact editProjact(@RequestParam("projno") String projno,@RequestParam("actno") Short actno,@RequestParam("acstdate") Date acstdate, @RequestBody Projact projact) throws EntityNotFoundException {

        projact.setProjno(projno);
        projact.setActno(actno);
        projact.setAcstdate(acstdate);

        LOGGER.debug("Projact details with id is updated with: {}" , projact);

        return projactService.update(projact);
    }


    @ApiOperation(value = "Deletes the Projact instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteProjact(@RequestParam("projno") String projno,@RequestParam("actno") Short actno,@RequestParam("acstdate") Date acstdate) throws EntityNotFoundException {

        ProjactId projactId = new ProjactId();
        projactId.setProjno(projno);
        projactId.setActno(actno);
        projactId.setAcstdate(acstdate);

        LOGGER.debug("Deleting Projact with id: {}" , projactId);
        Projact projact = projactService.delete(projactId);

        return projact != null;
    }


    /**
     * @deprecated Use {@link #findProjacts(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Projact instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Projact> searchProjactsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Projacts list");
        return projactService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Projact instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Projact> findProjacts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Projacts list");
        return projactService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Projact instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Projact> filterProjacts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Projacts list");
        return projactService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportProjacts(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return projactService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Projact instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countProjacts( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Projacts");
		return projactService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getProjactAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return projactService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/composite-id/empprojacts", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the empprojacts instance associated with the given composite-id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Empprojact> findAssociatedEmpprojacts(@RequestParam("projno") String projno,@RequestParam("actno") Short actno,@RequestParam("acstdate") Date acstdate, Pageable pageable) {

        LOGGER.debug("Fetching all associated empprojacts");
        return projactService.findAssociatedEmpprojacts(projno, actno, acstdate, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProjactService instance
	 */
	protected void setProjactService(ProjactService service) {
		this.projactService = service;
	}

}
