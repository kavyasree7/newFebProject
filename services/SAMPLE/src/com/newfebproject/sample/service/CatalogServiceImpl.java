/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

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

import com.newfebproject.sample.Catalog;


/**
 * ServiceImpl object for domain model class Catalog.
 *
 * @see Catalog
 */
@Service("SAMPLE.CatalogService")
public class CatalogServiceImpl implements CatalogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.CatalogDao")
    private WMGenericDao<Catalog, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Catalog, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Catalog create(Catalog catalog) {
        LOGGER.debug("Creating a new Catalog with information: {}", catalog);
        Catalog catalogCreated = this.wmGenericDao.create(catalog);
        return catalogCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Catalog getById(String catalogId) throws EntityNotFoundException {
        LOGGER.debug("Finding Catalog by id: {}", catalogId);
        Catalog catalog = this.wmGenericDao.findById(catalogId);
        if (catalog == null){
            LOGGER.debug("No Catalog found with id: {}", catalogId);
            throw new EntityNotFoundException(String.valueOf(catalogId));
        }
        return catalog;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Catalog findById(String catalogId) {
        LOGGER.debug("Finding Catalog by id: {}", catalogId);
        return this.wmGenericDao.findById(catalogId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Catalog update(Catalog catalog) throws EntityNotFoundException {
        LOGGER.debug("Updating Catalog with information: {}", catalog);
        this.wmGenericDao.update(catalog);

        String catalogId = catalog.getName();

        return this.wmGenericDao.findById(catalogId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Catalog delete(String catalogId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Catalog with id: {}", catalogId);
        Catalog deleted = this.wmGenericDao.findById(catalogId);
        if (deleted == null) {
            LOGGER.debug("No Catalog found with id: {}", catalogId);
            throw new EntityNotFoundException(String.valueOf(catalogId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Catalog> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Catalogs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Catalog> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Catalogs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Catalog to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

