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

define(['../ajax'], (jQuery) => {
	'use strict';

	jQuery._evalUrl = function (url, options, doc) {
		return jQuery.ajax({
			url,

			// Make this explicit, since user can override this through ajaxSetup (#11264)

			type: 'GET',
			dataType: 'script',
			cache: true,
			async: false,
			global: false,

			// Only evaluate the response if it is successful (gh-4126)
			// dataFilter is not invoked for failure responses, so using it instead
			// of the default converter is kludgy but it works.

			converters: {
				'text script'() {},
			},
			dataFilter(response) {
				jQuery.globalEval(response, options, doc);
			},
		});
	};

	return jQuery._evalUrl;
});
