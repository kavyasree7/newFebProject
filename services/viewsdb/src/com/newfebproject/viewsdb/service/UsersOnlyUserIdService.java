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

import com.newfebproject.viewsdb.UserDetailsOnlyUsername;
import com.newfebproject.viewsdb.UsersOnlyUserId;

/**
 * Service object for domain model class {@link UsersOnlyUserId}.
 */
public interface UsersOnlyUserIdService {

    /**
     * Creates a new UsersOnlyUserId. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on UsersOnlyUserId if any.
     *
     * @param usersOnlyUserId Details of the UsersOnlyUserId to be created; value cannot be null.
     * @return The newly created UsersOnlyUserId.
     */
	UsersOnlyUserId create(UsersOnlyUserId usersOnlyUserId);


	/**
	 * Returns UsersOnlyUserId by given id if exists.
	 *
	 * @param usersonlyuseridId The id of the UsersOnlyUserId to get; value cannot be null.
	 * @return UsersOnlyUserId associated with the given usersonlyuseridId.
     * @throws EntityNotFoundException If no UsersOnlyUserId is found.
	 */
	UsersOnlyUserId getById(Integer usersonlyuseridId) throws EntityNotFoundException;

    /**
	 * Find and return the UsersOnlyUserId by given id if exists, returns null otherwise.
	 *
	 * @param usersonlyuseridId The id of the UsersOnlyUserId to get; value cannot be null.
	 * @return UsersOnlyUserId associated with the given usersonlyuseridId.
	 */
	UsersOnlyUserId findById(Integer usersonlyuseridId);


	/**
	 * Updates the details of an existing UsersOnlyUserId. It replaces all fields of the existing UsersOnlyUserId with the given usersOnlyUserId.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on UsersOnlyUserId if any.
     *
	 * @param usersOnlyUserId The details of the UsersOnlyUserId to be updated; value cannot be null.
	 * @return The updated UsersOnlyUserId.
	 * @throws EntityNotFoundException if no UsersOnlyUserId is found with given input.
	 */
	UsersOnlyUserId update(UsersOnlyUserId usersOnlyUserId) throws EntityNotFoundException;

    /**
	 * Deletes an existing UsersOnlyUserId with the given id.
	 *
	 * @param usersonlyuseridId The id of the UsersOnlyUserId to be deleted; value cannot be null.
	 * @return The deleted UsersOnlyUserId.
	 * @throws EntityNotFoundException if no UsersOnlyUserId found with the given id.
	 */
	UsersOnlyUserId delete(Integer usersonlyuseridId) throws EntityNotFoundException;

	/**
	 * Find all UsersOnlyUserIds matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UsersOnlyUserIds.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<UsersOnlyUserId> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all UsersOnlyUserIds matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching UsersOnlyUserIds.
     *
     * @see Pageable
     * @see Page
	 */
    Page<UsersOnlyUserId> findAll(String query, Pageable pageable);

    /**
	 * Exports all UsersOnlyUserIds matching the given input query to the given exportType format.
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
	 * Retrieve the count of the UsersOnlyUserIds in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the UsersOnlyUserId.
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
     * Returns the associated userDetailsOnlyUsernames for given UsersOnlyUserId id.
     *
     * @param userId value of userId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated UserDetailsOnlyUsername instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<UserDetailsOnlyUsername> findAssociatedUserDetailsOnlyUsernames(Integer userId, Pageable pageable);

}

