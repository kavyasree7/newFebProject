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

import com.newfebproject.viewsdb.Tableupdate;


/**
 * ServiceImpl object for domain model class Tableupdate.
 *
 * @see Tableupdate
 */
@Service("viewsdb.TableupdateService")
public class TableupdateServiceImpl implements TableupdateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableupdateServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.TableupdateDao")
    private WMGenericDao<Tableupdate, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Tableupdate, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Tableupdate create(Tableupdate tableupdate) {
        LOGGER.debug("Creating a new Tableupdate with information: {}", tableupdate);
        Tableupdate tableupdateCreated = this.wmGenericDao.create(tableupdate);
        return tableupdateCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Tableupdate getById(Short tableupdateId) throws EntityNotFoundException {
        LOGGER.debug("Finding Tableupdate by id: {}", tableupdateId);
        Tableupdate tableupdate = this.wmGenericDao.findById(tableupdateId);
        if (tableupdate == null){
            LOGGER.debug("No Tableupdate found with id: {}", tableupdateId);
            throw new EntityNotFoundException(String.valueOf(tableupdateId));
        }
        return tableupdate;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Tableupdate findById(Short tableupdateId) {
        LOGGER.debug("Finding Tableupdate by id: {}", tableupdateId);
        return this.wmGenericDao.findById(tableupdateId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Tableupdate update(Tableupdate tableupdate) throws EntityNotFoundException {
        LOGGER.debug("Updating Tableupdate with information: {}", tableupdate);
        this.wmGenericDao.update(tableupdate);

        Short tableupdateId = tableupdate.getId();

        return this.wmGenericDao.findById(tableupdateId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Tableupdate delete(Short tableupdateId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Tableupdate with id: {}", tableupdateId);
        Tableupdate deleted = this.wmGenericDao.findById(tableupdateId);
        if (deleted == null) {
            LOGGER.debug("No Tableupdate found with id: {}", tableupdateId);
            throw new EntityNotFoundException(String.valueOf(tableupdateId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Tableupdate> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Tableupdates");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Tableupdate> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Tableupdates");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Tableupdate to {} format", exportType);
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

