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

import com.newfebproject.sample.Vdepmg1;
import com.newfebproject.sample.Vdepmg1Id;

/**
 * Service object for domain model class {@link Vdepmg1}.
 */
public interface Vdepmg1Service {

    /**
     * Creates a new Vdepmg1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Vdepmg1 if any.
     *
     * @param vdepmg1 Details of the Vdepmg1 to be created; value cannot be null.
     * @return The newly created Vdepmg1.
     */
	Vdepmg1 create(Vdepmg1 vdepmg1);


	/**
	 * Returns Vdepmg1 by given id if exists.
	 *
	 * @param vdepmg1Id The id of the Vdepmg1 to get; value cannot be null.
	 * @return Vdepmg1 associated with the given vdepmg1Id.
     * @throws EntityNotFoundException If no Vdepmg1 is found.
	 */
	Vdepmg1 getById(Vdepmg1Id vdepmg1Id) throws EntityNotFoundException;

    /**
	 * Find and return the Vdepmg1 by given id if exists, returns null otherwise.
	 *
	 * @param vdepmg1Id The id of the Vdepmg1 to get; value cannot be null.
	 * @return Vdepmg1 associated with the given vdepmg1Id.
	 */
	Vdepmg1 findById(Vdepmg1Id vdepmg1Id);


	/**
	 * Updates the details of an existing Vdepmg1. It replaces all fields of the existing Vdepmg1 with the given vdepmg1.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Vdepmg1 if any.
     *
	 * @param vdepmg1 The details of the Vdepmg1 to be updated; value cannot be null.
	 * @return The updated Vdepmg1.
	 * @throws EntityNotFoundException if no Vdepmg1 is found with given input.
	 */
	Vdepmg1 update(Vdepmg1 vdepmg1) throws EntityNotFoundException;

    /**
	 * Deletes an existing Vdepmg1 with the given id.
	 *
	 * @param vdepmg1Id The id of the Vdepmg1 to be deleted; value cannot be null.
	 * @return The deleted Vdepmg1.
	 * @throws EntityNotFoundException if no Vdepmg1 found with the given id.
	 */
	Vdepmg1 delete(Vdepmg1Id vdepmg1Id) throws EntityNotFoundException;

	/**
	 * Find all Vdepmg1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Vdepmg1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Vdepmg1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Vdepmg1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Vdepmg1s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Vdepmg1> findAll(String query, Pageable pageable);

    /**
	 * Exports all Vdepmg1s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Vdepmg1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Vdepmg1.
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
