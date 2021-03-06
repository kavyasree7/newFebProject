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

import com.newfebproject.sample.Vprojact;
import com.newfebproject.sample.VprojactId;


/**
 * ServiceImpl object for domain model class Vprojact.
 *
 * @see Vprojact
 */
@Service("SAMPLE.VprojactService")
public class VprojactServiceImpl implements VprojactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VprojactServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.VprojactDao")
    private WMGenericDao<Vprojact, VprojactId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Vprojact, VprojactId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Vprojact create(Vprojact vprojact) {
        LOGGER.debug("Creating a new Vprojact with information: {}", vprojact);
        Vprojact vprojactCreated = this.wmGenericDao.create(vprojact);
        return vprojactCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Vprojact getById(VprojactId vprojactId) throws EntityNotFoundException {
        LOGGER.debug("Finding Vprojact by id: {}", vprojactId);
        Vprojact vprojact = this.wmGenericDao.findById(vprojactId);
        if (vprojact == null){
            LOGGER.debug("No Vprojact found with id: {}", vprojactId);
            throw new EntityNotFoundException(String.valueOf(vprojactId));
        }
        return vprojact;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Vprojact findById(VprojactId vprojactId) {
        LOGGER.debug("Finding Vprojact by id: {}", vprojactId);
        return this.wmGenericDao.findById(vprojactId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Vprojact update(Vprojact vprojact) throws EntityNotFoundException {
        LOGGER.debug("Updating Vprojact with information: {}", vprojact);
        this.wmGenericDao.update(vprojact);

        VprojactId vprojactId = new VprojactId();
        vprojactId.setProjno(vprojact.getProjno());
        vprojactId.setActno(vprojact.getActno());
        vprojactId.setAcstaff(vprojact.getAcstaff());
        vprojactId.setAcstdate(vprojact.getAcstdate());
        vprojactId.setAcendate(vprojact.getAcendate());

        return this.wmGenericDao.findById(vprojactId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Vprojact delete(VprojactId vprojactId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Vprojact with id: {}", vprojactId);
        Vprojact deleted = this.wmGenericDao.findById(vprojactId);
        if (deleted == null) {
            LOGGER.debug("No Vprojact found with id: {}", vprojactId);
            throw new EntityNotFoundException(String.valueOf(vprojactId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Vprojact> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Vprojacts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Vprojact> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Vprojacts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Vprojact to {} format", exportType);
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

