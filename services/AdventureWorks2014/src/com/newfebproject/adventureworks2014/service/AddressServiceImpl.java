/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.adventureworks2014.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.newfebproject.adventureworks2014.Address;


/**
 * ServiceImpl object for domain model class Address.
 *
 * @see Address
 */
@Service("AdventureWorks2014.AddressService")
public class AddressServiceImpl implements AddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2014.AddressDao")
    private WMGenericDao<Address, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Address, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
    @Override
	public Address create(Address address) {
        LOGGER.debug("Creating a new Address with information: {}", address);
        Address addressCreated = this.wmGenericDao.create(address);
        return addressCreated;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Address getById(Integer addressIdInstance) throws EntityNotFoundException {
        LOGGER.debug("Finding Address by id: {}", addressIdInstance);
        Address address = this.wmGenericDao.findById(addressIdInstance);
        if (address == null){
            LOGGER.debug("No Address found with id: {}", addressIdInstance);
            throw new EntityNotFoundException(String.valueOf(addressIdInstance));
        }
        return address;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Address findById(Integer addressIdInstance) {
        LOGGER.debug("Finding Address by id: {}", addressIdInstance);
        return this.wmGenericDao.findById(addressIdInstance);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Address getByRowguid(String rowguid) {
        Map<String, Object> rowguidMap = new HashMap<>();
        rowguidMap.put("rowguid", rowguid);

        LOGGER.debug("Finding Address by unique keys: {}", rowguidMap);
        Address address = this.wmGenericDao.findByUniqueKey(rowguidMap);

        if (address == null){
            LOGGER.debug("No Address found with given unique key values: {}", rowguidMap);
            throw new EntityNotFoundException(String.valueOf(rowguidMap));
        }

        return address;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Address getByAddressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCode(String addressLine1, String addressLine2, String city, int stateProvinceId, String postalCode) {
        Map<String, Object> addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap = new HashMap<>();
        addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap.put("addressLine1", addressLine1);
        addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap.put("addressLine2", addressLine2);
        addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap.put("city", city);
        addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap.put("stateProvinceId", stateProvinceId);
        addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap.put("postalCode", postalCode);

        LOGGER.debug("Finding Address by unique keys: {}", addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap);
        Address address = this.wmGenericDao.findByUniqueKey(addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap);

        if (address == null){
            LOGGER.debug("No Address found with given unique key values: {}", addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap);
            throw new EntityNotFoundException(String.valueOf(addressLine1AndAddressLine2AndCityAndStateProvinceIdAndPostalCodeMap));
        }

        return address;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "AdventureWorks2014TransactionManager")
	@Override
	public Address update(Address address) throws EntityNotFoundException {
        LOGGER.debug("Updating Address with information: {}", address);
        this.wmGenericDao.update(address);

        Integer addressIdInstance = address.getAddressId();

        return this.wmGenericDao.findById(addressIdInstance);
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
	@Override
	public Address delete(Integer addressIdInstance) throws EntityNotFoundException {
        LOGGER.debug("Deleting Address with id: {}", addressIdInstance);
        Address deleted = this.wmGenericDao.findById(addressIdInstance);
        if (deleted == null) {
            LOGGER.debug("No Address found with id: {}", addressIdInstance);
            throw new EntityNotFoundException(String.valueOf(addressIdInstance));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<Address> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Addresses");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<Address> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Addresses");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table Address to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

