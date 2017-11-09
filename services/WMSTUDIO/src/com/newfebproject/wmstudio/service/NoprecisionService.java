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

import com.newfebproject.wmstudio.Noprecision;
import com.newfebproject.wmstudio.NoprecisionId;

/**
 * Service object for domain model class {@link Noprecision}.
 */
public interface NoprecisionService {

    /**
     * Creates a new Noprecision. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Noprecision if any.
     *
     * @param noprecisionInstance Details of the Noprecision to be created; value cannot be null.
     * @return The newly created Noprecision.
     */
	Noprecision create(Noprecision noprecisionInstance);


	/**
	 * Returns Noprecision by given id if exists.
	 *
	 * @param noprecisionId The id of the Noprecision to get; value cannot be null.
	 * @return Noprecision associated with the given noprecisionId.
     * @throws EntityNotFoundException If no Noprecision is found.
	 */
	Noprecision getById(NoprecisionId noprecisionId) throws EntityNotFoundException;

    /**
	 * Find and return the Noprecision by given id if exists, returns null otherwise.
	 *
	 * @param noprecisionId The id of the Noprecision to get; value cannot be null.
	 * @return Noprecision associated with the given noprecisionId.
	 */
	Noprecision findById(NoprecisionId noprecisionId);


	/**
	 * Updates the details of an existing Noprecision. It replaces all fields of the existing Noprecision with the given noprecisionInstance.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Noprecision if any.
     *
	 * @param noprecisionInstance The details of the Noprecision to be updated; value cannot be null.
	 * @return The updated Noprecision.
	 * @throws EntityNotFoundException if no Noprecision is found with given input.
	 */
	Noprecision update(Noprecision noprecisionInstance) throws EntityNotFoundException;

    /**
	 * Deletes an existing Noprecision with the given id.
	 *
	 * @param noprecisionId The id of the Noprecision to be deleted; value cannot be null.
	 * @return The deleted Noprecision.
	 * @throws EntityNotFoundException if no Noprecision found with the given id.
	 */
	Noprecision delete(NoprecisionId noprecisionId) throws EntityNotFoundException;

	/**
	 * Find all Noprecisions matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Noprecisions.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Noprecision> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Noprecisions matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Noprecisions.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Noprecision> findAll(String query, Pageable pageable);

    /**
	 * Exports all Noprecisions matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Noprecisions in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Noprecision.
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

