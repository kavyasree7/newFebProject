/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.viewsdb.Number223;
import com.newfebproject.viewsdb.Number223Id;

/**
 * Service object for domain model class {@link Number223}.
 */
public interface Number223Service {

    /**
     * Creates a new Number223. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Number223 if any.
     *
     * @param number223 Details of the Number223 to be created; value cannot be null.
     * @return The newly created Number223.
     */
	Number223 create(Number223 number223);


	/**
	 * Returns Number223 by given id if exists.
	 *
	 * @param number223Id The id of the Number223 to get; value cannot be null.
	 * @return Number223 associated with the given number223Id.
     * @throws EntityNotFoundException If no Number223 is found.
	 */
	Number223 getById(Number223Id number223Id) throws EntityNotFoundException;

    /**
	 * Find and return the Number223 by given id if exists, returns null otherwise.
	 *
	 * @param number223Id The id of the Number223 to get; value cannot be null.
	 * @return Number223 associated with the given number223Id.
	 */
	Number223 findById(Number223Id number223Id);


	/**
	 * Updates the details of an existing Number223. It replaces all fields of the existing Number223 with the given number223.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Number223 if any.
     *
	 * @param number223 The details of the Number223 to be updated; value cannot be null.
	 * @return The updated Number223.
	 * @throws EntityNotFoundException if no Number223 is found with given input.
	 */
	Number223 update(Number223 number223) throws EntityNotFoundException;

    /**
	 * Deletes an existing Number223 with the given id.
	 *
	 * @param number223Id The id of the Number223 to be deleted; value cannot be null.
	 * @return The deleted Number223.
	 * @throws EntityNotFoundException if no Number223 found with the given id.
	 */
	Number223 delete(Number223Id number223Id) throws EntityNotFoundException;

	/**
	 * Find all Number223s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Number223s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Number223> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Number223s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Number223s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Number223> findAll(String query, Pageable pageable);

    /**
	 * Exports all Number223s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Number223s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Number223.
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

