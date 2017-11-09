/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.sample.Vhdept;
import com.newfebproject.sample.VhdeptId;

/**
 * Service object for domain model class {@link Vhdept}.
 */
public interface VhdeptService {

    /**
     * Creates a new Vhdept. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Vhdept if any.
     *
     * @param vhdept Details of the Vhdept to be created; value cannot be null.
     * @return The newly created Vhdept.
     */
	Vhdept create(Vhdept vhdept);


	/**
	 * Returns Vhdept by given id if exists.
	 *
	 * @param vhdeptId The id of the Vhdept to get; value cannot be null.
	 * @return Vhdept associated with the given vhdeptId.
     * @throws EntityNotFoundException If no Vhdept is found.
	 */
	Vhdept getById(VhdeptId vhdeptId) throws EntityNotFoundException;

    /**
	 * Find and return the Vhdept by given id if exists, returns null otherwise.
	 *
	 * @param vhdeptId The id of the Vhdept to get; value cannot be null.
	 * @return Vhdept associated with the given vhdeptId.
	 */
	Vhdept findById(VhdeptId vhdeptId);


	/**
	 * Updates the details of an existing Vhdept. It replaces all fields of the existing Vhdept with the given vhdept.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Vhdept if any.
     *
	 * @param vhdept The details of the Vhdept to be updated; value cannot be null.
	 * @return The updated Vhdept.
	 * @throws EntityNotFoundException if no Vhdept is found with given input.
	 */
	Vhdept update(Vhdept vhdept) throws EntityNotFoundException;

    /**
	 * Deletes an existing Vhdept with the given id.
	 *
	 * @param vhdeptId The id of the Vhdept to be deleted; value cannot be null.
	 * @return The deleted Vhdept.
	 * @throws EntityNotFoundException if no Vhdept found with the given id.
	 */
	Vhdept delete(VhdeptId vhdeptId) throws EntityNotFoundException;

	/**
	 * Find all Vhdepts matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Vhdepts.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Vhdept> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Vhdepts matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Vhdepts.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Vhdept> findAll(String query, Pageable pageable);

    /**
	 * Exports all Vhdepts matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Vhdepts in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Vhdept.
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

