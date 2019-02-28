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

package com.liferay.wiki.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ContainerModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.model.WikiNodeModel;
import com.liferay.wiki.model.WikiNodeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the WikiNode service. Represents a row in the &quot;WikiNode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>WikiNodeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WikiNodeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiNodeImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class WikiNodeModelImpl
	extends BaseModelImpl<WikiNode> implements WikiNodeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wiki node model instance should use the <code>WikiNode</code> interface instead.
	 */
	public static final String TABLE_NAME = "WikiNode";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"nodeId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"lastPostDate", Types.TIMESTAMP}, {"lastPublishDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nodeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastPostDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table WikiNode (uuid_ VARCHAR(75) null,nodeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description STRING null,lastPostDate DATE null,lastPublishDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table WikiNode";

	public static final String ORDER_BY_JPQL = " ORDER BY wikiNode.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY WikiNode.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.wiki.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.wiki.model.WikiNode"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.wiki.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.wiki.model.WikiNode"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.wiki.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.wiki.model.WikiNode"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NAME_COLUMN_BITMASK = 4L;

	public static final long STATUS_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WikiNode toModel(WikiNodeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		WikiNode model = new WikiNodeImpl();

		model.setUuid(soapModel.getUuid());
		model.setNodeId(soapModel.getNodeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setLastPostDate(soapModel.getLastPostDate());
		model.setLastPublishDate(soapModel.getLastPublishDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WikiNode> toModels(WikiNodeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<WikiNode> models = new ArrayList<WikiNode>(soapModels.length);

		for (WikiNodeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.wiki.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.wiki.model.WikiNode"));

	public WikiNodeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _nodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _nodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WikiNode.class;
	}

	@Override
	public String getModelClassName() {
		return WikiNode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<WikiNode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<WikiNode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WikiNode, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((WikiNode)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<WikiNode, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<WikiNode, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(WikiNode)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<WikiNode, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<WikiNode, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<WikiNode, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<WikiNode, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<WikiNode, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<WikiNode, Object>>();
		Map<String, BiConsumer<WikiNode, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<WikiNode, ?>>();

		attributeGetterFunctions.put("uuid", WikiNode::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<WikiNode, String>)WikiNode::setUuid);
		attributeGetterFunctions.put("nodeId", WikiNode::getNodeId);
		attributeSetterBiConsumers.put(
			"nodeId", (BiConsumer<WikiNode, Long>)WikiNode::setNodeId);
		attributeGetterFunctions.put("groupId", WikiNode::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<WikiNode, Long>)WikiNode::setGroupId);
		attributeGetterFunctions.put("companyId", WikiNode::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<WikiNode, Long>)WikiNode::setCompanyId);
		attributeGetterFunctions.put("userId", WikiNode::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<WikiNode, Long>)WikiNode::setUserId);
		attributeGetterFunctions.put("userName", WikiNode::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<WikiNode, String>)WikiNode::setUserName);
		attributeGetterFunctions.put("createDate", WikiNode::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<WikiNode, Date>)WikiNode::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", WikiNode::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<WikiNode, Date>)WikiNode::setModifiedDate);
		attributeGetterFunctions.put("name", WikiNode::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<WikiNode, String>)WikiNode::setName);
		attributeGetterFunctions.put("description", WikiNode::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<WikiNode, String>)WikiNode::setDescription);
		attributeGetterFunctions.put("lastPostDate", WikiNode::getLastPostDate);
		attributeSetterBiConsumers.put(
			"lastPostDate",
			(BiConsumer<WikiNode, Date>)WikiNode::setLastPostDate);
		attributeGetterFunctions.put(
			"lastPublishDate", WikiNode::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<WikiNode, Date>)WikiNode::setLastPublishDate);
		attributeGetterFunctions.put("status", WikiNode::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<WikiNode, Integer>)WikiNode::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", WikiNode::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<WikiNode, Long>)WikiNode::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", WikiNode::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<WikiNode, String>)WikiNode::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", WikiNode::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate", (BiConsumer<WikiNode, Date>)WikiNode::setStatusDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
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

	@JSON
	@Override
	public long getNodeId() {
		return _nodeId;
	}

	@Override
	public void setNodeId(long nodeId) {
		_nodeId = nodeId;
	}

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
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

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public Date getLastPostDate() {
		return _lastPostDate;
	}

	@Override
	public void setLastPostDate(Date lastPostDate) {
		_lastPostDate = lastPostDate;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public long getContainerModelId() {
		return getNodeId();
	}

	@Override
	public void setContainerModelId(long containerModelId) {
		_nodeId = containerModelId;
	}

	@Override
	public String getContainerModelName() {
		return String.valueOf(getName());
	}

	@Override
	public long getParentContainerModelId() {
		return 0;
	}

	@Override
	public void setParentContainerModelId(long parentContainerModelId) {
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(WikiNode.class.getName()));
	}

	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException {

		if (!isInTrash()) {
			return null;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return trashEntry;
		}

		com.liferay.portal.kernel.trash.TrashHandler trashHandler =
			getTrashHandler();

		if (Validator.isNotNull(
				trashHandler.getContainerModelClassName(getPrimaryKey()))) {

			ContainerModel containerModel = null;

			try {
				containerModel = trashHandler.getParentContainerModel(this);
			}
			catch (NoSuchModelException nsme) {
				return null;
			}

			while (containerModel != null) {
				if (containerModel instanceof TrashedModel) {
					TrashedModel trashedModel = (TrashedModel)containerModel;

					return trashedModel.getTrashEntry();
				}

				trashHandler =
					com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.
						getTrashHandler(
							trashHandler.getContainerModelClassName(
								containerModel.getContainerModelId()));

				if (trashHandler == null) {
					return null;
				}

				containerModel = trashHandler.getContainerModel(
					containerModel.getParentContainerModelId());
			}
		}

		return null;
	}

	@Override
	public long getTrashEntryClassPK() {
		return getPrimaryKey();
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.
			getTrashHandler(getModelClassName());
	}

	@Override
	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInTrashContainer() {
		com.liferay.portal.kernel.trash.TrashHandler trashHandler =
			getTrashHandler();

		if ((trashHandler == null) ||
			Validator.isNull(
				trashHandler.getContainerModelClassName(getPrimaryKey()))) {

			return false;
		}

		try {
			ContainerModel containerModel =
				trashHandler.getParentContainerModel(this);

			if (containerModel == null) {
				return false;
			}

			if (containerModel instanceof TrashedModel) {
				return ((TrashedModel)containerModel).isInTrash();
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	@Override
	public boolean isInTrashExplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isInTrashImplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), WikiNode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WikiNode toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WikiNode)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WikiNodeImpl wikiNodeImpl = new WikiNodeImpl();

		wikiNodeImpl.setUuid(getUuid());
		wikiNodeImpl.setNodeId(getNodeId());
		wikiNodeImpl.setGroupId(getGroupId());
		wikiNodeImpl.setCompanyId(getCompanyId());
		wikiNodeImpl.setUserId(getUserId());
		wikiNodeImpl.setUserName(getUserName());
		wikiNodeImpl.setCreateDate(getCreateDate());
		wikiNodeImpl.setModifiedDate(getModifiedDate());
		wikiNodeImpl.setName(getName());
		wikiNodeImpl.setDescription(getDescription());
		wikiNodeImpl.setLastPostDate(getLastPostDate());
		wikiNodeImpl.setLastPublishDate(getLastPublishDate());
		wikiNodeImpl.setStatus(getStatus());
		wikiNodeImpl.setStatusByUserId(getStatusByUserId());
		wikiNodeImpl.setStatusByUserName(getStatusByUserName());
		wikiNodeImpl.setStatusDate(getStatusDate());

		wikiNodeImpl.resetOriginalValues();

		return wikiNodeImpl;
	}

	@Override
	public int compareTo(WikiNode wikiNode) {
		int value = 0;

		value = getName().compareToIgnoreCase(wikiNode.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WikiNode)) {
			return false;
		}

		WikiNode wikiNode = (WikiNode)obj;

		long primaryKey = wikiNode.getPrimaryKey();

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
		WikiNodeModelImpl wikiNodeModelImpl = this;

		wikiNodeModelImpl._originalUuid = wikiNodeModelImpl._uuid;

		wikiNodeModelImpl._originalGroupId = wikiNodeModelImpl._groupId;

		wikiNodeModelImpl._setOriginalGroupId = false;

		wikiNodeModelImpl._originalCompanyId = wikiNodeModelImpl._companyId;

		wikiNodeModelImpl._setOriginalCompanyId = false;

		wikiNodeModelImpl._setModifiedDate = false;

		wikiNodeModelImpl._originalName = wikiNodeModelImpl._name;

		wikiNodeModelImpl._originalStatus = wikiNodeModelImpl._status;

		wikiNodeModelImpl._setOriginalStatus = false;

		wikiNodeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WikiNode> toCacheModel() {
		WikiNodeCacheModel wikiNodeCacheModel = new WikiNodeCacheModel();

		wikiNodeCacheModel.uuid = getUuid();

		String uuid = wikiNodeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			wikiNodeCacheModel.uuid = null;
		}

		wikiNodeCacheModel.nodeId = getNodeId();

		wikiNodeCacheModel.groupId = getGroupId();

		wikiNodeCacheModel.companyId = getCompanyId();

		wikiNodeCacheModel.userId = getUserId();

		wikiNodeCacheModel.userName = getUserName();

		String userName = wikiNodeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			wikiNodeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			wikiNodeCacheModel.createDate = createDate.getTime();
		}
		else {
			wikiNodeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			wikiNodeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			wikiNodeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		wikiNodeCacheModel.name = getName();

		String name = wikiNodeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			wikiNodeCacheModel.name = null;
		}

		wikiNodeCacheModel.description = getDescription();

		String description = wikiNodeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			wikiNodeCacheModel.description = null;
		}

		Date lastPostDate = getLastPostDate();

		if (lastPostDate != null) {
			wikiNodeCacheModel.lastPostDate = lastPostDate.getTime();
		}
		else {
			wikiNodeCacheModel.lastPostDate = Long.MIN_VALUE;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			wikiNodeCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			wikiNodeCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		wikiNodeCacheModel.status = getStatus();

		wikiNodeCacheModel.statusByUserId = getStatusByUserId();

		wikiNodeCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = wikiNodeCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			wikiNodeCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			wikiNodeCacheModel.statusDate = statusDate.getTime();
		}
		else {
			wikiNodeCacheModel.statusDate = Long.MIN_VALUE;
		}

		return wikiNodeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<WikiNode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<WikiNode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WikiNode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((WikiNode)this));
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
		Map<String, Function<WikiNode, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<WikiNode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<WikiNode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((WikiNode)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		WikiNode.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		WikiNode.class, ModelWrapper.class
	};

	private String _uuid;
	private String _originalUuid;
	private long _nodeId;
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
	private String _name;
	private String _originalName;
	private String _description;
	private Date _lastPostDate;
	private Date _lastPublishDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private WikiNode _escapedModel;

}