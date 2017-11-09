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

import com.newfebproject.wmstudio.UdUpdatableWithOutValues;
import com.newfebproject.wmstudio.service.UdUpdatableWithOutValuesService;


/**
 * Controller object for domain model class UdUpdatableWithOutValues.
 * @see UdUpdatableWithOutValues
 */
@RestController("WMSTUDIO.UdUpdatableWithOutValuesController")
@Api(value = "UdUpdatableWithOutValuesController", description = "Exposes APIs to work with UdUpdatableWithOutValues resource.")
@RequestMapping("/WMSTUDIO/UdUpdatableWithOutValues")
public class UdUpdatableWithOutValuesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdUpdatableWithOutValuesController.class);

    @Autowired
	@Qualifier("WMSTUDIO.UdUpdatableWithOutValuesService")
	private UdUpdatableWithOutValuesService udUpdatableWithOutValuesService;

	@ApiOperation(value = "Creates a new UdUpdatableWithOutValues instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public UdUpdatableWithOutValues createUdUpdatableWithOutValues(@RequestBody UdUpdatableWithOutValues udUpdatableWithOutValues) {
		LOGGER.debug("Create UdUpdatableWithOutValues with information: {}" , udUpdatableWithOutValues);

		udUpdatableWithOutValues = udUpdatableWithOutValuesService.create(udUpdatableWithOutValues);
		LOGGER.debug("Created UdUpdatableWithOutValues with information: {}" , udUpdatableWithOutValues);

	    return udUpdatableWithOutValues;
	}

	@ApiOperation(value = "Creates a new UdUpdatableWithOutValues instance.This API should be used when the UdUpdatableWithOutValues instance has fields that requires multipart data.")
	@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdUpdatableWithOutValues createUdUpdatableWithOutValues(MultipartHttpServletRequest multipartHttpServletRequest) {
    	UdUpdatableWithOutValues udUpdatableWithOutValues = WMMultipartUtils.toObject(multipartHttpServletRequest, UdUpdatableWithOutValues.class, "WMSTUDIO"); 
        LOGGER.debug("Creating a new UdUpdatableWithOutValues with information: {}" , udUpdatableWithOutValues);
        return udUpdatableWithOutValuesService.create(udUpdatableWithOutValues);
    }


    @ApiOperation(value = "Returns the UdUpdatableWithOutValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdUpdatableWithOutValues getUdUpdatableWithOutValues(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting UdUpdatableWithOutValues with id: {}" , id);

        UdUpdatableWithOutValues foundUdUpdatableWithOutValues = udUpdatableWithOutValuesService.getById(id);
        LOGGER.debug("UdUpdatableWithOutValues details with id: {}" , foundUdUpdatableWithOutValues);

        return foundUdUpdatableWithOutValues;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in UdUpdatableWithOutValues instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getUdUpdatableWithOutValuesBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in UdUpdatableWithOutValues instance" , fieldName);

        if(!WMRuntimeUtils.isLob(UdUpdatableWithOutValues.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        UdUpdatableWithOutValues udUpdatableWithOutValues = udUpdatableWithOutValuesService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(udUpdatableWithOutValues, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the UdUpdatableWithOutValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdUpdatableWithOutValues editUdUpdatableWithOutValues(@PathVariable("id") Integer id, @RequestBody UdUpdatableWithOutValues udUpdatableWithOutValues) throws EntityNotFoundException {
        LOGGER.debug("Editing UdUpdatableWithOutValues with id: {}" , udUpdatableWithOutValues.getIdCol());

        udUpdatableWithOutValues.setIdCol(id);
        udUpdatableWithOutValues = udUpdatableWithOutValuesService.update(udUpdatableWithOutValues);
        LOGGER.debug("UdUpdatableWithOutValues details with id: {}" , udUpdatableWithOutValues);

        return udUpdatableWithOutValues;
    }

    @ApiOperation(value = "Updates the UdUpdatableWithOutValues instance associated with the given id.This API should be used when UdUpdatableWithOutValues instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdUpdatableWithOutValues editUdUpdatableWithOutValues(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        UdUpdatableWithOutValues newUdUpdatableWithOutValues = WMMultipartUtils.toObject(multipartHttpServletRequest, UdUpdatableWithOutValues.class, "WMSTUDIO");
        newUdUpdatableWithOutValues.setIdCol(id);

        UdUpdatableWithOutValues oldUdUpdatableWithOutValues = udUpdatableWithOutValuesService.getById(id);
        WMMultipartUtils.updateLobsContent(oldUdUpdatableWithOutValues, newUdUpdatableWithOutValues);
        LOGGER.debug("Updating UdUpdatableWithOutValues with information: {}" , newUdUpdatableWithOutValues);

        return udUpdatableWithOutValuesService.update(newUdUpdatableWithOutValues);
    }

    @ApiOperation(value = "Deletes the UdUpdatableWithOutValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUdUpdatableWithOutValues(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting UdUpdatableWithOutValues with id: {}" , id);

        UdUpdatableWithOutValues deletedUdUpdatableWithOutValues = udUpdatableWithOutValuesService.delete(id);

        return deletedUdUpdatableWithOutValues != null;
    }

    /**
     * @deprecated Use {@link #findUdUpdatableWithOutValues(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of UdUpdatableWithOutValues instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdUpdatableWithOutValues> searchUdUpdatableWithOutValuesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering UdUpdatableWithOutValues list");
        return udUpdatableWithOutValuesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UdUpdatableWithOutValues instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdUpdatableWithOutValues> findUdUpdatableWithOutValues(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UdUpdatableWithOutValues list");
        return udUpdatableWithOutValuesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UdUpdatableWithOutValues instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdUpdatableWithOutValues> filterUdUpdatableWithOutValues(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UdUpdatableWithOutValues list");
        return udUpdatableWithOutValuesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUdUpdatableWithOutValues(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return udUpdatableWithOutValuesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of UdUpdatableWithOutValues instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUdUpdatableWithOutValues( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting UdUpdatableWithOutValues");
		return udUpdatableWithOutValuesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUdUpdatableWithOutValuesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return udUpdatableWithOutValuesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UdUpdatableWithOutValuesService instance
	 */
	protected void setUdUpdatableWithOutValuesService(UdUpdatableWithOutValuesService service) {
		this.udUpdatableWithOutValuesService = service;
	}

}
