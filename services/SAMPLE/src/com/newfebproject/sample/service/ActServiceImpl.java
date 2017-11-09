/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.newfebproject.sample.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
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

import com.newfebproject.sample.Act;


/**
 * ServiceImpl object for domain model class Act.
 *
 * @see Act
 */
@Service("SAMPLE.ActService")
public class ActServiceImpl implements ActService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActServiceImpl.class);


    @Autowired
    @Qualifier("SAMPLE.ActDao")
    private WMGenericDao<Act, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Act, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Act create(Act act) {
        LOGGER.debug("Creating a new Act with information: {}", act);
        Act actCreated = this.wmGenericDao.create(act);
        if(actCreated.getActForActno() != null) {
            Act actForActno = actCreated.getActForActno();
            LOGGER.debug("Creating a new child Act with information: {}", actForActno);
            actForActno.setActByActno(actCreated);
            create(actForActno);
        }
        return actCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Act getById(Short actId) throws EntityNotFoundException {
        LOGGER.debug("Finding Act by id: {}", actId);
        Act act = this.wmGenericDao.findById(actId);
        if (act == null){
            LOGGER.debug("No Act found with id: {}", actId);
            throw new EntityNotFoundException(String.valueOf(actId));
        }
        return act;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Act findById(Short actId) {
        LOGGER.debug("Finding Act by id: {}", actId);
        return this.wmGenericDao.findById(actId);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Act getByActnoAndActkwd(short actno, String actkwd) {
        Map<String, Object> actnoAndActkwdMap = new HashMap<>();
        actnoAndActkwdMap.put("actno", actno);
        actnoAndActkwdMap.put("actkwd", actkwd);

        LOGGER.debug("Finding Act by unique keys: {}", actnoAndActkwdMap);
        Act act = this.wmGenericDao.findByUniqueKey(actnoAndActkwdMap);

        if (act == null){
            LOGGER.debug("No Act found with given unique key values: {}", actnoAndActkwdMap);
            throw new EntityNotFoundException(String.valueOf(actnoAndActkwdMap));
        }

        return act;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Act update(Act act) throws EntityNotFoundException {
        LOGGER.debug("Updating Act with information: {}", act);
        this.wmGenericDao.update(act);

        Short actId = act.getActno();

        return this.wmGenericDao.findById(actId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Act delete(Short actId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Act with id: {}", actId);
        Act deleted = this.wmGenericDao.findById(actId);
        if (deleted == null) {
            LOGGER.debug("No Act found with id: {}", actId);
            throw new EntityNotFoundException(String.valueOf(actId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Act> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Acts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Act> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Acts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Act to {} format", exportType);
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

