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

import com.newfebproject.sample.Vprojre1;
import com.newfebproject.sample.Vprojre1Id;

/**
 * Service object for domain model class {@link Vprojre1}.
 */
public interface Vprojre1Service {

    /**
     * Creates a new Vprojre1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Vprojre1 if any.
     *
     * @param vprojre1 Details of the Vprojre1 to be created; value cannot be null.
     * @return The newly created Vprojre1.
     */
	Vprojre1 create(Vprojre1 vprojre1);


	/**
	 * Returns Vprojre1 by given id if exists.
	 *
	 * @param vprojre1Id The id of the Vprojre1 to get; value cannot be null.
	 * @return Vprojre1 associated with the given vprojre1Id.
     * @throws EntityNotFoundException If no Vprojre1 is found.
	 */
	Vprojre1 getById(Vprojre1Id vprojre1Id) throws EntityNotFoundException;

    /**
	 * Find and return the Vprojre1 by given id if exists, returns null otherwise.
	 *
	 * @param vprojre1Id The id of the Vprojre1 to get; value cannot be null.
	 * @return Vprojre1 associated with the given vprojre1Id.
	 */
	Vprojre1 findById(Vprojre1Id vprojre1Id);


	/**
	 * Updates the details of an existing Vprojre1. It replaces all fields of the existing Vprojre1 with the given vprojre1.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Vprojre1 if any.
     *
	 * @param vprojre1 The details of the Vprojre1 to be updated; value cannot be null.
	 * @return The updated Vprojre1.
	 * @throws EntityNotFoundException if no Vprojre1 is found with given input.
	 */
	Vprojre1 update(Vprojre1 vprojre1) throws EntityNotFoundException;

    /**
	 * Deletes an existing Vprojre1 with the given id.
	 *
	 * @param vprojre1Id The id of the Vprojre1 to be deleted; value cannot be null.
	 * @return The deleted Vprojre1.
	 * @throws EntityNotFoundException if no Vprojre1 found with the given id.
	 */
	Vprojre1 delete(Vprojre1Id vprojre1Id) throws EntityNotFoundException;

	/**
	 * Find all Vprojre1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Vprojre1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Vprojre1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Vprojre1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Vprojre1s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Vprojre1> findAll(String query, Pageable pageable);

    /**
	 * Exports all Vprojre1s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Vprojre1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Vprojre1.
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

