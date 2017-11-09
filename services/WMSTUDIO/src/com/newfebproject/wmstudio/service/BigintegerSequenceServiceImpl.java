/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.math.BigInteger;
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

import com.newfebproject.wmstudio.BigintegerSequence;


/**
 * ServiceImpl object for domain model class BigintegerSequence.
 *
 * @see BigintegerSequence
 */
@Service("WMSTUDIO.BigintegerSequenceService")
public class BigintegerSequenceServiceImpl implements BigintegerSequenceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BigintegerSequenceServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.BigintegerSequenceDao")
    private WMGenericDao<BigintegerSequence, BigInteger> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<BigintegerSequence, BigInteger> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public BigintegerSequence create(BigintegerSequence bigintegerSequenceInstance) {
        LOGGER.debug("Creating a new BigintegerSequence with information: {}", bigintegerSequenceInstance);
        BigintegerSequence bigintegerSequenceInstanceCreated = this.wmGenericDao.create(bigintegerSequenceInstance);
        return bigintegerSequenceInstanceCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public BigintegerSequence getById(BigInteger bigintegersequenceId) throws EntityNotFoundException {
        LOGGER.debug("Finding BigintegerSequence by id: {}", bigintegersequenceId);
        BigintegerSequence bigintegerSequenceInstance = this.wmGenericDao.findById(bigintegersequenceId);
        if (bigintegerSequenceInstance == null){
            LOGGER.debug("No BigintegerSequence found with id: {}", bigintegersequenceId);
            throw new EntityNotFoundException(String.valueOf(bigintegersequenceId));
        }
        return bigintegerSequenceInstance;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public BigintegerSequence findById(BigInteger bigintegersequenceId) {
        LOGGER.debug("Finding BigintegerSequence by id: {}", bigintegersequenceId);
        return this.wmGenericDao.findById(bigintegersequenceId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public BigintegerSequence update(BigintegerSequence bigintegerSequenceInstance) throws EntityNotFoundException {
        LOGGER.debug("Updating BigintegerSequence with information: {}", bigintegerSequenceInstance);
        this.wmGenericDao.update(bigintegerSequenceInstance);

        BigInteger bigintegersequenceId = bigintegerSequenceInstance.getBigintegerSequence();

        return this.wmGenericDao.findById(bigintegersequenceId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public BigintegerSequence delete(BigInteger bigintegersequenceId) throws EntityNotFoundException {
        LOGGER.debug("Deleting BigintegerSequence with id: {}", bigintegersequenceId);
        BigintegerSequence deleted = this.wmGenericDao.findById(bigintegersequenceId);
        if (deleted == null) {
            LOGGER.debug("No BigintegerSequence found with id: {}", bigintegersequenceId);
            throw new EntityNotFoundException(String.valueOf(bigintegersequenceId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<BigintegerSequence> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all BigintegerSequences");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<BigintegerSequence> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all BigintegerSequences");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table BigintegerSequence to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
