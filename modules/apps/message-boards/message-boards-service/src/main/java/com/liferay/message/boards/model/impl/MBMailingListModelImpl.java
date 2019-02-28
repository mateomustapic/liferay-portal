/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.message.boards.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.message.boards.model.MBMailingList;
import com.liferay.message.boards.model.MBMailingListModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the MBMailingList service. Represents a row in the &quot;MBMailingList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>MBMailingListModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MBMailingListImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBMailingListImpl
 * @generated
 */
@ProviderType
public class MBMailingListModelImpl
	extends BaseModelImpl<MBMailingList> implements MBMailingListModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a message boards mailing list model instance should use the <code>MBMailingList</code> interface instead.
	 */
	public static final String TABLE_NAME = "MBMailingList";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"mailingListId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"categoryId", Types.BIGINT}, {"emailAddress", Types.VARCHAR},
		{"inProtocol", Types.VARCHAR}, {"inServerName", Types.VARCHAR},
		{"inServerPort", Types.INTEGER}, {"inUseSSL", Types.BOOLEAN},
		{"inUserName", Types.VARCHAR}, {"inPassword", Types.VARCHAR},
		{"inReadInterval", Types.INTEGER}, {"outEmailAddress", Types.VARCHAR},
		{"outCustom", Types.BOOLEAN}, {"outServerName", Types.VARCHAR},
		{"outServerPort", Types.INTEGER}, {"outUseSSL", Types.BOOLEAN},
		{"outUserName", Types.VARCHAR}, {"outPassword", Types.VARCHAR},
		{"allowAnonymous", Types.BOOLEAN}, {"active_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mailingListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("categoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("emailAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inProtocol", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inServerName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inServerPort", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("inUseSSL", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("inUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inPassword", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inReadInterval", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("outEmailAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("outCustom", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("outServerName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("outServerPort", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("outUseSSL", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("outUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("outPassword", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("allowAnonymous", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table MBMailingList (uuid_ VARCHAR(75) null,mailingListId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,emailAddress VARCHAR(254) null,inProtocol VARCHAR(75) null,inServerName VARCHAR(75) null,inServerPort INTEGER,inUseSSL BOOLEAN,inUserName VARCHAR(75) null,inPassword VARCHAR(75) null,inReadInterval INTEGER,outEmailAddress VARCHAR(254) null,outCustom BOOLEAN,outServerName VARCHAR(75) null,outServerPort INTEGER,outUseSSL BOOLEAN,outUserName VARCHAR(75) null,outPassword VARCHAR(75) null,allowAnonymous BOOLEAN,active_ BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table MBMailingList";

	public static final String ORDER_BY_JPQL =
		" ORDER BY mbMailingList.mailingListId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY MBMailingList.mailingListId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.message.boards.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.message.boards.model.MBMailingList"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.message.boards.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.message.boards.model.MBMailingList"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.message.boards.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.message.boards.model.MBMailingList"),
		true);

	public static final long ACTIVE_COLUMN_BITMASK = 1L;

	public static final long CATEGORYID_COLUMN_BITMASK = 2L;

	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long MAILINGLISTID_COLUMN_BITMASK = 32L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.message.boards.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.message.boards.model.MBMailingList"));

	public MBMailingListModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _mailingListId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMailingListId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mailingListId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MBMailingList.class;
	}

	@Override
	public String getModelClassName() {
		return MBMailingList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<MBMailingList, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<MBMailingList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MBMailingList, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((MBMailingList)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<MBMailingList, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<MBMailingList, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(MBMailingList)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<MBMailingList, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<MBMailingList, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<MBMailingList, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<MBMailingList, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<MBMailingList, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<MBMailingList, Object>>();
		Map<String, BiConsumer<MBMailingList, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<MBMailingList, ?>>();

		attributeGetterFunctions.put("uuid", MBMailingList::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<MBMailingList, String>)MBMailingList::setUuid);
		attributeGetterFunctions.put(
			"mailingListId", MBMailingList::getMailingListId);
		attributeSetterBiConsumers.put(
			"mailingListId",
			(BiConsumer<MBMailingList, Long>)MBMailingList::setMailingListId);
		attributeGetterFunctions.put("groupId", MBMailingList::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<MBMailingList, Long>)MBMailingList::setGroupId);
		attributeGetterFunctions.put("companyId", MBMailingList::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<MBMailingList, Long>)MBMailingList::setCompanyId);
		attributeGetterFunctions.put("userId", MBMailingList::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<MBMailingList, Long>)MBMailingList::setUserId);
		attributeGetterFunctions.put("userName", MBMailingList::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<MBMailingList, String>)MBMailingList::setUserName);
		attributeGetterFunctions.put(
			"createDate", MBMailingList::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<MBMailingList, Date>)MBMailingList::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", MBMailingList::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<MBMailingList, Date>)MBMailingList::setModifiedDate);
		attributeGetterFunctions.put(
			"categoryId", MBMailingList::getCategoryId);
		attributeSetterBiConsumers.put(
			"categoryId",
			(BiConsumer<MBMailingList, Long>)MBMailingList::setCategoryId);
		attributeGetterFunctions.put(
			"emailAddress", MBMailingList::getEmailAddress);
		attributeSetterBiConsumers.put(
			"emailAddress",
			(BiConsumer<MBMailingList, String>)MBMailingList::setEmailAddress);
		attributeGetterFunctions.put(
			"inProtocol", MBMailingList::getInProtocol);
		attributeSetterBiConsumers.put(
			"inProtocol",
			(BiConsumer<MBMailingList, String>)MBMailingList::setInProtocol);
		attributeGetterFunctions.put(
			"inServerName", MBMailingList::getInServerName);
		attributeSetterBiConsumers.put(
			"inServerName",
			(BiConsumer<MBMailingList, String>)MBMailingList::setInServerName);
		attributeGetterFunctions.put(
			"inServerPort", MBMailingList::getInServerPort);
		attributeSetterBiConsumers.put(
			"inServerPort",
			(BiConsumer<MBMailingList, Integer>)MBMailingList::setInServerPort);
		attributeGetterFunctions.put("inUseSSL", MBMailingList::getInUseSSL);
		attributeSetterBiConsumers.put(
			"inUseSSL",
			(BiConsumer<MBMailingList, Boolean>)MBMailingList::setInUseSSL);
		attributeGetterFunctions.put(
			"inUserName", MBMailingList::getInUserName);
		attributeSetterBiConsumers.put(
			"inUserName",
			(BiConsumer<MBMailingList, String>)MBMailingList::setInUserName);
		attributeGetterFunctions.put(
			"inPassword", MBMailingList::getInPassword);
		attributeSetterBiConsumers.put(
			"inPassword",
			(BiConsumer<MBMailingList, String>)MBMailingList::setInPassword);
		attributeGetterFunctions.put(
			"inReadInterval", MBMailingList::getInReadInterval);
		attributeSetterBiConsumers.put(
			"inReadInterval",
			(BiConsumer<MBMailingList, Integer>)
				MBMailingList::setInReadInterval);
		attributeGetterFunctions.put(
			"outEmailAddress", MBMailingList::getOutEmailAddress);
		attributeSetterBiConsumers.put(
			"outEmailAddress",
			(BiConsumer<MBMailingList, String>)
				MBMailingList::setOutEmailAddress);
		attributeGetterFunctions.put("outCustom", MBMailingList::getOutCustom);
		attributeSetterBiConsumers.put(
			"outCustom",
			(BiConsumer<MBMailingList, Boolean>)MBMailingList::setOutCustom);
		attributeGetterFunctions.put(
			"outServerName", MBMailingList::getOutServerName);
		attributeSetterBiConsumers.put(
			"outServerName",
			(BiConsumer<MBMailingList, String>)MBMailingList::setOutServerName);
		attributeGetterFunctions.put(
			"outServerPort", MBMailingList::getOutServerPort);
		attributeSetterBiConsumers.put(
			"outServerPort",
			(BiConsumer<MBMailingList, Integer>)
				MBMailingList::setOutServerPort);
		attributeGetterFunctions.put("outUseSSL", MBMailingList::getOutUseSSL);
		attributeSetterBiConsumers.put(
			"outUseSSL",
			(BiConsumer<MBMailingList, Boolean>)MBMailingList::setOutUseSSL);
		attributeGetterFunctions.put(
			"outUserName", MBMailingList::getOutUserName);
		attributeSetterBiConsumers.put(
			"outUserName",
			(BiConsumer<MBMailingList, String>)MBMailingList::setOutUserName);
		attributeGetterFunctions.put(
			"outPassword", MBMailingList::getOutPassword);
		attributeSetterBiConsumers.put(
			"outPassword",
			(BiConsumer<MBMailingList, String>)MBMailingList::setOutPassword);
		attributeGetterFunctions.put(
			"allowAnonymous", MBMailingList::getAllowAnonymous);
		attributeSetterBiConsumers.put(
			"allowAnonymous",
			(BiConsumer<MBMailingList, Boolean>)
				MBMailingList::setAllowAnonymous);
		attributeGetterFunctions.put("active", MBMailingList::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<MBMailingList, Boolean>)MBMailingList::setActive);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getMailingListId() {
		return _mailingListId;
	}

	@Override
	public void setMailingListId(long mailingListId) {
		_mailingListId = mailingListId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
	}

	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return "";
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@Override
	public String getInProtocol() {
		if (_inProtocol == null) {
			return "";
		}
		else {
			return _inProtocol;
		}
	}

	@Override
	public void setInProtocol(String inProtocol) {
		_inProtocol = inProtocol;
	}

	@Override
	public String getInServerName() {
		if (_inServerName == null) {
			return "";
		}
		else {
			return _inServerName;
		}
	}

	@Override
	public void setInServerName(String inServerName) {
		_inServerName = inServerName;
	}

	@Override
	public int getInServerPort() {
		return _inServerPort;
	}

	@Override
	public void setInServerPort(int inServerPort) {
		_inServerPort = inServerPort;
	}

	@Override
	public boolean getInUseSSL() {
		return _inUseSSL;
	}

	@Override
	public boolean isInUseSSL() {
		return _inUseSSL;
	}

	@Override
	public void setInUseSSL(boolean inUseSSL) {
		_inUseSSL = inUseSSL;
	}

	@Override
	public String getInUserName() {
		if (_inUserName == null) {
			return "";
		}
		else {
			return _inUserName;
		}
	}

	@Override
	public void setInUserName(String inUserName) {
		_inUserName = inUserName;
	}

	@Override
	public String getInPassword() {
		if (_inPassword == null) {
			return "";
		}
		else {
			return _inPassword;
		}
	}

	@Override
	public void setInPassword(String inPassword) {
		_inPassword = inPassword;
	}

	@Override
	public int getInReadInterval() {
		return _inReadInterval;
	}

	@Override
	public void setInReadInterval(int inReadInterval) {
		_inReadInterval = inReadInterval;
	}

	@Override
	public String getOutEmailAddress() {
		if (_outEmailAddress == null) {
			return "";
		}
		else {
			return _outEmailAddress;
		}
	}

	@Override
	public void setOutEmailAddress(String outEmailAddress) {
		_outEmailAddress = outEmailAddress;
	}

	@Override
	public boolean getOutCustom() {
		return _outCustom;
	}

	@Override
	public boolean isOutCustom() {
		return _outCustom;
	}

	@Override
	public void setOutCustom(boolean outCustom) {
		_outCustom = outCustom;
	}

	@Override
	public String getOutServerName() {
		if (_outServerName == null) {
			return "";
		}
		else {
			return _outServerName;
		}
	}

	@Override
	public void setOutServerName(String outServerName) {
		_outServerName = outServerName;
	}

	@Override
	public int getOutServerPort() {
		return _outServerPort;
	}

	@Override
	public void setOutServerPort(int outServerPort) {
		_outServerPort = outServerPort;
	}

	@Override
	public boolean getOutUseSSL() {
		return _outUseSSL;
	}

	@Override
	public boolean isOutUseSSL() {
		return _outUseSSL;
	}

	@Override
	public void setOutUseSSL(boolean outUseSSL) {
		_outUseSSL = outUseSSL;
	}

	@Override
	public String getOutUserName() {
		if (_outUserName == null) {
			return "";
		}
		else {
			return _outUserName;
		}
	}

	@Override
	public void setOutUserName(String outUserName) {
		_outUserName = outUserName;
	}

	@Override
	public String getOutPassword() {
		if (_outPassword == null) {
			return "";
		}
		else {
			return _outPassword;
		}
	}

	@Override
	public void setOutPassword(String outPassword) {
		_outPassword = outPassword;
	}

	@Override
	public boolean getAllowAnonymous() {
		return _allowAnonymous;
	}

	@Override
	public boolean isAllowAnonymous() {
		return _allowAnonymous;
	}

	@Override
	public void setAllowAnonymous(boolean allowAnonymous) {
		_allowAnonymous = allowAnonymous;
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(MBMailingList.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), MBMailingList.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MBMailingList toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MBMailingList)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MBMailingListImpl mbMailingListImpl = new MBMailingListImpl();

		mbMailingListImpl.setUuid(getUuid());
		mbMailingListImpl.setMailingListId(getMailingListId());
		mbMailingListImpl.setGroupId(getGroupId());
		mbMailingListImpl.setCompanyId(getCompanyId());
		mbMailingListImpl.setUserId(getUserId());
		mbMailingListImpl.setUserName(getUserName());
		mbMailingListImpl.setCreateDate(getCreateDate());
		mbMailingListImpl.setModifiedDate(getModifiedDate());
		mbMailingListImpl.setCategoryId(getCategoryId());
		mbMailingListImpl.setEmailAddress(getEmailAddress());
		mbMailingListImpl.setInProtocol(getInProtocol());
		mbMailingListImpl.setInServerName(getInServerName());
		mbMailingListImpl.setInServerPort(getInServerPort());
		mbMailingListImpl.setInUseSSL(isInUseSSL());
		mbMailingListImpl.setInUserName(getInUserName());
		mbMailingListImpl.setInPassword(getInPassword());
		mbMailingListImpl.setInReadInterval(getInReadInterval());
		mbMailingListImpl.setOutEmailAddress(getOutEmailAddress());
		mbMailingListImpl.setOutCustom(isOutCustom());
		mbMailingListImpl.setOutServerName(getOutServerName());
		mbMailingListImpl.setOutServerPort(getOutServerPort());
		mbMailingListImpl.setOutUseSSL(isOutUseSSL());
		mbMailingListImpl.setOutUserName(getOutUserName());
		mbMailingListImpl.setOutPassword(getOutPassword());
		mbMailingListImpl.setAllowAnonymous(isAllowAnonymous());
		mbMailingListImpl.setActive(isActive());

		mbMailingListImpl.resetOriginalValues();

		return mbMailingListImpl;
	}

	@Override
	public int compareTo(MBMailingList mbMailingList) {
		long primaryKey = mbMailingList.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MBMailingList)) {
			return false;
		}

		MBMailingList mbMailingList = (MBMailingList)obj;

		long primaryKey = mbMailingList.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		MBMailingListModelImpl mbMailingListModelImpl = this;

		mbMailingListModelImpl._originalUuid = mbMailingListModelImpl._uuid;

		mbMailingListModelImpl._originalGroupId =
			mbMailingListModelImpl._groupId;

		mbMailingListModelImpl._setOriginalGroupId = false;

		mbMailingListModelImpl._originalCompanyId =
			mbMailingListModelImpl._companyId;

		mbMailingListModelImpl._setOriginalCompanyId = false;

		mbMailingListModelImpl._setModifiedDate = false;

		mbMailingListModelImpl._originalCategoryId =
			mbMailingListModelImpl._categoryId;

		mbMailingListModelImpl._setOriginalCategoryId = false;

		mbMailingListModelImpl._originalActive = mbMailingListModelImpl._active;

		mbMailingListModelImpl._setOriginalActive = false;

		mbMailingListModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MBMailingList> toCacheModel() {
		MBMailingListCacheModel mbMailingListCacheModel =
			new MBMailingListCacheModel();

		mbMailingListCacheModel.uuid = getUuid();

		String uuid = mbMailingListCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			mbMailingListCacheModel.uuid = null;
		}

		mbMailingListCacheModel.mailingListId = getMailingListId();

		mbMailingListCacheModel.groupId = getGroupId();

		mbMailingListCacheModel.companyId = getCompanyId();

		mbMailingListCacheModel.userId = getUserId();

		mbMailingListCacheModel.userName = getUserName();

		String userName = mbMailingListCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			mbMailingListCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			mbMailingListCacheModel.createDate = createDate.getTime();
		}
		else {
			mbMailingListCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			mbMailingListCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			mbMailingListCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		mbMailingListCacheModel.categoryId = getCategoryId();

		mbMailingListCacheModel.emailAddress = getEmailAddress();

		String emailAddress = mbMailingListCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			mbMailingListCacheModel.emailAddress = null;
		}

		mbMailingListCacheModel.inProtocol = getInProtocol();

		String inProtocol = mbMailingListCacheModel.inProtocol;

		if ((inProtocol != null) && (inProtocol.length() == 0)) {
			mbMailingListCacheModel.inProtocol = null;
		}

		mbMailingListCacheModel.inServerName = getInServerName();

		String inServerName = mbMailingListCacheModel.inServerName;

		if ((inServerName != null) && (inServerName.length() == 0)) {
			mbMailingListCacheModel.inServerName = null;
		}

		mbMailingListCacheModel.inServerPort = getInServerPort();

		mbMailingListCacheModel.inUseSSL = isInUseSSL();

		mbMailingListCacheModel.inUserName = getInUserName();

		String inUserName = mbMailingListCacheModel.inUserName;

		if ((inUserName != null) && (inUserName.length() == 0)) {
			mbMailingListCacheModel.inUserName = null;
		}

		mbMailingListCacheModel.inPassword = getInPassword();

		String inPassword = mbMailingListCacheModel.inPassword;

		if ((inPassword != null) && (inPassword.length() == 0)) {
			mbMailingListCacheModel.inPassword = null;
		}

		mbMailingListCacheModel.inReadInterval = getInReadInterval();

		mbMailingListCacheModel.outEmailAddress = getOutEmailAddress();

		String outEmailAddress = mbMailingListCacheModel.outEmailAddress;

		if ((outEmailAddress != null) && (outEmailAddress.length() == 0)) {
			mbMailingListCacheModel.outEmailAddress = null;
		}

		mbMailingListCacheModel.outCustom = isOutCustom();

		mbMailingListCacheModel.outServerName = getOutServerName();

		String outServerName = mbMailingListCacheModel.outServerName;

		if ((outServerName != null) && (outServerName.length() == 0)) {
			mbMailingListCacheModel.outServerName = null;
		}

		mbMailingListCacheModel.outServerPort = getOutServerPort();

		mbMailingListCacheModel.outUseSSL = isOutUseSSL();

		mbMailingListCacheModel.outUserName = getOutUserName();

		String outUserName = mbMailingListCacheModel.outUserName;

		if ((outUserName != null) && (outUserName.length() == 0)) {
			mbMailingListCacheModel.outUserName = null;
		}

		mbMailingListCacheModel.outPassword = getOutPassword();

		String outPassword = mbMailingListCacheModel.outPassword;

		if ((outPassword != null) && (outPassword.length() == 0)) {
			mbMailingListCacheModel.outPassword = null;
		}

		mbMailingListCacheModel.allowAnonymous = isAllowAnonymous();

		mbMailingListCacheModel.active = isActive();

		return mbMailingListCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<MBMailingList, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<MBMailingList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MBMailingList, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((MBMailingList)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<MBMailingList, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<MBMailingList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MBMailingList, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((MBMailingList)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		MBMailingList.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		MBMailingList.class, ModelWrapper.class
	};

	private String _uuid;
	private String _originalUuid;
	private long _mailingListId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private String _emailAddress;
	private String _inProtocol;
	private String _inServerName;
	private int _inServerPort;
	private boolean _inUseSSL;
	private String _inUserName;
	private String _inPassword;
	private int _inReadInterval;
	private String _outEmailAddress;
	private boolean _outCustom;
	private String _outServerName;
	private int _outServerPort;
	private boolean _outUseSSL;
	private String _outUserName;
	private String _outPassword;
	private boolean _allowAnonymous;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private long _columnBitmask;
	private MBMailingList _escapedModel;

}