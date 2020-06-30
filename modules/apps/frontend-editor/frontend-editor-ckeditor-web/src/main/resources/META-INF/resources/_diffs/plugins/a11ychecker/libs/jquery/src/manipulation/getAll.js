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

define(['../core', '../core/nodeName'], (jQuery, nodeName) => {
	'use strict';

	function getAll(context, tag) {

		// Support: IE <=9 - 11 only
		// Use typeof to avoid zero-argument method invocation on host objects (#15151)

		var ret;

		if (typeof context.getElementsByTagName !== 'undefined') {
			ret = context.getElementsByTagName(tag || '*');
		}
		else if (typeof context.querySelectorAll !== 'undefined') {
			ret = context.querySelectorAll(tag || '*');
		}
		else {
			ret = [];
		}

		if (tag === undefined || (tag && nodeName(context, tag))) {
			return jQuery.merge([context], ret);
		}

		return ret;
	}

	return getAll;
});
