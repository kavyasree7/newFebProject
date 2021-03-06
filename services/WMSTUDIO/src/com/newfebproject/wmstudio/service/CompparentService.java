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

import com.newfebproject.wmstudio.CompChild;
import com.newfebproject.wmstudio.Compparent;
import com.newfebproject.wmstudio.CompparentId;

/**
 * Service object for domain model class {@link Compparent}.
 */
public interface CompparentService {

    /**
     * Creates a new Compparent. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Compparent if any.
     *
     * @param compparent Details of the Compparent to be created; value cannot be null.
     * @return The newly created Compparent.
     */
	Compparent create(Compparent compparent);


	/**
	 * Returns Compparent by given id if exists.
	 *
	 * @param compparentId The id of the Compparent to get; value cannot be null.
	 * @return Compparent associated with the given compparentId.
     * @throws EntityNotFoundException If no Compparent is found.
	 */
	Compparent getById(CompparentId compparentId) throws EntityNotFoundException;

    /**
	 * Find and return the Compparent by given id if exists, returns null otherwise.
	 *
	 * @param compparentId The id of the Compparent to get; value cannot be null.
	 * @return Compparent associated with the given compparentId.
	 */
	Compparent findById(CompparentId compparentId);

    /**
	 * Find and return the Compparent for given stringColumnm  if exists.
	 *
	 * @param stringColumnm value of stringColumnm; value cannot be null.
	 * @return Compparent associated with the given inputs.
     * @throws EntityNotFoundException if no matching Compparent found.
	 */
    Compparent getByStringColumnm(String stringColumnm)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Compparent. It replaces all fields of the existing Compparent with the given compparent.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Compparent if any.
     *
	 * @param compparent The details of the Compparent to be updated; value cannot be null.
	 * @return The updated Compparent.
	 * @throws EntityNotFoundException if no Compparent is found with given input.
	 */
	Compparent update(Compparent compparent) throws EntityNotFoundException;

    /**
	 * Deletes an existing Compparent with the given id.
	 *
	 * @param compparentId The id of the Compparent to be deleted; value cannot be null.
	 * @return The deleted Compparent.
	 * @throws EntityNotFoundException if no Compparent found with the given id.
	 */
	Compparent delete(CompparentId compparentId) throws EntityNotFoundException;

	/**
	 * Find all Compparents matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Compparents.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Compparent> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Compparents matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Compparents.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Compparent> findAll(String query, Pageable pageable);

    /**
	 * Exports all Compparents matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Compparents in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Compparent.
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

    /*
     * Returns the associated compChilds for given Compparent id.
     *
     * @param idColumn value of idColumn; value cannot be null
     * @param bigdecimalColumn value of bigdecimalColumn; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated CompChild instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<CompChild> findAssociatedCompChilds(Integer idColumn, BigInteger bigdecimalColumn, Pageable pageable);

}

