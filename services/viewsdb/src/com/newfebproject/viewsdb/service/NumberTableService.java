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

import com.newfebproject.viewsdb.NumberTable;

/**
 * Service object for domain model class {@link NumberTable}.
 */
public interface NumberTableService {

    /**
     * Creates a new NumberTable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on NumberTable if any.
     *
     * @param numberTable Details of the NumberTable to be created; value cannot be null.
     * @return The newly created NumberTable.
     */
	NumberTable create(NumberTable numberTable);


	/**
	 * Returns NumberTable by given id if exists.
	 *
	 * @param numbertableId The id of the NumberTable to get; value cannot be null.
	 * @return NumberTable associated with the given numbertableId.
     * @throws EntityNotFoundException If no NumberTable is found.
	 */
	NumberTable getById(Integer numbertableId) throws EntityNotFoundException;

    /**
	 * Find and return the NumberTable by given id if exists, returns null otherwise.
	 *
	 * @param numbertableId The id of the NumberTable to get; value cannot be null.
	 * @return NumberTable associated with the given numbertableId.
	 */
	NumberTable findById(Integer numbertableId);


	/**
	 * Updates the details of an existing NumberTable. It replaces all fields of the existing NumberTable with the given numberTable.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on NumberTable if any.
     *
	 * @param numberTable The details of the NumberTable to be updated; value cannot be null.
	 * @return The updated NumberTable.
	 * @throws EntityNotFoundException if no NumberTable is found with given input.
	 */
	NumberTable update(NumberTable numberTable) throws EntityNotFoundException;

    /**
	 * Deletes an existing NumberTable with the given id.
	 *
	 * @param numbertableId The id of the NumberTable to be deleted; value cannot be null.
	 * @return The deleted NumberTable.
	 * @throws EntityNotFoundException if no NumberTable found with the given id.
	 */
	NumberTable delete(Integer numbertableId) throws EntityNotFoundException;

	/**
	 * Find all NumberTables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching NumberTables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<NumberTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all NumberTables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching NumberTables.
     *
     * @see Pageable
     * @see Page
	 */
    Page<NumberTable> findAll(String query, Pageable pageable);

    /**
	 * Exports all NumberTables matching the given input query to the given exportType format.
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
	 * Retrieve the count of the NumberTables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the NumberTable.
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

