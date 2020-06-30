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

define([
	'../core',
	'../var/documentElement',
	'../selector', // jQuery.contains
], (jQuery, documentElement) => {
	'use strict';

	var isAttached = function (elem) {
			return jQuery.contains(elem.ownerDocument, elem);
		},
		composed = {composed: true};

	// Support: IE 9 - 11+, Edge 12 - 18+, iOS 10.0 - 10.2 only
	// Check attachment across shadow DOM boundaries when possible (gh-3504)
	// Support: iOS 10.0-10.2 only
	// Early iOS 10 versions support `attachShadow` but not `getRootNode`,
	// leading to errors. We need to check for `getRootNode`.

	if (documentElement.getRootNode) {
		isAttached = function (elem) {
			return (
				jQuery.contains(elem.ownerDocument, elem) ||
				elem.getRootNode(composed) === elem.ownerDocument
			);
		};
	}

	return isAttached;
});
