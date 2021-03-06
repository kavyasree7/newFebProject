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

import com.newfebproject.sample.Empprojact;
import com.newfebproject.sample.EmpprojactId;


/**
 * ServiceImpl object for domain model class Empprojact.
 *
 * @see Empprojact
 */
@Service("SAMPLE.EmpprojactService")
public class EmpprojactServiceImpl implements EmpprojactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpprojactServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.EmpprojactDao")
    private WMGenericDao<Empprojact, EmpprojactId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Empprojact, EmpprojactId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Empprojact create(Empprojact empprojact) {
        LOGGER.debug("Creating a new Empprojact with information: {}", empprojact);
        Empprojact empprojactCreated = this.wmGenericDao.create(empprojact);
        return empprojactCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Empprojact getById(EmpprojactId empprojactId) throws EntityNotFoundException {
        LOGGER.debug("Finding Empprojact by id: {}", empprojactId);
        Empprojact empprojact = this.wmGenericDao.findById(empprojactId);
        if (empprojact == null){
            LOGGER.debug("No Empprojact found with id: {}", empprojactId);
            throw new EntityNotFoundException(String.valueOf(empprojactId));
        }
        return empprojact;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Empprojact findById(EmpprojactId empprojactId) {
        LOGGER.debug("Finding Empprojact by id: {}", empprojactId);
        return this.wmGenericDao.findById(empprojactId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Empprojact update(Empprojact empprojact) throws EntityNotFoundException {
        LOGGER.debug("Updating Empprojact with information: {}", empprojact);
        this.wmGenericDao.update(empprojact);

        EmpprojactId empprojactId = new EmpprojactId();
        empprojactId.setEmpno(empprojact.getEmpno());
        empprojactId.setProjno(empprojact.getProjno());
        empprojactId.setActno(empprojact.getActno());
        empprojactId.setEmptime(empprojact.getEmptime());
        empprojactId.setEmstdate(empprojact.getEmstdate());
        empprojactId.setEmendate(empprojact.getEmendate());

        return this.wmGenericDao.findById(empprojactId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Empprojact delete(EmpprojactId empprojactId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Empprojact with id: {}", empprojactId);
        Empprojact deleted = this.wmGenericDao.findById(empprojactId);
        if (deleted == null) {
            LOGGER.debug("No Empprojact found with id: {}", empprojactId);
            throw new EntityNotFoundException(String.valueOf(empprojactId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Empprojact> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Empprojacts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Empprojact> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Empprojacts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Empprojact to {} format", exportType);
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

