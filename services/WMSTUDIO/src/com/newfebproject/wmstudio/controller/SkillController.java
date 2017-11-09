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

import com.newfebproject.wmstudio.Callrouting;
import com.newfebproject.wmstudio.Skill;
import com.newfebproject.wmstudio.service.SkillService;


/**
 * Controller object for domain model class Skill.
 * @see Skill
 */
@RestController("WMSTUDIO.SkillController")
@Api(value = "SkillController", description = "Exposes APIs to work with Skill resource.")
@RequestMapping("/WMSTUDIO/Skill")
public class SkillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillController.class);

    @Autowired
	@Qualifier("WMSTUDIO.SkillService")
	private SkillService skillService;

	@ApiOperation(value = "Creates a new Skill instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Skill createSkill(@RequestBody Skill skill) {
		LOGGER.debug("Create Skill with information: {}" , skill);

		skill = skillService.create(skill);
		LOGGER.debug("Created Skill with information: {}" , skill);

	    return skill;
	}


    @ApiOperation(value = "Returns the Skill instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Skill getSkill(@PathVariable("id") Double id) throws EntityNotFoundException {
        LOGGER.debug("Getting Skill with id: {}" , id);

        Skill foundSkill = skillService.getById(id);
        LOGGER.debug("Skill details with id: {}" , foundSkill);

        return foundSkill;
    }

    @ApiOperation(value = "Updates the Skill instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Skill editSkill(@PathVariable("id") Double id, @RequestBody Skill skill) throws EntityNotFoundException {
        LOGGER.debug("Editing Skill with id: {}" , skill.getId());

        skill.setId(id);
        skill = skillService.update(skill);
        LOGGER.debug("Skill details with id: {}" , skill);

        return skill;
    }

    @ApiOperation(value = "Deletes the Skill instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSkill(@PathVariable("id") Double id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Skill with id: {}" , id);

        Skill deletedSkill = skillService.delete(id);

        return deletedSkill != null;
    }

    /**
     * @deprecated Use {@link #findSkills(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Skill instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Skill> searchSkillsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Skills list");
        return skillService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Skill instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Skill> findSkills(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Skills list");
        return skillService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Skill instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Skill> filterSkills(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Skills list");
        return skillService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSkills(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return skillService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Skill instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSkills( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Skills");
		return skillService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getSkillAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return skillService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/callroutings", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the callroutings instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Callrouting> findAssociatedCallroutings(@PathVariable("id") Double id, Pageable pageable) {

        LOGGER.debug("Fetching all associated callroutings");
        return skillService.findAssociatedCallroutings(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SkillService instance
	 */
	protected void setSkillService(SkillService service) {
		this.skillService = service;
	}

}
