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

import com.newfebproject.wmstudio.UdUpdatableWithValues;
import com.newfebproject.wmstudio.service.UdUpdatableWithValuesService;


/**
 * Controller object for domain model class UdUpdatableWithValues.
 * @see UdUpdatableWithValues
 */
@RestController("WMSTUDIO.UdUpdatableWithValuesController")
@Api(value = "UdUpdatableWithValuesController", description = "Exposes APIs to work with UdUpdatableWithValues resource.")
@RequestMapping("/WMSTUDIO/UdUpdatableWithValues")
public class UdUpdatableWithValuesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdUpdatableWithValuesController.class);

    @Autowired
	@Qualifier("WMSTUDIO.UdUpdatableWithValuesService")
	private UdUpdatableWithValuesService udUpdatableWithValuesService;

	@ApiOperation(value = "Creates a new UdUpdatableWithValues instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public UdUpdatableWithValues createUdUpdatableWithValues(@RequestBody UdUpdatableWithValues udUpdatableWithValues) {
		LOGGER.debug("Create UdUpdatableWithValues with information: {}" , udUpdatableWithValues);

		udUpdatableWithValues = udUpdatableWithValuesService.create(udUpdatableWithValues);
		LOGGER.debug("Created UdUpdatableWithValues with information: {}" , udUpdatableWithValues);

	    return udUpdatableWithValues;
	}

	@ApiOperation(value = "Creates a new UdUpdatableWithValues instance.This API should be used when the UdUpdatableWithValues instance has fields that requires multipart data.")
	@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdUpdatableWithValues createUdUpdatableWithValues(MultipartHttpServletRequest multipartHttpServletRequest) {
    	UdUpdatableWithValues udUpdatableWithValues = WMMultipartUtils.toObject(multipartHttpServletRequest, UdUpdatableWithValues.class, "WMSTUDIO"); 
        LOGGER.debug("Creating a new UdUpdatableWithValues with information: {}" , udUpdatableWithValues);
        return udUpdatableWithValuesService.create(udUpdatableWithValues);
    }


    @ApiOperation(value = "Returns the UdUpdatableWithValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdUpdatableWithValues getUdUpdatableWithValues(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting UdUpdatableWithValues with id: {}" , id);

        UdUpdatableWithValues foundUdUpdatableWithValues = udUpdatableWithValuesService.getById(id);
        LOGGER.debug("UdUpdatableWithValues details with id: {}" , foundUdUpdatableWithValues);

        return foundUdUpdatableWithValues;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in UdUpdatableWithValues instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getUdUpdatableWithValuesBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in UdUpdatableWithValues instance" , fieldName);

        if(!WMRuntimeUtils.isLob(UdUpdatableWithValues.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        UdUpdatableWithValues udUpdatableWithValues = udUpdatableWithValuesService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(udUpdatableWithValues, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the UdUpdatableWithValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdUpdatableWithValues editUdUpdatableWithValues(@PathVariable("id") Integer id, @RequestBody UdUpdatableWithValues udUpdatableWithValues) throws EntityNotFoundException {
        LOGGER.debug("Editing UdUpdatableWithValues with id: {}" , udUpdatableWithValues.getIdCol());

        udUpdatableWithValues.setIdCol(id);
        udUpdatableWithValues = udUpdatableWithValuesService.update(udUpdatableWithValues);
        LOGGER.debug("UdUpdatableWithValues details with id: {}" , udUpdatableWithValues);

        return udUpdatableWithValues;
    }

    @ApiOperation(value = "Updates the UdUpdatableWithValues instance associated with the given id.This API should be used when UdUpdatableWithValues instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdUpdatableWithValues editUdUpdatableWithValues(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        UdUpdatableWithValues newUdUpdatableWithValues = WMMultipartUtils.toObject(multipartHttpServletRequest, UdUpdatableWithValues.class, "WMSTUDIO");
        newUdUpdatableWithValues.setIdCol(id);

        UdUpdatableWithValues oldUdUpdatableWithValues = udUpdatableWithValuesService.getById(id);
        WMMultipartUtils.updateLobsContent(oldUdUpdatableWithValues, newUdUpdatableWithValues);
        LOGGER.debug("Updating UdUpdatableWithValues with information: {}" , newUdUpdatableWithValues);

        return udUpdatableWithValuesService.update(newUdUpdatableWithValues);
    }

    @ApiOperation(value = "Deletes the UdUpdatableWithValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUdUpdatableWithValues(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting UdUpdatableWithValues with id: {}" , id);

        UdUpdatableWithValues deletedUdUpdatableWithValues = udUpdatableWithValuesService.delete(id);

        return deletedUdUpdatableWithValues != null;
    }

    /**
     * @deprecated Use {@link #findUdUpdatableWithValues(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of UdUpdatableWithValues instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdUpdatableWithValues> searchUdUpdatableWithValuesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering UdUpdatableWithValues list");
        return udUpdatableWithValuesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UdUpdatableWithValues instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdUpdatableWithValues> findUdUpdatableWithValues(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UdUpdatableWithValues list");
        return udUpdatableWithValuesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UdUpdatableWithValues instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdUpdatableWithValues> filterUdUpdatableWithValues(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UdUpdatableWithValues list");
        return udUpdatableWithValuesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUdUpdatableWithValues(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return udUpdatableWithValuesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of UdUpdatableWithValues instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUdUpdatableWithValues( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting UdUpdatableWithValues");
		return udUpdatableWithValuesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUdUpdatableWithValuesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return udUpdatableWithValuesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UdUpdatableWithValuesService instance
	 */
	protected void setUdUpdatableWithValuesService(UdUpdatableWithValuesService service) {
		this.udUpdatableWithValuesService = service;
	}

}

