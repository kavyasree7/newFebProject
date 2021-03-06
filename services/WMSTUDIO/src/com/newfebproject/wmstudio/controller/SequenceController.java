/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.math.BigInteger;
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

import com.newfebproject.wmstudio.Sequence;
import com.newfebproject.wmstudio.SequenceId;
import com.newfebproject.wmstudio.service.SequenceService;


/**
 * Controller object for domain model class Sequence.
 * @see Sequence
 */
@RestController("WMSTUDIO.SequenceController")
@Api(value = "SequenceController", description = "Exposes APIs to work with Sequence resource.")
@RequestMapping("/WMSTUDIO/Sequence")
public class SequenceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SequenceController.class);

    @Autowired
	@Qualifier("WMSTUDIO.SequenceService")
	private SequenceService sequenceService;

	@ApiOperation(value = "Creates a new Sequence instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Sequence createSequence(@RequestBody Sequence sequence) {
		LOGGER.debug("Create Sequence with information: {}" , sequence);

		sequence = sequenceService.create(sequence);
		LOGGER.debug("Created Sequence with information: {}" , sequence);

	    return sequence;
	}

    @ApiOperation(value = "Returns the Sequence instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Sequence getSequence(@RequestParam("column1") String column1,@RequestParam("shortColumn") BigInteger shortColumn,@RequestParam("bigintegerColumn") BigInteger bigintegerColumn) throws EntityNotFoundException {

        SequenceId sequenceId = new SequenceId();
        sequenceId.setColumn1(column1);
        sequenceId.setShortColumn(shortColumn);
        sequenceId.setBigintegerColumn(bigintegerColumn);

        LOGGER.debug("Getting Sequence with id: {}" , sequenceId);
        Sequence sequence = sequenceService.getById(sequenceId);
        LOGGER.debug("Sequence details with id: {}" , sequence);

        return sequence;
    }



    @ApiOperation(value = "Updates the Sequence instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Sequence editSequence(@RequestParam("column1") String column1,@RequestParam("shortColumn") BigInteger shortColumn,@RequestParam("bigintegerColumn") BigInteger bigintegerColumn, @RequestBody Sequence sequence) throws EntityNotFoundException {

        sequence.setColumn1(column1);
        sequence.setShortColumn(shortColumn);
        sequence.setBigintegerColumn(bigintegerColumn);

        LOGGER.debug("Sequence details with id is updated with: {}" , sequence);

        return sequenceService.update(sequence);
    }


    @ApiOperation(value = "Deletes the Sequence instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSequence(@RequestParam("column1") String column1,@RequestParam("shortColumn") BigInteger shortColumn,@RequestParam("bigintegerColumn") BigInteger bigintegerColumn) throws EntityNotFoundException {

        SequenceId sequenceId = new SequenceId();
        sequenceId.setColumn1(column1);
        sequenceId.setShortColumn(shortColumn);
        sequenceId.setBigintegerColumn(bigintegerColumn);

        LOGGER.debug("Deleting Sequence with id: {}" , sequenceId);
        Sequence sequence = sequenceService.delete(sequenceId);

        return sequence != null;
    }


    /**
     * @deprecated Use {@link #findSequences(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Sequence instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Sequence> searchSequencesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Sequences list");
        return sequenceService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Sequence instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Sequence> findSequences(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Sequences list");
        return sequenceService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Sequence instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Sequence> filterSequences(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Sequences list");
        return sequenceService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSequences(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return sequenceService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Sequence instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSequences( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Sequences");
		return sequenceService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSequenceAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return sequenceService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SequenceService instance
	 */
	protected void setSequenceService(SequenceService service) {
		this.sequenceService = service;
	}

}

