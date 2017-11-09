/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.math.BigDecimal;
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

import com.newfebproject.viewsdb.NumberView;
import com.newfebproject.viewsdb.NumberViewId;
import com.newfebproject.viewsdb.service.NumberViewService;


/**
 * Controller object for domain model class NumberView.
 * @see NumberView
 */
@RestController("viewsdb.NumberViewController")
@Api(value = "NumberViewController", description = "Exposes APIs to work with NumberView resource.")
@RequestMapping("/viewsdb/NumberView")
public class NumberViewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberViewController.class);

    @Autowired
	@Qualifier("viewsdb.NumberViewService")
	private NumberViewService numberViewService;

	@ApiOperation(value = "Creates a new NumberView instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public NumberView createNumberView(@RequestBody NumberView numberView) {
		LOGGER.debug("Create NumberView with information: {}" , numberView);

		numberView = numberViewService.create(numberView);
		LOGGER.debug("Created NumberView with information: {}" , numberView);

	    return numberView;
	}

    @ApiOperation(value = "Returns the NumberView instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public NumberView getNumberView(@RequestParam("id") Integer id,@RequestParam("integerCol") Short integerCol,@RequestParam("shortCol") Short shortCol,@RequestParam("longCol") Integer longCol,@RequestParam("bigintegerCol") Integer bigintegerCol,@RequestParam("byteCol") BigDecimal byteCol,@RequestParam("floatCol") Short floatCol,@RequestParam("doubleCol") Double doubleCol) throws EntityNotFoundException {

        NumberViewId numberviewId = new NumberViewId();
        numberviewId.setId(id);
        numberviewId.setIntegerCol(integerCol);
        numberviewId.setShortCol(shortCol);
        numberviewId.setLongCol(longCol);
        numberviewId.setBigintegerCol(bigintegerCol);
        numberviewId.setByteCol(byteCol);
        numberviewId.setFloatCol(floatCol);
        numberviewId.setDoubleCol(doubleCol);

        LOGGER.debug("Getting NumberView with id: {}" , numberviewId);
        NumberView numberView = numberViewService.getById(numberviewId);
        LOGGER.debug("NumberView details with id: {}" , numberView);

        return numberView;
    }



    @ApiOperation(value = "Updates the NumberView instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public NumberView editNumberView(@RequestParam("id") Integer id,@RequestParam("integerCol") Short integerCol,@RequestParam("shortCol") Short shortCol,@RequestParam("longCol") Integer longCol,@RequestParam("bigintegerCol") Integer bigintegerCol,@RequestParam("byteCol") BigDecimal byteCol,@RequestParam("floatCol") Short floatCol,@RequestParam("doubleCol") Double doubleCol, @RequestBody NumberView numberView) throws EntityNotFoundException {

        numberView.setId(id);
        numberView.setIntegerCol(integerCol);
        numberView.setShortCol(shortCol);
        numberView.setLongCol(longCol);
        numberView.setBigintegerCol(bigintegerCol);
        numberView.setByteCol(byteCol);
        numberView.setFloatCol(floatCol);
        numberView.setDoubleCol(doubleCol);

        LOGGER.debug("NumberView details with id is updated with: {}" , numberView);

        return numberViewService.update(numberView);
    }


    @ApiOperation(value = "Deletes the NumberView instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteNumberView(@RequestParam("id") Integer id,@RequestParam("integerCol") Short integerCol,@RequestParam("shortCol") Short shortCol,@RequestParam("longCol") Integer longCol,@RequestParam("bigintegerCol") Integer bigintegerCol,@RequestParam("byteCol") BigDecimal byteCol,@RequestParam("floatCol") Short floatCol,@RequestParam("doubleCol") Double doubleCol) throws EntityNotFoundException {

        NumberViewId numberviewId = new NumberViewId();
        numberviewId.setId(id);
        numberviewId.setIntegerCol(integerCol);
        numberviewId.setShortCol(shortCol);
        numberviewId.setLongCol(longCol);
        numberviewId.setBigintegerCol(bigintegerCol);
        numberviewId.setByteCol(byteCol);
        numberviewId.setFloatCol(floatCol);
        numberviewId.setDoubleCol(doubleCol);

        LOGGER.debug("Deleting NumberView with id: {}" , numberviewId);
        NumberView numberView = numberViewService.delete(numberviewId);

        return numberView != null;
    }


    /**
     * @deprecated Use {@link #findNumberViews(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of NumberView instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<NumberView> searchNumberViewsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering NumberViews list");
        return numberViewService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of NumberView instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<NumberView> findNumberViews(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering NumberViews list");
        return numberViewService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of NumberView instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<NumberView> filterNumberViews(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering NumberViews list");
        return numberViewService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportNumberViews(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return numberViewService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of NumberView instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countNumberViews( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting NumberViews");
		return numberViewService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getNumberViewAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return numberViewService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service NumberViewService instance
	 */
	protected void setNumberViewService(NumberViewService service) {
		this.numberViewService = service;
	}

}

