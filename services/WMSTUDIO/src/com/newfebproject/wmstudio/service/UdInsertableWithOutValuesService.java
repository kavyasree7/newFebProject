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

import com.newfebproject.wmstudio.UdInsertableWithOutValues;

/**
 * Service object for domain model class {@link UdInsertableWithOutValues}.
 */
public interface UdInsertableWithOutValuesService {

    /**
     * Creates a new UdInsertableWithOutValues. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UdInsertableWithOutValues if any.
     *
     * @param udInsertableWithOutValues Details of the UdInsertableWithOutValues to be created; value cannot be null.
     * @return The newly created UdInsertableWithOutValues.
     */
	UdInsertableWithOutValues create(UdInsertableWithOutValues udInsertableWithOutValues);


	/**
	 * Returns UdInsertableWithOutValues by given id if exists.
	 *
	 * @param udinsertablewithoutvaluesId The id of the UdInsertableWithOutValues to get; value cannot be null.
	 * @return UdInsertableWithOutValues associated with the given udinsertablewithoutvaluesId.
     * @throws EntityNotFoundException If no UdInsertableWithOutValues is found.
	 */
	UdInsertableWithOutValues getById(Integer udinsertablewithoutvaluesId) throws EntityNotFoundException;

    /**
	 * Find and return the UdInsertableWithOutValues by given id if exists, returns null otherwise.
	 *
	 * @param udinsertablewithoutvaluesId The id of the UdInsertableWithOutValues to get; value cannot be null.
	 * @return UdInsertableWithOutValues associated with the given udinsertablewithoutvaluesId.
	 */
	UdInsertableWithOutValues findById(Integer udinsertablewithoutvaluesId);


	/**
	 * Updates the details of an existing UdInsertableWithOutValues. It replaces all fields of the existing UdInsertableWithOutValues with the given udInsertableWithOutValues.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on UdInsertableWithOutValues if any.
     *
	 * @param udInsertableWithOutValues The details of the UdInsertableWithOutValues to be updated; value cannot be null.
	 * @return The updated UdInsertableWithOutValues.
	 * @throws EntityNotFoundException if no UdInsertableWithOutValues is found with given input.
	 */
	UdInsertableWithOutValues update(UdInsertableWithOutValues udInsertableWithOutValues) throws EntityNotFoundException;

    /**
	 * Deletes an existing UdInsertableWithOutValues with the given id.
	 *
	 * @param udinsertablewithoutvaluesId The id of the UdInsertableWithOutValues to be deleted; value cannot be null.
	 * @return The deleted UdInsertableWithOutValues.
	 * @throws EntityNotFoundException if no UdInsertableWithOutValues found with the given id.
	 */
	UdInsertableWithOutValues delete(Integer udinsertablewithoutvaluesId) throws EntityNotFoundException;

	/**
	 * Find all UdInsertableWithOutValues matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UdInsertableWithOutValues.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<UdInsertableWithOutValues> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all UdInsertableWithOutValues matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UdInsertableWithOutValues.
     *
     * @see Pageable
     * @see Page
	 */
    Page<UdInsertableWithOutValues> findAll(String query, Pageable pageable);

    /**
	 * Exports all UdInsertableWithOutValues matching the given input query to the given exportType format.
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
	 * Retrieve the count of the UdInsertableWithOutValues in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the UdInsertableWithOutValues.
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

