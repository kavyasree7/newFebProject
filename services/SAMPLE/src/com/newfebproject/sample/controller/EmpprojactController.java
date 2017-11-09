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
import com.newfebproject.sample.EmpprojactId;
import com.newfebproject.sample.service.EmpprojactService;


/**
 * Controller object for domain model class Empprojact.
 * @see Empprojact
 */
@RestController("SAMPLE.EmpprojactController")
@Api(value = "EmpprojactController", description = "Exposes APIs to work with Empprojact resource.")
@RequestMapping("/SAMPLE/Empprojact")
public class EmpprojactController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpprojactController.class);

    @Autowired
	@Qualifier("SAMPLE.EmpprojactService")
	private EmpprojactService empprojactService;

	@ApiOperation(value = "Creates a new Empprojact instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Empprojact createEmpprojact(@RequestBody Empprojact empprojact) {
		LOGGER.debug("Create Empprojact with information: {}" , empprojact);

		empprojact = empprojactService.create(empprojact);
		LOGGER.debug("Created Empprojact with information: {}" , empprojact);

	    return empprojact;
	}

    @ApiOperation(value = "Returns the Empprojact instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Empprojact getEmpprojact(@RequestParam("empno") String empno,@RequestParam("projno") String projno,@RequestParam("actno") Short actno,@RequestParam("emptime") Float emptime,@RequestParam("emstdate") Date emstdate,@RequestParam("emendate") Date emendate) throws EntityNotFoundException {

        EmpprojactId empprojactId = new EmpprojactId();
        empprojactId.setEmpno(empno);
        empprojactId.setProjno(projno);
        empprojactId.setActno(actno);
        empprojactId.setEmptime(emptime);
        empprojactId.setEmstdate(emstdate);
        empprojactId.setEmendate(emendate);

        LOGGER.debug("Getting Empprojact with id: {}" , empprojactId);
        Empprojact empprojact = empprojactService.getById(empprojactId);
        LOGGER.debug("Empprojact details with id: {}" , empprojact);

        return empprojact;
    }



    @ApiOperation(value = "Updates the Empprojact instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Empprojact editEmpprojact(@RequestParam("empno") String empno,@RequestParam("projno") String projno,@RequestParam("actno") Short actno,@RequestParam("emptime") Float emptime,@RequestParam("emstdate") Date emstdate,@RequestParam("emendate") Date emendate, @RequestBody Empprojact empprojact) throws EntityNotFoundException {

        empprojact.setEmpno(empno);
        empprojact.setProjno(projno);
        empprojact.setActno(actno);
        empprojact.setEmptime(emptime);
        empprojact.setEmstdate(emstdate);
        empprojact.setEmendate(emendate);

        LOGGER.debug("Empprojact details with id is updated with: {}" , empprojact);

        return empprojactService.update(empprojact);
    }


    @ApiOperation(value = "Deletes the Empprojact instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteEmpprojact(@RequestParam("empno") String empno,@RequestParam("projno") String projno,@RequestParam("actno") Short actno,@RequestParam("emptime") Float emptime,@RequestParam("emstdate") Date emstdate,@RequestParam("emendate") Date emendate) throws EntityNotFoundException {

        EmpprojactId empprojactId = new EmpprojactId();
        empprojactId.setEmpno(empno);
        empprojactId.setProjno(projno);
        empprojactId.setActno(actno);
        empprojactId.setEmptime(emptime);
        empprojactId.setEmstdate(emstdate);
        empprojactId.setEmendate(emendate);

        LOGGER.debug("Deleting Empprojact with id: {}" , empprojactId);
        Empprojact empprojact = empprojactService.delete(empprojactId);

        return empprojact != null;
    }


    /**
     * @deprecated Use {@link #findEmpprojacts(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Empprojact instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Empprojact> searchEmpprojactsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Empprojacts list");
        return empprojactService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Empprojact instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Empprojact> findEmpprojacts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Empprojacts list");
        return empprojactService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Empprojact instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Empprojact> filterEmpprojacts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Empprojacts list");
        return empprojactService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportEmpprojacts(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return empprojactService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Empprojact instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countEmpprojacts( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Empprojacts");
		return empprojactService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getEmpprojactAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return empprojactService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmpprojactService instance
	 */
	protected void setEmpprojactService(EmpprojactService service) {
		this.empprojactService = service;
	}

}

