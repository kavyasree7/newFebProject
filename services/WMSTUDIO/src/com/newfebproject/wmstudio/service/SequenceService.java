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

import com.newfebproject.wmstudio.Sequence;
import com.newfebproject.wmstudio.SequenceId;

/**
 * Service object for domain model class {@link Sequence}.
 */
public interface SequenceService {

    /**
     * Creates a new Sequence. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Sequence if any.
     *
     * @param sequence Details of the Sequence to be created; value cannot be null.
     * @return The newly created Sequence.
     */
	Sequence create(Sequence sequence);


	/**
	 * Returns Sequence by given id if exists.
	 *
	 * @param sequenceId The id of the Sequence to get; value cannot be null.
	 * @return Sequence associated with the given sequenceId.
     * @throws EntityNotFoundException If no Sequence is found.
	 */
	Sequence getById(SequenceId sequenceId) throws EntityNotFoundException;

    /**
	 * Find and return the Sequence by given id if exists, returns null otherwise.
	 *
	 * @param sequenceId The id of the Sequence to get; value cannot be null.
	 * @return Sequence associated with the given sequenceId.
	 */
	Sequence findById(SequenceId sequenceId);


	/**
	 * Updates the details of an existing Sequence. It replaces all fields of the existing Sequence with the given sequence.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Sequence if any.
     *
	 * @param sequence The details of the Sequence to be updated; value cannot be null.
	 * @return The updated Sequence.
	 * @throws EntityNotFoundException if no Sequence is found with given input.
	 */
	Sequence update(Sequence sequence) throws EntityNotFoundException;

    /**
	 * Deletes an existing Sequence with the given id.
	 *
	 * @param sequenceId The id of the Sequence to be deleted; value cannot be null.
	 * @return The deleted Sequence.
	 * @throws EntityNotFoundException if no Sequence found with the given id.
	 */
	Sequence delete(SequenceId sequenceId) throws EntityNotFoundException;

	/**
	 * Find all Sequences matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Sequences.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Sequence> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Sequences matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Sequences.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Sequence> findAll(String query, Pageable pageable);

    /**
	 * Exports all Sequences matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Sequences in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Sequence.
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

