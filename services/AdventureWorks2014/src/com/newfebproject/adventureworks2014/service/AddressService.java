/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.adventureworks2014.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.adventureworks2014.Address;

/**
 * Service object for domain model class {@link Address}.
 */
public interface AddressService {

    /**
     * Creates a new Address. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Address if any.
     *
     * @param address Details of the Address to be created; value cannot be null.
     * @return The newly created Address.
     */
	Address create(Address address);


	/**
	 * Returns Address by given id if exists.
	 *
	 * @param addressIdInstance The id of the Address to get; value cannot be null.
	 * @return Address associated with the given addressIdInstance.
     * @throws EntityNotFoundException If no Address is found.
	 */
	Address getById(Integer addressIdInstance) throws EntityNotFoundException;

    /**
	 * Find and return the Address by given id if exists, returns null otherwise.
	 *
	 * @param addressIdInstance The id of the Address to get; value cannot be null.
	 * @return Address associated with the given addressIdInstance.
	 */
	Address findById(Integer addressIdInstance);

    /**
	 * Find and return the Address for given rowguid  if exists.
	 *
	 * @param rowguid value of rowguid; value cannot be null.
	 * @return Address associated with the given inputs.
     * @throws EntityNotFoundException if no matching Address found.
	 */
    Address getByRowguid(String rowguid)throws EntityNotFoundException;

    /**
	 * Find and return the Address for given addressLine1  andaddressLine2  andcity  andstateProvinceId  andpostalCode  if exists.
	 *
	 * @param addressLine1 value of addressLine1; value cannot be null.
	 * @param addressLine2 value of addressLine2; value cannot be null.
	 * @param city value of city; value cannot be null.
	 * @param stateProvinceId value of stateProvinceId; value cannot be null.
	 * @param postalCode value of postalCode; value cannot be null.
	 * @return Address associated with the given inputs.
     * @throws EntityNotFoundException if no matching Address found.
	 */
    Address getByAddressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCode(String addressLine1, String addressLine2, String city, int stateProvinceId, String postalCode)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Address. It replaces all fields of the existing Address with the given address.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Address if any.
     *
	 * @param address The details of the Address to be updated; value cannot be null.
	 * @return The updated Address.
	 * @throws EntityNotFoundException if no Address is found with given input.
	 */
	Address update(Address address) throws EntityNotFoundException;

    /**
	 * Deletes an existing Address with the given id.
	 *
	 * @param addressIdInstance The id of the Address to be deleted; value cannot be null.
	 * @return The deleted Address.
	 * @throws EntityNotFoundException if no Address found with the given id.
	 */
	Address delete(Integer addressIdInstance) throws EntityNotFoundException;

	/**
	 * Find all Addresses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Addresses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Address> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Addresses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Addresses.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Address> findAll(String query, Pageable pageable);

    /**
	 * Exports all Addresses matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Addresses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Address.
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
