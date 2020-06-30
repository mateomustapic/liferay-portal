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
	'../core/isAttached',
	'./var/rboxStyle',
	'./var/rnumnonpx',
	'./var/getStyles',
	'./support',
], (jQuery, isAttached, rboxStyle, rnumnonpx, getStyles, support) => {
	'use strict';

	function curCSS(elem, name, computed) {
		var width,
			minWidth,
			maxWidth,
			ret,

			// Support: Firefox 51+
			// Retrieving style before computed somehow
			// fixes an issue with getting wrong values
			// on detached elements

			style = elem.style;

		computed = computed || getStyles(elem);

		// getPropertyValue is needed for:
		//   .css('filter') (IE 9 only, #12537)
		//   .css('--customProperty) (#3144)

		if (computed) {
			ret = computed.getPropertyValue(name) || computed[name];

			if (ret === '' && !isAttached(elem)) {
				ret = jQuery.style(elem, name);
			}

			// A tribute to the "awesome hack by Dean Edwards"
			// Android Browser returns percentage for some values,
			// but width seems to be reliably pixels.
			// This is against the CSSOM draft spec:
			// https://drafts.csswg.org/cssom/#resolved-values

			if (
				!support.pixelBoxStyles() &&
				rnumnonpx.test(ret) &&
				rboxStyle.test(name)
			) {

				// Remember the original values

				width = style.width;
				minWidth = style.minWidth;
				maxWidth = style.maxWidth;

				// Put in the new values to get a computed value out

				style.minWidth = style.maxWidth = style.width = ret;
				ret = computed.width;

				// Revert the changed values

				style.width = width;
				style.minWidth = minWidth;
				style.maxWidth = maxWidth;
			}
		}

		return ret !== undefined
			? // Support: IE <=9 - 11 only
			  // IE returns zIndex value as an integer.

			  ret + ''
			: ret;
	}

	return curCSS;
});
