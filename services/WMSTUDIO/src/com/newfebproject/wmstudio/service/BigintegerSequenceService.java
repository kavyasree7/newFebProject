/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigInteger;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.wmstudio.BigintegerSequence;

/**
 * Service object for domain model class {@link BigintegerSequence}.
 */
public interface BigintegerSequenceService {

    /**
     * Creates a new BigintegerSequence. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on BigintegerSequence if any.
     *
     * @param bigintegerSequenceInstance Details of the BigintegerSequence to be created; value cannot be null.
     * @return The newly created BigintegerSequence.
     */
	BigintegerSequence create(BigintegerSequence bigintegerSequenceInstance);


	/**
	 * Returns BigintegerSequence by given id if exists.
	 *
	 * @param bigintegersequenceId The id of the BigintegerSequence to get; value cannot be null.
	 * @return BigintegerSequence associated with the given bigintegersequenceId.
     * @throws EntityNotFoundException If no BigintegerSequence is found.
	 */
	BigintegerSequence getById(BigInteger bigintegersequenceId) throws EntityNotFoundException;

    /**
	 * Find and return the BigintegerSequence by given id if exists, returns null otherwise.
	 *
	 * @param bigintegersequenceId The id of the BigintegerSequence to get; value cannot be null.
	 * @return BigintegerSequence associated with the given bigintegersequenceId.
	 */
	BigintegerSequence findById(BigInteger bigintegersequenceId);


	/**
	 * Updates the details of an existing BigintegerSequence. It replaces all fields of the existing BigintegerSequence with the given bigintegerSequenceInstance.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on BigintegerSequence if any.
     *
	 * @param bigintegerSequenceInstance The details of the BigintegerSequence to be updated; value cannot be null.
	 * @return The updated BigintegerSequence.
	 * @throws EntityNotFoundException if no BigintegerSequence is found with given input.
	 */
	BigintegerSequence update(BigintegerSequence bigintegerSequenceInstance) throws EntityNotFoundException;

    /**
	 * Deletes an existing BigintegerSequence with the given id.
	 *
	 * @param bigintegersequenceId The id of the BigintegerSequence to be deleted; value cannot be null.
	 * @return The deleted BigintegerSequence.
	 * @throws EntityNotFoundException if no BigintegerSequence found with the given id.
	 */
	BigintegerSequence delete(BigInteger bigintegersequenceId) throws EntityNotFoundException;

	/**
	 * Find all BigintegerSequences matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching BigintegerSequences.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<BigintegerSequence> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all BigintegerSequences matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching BigintegerSequences.
     *
     * @see Pageable
     * @see Page
	 */
    Page<BigintegerSequence> findAll(String query, Pageable pageable);

    /**
	 * Exports all BigintegerSequences matching the given input query to the given exportType format.
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
	 * Retrieve the count of the BigintegerSequences in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the BigintegerSequence.
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

