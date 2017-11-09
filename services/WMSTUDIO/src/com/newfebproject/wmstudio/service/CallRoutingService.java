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

import com.newfebproject.wmstudio.CallRouting;
import com.newfebproject.wmstudio.CallRoutingId;

/**
 * Service object for domain model class {@link CallRouting}.
 */
public interface CallRoutingService {

    /**
     * Creates a new CallRouting. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CallRouting if any.
     *
     * @param callRouting Details of the CallRouting to be created; value cannot be null.
     * @return The newly created CallRouting.
     */
	CallRouting create(CallRouting callRouting);


	/**
	 * Returns CallRouting by given id if exists.
	 *
	 * @param callroutingId The id of the CallRouting to get; value cannot be null.
	 * @return CallRouting associated with the given callroutingId.
     * @throws EntityNotFoundException If no CallRouting is found.
	 */
	CallRouting getById(CallRoutingId callroutingId) throws EntityNotFoundException;

    /**
	 * Find and return the CallRouting by given id if exists, returns null otherwise.
	 *
	 * @param callroutingId The id of the CallRouting to get; value cannot be null.
	 * @return CallRouting associated with the given callroutingId.
	 */
	CallRouting findById(CallRoutingId callroutingId);


	/**
	 * Updates the details of an existing CallRouting. It replaces all fields of the existing CallRouting with the given callRouting.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on CallRouting if any.
     *
	 * @param callRouting The details of the CallRouting to be updated; value cannot be null.
	 * @return The updated CallRouting.
	 * @throws EntityNotFoundException if no CallRouting is found with given input.
	 */
	CallRouting update(CallRouting callRouting) throws EntityNotFoundException;

    /**
	 * Deletes an existing CallRouting with the given id.
	 *
	 * @param callroutingId The id of the CallRouting to be deleted; value cannot be null.
	 * @return The deleted CallRouting.
	 * @throws EntityNotFoundException if no CallRouting found with the given id.
	 */
	CallRouting delete(CallRoutingId callroutingId) throws EntityNotFoundException;

	/**
	 * Find all CallRoutings matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CallRoutings.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<CallRouting> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all CallRoutings matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CallRoutings.
     *
     * @see Pageable
     * @see Page
	 */
    Page<CallRouting> findAll(String query, Pageable pageable);

    /**
	 * Exports all CallRoutings matching the given input query to the given exportType format.
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
	 * Retrieve the count of the CallRoutings in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the CallRouting.
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


}

