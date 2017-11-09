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

import com.newfebproject.viewsdb.NumericView;
import com.newfebproject.viewsdb.NumericViewId;

/**
 * Service object for domain model class {@link NumericView}.
 */
public interface NumericViewService {

    /**
     * Creates a new NumericView. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on NumericView if any.
     *
     * @param numericView Details of the NumericView to be created; value cannot be null.
     * @return The newly created NumericView.
     */
	NumericView create(NumericView numericView);


	/**
	 * Returns NumericView by given id if exists.
	 *
	 * @param numericviewId The id of the NumericView to get; value cannot be null.
	 * @return NumericView associated with the given numericviewId.
     * @throws EntityNotFoundException If no NumericView is found.
	 */
	NumericView getById(NumericViewId numericviewId) throws EntityNotFoundException;

    /**
	 * Find and return the NumericView by given id if exists, returns null otherwise.
	 *
	 * @param numericviewId The id of the NumericView to get; value cannot be null.
	 * @return NumericView associated with the given numericviewId.
	 */
	NumericView findById(NumericViewId numericviewId);


	/**
	 * Updates the details of an existing NumericView. It replaces all fields of the existing NumericView with the given numericView.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on NumericView if any.
     *
	 * @param numericView The details of the NumericView to be updated; value cannot be null.
	 * @return The updated NumericView.
	 * @throws EntityNotFoundException if no NumericView is found with given input.
	 */
	NumericView update(NumericView numericView) throws EntityNotFoundException;

    /**
	 * Deletes an existing NumericView with the given id.
	 *
	 * @param numericviewId The id of the NumericView to be deleted; value cannot be null.
	 * @return The deleted NumericView.
	 * @throws EntityNotFoundException if no NumericView found with the given id.
	 */
	NumericView delete(NumericViewId numericviewId) throws EntityNotFoundException;

	/**
	 * Find all NumericViews matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching NumericViews.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<NumericView> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all NumericViews matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching NumericViews.
     *
     * @see Pageable
     * @see Page
	 */
    Page<NumericView> findAll(String query, Pageable pageable);

    /**
	 * Exports all NumericViews matching the given input query to the given exportType format.
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
	 * Retrieve the count of the NumericViews in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the NumericView.
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

