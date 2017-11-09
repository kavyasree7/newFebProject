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

import com.newfebproject.wmstudio.UdIfUtNullWithOutValues;
import com.newfebproject.wmstudio.service.UdIfUtNullWithOutValuesService;


/**
 * Controller object for domain model class UdIfUtNullWithOutValues.
 * @see UdIfUtNullWithOutValues
 */
@RestController("WMSTUDIO.UdIfUtNullWithOutValuesController")
@Api(value = "UdIfUtNullWithOutValuesController", description = "Exposes APIs to work with UdIfUtNullWithOutValues resource.")
@RequestMapping("/WMSTUDIO/UdIfUtNullWithOutValues")
public class UdIfUtNullWithOutValuesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdIfUtNullWithOutValuesController.class);

    @Autowired
	@Qualifier("WMSTUDIO.UdIfUtNullWithOutValuesService")
	private UdIfUtNullWithOutValuesService udIfUtNullWithOutValuesService;

	@ApiOperation(value = "Creates a new UdIfUtNullWithOutValues instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public UdIfUtNullWithOutValues createUdIfUtNullWithOutValues(@RequestBody UdIfUtNullWithOutValues udIfUtNullWithOutValues) {
		LOGGER.debug("Create UdIfUtNullWithOutValues with information: {}" , udIfUtNullWithOutValues);

		udIfUtNullWithOutValues = udIfUtNullWithOutValuesService.create(udIfUtNullWithOutValues);
		LOGGER.debug("Created UdIfUtNullWithOutValues with information: {}" , udIfUtNullWithOutValues);

	    return udIfUtNullWithOutValues;
	}

	@ApiOperation(value = "Creates a new UdIfUtNullWithOutValues instance.This API should be used when the UdIfUtNullWithOutValues instance has fields that requires multipart data.")
	@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdIfUtNullWithOutValues createUdIfUtNullWithOutValues(MultipartHttpServletRequest multipartHttpServletRequest) {
    	UdIfUtNullWithOutValues udIfUtNullWithOutValues = WMMultipartUtils.toObject(multipartHttpServletRequest, UdIfUtNullWithOutValues.class, "WMSTUDIO"); 
        LOGGER.debug("Creating a new UdIfUtNullWithOutValues with information: {}" , udIfUtNullWithOutValues);
        return udIfUtNullWithOutValuesService.create(udIfUtNullWithOutValues);
    }


    @ApiOperation(value = "Returns the UdIfUtNullWithOutValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdIfUtNullWithOutValues getUdIfUtNullWithOutValues(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting UdIfUtNullWithOutValues with id: {}" , id);

        UdIfUtNullWithOutValues foundUdIfUtNullWithOutValues = udIfUtNullWithOutValuesService.getById(id);
        LOGGER.debug("UdIfUtNullWithOutValues details with id: {}" , foundUdIfUtNullWithOutValues);

        return foundUdIfUtNullWithOutValues;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in UdIfUtNullWithOutValues instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getUdIfUtNullWithOutValuesBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in UdIfUtNullWithOutValues instance" , fieldName);

        if(!WMRuntimeUtils.isLob(UdIfUtNullWithOutValues.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        UdIfUtNullWithOutValues udIfUtNullWithOutValues = udIfUtNullWithOutValuesService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(udIfUtNullWithOutValues, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the UdIfUtNullWithOutValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdIfUtNullWithOutValues editUdIfUtNullWithOutValues(@PathVariable("id") Integer id, @RequestBody UdIfUtNullWithOutValues udIfUtNullWithOutValues) throws EntityNotFoundException {
        LOGGER.debug("Editing UdIfUtNullWithOutValues with id: {}" , udIfUtNullWithOutValues.getId());

        udIfUtNullWithOutValues.setId(id);
        udIfUtNullWithOutValues = udIfUtNullWithOutValuesService.update(udIfUtNullWithOutValues);
        LOGGER.debug("UdIfUtNullWithOutValues details with id: {}" , udIfUtNullWithOutValues);

        return udIfUtNullWithOutValues;
    }

    @ApiOperation(value = "Updates the UdIfUtNullWithOutValues instance associated with the given id.This API should be used when UdIfUtNullWithOutValues instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UdIfUtNullWithOutValues editUdIfUtNullWithOutValues(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        UdIfUtNullWithOutValues newUdIfUtNullWithOutValues = WMMultipartUtils.toObject(multipartHttpServletRequest, UdIfUtNullWithOutValues.class, "WMSTUDIO");
        newUdIfUtNullWithOutValues.setId(id);

        UdIfUtNullWithOutValues oldUdIfUtNullWithOutValues = udIfUtNullWithOutValuesService.getById(id);
        WMMultipartUtils.updateLobsContent(oldUdIfUtNullWithOutValues, newUdIfUtNullWithOutValues);
        LOGGER.debug("Updating UdIfUtNullWithOutValues with information: {}" , newUdIfUtNullWithOutValues);

        return udIfUtNullWithOutValuesService.update(newUdIfUtNullWithOutValues);
    }

    @ApiOperation(value = "Deletes the UdIfUtNullWithOutValues instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUdIfUtNullWithOutValues(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting UdIfUtNullWithOutValues with id: {}" , id);

        UdIfUtNullWithOutValues deletedUdIfUtNullWithOutValues = udIfUtNullWithOutValuesService.delete(id);

        return deletedUdIfUtNullWithOutValues != null;
    }

    /**
     * @deprecated Use {@link #findUdIfUtNullWithOutValues(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of UdIfUtNullWithOutValues instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdIfUtNullWithOutValues> searchUdIfUtNullWithOutValuesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering UdIfUtNullWithOutValues list");
        return udIfUtNullWithOutValuesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UdIfUtNullWithOutValues instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdIfUtNullWithOutValues> findUdIfUtNullWithOutValues(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UdIfUtNullWithOutValues list");
        return udIfUtNullWithOutValuesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UdIfUtNullWithOutValues instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UdIfUtNullWithOutValues> filterUdIfUtNullWithOutValues(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UdIfUtNullWithOutValues list");
        return udIfUtNullWithOutValuesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUdIfUtNullWithOutValues(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return udIfUtNullWithOutValuesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of UdIfUtNullWithOutValues instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUdIfUtNullWithOutValues( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting UdIfUtNullWithOutValues");
		return udIfUtNullWithOutValuesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUdIfUtNullWithOutValuesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return udIfUtNullWithOutValuesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UdIfUtNullWithOutValuesService instance
	 */
	protected void setUdIfUtNullWithOutValuesService(UdIfUtNullWithOutValuesService service) {
		this.udIfUtNullWithOutValuesService = service;
	}

}

