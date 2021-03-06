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

import com.newfebproject.wmstudio.Testbigdectab;

/**
 * Service object for domain model class {@link Testbigdectab}.
 */
public interface TestbigdectabService {

    /**
     * Creates a new Testbigdectab. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Testbigdectab if any.
     *
     * @param testbigdectab Details of the Testbigdectab to be created; value cannot be null.
     * @return The newly created Testbigdectab.
     */
	Testbigdectab create(Testbigdectab testbigdectab);


	/**
	 * Returns Testbigdectab by given id if exists.
	 *
	 * @param testbigdectabId The id of the Testbigdectab to get; value cannot be null.
	 * @return Testbigdectab associated with the given testbigdectabId.
     * @throws EntityNotFoundException If no Testbigdectab is found.
	 */
	Testbigdectab getById(BigInteger testbigdectabId) throws EntityNotFoundException;

    /**
	 * Find and return the Testbigdectab by given id if exists, returns null otherwise.
	 *
	 * @param testbigdectabId The id of the Testbigdectab to get; value cannot be null.
	 * @return Testbigdectab associated with the given testbigdectabId.
	 */
	Testbigdectab findById(BigInteger testbigdectabId);


	/**
	 * Updates the details of an existing Testbigdectab. It replaces all fields of the existing Testbigdectab with the given testbigdectab.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Testbigdectab if any.
     *
	 * @param testbigdectab The details of the Testbigdectab to be updated; value cannot be null.
	 * @return The updated Testbigdectab.
	 * @throws EntityNotFoundException if no Testbigdectab is found with given input.
	 */
	Testbigdectab update(Testbigdectab testbigdectab) throws EntityNotFoundException;

    /**
	 * Deletes an existing Testbigdectab with the given id.
	 *
	 * @param testbigdectabId The id of the Testbigdectab to be deleted; value cannot be null.
	 * @return The deleted Testbigdectab.
	 * @throws EntityNotFoundException if no Testbigdectab found with the given id.
	 */
	Testbigdectab delete(BigInteger testbigdectabId) throws EntityNotFoundException;

	/**
	 * Find all Testbigdectabs matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Testbigdectabs.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Testbigdectab> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Testbigdectabs matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Testbigdectabs.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Testbigdectab> findAll(String query, Pageable pageable);

    /**
	 * Exports all Testbigdectabs matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Testbigdectabs in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Testbigdectab.
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

