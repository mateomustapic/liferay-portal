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

define(['../core'], (jQuery) => {
	'use strict';

	// Cross-browser xml parsing

	jQuery.parseXML = function (data) {
		var xml;
		if (!data || typeof data !== 'string') {
			return null;
		}

		// Support: IE 9 - 11 only
		// IE throws on parseFromString with invalid input.

		try {
			xml = new window.DOMParser().parseFromString(data, 'text/xml');
		}
		catch (e) {
			xml = undefined;
		}

		if (!xml || xml.getElementsByTagName('parsererror').length) {
			jQuery.error('Invalid XML: ' + data);
		}

		return xml;
	};

	return jQuery.parseXML;
});
