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

import com.newfebproject.viewsdb.UserDetailsOnlyUsername;
import com.newfebproject.viewsdb.UsersOnlyUserId;


/**
 * ServiceImpl object for domain model class UsersOnlyUserId.
 *
 * @see UsersOnlyUserId
 */
@Service("viewsdb.UsersOnlyUserIdService")
public class UsersOnlyUserIdServiceImpl implements UsersOnlyUserIdService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersOnlyUserIdServiceImpl.class);

    @Autowired
	@Qualifier("viewsdb.UserDetailsOnlyUsernameService")
	private UserDetailsOnlyUsernameService userDetailsOnlyUsernameService;

    @Autowired
    @Qualifier("viewsdb.UsersOnlyUserIdDao")
    private WMGenericDao<UsersOnlyUserId, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<UsersOnlyUserId, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public UsersOnlyUserId create(UsersOnlyUserId usersOnlyUserId) {
        LOGGER.debug("Creating a new UsersOnlyUserId with information: {}", usersOnlyUserId);
        UsersOnlyUserId usersOnlyUserIdCreated = this.wmGenericDao.create(usersOnlyUserId);
        if(usersOnlyUserIdCreated.getUserDetailsOnlyUsernames() != null) {
            for(UserDetailsOnlyUsername userDetailsOnlyUsername : usersOnlyUserIdCreated.getUserDetailsOnlyUsernames()) {
                userDetailsOnlyUsername.setUsersOnlyUserId(usersOnlyUserIdCreated);
                LOGGER.debug("Creating a new child UserDetailsOnlyUsername with information: {}", userDetailsOnlyUsername);
                userDetailsOnlyUsernameService.create(userDetailsOnlyUsername);
            }
        }
        return usersOnlyUserIdCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public UsersOnlyUserId getById(Integer usersonlyuseridId) throws EntityNotFoundException {
        LOGGER.debug("Finding UsersOnlyUserId by id: {}", usersonlyuseridId);
        UsersOnlyUserId usersOnlyUserId = this.wmGenericDao.findById(usersonlyuseridId);
        if (usersOnlyUserId == null){
            LOGGER.debug("No UsersOnlyUserId found with id: {}", usersonlyuseridId);
            throw new EntityNotFoundException(String.valueOf(usersonlyuseridId));
        }
        return usersOnlyUserId;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public UsersOnlyUserId findById(Integer usersonlyuseridId) {
        LOGGER.debug("Finding UsersOnlyUserId by id: {}", usersonlyuseridId);
        return this.wmGenericDao.findById(usersonlyuseridId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public UsersOnlyUserId update(UsersOnlyUserId usersOnlyUserId) throws EntityNotFoundException {
        LOGGER.debug("Updating UsersOnlyUserId with information: {}", usersOnlyUserId);
        this.wmGenericDao.update(usersOnlyUserId);

        Integer usersonlyuseridId = usersOnlyUserId.getUserId();

        return this.wmGenericDao.findById(usersonlyuseridId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public UsersOnlyUserId delete(Integer usersonlyuseridId) throws EntityNotFoundException {
        LOGGER.debug("Deleting UsersOnlyUserId with id: {}", usersonlyuseridId);
        UsersOnlyUserId deleted = this.wmGenericDao.findById(usersonlyuseridId);
        if (deleted == null) {
            LOGGER.debug("No UsersOnlyUserId found with id: {}", usersonlyuseridId);
            throw new EntityNotFoundException(String.valueOf(usersonlyuseridId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<UsersOnlyUserId> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UsersOnlyUserIds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<UsersOnlyUserId> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UsersOnlyUserIds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table UsersOnlyUserId to {} format", exportType);
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

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<UserDetailsOnlyUsername> findAssociatedUserDetailsOnlyUsernames(Integer userId, Pageable pageable) {
        LOGGER.debug("Fetching all associated userDetailsOnlyUsernames");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("usersOnlyUserId.userId = '" + userId + "'");

        return userDetailsOnlyUsernameService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UserDetailsOnlyUsernameService instance
	 */
	protected void setUserDetailsOnlyUsernameService(UserDetailsOnlyUsernameService service) {
        this.userDetailsOnlyUsernameService = service;
    }

}

