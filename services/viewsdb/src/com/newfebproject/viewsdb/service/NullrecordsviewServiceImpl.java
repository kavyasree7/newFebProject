/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.viewsdb.service;

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

import com.newfebproject.viewsdb.Nullrecordsview;
import com.newfebproject.viewsdb.NullrecordsviewId;


/**
 * ServiceImpl object for domain model class Nullrecordsview.
 *
 * @see Nullrecordsview
 */
@Service("viewsdb.NullrecordsviewService")
public class NullrecordsviewServiceImpl implements NullrecordsviewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NullrecordsviewServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.NullrecordsviewDao")
    private WMGenericDao<Nullrecordsview, NullrecordsviewId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Nullrecordsview, NullrecordsviewId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Nullrecordsview create(Nullrecordsview nullrecordsview) {
        LOGGER.debug("Creating a new Nullrecordsview with information: {}", nullrecordsview);
        Nullrecordsview nullrecordsviewCreated = this.wmGenericDao.create(nullrecordsview);
        return nullrecordsviewCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Nullrecordsview getById(NullrecordsviewId nullrecordsviewId) throws EntityNotFoundException {
        LOGGER.debug("Finding Nullrecordsview by id: {}", nullrecordsviewId);
        Nullrecordsview nullrecordsview = this.wmGenericDao.findById(nullrecordsviewId);
        if (nullrecordsview == null){
            LOGGER.debug("No Nullrecordsview found with id: {}", nullrecordsviewId);
            throw new EntityNotFoundException(String.valueOf(nullrecordsviewId));
        }
        return nullrecordsview;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Nullrecordsview findById(NullrecordsviewId nullrecordsviewId) {
        LOGGER.debug("Finding Nullrecordsview by id: {}", nullrecordsviewId);
        return this.wmGenericDao.findById(nullrecordsviewId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Nullrecordsview update(Nullrecordsview nullrecordsview) throws EntityNotFoundException {
        LOGGER.debug("Updating Nullrecordsview with information: {}", nullrecordsview);
        this.wmGenericDao.update(nullrecordsview);

        NullrecordsviewId nullrecordsviewId = new NullrecordsviewId();
        nullrecordsviewId.setUsername(nullrecordsview.getUsername());
        nullrecordsviewId.setPassword(nullrecordsview.getPassword());
        nullrecordsviewId.setRole(nullrecordsview.getRole());
        nullrecordsviewId.setUsernamedeta(nullrecordsview.getUsernamedeta());
        nullrecordsviewId.setUsersal(nullrecordsview.getUsersal());
        nullrecordsviewId.setNoofemployees(nullrecordsview.getNoofemployees());
        nullrecordsviewId.setIsemployee(nullrecordsview.getIsemployee());

        return this.wmGenericDao.findById(nullrecordsviewId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Nullrecordsview delete(NullrecordsviewId nullrecordsviewId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Nullrecordsview with id: {}", nullrecordsviewId);
        Nullrecordsview deleted = this.wmGenericDao.findById(nullrecordsviewId);
        if (deleted == null) {
            LOGGER.debug("No Nullrecordsview found with id: {}", nullrecordsviewId);
            throw new EntityNotFoundException(String.valueOf(nullrecordsviewId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Nullrecordsview> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Nullrecordsviews");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Nullrecordsview> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Nullrecordsviews");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Nullrecordsview to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
