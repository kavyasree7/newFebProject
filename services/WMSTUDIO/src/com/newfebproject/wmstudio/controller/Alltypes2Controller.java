/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.newfebproject.wmstudio.Alltypes2;
import com.newfebproject.wmstudio.service.Alltypes2Service;


/**
 * Controller object for domain model class Alltypes2.
 * @see Alltypes2
 */
@RestController("WMSTUDIO.Alltypes2Controller")
@Api(value = "Alltypes2Controller", description = "Exposes APIs to work with Alltypes2 resource.")
@RequestMapping("/WMSTUDIO/Alltypes2")
public class Alltypes2Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Alltypes2Controller.class);

    @Autowired
	@Qualifier("WMSTUDIO.Alltypes2Service")
	private Alltypes2Service alltypes2Service;

	@ApiOperation(value = "Creates a new Alltypes2 instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Alltypes2 createAlltypes2(@RequestBody Alltypes2 alltypes2) {
		LOGGER.debug("Create Alltypes2 with information: {}" , alltypes2);

		alltypes2 = alltypes2Service.create(alltypes2);
		LOGGER.debug("Created Alltypes2 with information: {}" , alltypes2);

	    return alltypes2;
	}

	@ApiOperation(value = "Creates a new Alltypes2 instance.This API should be used when the Alltypes2 instance has fields that requires multipart data.")
	@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Alltypes2 createAlltypes2(MultipartHttpServletRequest multipartHttpServletRequest) {
    	Alltypes2 alltypes2 = WMMultipartUtils.toObject(multipartHttpServletRequest, Alltypes2.class, "WMSTUDIO"); 
        LOGGER.debug("Creating a new Alltypes2 with information: {}" , alltypes2);
        return alltypes2Service.create(alltypes2);
    }


    @ApiOperation(value = "Returns the Alltypes2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Alltypes2 getAlltypes2(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Alltypes2 with id: {}" , id);

        Alltypes2 foundAlltypes2 = alltypes2Service.getById(id);
        LOGGER.debug("Alltypes2 details with id: {}" , foundAlltypes2);

        return foundAlltypes2;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in Alltypes2 instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getAlltypes2BLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in Alltypes2 instance" , fieldName);

        if(!WMRuntimeUtils.isLob(Alltypes2.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Alltypes2 alltypes2 = alltypes2Service.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(alltypes2, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the Alltypes2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Alltypes2 editAlltypes2(@PathVariable("id") Integer id, @RequestBody Alltypes2 alltypes2) throws EntityNotFoundException {
        LOGGER.debug("Editing Alltypes2 with id: {}" , alltypes2.getId());

        alltypes2.setId(id);
        alltypes2 = alltypes2Service.update(alltypes2);
        LOGGER.debug("Alltypes2 details with id: {}" , alltypes2);

        return alltypes2;
    }

    @ApiOperation(value = "Updates the Alltypes2 instance associated with the given id.This API should be used when Alltypes2 instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Alltypes2 editAlltypes2(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Alltypes2 newAlltypes2 = WMMultipartUtils.toObject(multipartHttpServletRequest, Alltypes2.class, "WMSTUDIO");
        newAlltypes2.setId(id);

        Alltypes2 oldAlltypes2 = alltypes2Service.getById(id);
        WMMultipartUtils.updateLobsContent(oldAlltypes2, newAlltypes2);
        LOGGER.debug("Updating Alltypes2 with information: {}" , newAlltypes2);

        return alltypes2Service.update(newAlltypes2);
    }

    @ApiOperation(value = "Deletes the Alltypes2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAlltypes2(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Alltypes2 with id: {}" , id);

        Alltypes2 deletedAlltypes2 = alltypes2Service.delete(id);

        return deletedAlltypes2 != null;
    }

    /**
     * @deprecated Use {@link #findAlltypes2s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Alltypes2 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Alltypes2> searchAlltypes2sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Alltypes2s list");
        return alltypes2Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Alltypes2 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Alltypes2> findAlltypes2s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Alltypes2s list");
        return alltypes2Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Alltypes2 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Alltypes2> filterAlltypes2s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Alltypes2s list");
        return alltypes2Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAlltypes2s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return alltypes2Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Alltypes2 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAlltypes2s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Alltypes2s");
		return alltypes2Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAlltypes2AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return alltypes2Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Alltypes2Service instance
	 */
	protected void setAlltypes2Service(Alltypes2Service service) {
		this.alltypes2Service = service;
	}

}

