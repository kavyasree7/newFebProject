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

import com.newfebproject.sample.Productsupplier;
import com.newfebproject.sample.ProductsupplierId;
import com.newfebproject.sample.service.ProductsupplierService;


/**
 * Controller object for domain model class Productsupplier.
 * @see Productsupplier
 */
@RestController("SAMPLE.ProductsupplierController")
@Api(value = "ProductsupplierController", description = "Exposes APIs to work with Productsupplier resource.")
@RequestMapping("/SAMPLE/Productsupplier")
public class ProductsupplierController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsupplierController.class);

    @Autowired
	@Qualifier("SAMPLE.ProductsupplierService")
	private ProductsupplierService productsupplierService;

	@ApiOperation(value = "Creates a new Productsupplier instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Productsupplier createProductsupplier(@RequestBody Productsupplier productsupplier) {
		LOGGER.debug("Create Productsupplier with information: {}" , productsupplier);

		productsupplier = productsupplierService.create(productsupplier);
		LOGGER.debug("Created Productsupplier with information: {}" , productsupplier);

	    return productsupplier;
	}

    @ApiOperation(value = "Returns the Productsupplier instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Productsupplier getProductsupplier(@RequestParam("pid") String pid,@RequestParam("sid") String sid) throws EntityNotFoundException {

        ProductsupplierId productsupplierId = new ProductsupplierId();
        productsupplierId.setPid(pid);
        productsupplierId.setSid(sid);

        LOGGER.debug("Getting Productsupplier with id: {}" , productsupplierId);
        Productsupplier productsupplier = productsupplierService.getById(productsupplierId);
        LOGGER.debug("Productsupplier details with id: {}" , productsupplier);

        return productsupplier;
    }



    @ApiOperation(value = "Updates the Productsupplier instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Productsupplier editProductsupplier(@RequestParam("pid") String pid,@RequestParam("sid") String sid, @RequestBody Productsupplier productsupplier) throws EntityNotFoundException {

        productsupplier.setPid(pid);
        productsupplier.setSid(sid);

        LOGGER.debug("Productsupplier details with id is updated with: {}" , productsupplier);

        return productsupplierService.update(productsupplier);
    }


    @ApiOperation(value = "Deletes the Productsupplier instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteProductsupplier(@RequestParam("pid") String pid,@RequestParam("sid") String sid) throws EntityNotFoundException {

        ProductsupplierId productsupplierId = new ProductsupplierId();
        productsupplierId.setPid(pid);
        productsupplierId.setSid(sid);

        LOGGER.debug("Deleting Productsupplier with id: {}" , productsupplierId);
        Productsupplier productsupplier = productsupplierService.delete(productsupplierId);

        return productsupplier != null;
    }


    /**
     * @deprecated Use {@link #findProductsuppliers(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Productsupplier instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Productsupplier> searchProductsuppliersByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Productsuppliers list");
        return productsupplierService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Productsupplier instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Productsupplier> findProductsuppliers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Productsuppliers list");
        return productsupplierService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Productsupplier instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Productsupplier> filterProductsuppliers(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Productsuppliers list");
        return productsupplierService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportProductsuppliers(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return productsupplierService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Productsupplier instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countProductsuppliers( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Productsuppliers");
		return productsupplierService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getProductsupplierAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return productsupplierService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProductsupplierService instance
	 */
	protected void setProductsupplierService(ProductsupplierService service) {
		this.productsupplierService = service;
	}

}
