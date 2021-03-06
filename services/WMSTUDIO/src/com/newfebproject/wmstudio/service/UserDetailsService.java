/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.wmstudio.JoiningDetails;
import com.newfebproject.wmstudio.SalaryDetails;
import com.newfebproject.wmstudio.UserDetails;

/**
 * Service object for domain model class {@link UserDetails}.
 */
public interface UserDetailsService {

    /**
     * Creates a new UserDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UserDetails if any.
     *
     * @param userDetailsInstance Details of the UserDetails to be created; value cannot be null.
     * @return The newly created UserDetails.
     */
	UserDetails create(UserDetails userDetailsInstance);


	/**
	 * Returns UserDetails by given id if exists.
	 *
	 * @param userdetailsId The id of the UserDetails to get; value cannot be null.
	 * @return UserDetails associated with the given userdetailsId.
     * @throws EntityNotFoundException If no UserDetails is found.
	 */
	UserDetails getById(Integer userdetailsId) throws EntityNotFoundException;

    /**
	 * Find and return the UserDetails by given id if exists, returns null otherwise.
	 *
	 * @param userdetailsId The id of the UserDetails to get; value cannot be null.
	 * @return UserDetails associated with the given userdetailsId.
	 */
	UserDetails findById(Integer userdetailsId);


	/**
	 * Updates the details of an existing UserDetails. It replaces all fields of the existing UserDetails with the given userDetailsInstance.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on UserDetails if any.
     *
	 * @param userDetailsInstance The details of the UserDetails to be updated; value cannot be null.
	 * @return The updated UserDetails.
	 * @throws EntityNotFoundException if no UserDetails is found with given input.
	 */
	UserDetails update(UserDetails userDetailsInstance) throws EntityNotFoundException;

    /**
	 * Deletes an existing UserDetails with the given id.
	 *
	 * @param userdetailsId The id of the UserDetails to be deleted; value cannot be null.
	 * @return The deleted UserDetails.
	 * @throws EntityNotFoundException if no UserDetails found with the given id.
	 */
	UserDetails delete(Integer userdetailsId) throws EntityNotFoundException;

	/**
	 * Find all UserDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UserDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<UserDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all UserDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UserDetails.
     *
     * @see Pageable
     * @see Page
	 */
    Page<UserDetails> findAll(String query, Pageable pageable);

    /**
	 * Exports all UserDetails matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the UserDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the UserDetails.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated joiningDetailses for given UserDetails id.
     *
     * @param userDetails value of userDetails; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated JoiningDetails instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<JoiningDetails> findAssociatedJoiningDetailses(Integer userDetails, Pageable pageable);

    /*
     * Returns the associated salaryDetailses for given UserDetails id.
     *
     * @param userDetails value of userDetails; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated SalaryDetails instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<SalaryDetails> findAssociatedSalaryDetailses(Integer userDetails, Pageable pageable);

}

