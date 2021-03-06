/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.controller;

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

import com.newfebproject.wmstudio.Departments;
import com.newfebproject.wmstudio.Locations;
import com.newfebproject.wmstudio.service.LocationsService;


/**
 * Controller object for domain model class Locations.
 * @see Locations
 */
@RestController("WMSTUDIO.LocationsController")
@Api(value = "LocationsController", description = "Exposes APIs to work with Locations resource.")
@RequestMapping("/WMSTUDIO/Locations")
public class LocationsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationsController.class);

    @Autowired
	@Qualifier("WMSTUDIO.LocationsService")
	private LocationsService locationsService;

	@ApiOperation(value = "Creates a new Locations instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Locations createLocations(@RequestBody Locations locations) {
		LOGGER.debug("Create Locations with information: {}" , locations);

		locations = locationsService.create(locations);
		LOGGER.debug("Created Locations with information: {}" , locations);

	    return locations;
	}


    @ApiOperation(value = "Returns the Locations instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Locations getLocations(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Getting Locations with id: {}" , id);

        Locations foundLocations = locationsService.getById(id);
        LOGGER.debug("Locations details with id: {}" , foundLocations);

        return foundLocations;
    }

    @ApiOperation(value = "Updates the Locations instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Locations editLocations(@PathVariable("id") Short id, @RequestBody Locations locations) throws EntityNotFoundException {
        LOGGER.debug("Editing Locations with id: {}" , locations.getLocationId());

        locations.setLocationId(id);
        locations = locationsService.update(locations);
        LOGGER.debug("Locations details with id: {}" , locations);

        return locations;
    }

    @ApiOperation(value = "Deletes the Locations instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteLocations(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Locations with id: {}" , id);

        Locations deletedLocations = locationsService.delete(id);

        return deletedLocations != null;
    }

    /**
     * @deprecated Use {@link #findLocations(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Locations instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Locations> searchLocationsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Locations list");
        return locationsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Locations instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Locations> findLocations(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Locations list");
        return locationsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Locations instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Locations> filterLocations(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Locations list");
        return locationsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportLocations(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return locationsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Locations instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countLocations( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Locations");
		return locationsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getLocationsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return locationsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/departmentses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the departmentses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Departments> findAssociatedDepartmentses(@PathVariable("id") Short id, Pageable pageable) {

        LOGGER.debug("Fetching all associated departmentses");
        return locationsService.findAssociatedDepartmentses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LocationsService instance
	 */
	protected void setLocationsService(LocationsService service) {
		this.locationsService = service;
	}

}

