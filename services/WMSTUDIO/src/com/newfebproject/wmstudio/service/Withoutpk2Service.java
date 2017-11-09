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

import com.newfebproject.wmstudio.Withoutpk2;
import com.newfebproject.wmstudio.Withoutpk2Id;

/**
 * Service object for domain model class {@link Withoutpk2}.
 */
public interface Withoutpk2Service {

    /**
     * Creates a new Withoutpk2. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Withoutpk2 if any.
     *
     * @param withoutpk2 Details of the Withoutpk2 to be created; value cannot be null.
     * @return The newly created Withoutpk2.
     */
	Withoutpk2 create(Withoutpk2 withoutpk2);


	/**
	 * Returns Withoutpk2 by given id if exists.
	 *
	 * @param withoutpk2Id The id of the Withoutpk2 to get; value cannot be null.
	 * @return Withoutpk2 associated with the given withoutpk2Id.
     * @throws EntityNotFoundException If no Withoutpk2 is found.
	 */
	Withoutpk2 getById(Withoutpk2Id withoutpk2Id) throws EntityNotFoundException;

    /**
	 * Find and return the Withoutpk2 by given id if exists, returns null otherwise.
	 *
	 * @param withoutpk2Id The id of the Withoutpk2 to get; value cannot be null.
	 * @return Withoutpk2 associated with the given withoutpk2Id.
	 */
	Withoutpk2 findById(Withoutpk2Id withoutpk2Id);


	/**
	 * Updates the details of an existing Withoutpk2. It replaces all fields of the existing Withoutpk2 with the given withoutpk2.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Withoutpk2 if any.
     *
	 * @param withoutpk2 The details of the Withoutpk2 to be updated; value cannot be null.
	 * @return The updated Withoutpk2.
	 * @throws EntityNotFoundException if no Withoutpk2 is found with given input.
	 */
	Withoutpk2 update(Withoutpk2 withoutpk2) throws EntityNotFoundException;

    /**
	 * Deletes an existing Withoutpk2 with the given id.
	 *
	 * @param withoutpk2Id The id of the Withoutpk2 to be deleted; value cannot be null.
	 * @return The deleted Withoutpk2.
	 * @throws EntityNotFoundException if no Withoutpk2 found with the given id.
	 */
	Withoutpk2 delete(Withoutpk2Id withoutpk2Id) throws EntityNotFoundException;

	/**
	 * Find all Withoutpk2s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Withoutpk2s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Withoutpk2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Withoutpk2s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Withoutpk2s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Withoutpk2> findAll(String query, Pageable pageable);

    /**
	 * Exports all Withoutpk2s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Withoutpk2s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Withoutpk2.
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
