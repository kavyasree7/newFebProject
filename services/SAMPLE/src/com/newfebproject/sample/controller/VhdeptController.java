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

import com.newfebproject.sample.Vhdept;
import com.newfebproject.sample.VhdeptId;
import com.newfebproject.sample.service.VhdeptService;


/**
 * Controller object for domain model class Vhdept.
 * @see Vhdept
 */
@RestController("SAMPLE.VhdeptController")
@Api(value = "VhdeptController", description = "Exposes APIs to work with Vhdept resource.")
@RequestMapping("/SAMPLE/Vhdept")
public class VhdeptController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VhdeptController.class);

    @Autowired
	@Qualifier("SAMPLE.VhdeptService")
	private VhdeptService vhdeptService;

	@ApiOperation(value = "Creates a new Vhdept instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Vhdept createVhdept(@RequestBody Vhdept vhdept) {
		LOGGER.debug("Create Vhdept with information: {}" , vhdept);

		vhdept = vhdeptService.create(vhdept);
		LOGGER.debug("Created Vhdept with information: {}" , vhdept);

	    return vhdept;
	}

    @ApiOperation(value = "Returns the Vhdept instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Vhdept getVhdept(@RequestParam("deptno") String deptno,@RequestParam("deptname") String deptname,@RequestParam("mgrno") String mgrno,@RequestParam("admrdept") String admrdept,@RequestParam("location") String location) throws EntityNotFoundException {

        VhdeptId vhdeptId = new VhdeptId();
        vhdeptId.setDeptno(deptno);
        vhdeptId.setDeptname(deptname);
        vhdeptId.setMgrno(mgrno);
        vhdeptId.setAdmrdept(admrdept);
        vhdeptId.setLocation(location);

        LOGGER.debug("Getting Vhdept with id: {}" , vhdeptId);
        Vhdept vhdept = vhdeptService.getById(vhdeptId);
        LOGGER.debug("Vhdept details with id: {}" , vhdept);

        return vhdept;
    }



    @ApiOperation(value = "Updates the Vhdept instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Vhdept editVhdept(@RequestParam("deptno") String deptno,@RequestParam("deptname") String deptname,@RequestParam("mgrno") String mgrno,@RequestParam("admrdept") String admrdept,@RequestParam("location") String location, @RequestBody Vhdept vhdept) throws EntityNotFoundException {

        vhdept.setDeptno(deptno);
        vhdept.setDeptname(deptname);
        vhdept.setMgrno(mgrno);
        vhdept.setAdmrdept(admrdept);
        vhdept.setLocation(location);

        LOGGER.debug("Vhdept details with id is updated with: {}" , vhdept);

        return vhdeptService.update(vhdept);
    }


    @ApiOperation(value = "Deletes the Vhdept instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteVhdept(@RequestParam("deptno") String deptno,@RequestParam("deptname") String deptname,@RequestParam("mgrno") String mgrno,@RequestParam("admrdept") String admrdept,@RequestParam("location") String location) throws EntityNotFoundException {

        VhdeptId vhdeptId = new VhdeptId();
        vhdeptId.setDeptno(deptno);
        vhdeptId.setDeptname(deptname);
        vhdeptId.setMgrno(mgrno);
        vhdeptId.setAdmrdept(admrdept);
        vhdeptId.setLocation(location);

        LOGGER.debug("Deleting Vhdept with id: {}" , vhdeptId);
        Vhdept vhdept = vhdeptService.delete(vhdeptId);

        return vhdept != null;
    }


    /**
     * @deprecated Use {@link #findVhdepts(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Vhdept instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Vhdept> searchVhdeptsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Vhdepts list");
        return vhdeptService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Vhdept instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Vhdept> findVhdepts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Vhdepts list");
        return vhdeptService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Vhdept instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Vhdept> filterVhdepts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Vhdepts list");
        return vhdeptService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVhdepts(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return vhdeptService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Vhdept instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countVhdepts( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Vhdepts");
		return vhdeptService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getVhdeptAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return vhdeptService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VhdeptService instance
	 */
	protected void setVhdeptService(VhdeptService service) {
		this.vhdeptService = service;
	}

}
