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

import com.newfebproject.viewsdb.Table39;


/**
 * ServiceImpl object for domain model class Table39.
 *
 * @see Table39
 */
@Service("viewsdb.Table39Service")
public class Table39ServiceImpl implements Table39Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table39ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table39Dao")
    private WMGenericDao<Table39, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table39, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table39 create(Table39 table39) {
        LOGGER.debug("Creating a new Table39 with information: {}", table39);
        Table39 table39Created = this.wmGenericDao.create(table39);
        return table39Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table39 getById(Integer table39Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table39 by id: {}", table39Id);
        Table39 table39 = this.wmGenericDao.findById(table39Id);
        if (table39 == null){
            LOGGER.debug("No Table39 found with id: {}", table39Id);
            throw new EntityNotFoundException(String.valueOf(table39Id));
        }
        return table39;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table39 findById(Integer table39Id) {
        LOGGER.debug("Finding Table39 by id: {}", table39Id);
        return this.wmGenericDao.findById(table39Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table39 update(Table39 table39) throws EntityNotFoundException {
        LOGGER.debug("Updating Table39 with information: {}", table39);
        this.wmGenericDao.update(table39);

        Integer table39Id = table39.getId();

        return this.wmGenericDao.findById(table39Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table39 delete(Integer table39Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table39 with id: {}", table39Id);
        Table39 deleted = this.wmGenericDao.findById(table39Id);
        if (deleted == null) {
            LOGGER.debug("No Table39 found with id: {}", table39Id);
            throw new EntityNotFoundException(String.valueOf(table39Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table39> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table39s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table39> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table39s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table39 to {} format", exportType);
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
