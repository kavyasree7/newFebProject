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

import com.newfebproject.viewsdb.TestUpdate;

/**
 * Service object for domain model class {@link TestUpdate}.
 */
public interface TestUpdateService {

    /**
     * Creates a new TestUpdate. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TestUpdate if any.
     *
     * @param testUpdate Details of the TestUpdate to be created; value cannot be null.
     * @return The newly created TestUpdate.
     */
	TestUpdate create(TestUpdate testUpdate);


	/**
	 * Returns TestUpdate by given id if exists.
	 *
	 * @param testupdateId The id of the TestUpdate to get; value cannot be null.
	 * @return TestUpdate associated with the given testupdateId.
     * @throws EntityNotFoundException If no TestUpdate is found.
	 */
	TestUpdate getById(Short testupdateId) throws EntityNotFoundException;

    /**
	 * Find and return the TestUpdate by given id if exists, returns null otherwise.
	 *
	 * @param testupdateId The id of the TestUpdate to get; value cannot be null.
	 * @return TestUpdate associated with the given testupdateId.
	 */
	TestUpdate findById(Short testupdateId);


	/**
	 * Updates the details of an existing TestUpdate. It replaces all fields of the existing TestUpdate with the given testUpdate.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TestUpdate if any.
     *
	 * @param testUpdate The details of the TestUpdate to be updated; value cannot be null.
	 * @return The updated TestUpdate.
	 * @throws EntityNotFoundException if no TestUpdate is found with given input.
	 */
	TestUpdate update(TestUpdate testUpdate) throws EntityNotFoundException;

    /**
	 * Deletes an existing TestUpdate with the given id.
	 *
	 * @param testupdateId The id of the TestUpdate to be deleted; value cannot be null.
	 * @return The deleted TestUpdate.
	 * @throws EntityNotFoundException if no TestUpdate found with the given id.
	 */
	TestUpdate delete(Short testupdateId) throws EntityNotFoundException;

	/**
	 * Find all TestUpdates matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TestUpdates.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TestUpdate> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TestUpdates matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TestUpdates.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TestUpdate> findAll(String query, Pageable pageable);

    /**
	 * Exports all TestUpdates matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TestUpdates in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TestUpdate.
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

