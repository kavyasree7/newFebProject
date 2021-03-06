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

import com.newfebproject.sample.Vproj;
import com.newfebproject.sample.VprojId;


/**
 * ServiceImpl object for domain model class Vproj.
 *
 * @see Vproj
 */
@Service("SAMPLE.VprojService")
public class VprojServiceImpl implements VprojService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VprojServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.VprojDao")
    private WMGenericDao<Vproj, VprojId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Vproj, VprojId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Vproj create(Vproj vproj) {
        LOGGER.debug("Creating a new Vproj with information: {}", vproj);
        Vproj vprojCreated = this.wmGenericDao.create(vproj);
        return vprojCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Vproj getById(VprojId vprojId) throws EntityNotFoundException {
        LOGGER.debug("Finding Vproj by id: {}", vprojId);
        Vproj vproj = this.wmGenericDao.findById(vprojId);
        if (vproj == null){
            LOGGER.debug("No Vproj found with id: {}", vprojId);
            throw new EntityNotFoundException(String.valueOf(vprojId));
        }
        return vproj;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Vproj findById(VprojId vprojId) {
        LOGGER.debug("Finding Vproj by id: {}", vprojId);
        return this.wmGenericDao.findById(vprojId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Vproj update(Vproj vproj) throws EntityNotFoundException {
        LOGGER.debug("Updating Vproj with information: {}", vproj);
        this.wmGenericDao.update(vproj);

        VprojId vprojId = new VprojId();
        vprojId.setProjno(vproj.getProjno());
        vprojId.setProjname(vproj.getProjname());
        vprojId.setDeptno(vproj.getDeptno());
        vprojId.setRespemp(vproj.getRespemp());
        vprojId.setPrstaff(vproj.getPrstaff());
        vprojId.setPrstdate(vproj.getPrstdate());
        vprojId.setPrendate(vproj.getPrendate());
        vprojId.setMajproj(vproj.getMajproj());

        return this.wmGenericDao.findById(vprojId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Vproj delete(VprojId vprojId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Vproj with id: {}", vprojId);
        Vproj deleted = this.wmGenericDao.findById(vprojId);
        if (deleted == null) {
            LOGGER.debug("No Vproj found with id: {}", vprojId);
            throw new EntityNotFoundException(String.valueOf(vprojId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Vproj> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Vprojs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Vproj> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Vprojs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Vproj to {} format", exportType);
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

