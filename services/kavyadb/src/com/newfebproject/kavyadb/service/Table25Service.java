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

import com.newfebproject.kavyadb.Table25;

/**
 * Service object for domain model class {@link Table25}.
 */
public interface Table25Service {

    /**
     * Creates a new Table25. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table25 if any.
     *
     * @param table25 Details of the Table25 to be created; value cannot be null.
     * @return The newly created Table25.
     */
	Table25 create(Table25 table25);


	/**
	 * Returns Table25 by given id if exists.
	 *
	 * @param table25Id The id of the Table25 to get; value cannot be null.
	 * @return Table25 associated with the given table25Id.
     * @throws EntityNotFoundException If no Table25 is found.
	 */
	Table25 getById(Integer table25Id) throws EntityNotFoundException;

    /**
	 * Find and return the Table25 by given id if exists, returns null otherwise.
	 *
	 * @param table25Id The id of the Table25 to get; value cannot be null.
	 * @return Table25 associated with the given table25Id.
	 */
	Table25 findById(Integer table25Id);


	/**
	 * Updates the details of an existing Table25. It replaces all fields of the existing Table25 with the given table25.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Table25 if any.
     *
	 * @param table25 The details of the Table25 to be updated; value cannot be null.
	 * @return The updated Table25.
	 * @throws EntityNotFoundException if no Table25 is found with given input.
	 */
	Table25 update(Table25 table25) throws EntityNotFoundException;

    /**
	 * Deletes an existing Table25 with the given id.
	 *
	 * @param table25Id The id of the Table25 to be deleted; value cannot be null.
	 * @return The deleted Table25.
	 * @throws EntityNotFoundException if no Table25 found with the given id.
	 */
	Table25 delete(Integer table25Id) throws EntityNotFoundException;

	/**
	 * Find all Table25s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table25s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Table25> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Table25s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table25s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Table25> findAll(String query, Pageable pageable);

    /**
	 * Exports all Table25s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Table25s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Table25.
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
