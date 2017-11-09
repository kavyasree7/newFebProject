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

import com.newfebproject.wmstudio.BooleanTableNullConstraints;

/**
 * Service object for domain model class {@link BooleanTableNullConstraints}.
 */
public interface BooleanTableNullConstraintsService {

    /**
     * Creates a new BooleanTableNullConstraints. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on BooleanTableNullConstraints if any.
     *
     * @param booleanTableNullConstraints Details of the BooleanTableNullConstraints to be created; value cannot be null.
     * @return The newly created BooleanTableNullConstraints.
     */
	BooleanTableNullConstraints create(BooleanTableNullConstraints booleanTableNullConstraints);


	/**
	 * Returns BooleanTableNullConstraints by given id if exists.
	 *
	 * @param booleantablenullconstraintsId The id of the BooleanTableNullConstraints to get; value cannot be null.
	 * @return BooleanTableNullConstraints associated with the given booleantablenullconstraintsId.
     * @throws EntityNotFoundException If no BooleanTableNullConstraints is found.
	 */
	BooleanTableNullConstraints getById(Integer booleantablenullconstraintsId) throws EntityNotFoundException;

    /**
	 * Find and return the BooleanTableNullConstraints by given id if exists, returns null otherwise.
	 *
	 * @param booleantablenullconstraintsId The id of the BooleanTableNullConstraints to get; value cannot be null.
	 * @return BooleanTableNullConstraints associated with the given booleantablenullconstraintsId.
	 */
	BooleanTableNullConstraints findById(Integer booleantablenullconstraintsId);


	/**
	 * Updates the details of an existing BooleanTableNullConstraints. It replaces all fields of the existing BooleanTableNullConstraints with the given booleanTableNullConstraints.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on BooleanTableNullConstraints if any.
     *
	 * @param booleanTableNullConstraints The details of the BooleanTableNullConstraints to be updated; value cannot be null.
	 * @return The updated BooleanTableNullConstraints.
	 * @throws EntityNotFoundException if no BooleanTableNullConstraints is found with given input.
	 */
	BooleanTableNullConstraints update(BooleanTableNullConstraints booleanTableNullConstraints) throws EntityNotFoundException;

    /**
	 * Deletes an existing BooleanTableNullConstraints with the given id.
	 *
	 * @param booleantablenullconstraintsId The id of the BooleanTableNullConstraints to be deleted; value cannot be null.
	 * @return The deleted BooleanTableNullConstraints.
	 * @throws EntityNotFoundException if no BooleanTableNullConstraints found with the given id.
	 */
	BooleanTableNullConstraints delete(Integer booleantablenullconstraintsId) throws EntityNotFoundException;

	/**
	 * Find all BooleanTableNullConstraints matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching BooleanTableNullConstraints.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<BooleanTableNullConstraints> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all BooleanTableNullConstraints matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching BooleanTableNullConstraints.
     *
     * @see Pageable
     * @see Page
	 */
    Page<BooleanTableNullConstraints> findAll(String query, Pageable pageable);

    /**
	 * Exports all BooleanTableNullConstraints matching the given input query to the given exportType format.
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
	 * Retrieve the count of the BooleanTableNullConstraints in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the BooleanTableNullConstraints.
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

