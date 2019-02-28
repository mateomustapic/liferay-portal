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

package com.liferay.polls.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.polls.model.PollsVote;
import com.liferay.polls.model.PollsVoteModel;
import com.liferay.polls.model.PollsVoteSoap;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
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
 * The base model implementation for the PollsVote service. Represents a row in the &quot;PollsVote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>PollsVoteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PollsVoteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PollsVoteImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class PollsVoteModelImpl
	extends BaseModelImpl<PollsVote> implements PollsVoteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a polls vote model instance should use the <code>PollsVote</code> interface instead.
	 */
	public static final String TABLE_NAME = "PollsVote";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"voteId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"questionId", Types.BIGINT}, {"choiceId", Types.BIGINT},
		{"lastPublishDate", Types.TIMESTAMP}, {"voteDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("voteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("questionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("choiceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("voteDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PollsVote (uuid_ VARCHAR(75) null,voteId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,questionId LONG,choiceId LONG,lastPublishDate DATE null,voteDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table PollsVote";

	public static final String ORDER_BY_JPQL = " ORDER BY pollsVote.voteId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY PollsVote.voteId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.polls.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.polls.model.PollsVote"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.polls.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.polls.model.PollsVote"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.polls.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.polls.model.PollsVote"),
		true);

	public static final long CHOICEID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long QUESTIONID_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long UUID_COLUMN_BITMASK = 32L;

	public static final long VOTEID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PollsVote toModel(PollsVoteSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PollsVote model = new PollsVoteImpl();

		model.setUuid(soapModel.getUuid());
		model.setVoteId(soapModel.getVoteId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setQuestionId(soapModel.getQuestionId());
		model.setChoiceId(soapModel.getChoiceId());
		model.setLastPublishDate(soapModel.getLastPublishDate());
		model.setVoteDate(soapModel.getVoteDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PollsVote> toModels(PollsVoteSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PollsVote> models = new ArrayList<PollsVote>(soapModels.length);

		for (PollsVoteSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.polls.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.polls.model.PollsVote"));

	public PollsVoteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _voteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVoteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _voteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PollsVote.class;
	}

	@Override
	public String getModelClassName() {
		return PollsVote.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PollsVote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PollsVote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PollsVote, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((PollsVote)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PollsVote, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PollsVote, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PollsVote)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PollsVote, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PollsVote, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<PollsVote, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PollsVote, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PollsVote, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<PollsVote, Object>>();
		Map<String, BiConsumer<PollsVote, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<PollsVote, ?>>();

		attributeGetterFunctions.put("uuid", PollsVote::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<PollsVote, String>)PollsVote::setUuid);
		attributeGetterFunctions.put("voteId", PollsVote::getVoteId);
		attributeSetterBiConsumers.put(
			"voteId", (BiConsumer<PollsVote, Long>)PollsVote::setVoteId);
		attributeGetterFunctions.put("groupId", PollsVote::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<PollsVote, Long>)PollsVote::setGroupId);
		attributeGetterFunctions.put("companyId", PollsVote::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<PollsVote, Long>)PollsVote::setCompanyId);
		attributeGetterFunctions.put("userId", PollsVote::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<PollsVote, Long>)PollsVote::setUserId);
		attributeGetterFunctions.put("userName", PollsVote::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<PollsVote, String>)PollsVote::setUserName);
		attributeGetterFunctions.put("createDate", PollsVote::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<PollsVote, Date>)PollsVote::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", PollsVote::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<PollsVote, Date>)PollsVote::setModifiedDate);
		attributeGetterFunctions.put("questionId", PollsVote::getQuestionId);
		attributeSetterBiConsumers.put(
			"questionId",
			(BiConsumer<PollsVote, Long>)PollsVote::setQuestionId);
		attributeGetterFunctions.put("choiceId", PollsVote::getChoiceId);
		attributeSetterBiConsumers.put(
			"choiceId", (BiConsumer<PollsVote, Long>)PollsVote::setChoiceId);
		attributeGetterFunctions.put(
			"lastPublishDate", PollsVote::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<PollsVote, Date>)PollsVote::setLastPublishDate);
		attributeGetterFunctions.put("voteDate", PollsVote::getVoteDate);
		attributeSetterBiConsumers.put(
			"voteDate", (BiConsumer<PollsVote, Date>)PollsVote::setVoteDate);

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
	public long getVoteId() {
		return _voteId;
	}

	@Override
	public void setVoteId(long voteId) {
		_voteId = voteId;
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
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
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
	public long getQuestionId() {
		return _questionId;
	}

	@Override
	public void setQuestionId(long questionId) {
		_columnBitmask |= QUESTIONID_COLUMN_BITMASK;

		if (!_setOriginalQuestionId) {
			_setOriginalQuestionId = true;

			_originalQuestionId = _questionId;
		}

		_questionId = questionId;
	}

	public long getOriginalQuestionId() {
		return _originalQuestionId;
	}

	@JSON
	@Override
	public long getChoiceId() {
		return _choiceId;
	}

	@Override
	public void setChoiceId(long choiceId) {
		_columnBitmask |= CHOICEID_COLUMN_BITMASK;

		if (!_setOriginalChoiceId) {
			_setOriginalChoiceId = true;

			_originalChoiceId = _choiceId;
		}

		_choiceId = choiceId;
	}

	public long getOriginalChoiceId() {
		return _originalChoiceId;
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
	public Date getVoteDate() {
		return _voteDate;
	}

	@Override
	public void setVoteDate(Date voteDate) {
		_voteDate = voteDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(PollsVote.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), PollsVote.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PollsVote toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PollsVote)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PollsVoteImpl pollsVoteImpl = new PollsVoteImpl();

		pollsVoteImpl.setUuid(getUuid());
		pollsVoteImpl.setVoteId(getVoteId());
		pollsVoteImpl.setGroupId(getGroupId());
		pollsVoteImpl.setCompanyId(getCompanyId());
		pollsVoteImpl.setUserId(getUserId());
		pollsVoteImpl.setUserName(getUserName());
		pollsVoteImpl.setCreateDate(getCreateDate());
		pollsVoteImpl.setModifiedDate(getModifiedDate());
		pollsVoteImpl.setQuestionId(getQuestionId());
		pollsVoteImpl.setChoiceId(getChoiceId());
		pollsVoteImpl.setLastPublishDate(getLastPublishDate());
		pollsVoteImpl.setVoteDate(getVoteDate());

		pollsVoteImpl.resetOriginalValues();

		return pollsVoteImpl;
	}

	@Override
	public int compareTo(PollsVote pollsVote) {
		long primaryKey = pollsVote.getPrimaryKey();

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

		if (!(obj instanceof PollsVote)) {
			return false;
		}

		PollsVote pollsVote = (PollsVote)obj;

		long primaryKey = pollsVote.getPrimaryKey();

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
		PollsVoteModelImpl pollsVoteModelImpl = this;

		pollsVoteModelImpl._originalUuid = pollsVoteModelImpl._uuid;

		pollsVoteModelImpl._originalGroupId = pollsVoteModelImpl._groupId;

		pollsVoteModelImpl._setOriginalGroupId = false;

		pollsVoteModelImpl._originalCompanyId = pollsVoteModelImpl._companyId;

		pollsVoteModelImpl._setOriginalCompanyId = false;

		pollsVoteModelImpl._originalUserId = pollsVoteModelImpl._userId;

		pollsVoteModelImpl._setOriginalUserId = false;

		pollsVoteModelImpl._setModifiedDate = false;

		pollsVoteModelImpl._originalQuestionId = pollsVoteModelImpl._questionId;

		pollsVoteModelImpl._setOriginalQuestionId = false;

		pollsVoteModelImpl._originalChoiceId = pollsVoteModelImpl._choiceId;

		pollsVoteModelImpl._setOriginalChoiceId = false;

		pollsVoteModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PollsVote> toCacheModel() {
		PollsVoteCacheModel pollsVoteCacheModel = new PollsVoteCacheModel();

		pollsVoteCacheModel.uuid = getUuid();

		String uuid = pollsVoteCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			pollsVoteCacheModel.uuid = null;
		}

		pollsVoteCacheModel.voteId = getVoteId();

		pollsVoteCacheModel.groupId = getGroupId();

		pollsVoteCacheModel.companyId = getCompanyId();

		pollsVoteCacheModel.userId = getUserId();

		pollsVoteCacheModel.userName = getUserName();

		String userName = pollsVoteCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			pollsVoteCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			pollsVoteCacheModel.createDate = createDate.getTime();
		}
		else {
			pollsVoteCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			pollsVoteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			pollsVoteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		pollsVoteCacheModel.questionId = getQuestionId();

		pollsVoteCacheModel.choiceId = getChoiceId();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			pollsVoteCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			pollsVoteCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		Date voteDate = getVoteDate();

		if (voteDate != null) {
			pollsVoteCacheModel.voteDate = voteDate.getTime();
		}
		else {
			pollsVoteCacheModel.voteDate = Long.MIN_VALUE;
		}

		return pollsVoteCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PollsVote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PollsVote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PollsVote, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PollsVote)this));
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
		Map<String, Function<PollsVote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PollsVote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PollsVote, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PollsVote)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		PollsVote.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		PollsVote.class, ModelWrapper.class
	};

	private String _uuid;
	private String _originalUuid;
	private long _voteId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _questionId;
	private long _originalQuestionId;
	private boolean _setOriginalQuestionId;
	private long _choiceId;
	private long _originalChoiceId;
	private boolean _setOriginalChoiceId;
	private Date _lastPublishDate;
	private Date _voteDate;
	private long _columnBitmask;
	private PollsVote _escapedModel;

}