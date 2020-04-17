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

/**
 * Appends given parameters to the given URL.
 * @param {String | Object} params Parameters to be added on to the base url
 * @param {String} baseUrl Base url
 * @return {String} finalUrl URL constructed from base url and params
 * @review
 */
export default function addParams(params, baseUrl) {
	if (typeof params !== 'object' && typeof params !== 'string') {
		throw new TypeError('Parameter params must be an object or string');
	}

	if (typeof baseUrl !== 'string') {
		throw new TypeError('Parameter baseUrl must be a string');
	}

	var url = new URL(baseUrl);

	if (params && typeof params === 'object') {
		const paramKeys = Object.entries(params);

		params = paramKeys.forEach((key, value) => {
			url.searchParams.append(value, key);
		})
	}
	else {
		params = params.trim();
		url.searchParams.append(params, params);
	}

	return url.toString();;
}
