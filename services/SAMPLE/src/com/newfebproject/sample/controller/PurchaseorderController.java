/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.math.BigInteger;
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

import com.newfebproject.sample.Purchaseorder;
import com.newfebproject.sample.service.PurchaseorderService;


/**
 * Controller object for domain model class Purchaseorder.
 * @see Purchaseorder
 */
@RestController("SAMPLE.PurchaseorderController")
@Api(value = "PurchaseorderController", description = "Exposes APIs to work with Purchaseorder resource.")
@RequestMapping("/SAMPLE/Purchaseorder")
public class PurchaseorderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseorderController.class);

    @Autowired
	@Qualifier("SAMPLE.PurchaseorderService")
	private PurchaseorderService purchaseorderService;

	@ApiOperation(value = "Creates a new Purchaseorder instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Purchaseorder createPurchaseorder(@RequestBody Purchaseorder purchaseorder) {
		LOGGER.debug("Create Purchaseorder with information: {}" , purchaseorder);

		purchaseorder = purchaseorderService.create(purchaseorder);
		LOGGER.debug("Created Purchaseorder with information: {}" , purchaseorder);

	    return purchaseorder;
	}

	@ApiOperation(value = "Creates a new Purchaseorder instance.This API should be used when the Purchaseorder instance has fields that requires multipart data.")
	@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Purchaseorder createPurchaseorder(MultipartHttpServletRequest multipartHttpServletRequest) {
    	Purchaseorder purchaseorder = WMMultipartUtils.toObject(multipartHttpServletRequest, Purchaseorder.class, "SAMPLE"); 
        LOGGER.debug("Creating a new Purchaseorder with information: {}" , purchaseorder);
        return purchaseorderService.create(purchaseorder);
    }


    @ApiOperation(value = "Returns the Purchaseorder instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Purchaseorder getPurchaseorder(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Getting Purchaseorder with id: {}" , id);

        Purchaseorder foundPurchaseorder = purchaseorderService.getById(id);
        LOGGER.debug("Purchaseorder details with id: {}" , foundPurchaseorder);

        return foundPurchaseorder;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in Purchaseorder instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getPurchaseorderBLOBContent(@PathVariable("id") BigInteger id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in Purchaseorder instance" , fieldName);

        if(!WMRuntimeUtils.isLob(Purchaseorder.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        Purchaseorder purchaseorder = purchaseorderService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(purchaseorder, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the Purchaseorder instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Purchaseorder editPurchaseorder(@PathVariable("id") BigInteger id, @RequestBody Purchaseorder purchaseorder) throws EntityNotFoundException {
        LOGGER.debug("Editing Purchaseorder with id: {}" , purchaseorder.getPoid());

        purchaseorder.setPoid(id);
        purchaseorder = purchaseorderService.update(purchaseorder);
        LOGGER.debug("Purchaseorder details with id: {}" , purchaseorder);

        return purchaseorder;
    }

    @ApiOperation(value = "Updates the Purchaseorder instance associated with the given id.This API should be used when Purchaseorder instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Purchaseorder editPurchaseorder(@PathVariable("id") BigInteger id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        Purchaseorder newPurchaseorder = WMMultipartUtils.toObject(multipartHttpServletRequest, Purchaseorder.class, "SAMPLE");
        newPurchaseorder.setPoid(id);

        Purchaseorder oldPurchaseorder = purchaseorderService.getById(id);
        WMMultipartUtils.updateLobsContent(oldPurchaseorder, newPurchaseorder);
        LOGGER.debug("Updating Purchaseorder with information: {}" , newPurchaseorder);

        return purchaseorderService.update(newPurchaseorder);
    }

    @ApiOperation(value = "Deletes the Purchaseorder instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePurchaseorder(@PathVariable("id") BigInteger id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Purchaseorder with id: {}" , id);

        Purchaseorder deletedPurchaseorder = purchaseorderService.delete(id);

        return deletedPurchaseorder != null;
    }

    /**
     * @deprecated Use {@link #findPurchaseorders(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Purchaseorder instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Purchaseorder> searchPurchaseordersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Purchaseorders list");
        return purchaseorderService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Purchaseorder instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Purchaseorder> findPurchaseorders(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Purchaseorders list");
        return purchaseorderService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Purchaseorder instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Purchaseorder> filterPurchaseorders(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Purchaseorders list");
        return purchaseorderService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPurchaseorders(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return purchaseorderService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Purchaseorder instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPurchaseorders( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Purchaseorders");
		return purchaseorderService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPurchaseorderAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return purchaseorderService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PurchaseorderService instance
	 */
	protected void setPurchaseorderService(PurchaseorderService service) {
		this.purchaseorderService = service;
	}

}

