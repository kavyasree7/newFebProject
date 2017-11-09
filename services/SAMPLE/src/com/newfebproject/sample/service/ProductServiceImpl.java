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

import com.newfebproject.sample.Product;


/**
 * ServiceImpl object for domain model class Product.
 *
 * @see Product
 */
@Service("SAMPLE.ProductService")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.ProductDao")
    private WMGenericDao<Product, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Product, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Product create(Product product) {
        LOGGER.debug("Creating a new Product with information: {}", product);
        Product productCreated = this.wmGenericDao.create(product);
        return productCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Product getById(String productId) throws EntityNotFoundException {
        LOGGER.debug("Finding Product by id: {}", productId);
        Product product = this.wmGenericDao.findById(productId);
        if (product == null){
            LOGGER.debug("No Product found with id: {}", productId);
            throw new EntityNotFoundException(String.valueOf(productId));
        }
        return product;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Product findById(String productId) {
        LOGGER.debug("Finding Product by id: {}", productId);
        return this.wmGenericDao.findById(productId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Product update(Product product) throws EntityNotFoundException {
        LOGGER.debug("Updating Product with information: {}", product);
        this.wmGenericDao.update(product);

        String productId = product.getPid();

        return this.wmGenericDao.findById(productId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Product delete(String productId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Product with id: {}", productId);
        Product deleted = this.wmGenericDao.findById(productId);
        if (deleted == null) {
            LOGGER.debug("No Product found with id: {}", productId);
            throw new EntityNotFoundException(String.valueOf(productId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Product> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Products");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Product> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Products");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Product to {} format", exportType);
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
