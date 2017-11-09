/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.kavyadb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.kavyadb.Table10;

/**
 * Service object for domain model class {@link Table10}.
 */
public interface Table10Service {

    /**
     * Creates a new Table10. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table10 if any.
     *
     * @param table10 Details of the Table10 to be created; value cannot be null.
     * @return The newly created Table10.
     */
	Table10 create(Table10 table10);


	/**
	 * Returns Table10 by given id if exists.
	 *
	 * @param table10Id The id of the Table10 to get; value cannot be null.
	 * @return Table10 associated with the given table10Id.
     * @throws EntityNotFoundException If no Table10 is found.
	 */
	Table10 getById(Integer table10Id) throws EntityNotFoundException;

    /**
	 * Find and return the Table10 by given id if exists, returns null otherwise.
	 *
	 * @param table10Id The id of the Table10 to get; value cannot be null.
	 * @return Table10 associated with the given table10Id.
	 */
	Table10 findById(Integer table10Id);


	/**
	 * Updates the details of an existing Table10. It replaces all fields of the existing Table10 with the given table10.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Table10 if any.
     *
	 * @param table10 The details of the Table10 to be updated; value cannot be null.
	 * @return The updated Table10.
	 * @throws EntityNotFoundException if no Table10 is found with given input.
	 */
	Table10 update(Table10 table10) throws EntityNotFoundException;

    /**
	 * Deletes an existing Table10 with the given id.
	 *
	 * @param table10Id The id of the Table10 to be deleted; value cannot be null.
	 * @return The deleted Table10.
	 * @throws EntityNotFoundException if no Table10 found with the given id.
	 */
	Table10 delete(Integer table10Id) throws EntityNotFoundException;

	/**
	 * Find all Table10s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table10s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Table10> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Table10s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table10s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Table10> findAll(String query, Pageable pageable);

    /**
	 * Exports all Table10s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Table10s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Table10.
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

