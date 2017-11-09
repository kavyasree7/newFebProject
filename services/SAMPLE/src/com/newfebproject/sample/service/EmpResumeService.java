/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.sample.EmpResume;
import com.newfebproject.sample.EmpResumeId;

/**
 * Service object for domain model class {@link EmpResume}.
 */
public interface EmpResumeService {

    /**
     * Creates a new EmpResume. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on EmpResume if any.
     *
     * @param empResume Details of the EmpResume to be created; value cannot be null.
     * @return The newly created EmpResume.
     */
	EmpResume create(EmpResume empResume);


	/**
	 * Returns EmpResume by given id if exists.
	 *
	 * @param empresumeId The id of the EmpResume to get; value cannot be null.
	 * @return EmpResume associated with the given empresumeId.
     * @throws EntityNotFoundException If no EmpResume is found.
	 */
	EmpResume getById(EmpResumeId empresumeId) throws EntityNotFoundException;

    /**
	 * Find and return the EmpResume by given id if exists, returns null otherwise.
	 *
	 * @param empresumeId The id of the EmpResume to get; value cannot be null.
	 * @return EmpResume associated with the given empresumeId.
	 */
	EmpResume findById(EmpResumeId empresumeId);


	/**
	 * Updates the details of an existing EmpResume. It replaces all fields of the existing EmpResume with the given empResume.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on EmpResume if any.
     *
	 * @param empResume The details of the EmpResume to be updated; value cannot be null.
	 * @return The updated EmpResume.
	 * @throws EntityNotFoundException if no EmpResume is found with given input.
	 */
	EmpResume update(EmpResume empResume) throws EntityNotFoundException;

    /**
	 * Deletes an existing EmpResume with the given id.
	 *
	 * @param empresumeId The id of the EmpResume to be deleted; value cannot be null.
	 * @return The deleted EmpResume.
	 * @throws EntityNotFoundException if no EmpResume found with the given id.
	 */
	EmpResume delete(EmpResumeId empresumeId) throws EntityNotFoundException;

	/**
	 * Find all EmpResumes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching EmpResumes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<EmpResume> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all EmpResumes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching EmpResumes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<EmpResume> findAll(String query, Pageable pageable);

    /**
	 * Exports all EmpResumes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the EmpResumes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the EmpResume.
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
