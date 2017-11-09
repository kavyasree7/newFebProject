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

import com.newfebproject.viewsdb.Table749;

/**
 * Service object for domain model class {@link Table749}.
 */
public interface Table749Service {

    /**
     * Creates a new Table749. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table749 if any.
     *
     * @param table749 Details of the Table749 to be created; value cannot be null.
     * @return The newly created Table749.
     */
	Table749 create(Table749 table749);


	/**
	 * Returns Table749 by given id if exists.
	 *
	 * @param table749Id The id of the Table749 to get; value cannot be null.
	 * @return Table749 associated with the given table749Id.
     * @throws EntityNotFoundException If no Table749 is found.
	 */
	Table749 getById(Integer table749Id) throws EntityNotFoundException;

    /**
	 * Find and return the Table749 by given id if exists, returns null otherwise.
	 *
	 * @param table749Id The id of the Table749 to get; value cannot be null.
	 * @return Table749 associated with the given table749Id.
	 */
	Table749 findById(Integer table749Id);


	/**
	 * Updates the details of an existing Table749. It replaces all fields of the existing Table749 with the given table749.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Table749 if any.
     *
	 * @param table749 The details of the Table749 to be updated; value cannot be null.
	 * @return The updated Table749.
	 * @throws EntityNotFoundException if no Table749 is found with given input.
	 */
	Table749 update(Table749 table749) throws EntityNotFoundException;

    /**
	 * Deletes an existing Table749 with the given id.
	 *
	 * @param table749Id The id of the Table749 to be deleted; value cannot be null.
	 * @return The deleted Table749.
	 * @throws EntityNotFoundException if no Table749 found with the given id.
	 */
	Table749 delete(Integer table749Id) throws EntityNotFoundException;

	/**
	 * Find all Table749s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table749s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Table749> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Table749s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table749s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Table749> findAll(String query, Pageable pageable);

    /**
	 * Exports all Table749s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Table749s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Table749.
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
