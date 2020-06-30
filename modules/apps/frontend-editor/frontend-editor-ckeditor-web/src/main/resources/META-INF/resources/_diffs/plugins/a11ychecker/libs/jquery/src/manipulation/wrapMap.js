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

define(['./support'], (support) => {
	'use strict';

	// We have to close these tags to support XHTML (#13200)

	var wrapMap = {

		// XHTML parsers do not magically insert elements in the
		// same way that tag soup parsers do. So we cannot shorten
		// this by omitting <tbody> or other required elements.

		thead: [1, '<table>', '</table>'],
		col: [2, '<table><colgroup>', '</colgroup></table>'],
		tr: [2, '<table><tbody>', '</tbody></table>'],
		td: [3, '<table><tbody><tr>', '</tr></tbody></table>'],

		_default: [0, '', ''],
	};

	wrapMap.tbody = wrapMap.tfoot = wrapMap.colgroup = wrapMap.caption =
		wrapMap.thead;
	wrapMap.th = wrapMap.td;

	// Support: IE <=9 only

	if (!support.option) {
		wrapMap.optgroup = wrapMap.option = [
			1,
			"<select multiple='multiple'>",
			'</select>',
		];
	}

	return wrapMap;
});
