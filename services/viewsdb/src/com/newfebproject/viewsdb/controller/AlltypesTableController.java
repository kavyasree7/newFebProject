/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb.controller;

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

import com.newfebproject.viewsdb.AlltypesTable;
import com.newfebproject.viewsdb.service.AlltypesTableService;


/**
 * Controller object for domain model class AlltypesTable.
 * @see AlltypesTable
 */
@RestController("viewsdb.AlltypesTableController")
@Api(value = "AlltypesTableController", description = "Exposes APIs to work with AlltypesTable resource.")
@RequestMapping("/viewsdb/AlltypesTable")
public class AlltypesTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlltypesTableController.class);

    @Autowired
	@Qualifier("viewsdb.AlltypesTableService")
	private AlltypesTableService alltypesTableService;

	@ApiOperation(value = "Creates a new AlltypesTable instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public AlltypesTable createAlltypesTable(@RequestBody AlltypesTable alltypesTable) {
		LOGGER.debug("Create AlltypesTable with information: {}" , alltypesTable);

		alltypesTable = alltypesTableService.create(alltypesTable);
		LOGGER.debug("Created AlltypesTable with information: {}" , alltypesTable);

	    return alltypesTable;
	}

	@ApiOperation(value = "Creates a new AlltypesTable instance.This API should be used when the AlltypesTable instance has fields that requires multipart data.")
	@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AlltypesTable createAlltypesTable(MultipartHttpServletRequest multipartHttpServletRequest) {
    	AlltypesTable alltypesTable = WMMultipartUtils.toObject(multipartHttpServletRequest, AlltypesTable.class, "viewsdb"); 
        LOGGER.debug("Creating a new AlltypesTable with information: {}" , alltypesTable);
        return alltypesTableService.create(alltypesTable);
    }


    @ApiOperation(value = "Returns the AlltypesTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AlltypesTable getAlltypesTable(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting AlltypesTable with id: {}" , id);

        AlltypesTable foundAlltypesTable = alltypesTableService.getById(id);
        LOGGER.debug("AlltypesTable details with id: {}" , foundAlltypesTable);

        return foundAlltypesTable;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in AlltypesTable instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getAlltypesTableBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in AlltypesTable instance" , fieldName);

        if(!WMRuntimeUtils.isLob(AlltypesTable.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        AlltypesTable alltypesTable = alltypesTableService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(alltypesTable, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the AlltypesTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AlltypesTable editAlltypesTable(@PathVariable("id") Integer id, @RequestBody AlltypesTable alltypesTable) throws EntityNotFoundException {
        LOGGER.debug("Editing AlltypesTable with id: {}" , alltypesTable.getId());

        alltypesTable.setId(id);
        alltypesTable = alltypesTableService.update(alltypesTable);
        LOGGER.debug("AlltypesTable details with id: {}" , alltypesTable);

        return alltypesTable;
    }

    @ApiOperation(value = "Updates the AlltypesTable instance associated with the given id.This API should be used when AlltypesTable instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AlltypesTable editAlltypesTable(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        AlltypesTable newAlltypesTable = WMMultipartUtils.toObject(multipartHttpServletRequest, AlltypesTable.class, "viewsdb");
        newAlltypesTable.setId(id);

        AlltypesTable oldAlltypesTable = alltypesTableService.getById(id);
        WMMultipartUtils.updateLobsContent(oldAlltypesTable, newAlltypesTable);
        LOGGER.debug("Updating AlltypesTable with information: {}" , newAlltypesTable);

        return alltypesTableService.update(newAlltypesTable);
    }

    @ApiOperation(value = "Deletes the AlltypesTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAlltypesTable(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AlltypesTable with id: {}" , id);

        AlltypesTable deletedAlltypesTable = alltypesTableService.delete(id);

        return deletedAlltypesTable != null;
    }

    /**
     * @deprecated Use {@link #findAlltypesTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of AlltypesTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AlltypesTable> searchAlltypesTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AlltypesTables list");
        return alltypesTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AlltypesTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AlltypesTable> findAlltypesTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AlltypesTables list");
        return alltypesTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AlltypesTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AlltypesTable> filterAlltypesTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AlltypesTables list");
        return alltypesTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAlltypesTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return alltypesTableService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of AlltypesTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAlltypesTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting AlltypesTables");
		return alltypesTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAlltypesTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return alltypesTableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AlltypesTableService instance
	 */
	protected void setAlltypesTableService(AlltypesTableService service) {
		this.alltypesTableService = service;
	}

}

