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
	'../core/stripAndCollapse',
	'../var/isFunction',
	'../core/parseHTML',
	'../ajax',
	'../traversing',
	'../manipulation',
	'../selector',
], (jQuery, stripAndCollapse, isFunction) => {
	'use strict';

	/**
	 * Load a url into a page
	 */
	jQuery.fn.load = function (url, params, callback) {
		var selector,
			type,
			response,
			self = this,
			off = url.indexOf(' ');

		if (off > -1) {
			selector = stripAndCollapse(url.slice(off));
			url = url.slice(0, off);
		}

		// If it's a function

		if (isFunction(params)) {

			// We assume that it's the callback

			callback = params;
			params = undefined;

			// Otherwise, build a param string

		}
		else if (params && typeof params === 'object') {
			type = 'POST';
		}

		// If we have elements to modify, make the request

		if (self.length > 0) {
			jQuery
				.ajax({
					url,

					// If "type" variable is undefined, then "GET" method will be used.
					// Make value of this field explicit since
					// user can override it through ajaxSetup method

					type: type || 'GET',
					dataType: 'html',
					data: params,
				})
				.done(function (responseText) {

					// Save response for use in complete callback

					response = arguments;

					self.html(
						selector
							? // If a selector was specified, locate the right elements in a dummy div
							  // Exclude scripts to avoid IE 'Permission Denied' errors

							  jQuery('<div>')
									.append(jQuery.parseHTML(responseText))
									.find(selector)
							: // Otherwise use the full result

							  responseText
					);

					// If the request succeeds, this function gets "data", "status", "jqXHR"
					// but they are ignored because response was set above.
					// If it fails, this function gets "jqXHR", "status", "error"

				})
				.always(
					callback &&
						((jqXHR, status) => {
							self.each(function () {
								callback.apply(
									this,
									response || [
										jqXHR.responseText,
										status,
										jqXHR,
									]
								);
							});
						})
				);
		}

		return this;
	};
});
