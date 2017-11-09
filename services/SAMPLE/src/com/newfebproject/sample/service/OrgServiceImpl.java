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

import com.newfebproject.sample.Org;
import com.newfebproject.sample.OrgId;


/**
 * ServiceImpl object for domain model class Org.
 *
 * @see Org
 */
@Service("SAMPLE.OrgService")
public class OrgServiceImpl implements OrgService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrgServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.OrgDao")
    private WMGenericDao<Org, OrgId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Org, OrgId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Org create(Org org) {
        LOGGER.debug("Creating a new Org with information: {}", org);
        Org orgCreated = this.wmGenericDao.create(org);
        return orgCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Org getById(OrgId orgId) throws EntityNotFoundException {
        LOGGER.debug("Finding Org by id: {}", orgId);
        Org org = this.wmGenericDao.findById(orgId);
        if (org == null){
            LOGGER.debug("No Org found with id: {}", orgId);
            throw new EntityNotFoundException(String.valueOf(orgId));
        }
        return org;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Org findById(OrgId orgId) {
        LOGGER.debug("Finding Org by id: {}", orgId);
        return this.wmGenericDao.findById(orgId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Org update(Org org) throws EntityNotFoundException {
        LOGGER.debug("Updating Org with information: {}", org);
        this.wmGenericDao.update(org);

        OrgId orgId = new OrgId();
        orgId.setDeptnumb(org.getDeptnumb());
        orgId.setDeptname(org.getDeptname());
        orgId.setManager(org.getManager());
        orgId.setDivision(org.getDivision());
        orgId.setLocation(org.getLocation());

        return this.wmGenericDao.findById(orgId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Org delete(OrgId orgId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Org with id: {}", orgId);
        Org deleted = this.wmGenericDao.findById(orgId);
        if (deleted == null) {
            LOGGER.debug("No Org found with id: {}", orgId);
            throw new EntityNotFoundException(String.valueOf(orgId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Org> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Orgs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Org> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Orgs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Org to {} format", exportType);
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

