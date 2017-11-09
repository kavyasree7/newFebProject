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

import com.newfebproject.sample.Vastrde2;
import com.newfebproject.sample.Vastrde2Id;

/**
 * Service object for domain model class {@link Vastrde2}.
 */
public interface Vastrde2Service {

    /**
     * Creates a new Vastrde2. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Vastrde2 if any.
     *
     * @param vastrde2 Details of the Vastrde2 to be created; value cannot be null.
     * @return The newly created Vastrde2.
     */
	Vastrde2 create(Vastrde2 vastrde2);


	/**
	 * Returns Vastrde2 by given id if exists.
	 *
	 * @param vastrde2Id The id of the Vastrde2 to get; value cannot be null.
	 * @return Vastrde2 associated with the given vastrde2Id.
     * @throws EntityNotFoundException If no Vastrde2 is found.
	 */
	Vastrde2 getById(Vastrde2Id vastrde2Id) throws EntityNotFoundException;

    /**
	 * Find and return the Vastrde2 by given id if exists, returns null otherwise.
	 *
	 * @param vastrde2Id The id of the Vastrde2 to get; value cannot be null.
	 * @return Vastrde2 associated with the given vastrde2Id.
	 */
	Vastrde2 findById(Vastrde2Id vastrde2Id);


	/**
	 * Updates the details of an existing Vastrde2. It replaces all fields of the existing Vastrde2 with the given vastrde2.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Vastrde2 if any.
     *
	 * @param vastrde2 The details of the Vastrde2 to be updated; value cannot be null.
	 * @return The updated Vastrde2.
	 * @throws EntityNotFoundException if no Vastrde2 is found with given input.
	 */
	Vastrde2 update(Vastrde2 vastrde2) throws EntityNotFoundException;

    /**
	 * Deletes an existing Vastrde2 with the given id.
	 *
	 * @param vastrde2Id The id of the Vastrde2 to be deleted; value cannot be null.
	 * @return The deleted Vastrde2.
	 * @throws EntityNotFoundException if no Vastrde2 found with the given id.
	 */
	Vastrde2 delete(Vastrde2Id vastrde2Id) throws EntityNotFoundException;

	/**
	 * Find all Vastrde2s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Vastrde2s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Vastrde2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Vastrde2s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Vastrde2s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Vastrde2> findAll(String query, Pageable pageable);

    /**
	 * Exports all Vastrde2s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Vastrde2s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Vastrde2.
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

