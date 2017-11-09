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

import com.newfebproject.wmstudio.JoiningDetails;
import com.newfebproject.wmstudio.SalaryDetails;
import com.newfebproject.wmstudio.UserDetails;
import com.newfebproject.wmstudio.service.UserDetailsService;


/**
 * Controller object for domain model class UserDetails.
 * @see UserDetails
 */
@RestController("WMSTUDIO.UserDetailsController")
@Api(value = "UserDetailsController", description = "Exposes APIs to work with UserDetails resource.")
@RequestMapping("/WMSTUDIO/UserDetails")
public class UserDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsController.class);

    @Autowired
	@Qualifier("WMSTUDIO.UserDetailsService")
	private UserDetailsService userDetailsService;

	@ApiOperation(value = "Creates a new UserDetails instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public UserDetails createUserDetails(@RequestBody UserDetails userDetailsInstance) {
		LOGGER.debug("Create UserDetails with information: {}" , userDetailsInstance);

		userDetailsInstance = userDetailsService.create(userDetailsInstance);
		LOGGER.debug("Created UserDetails with information: {}" , userDetailsInstance);

	    return userDetailsInstance;
	}

	@ApiOperation(value = "Creates a new UserDetails instance.This API should be used when the UserDetails instance has fields that requires multipart data.")
	@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserDetails createUserDetails(MultipartHttpServletRequest multipartHttpServletRequest) {
    	UserDetails userDetailsInstance = WMMultipartUtils.toObject(multipartHttpServletRequest, UserDetails.class, "WMSTUDIO"); 
        LOGGER.debug("Creating a new UserDetails with information: {}" , userDetailsInstance);
        return userDetailsService.create(userDetailsInstance);
    }


    @ApiOperation(value = "Returns the UserDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserDetails getUserDetails(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting UserDetails with id: {}" , id);

        UserDetails foundUserDetails = userDetailsService.getById(id);
        LOGGER.debug("UserDetails details with id: {}" , foundUserDetails);

        return foundUserDetails;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in UserDetails instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getUserDetailsBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in UserDetails instance" , fieldName);

        if(!WMRuntimeUtils.isLob(UserDetails.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        UserDetails userDetailsInstance = userDetailsService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(userDetailsInstance, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the UserDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserDetails editUserDetails(@PathVariable("id") Integer id, @RequestBody UserDetails userDetailsInstance) throws EntityNotFoundException {
        LOGGER.debug("Editing UserDetails with id: {}" , userDetailsInstance.getUserDetails());

        userDetailsInstance.setUserDetails(id);
        userDetailsInstance = userDetailsService.update(userDetailsInstance);
        LOGGER.debug("UserDetails details with id: {}" , userDetailsInstance);

        return userDetailsInstance;
    }

    @ApiOperation(value = "Updates the UserDetails instance associated with the given id.This API should be used when UserDetails instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserDetails editUserDetails(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        UserDetails newUserDetails = WMMultipartUtils.toObject(multipartHttpServletRequest, UserDetails.class, "WMSTUDIO");
        newUserDetails.setUserDetails(id);

        UserDetails oldUserDetails = userDetailsService.getById(id);
        WMMultipartUtils.updateLobsContent(oldUserDetails, newUserDetails);
        LOGGER.debug("Updating UserDetails with information: {}" , newUserDetails);

        return userDetailsService.update(newUserDetails);
    }

    @ApiOperation(value = "Deletes the UserDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUserDetails(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting UserDetails with id: {}" , id);

        UserDetails deletedUserDetails = userDetailsService.delete(id);

        return deletedUserDetails != null;
    }

    /**
     * @deprecated Use {@link #findUserDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of UserDetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserDetails> searchUserDetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering UserDetails list");
        return userDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UserDetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserDetails> findUserDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UserDetails list");
        return userDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UserDetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserDetails> filterUserDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UserDetails list");
        return userDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUserDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return userDetailsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of UserDetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUserDetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting UserDetails");
		return userDetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUserDetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return userDetailsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/joiningDetailses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the joiningDetailses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<JoiningDetails> findAssociatedJoiningDetailses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated joiningDetailses");
        return userDetailsService.findAssociatedJoiningDetailses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/salaryDetailses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the salaryDetailses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<SalaryDetails> findAssociatedSalaryDetailses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated salaryDetailses");
        return userDetailsService.findAssociatedSalaryDetailses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UserDetailsService instance
	 */
	protected void setUserDetailsService(UserDetailsService service) {
		this.userDetailsService = service;
	}

}

