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

import com.newfebproject.viewsdb.Nopk1;
import com.newfebproject.viewsdb.Nopk1Id;

/**
 * Service object for domain model class {@link Nopk1}.
 */
public interface Nopk1Service {

    /**
     * Creates a new Nopk1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Nopk1 if any.
     *
     * @param nopk1 Details of the Nopk1 to be created; value cannot be null.
     * @return The newly created Nopk1.
     */
	Nopk1 create(Nopk1 nopk1);


	/**
	 * Returns Nopk1 by given id if exists.
	 *
	 * @param nopk1Id The id of the Nopk1 to get; value cannot be null.
	 * @return Nopk1 associated with the given nopk1Id.
     * @throws EntityNotFoundException If no Nopk1 is found.
	 */
	Nopk1 getById(Nopk1Id nopk1Id) throws EntityNotFoundException;

    /**
	 * Find and return the Nopk1 by given id if exists, returns null otherwise.
	 *
	 * @param nopk1Id The id of the Nopk1 to get; value cannot be null.
	 * @return Nopk1 associated with the given nopk1Id.
	 */
	Nopk1 findById(Nopk1Id nopk1Id);


	/**
	 * Updates the details of an existing Nopk1. It replaces all fields of the existing Nopk1 with the given nopk1.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Nopk1 if any.
     *
	 * @param nopk1 The details of the Nopk1 to be updated; value cannot be null.
	 * @return The updated Nopk1.
	 * @throws EntityNotFoundException if no Nopk1 is found with given input.
	 */
	Nopk1 update(Nopk1 nopk1) throws EntityNotFoundException;

    /**
	 * Deletes an existing Nopk1 with the given id.
	 *
	 * @param nopk1Id The id of the Nopk1 to be deleted; value cannot be null.
	 * @return The deleted Nopk1.
	 * @throws EntityNotFoundException if no Nopk1 found with the given id.
	 */
	Nopk1 delete(Nopk1Id nopk1Id) throws EntityNotFoundException;

	/**
	 * Find all Nopk1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Nopk1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Nopk1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Nopk1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Nopk1s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Nopk1> findAll(String query, Pageable pageable);

    /**
	 * Exports all Nopk1s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Nopk1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Nopk1.
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

