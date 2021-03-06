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

import com.newfebproject.wmstudio.TestBigInteger;

/**
 * Service object for domain model class {@link TestBigInteger}.
 */
public interface TestBigIntegerService {

    /**
     * Creates a new TestBigInteger. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TestBigInteger if any.
     *
     * @param testBigInteger Details of the TestBigInteger to be created; value cannot be null.
     * @return The newly created TestBigInteger.
     */
	TestBigInteger create(TestBigInteger testBigInteger);


	/**
	 * Returns TestBigInteger by given id if exists.
	 *
	 * @param testbigintegerId The id of the TestBigInteger to get; value cannot be null.
	 * @return TestBigInteger associated with the given testbigintegerId.
     * @throws EntityNotFoundException If no TestBigInteger is found.
	 */
	TestBigInteger getById(Integer testbigintegerId) throws EntityNotFoundException;

    /**
	 * Find and return the TestBigInteger by given id if exists, returns null otherwise.
	 *
	 * @param testbigintegerId The id of the TestBigInteger to get; value cannot be null.
	 * @return TestBigInteger associated with the given testbigintegerId.
	 */
	TestBigInteger findById(Integer testbigintegerId);


	/**
	 * Updates the details of an existing TestBigInteger. It replaces all fields of the existing TestBigInteger with the given testBigInteger.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TestBigInteger if any.
     *
	 * @param testBigInteger The details of the TestBigInteger to be updated; value cannot be null.
	 * @return The updated TestBigInteger.
	 * @throws EntityNotFoundException if no TestBigInteger is found with given input.
	 */
	TestBigInteger update(TestBigInteger testBigInteger) throws EntityNotFoundException;

    /**
	 * Deletes an existing TestBigInteger with the given id.
	 *
	 * @param testbigintegerId The id of the TestBigInteger to be deleted; value cannot be null.
	 * @return The deleted TestBigInteger.
	 * @throws EntityNotFoundException if no TestBigInteger found with the given id.
	 */
	TestBigInteger delete(Integer testbigintegerId) throws EntityNotFoundException;

	/**
	 * Find all TestBigIntegers matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TestBigIntegers.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TestBigInteger> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TestBigIntegers matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TestBigIntegers.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TestBigInteger> findAll(String query, Pageable pageable);

    /**
	 * Exports all TestBigIntegers matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TestBigIntegers in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TestBigInteger.
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

