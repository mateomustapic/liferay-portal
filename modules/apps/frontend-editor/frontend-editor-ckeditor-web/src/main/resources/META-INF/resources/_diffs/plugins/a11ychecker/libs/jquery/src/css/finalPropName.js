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

define(['../var/document', '../core'], (document, jQuery) => {
	'use strict';

	var cssPrefixes = ['Webkit', 'Moz', 'ms'],
		emptyStyle = document.createElement('div').style,
		vendorProps = {};

	// Return a vendor-prefixed property or undefined

	function vendorPropName(name) {

		// Check for vendor prefixed names

		var capName = name[0].toUpperCase() + name.slice(1),
			i = cssPrefixes.length;

		while (i--) {
			name = cssPrefixes[i] + capName;
			if (name in emptyStyle) {
				return name;
			}
		}
	}

	// Return a potentially-mapped jQuery.cssProps or vendor prefixed property

	function finalPropName(name) {
		var final = jQuery.cssProps[name] || vendorProps[name];

		if (final) {
			return final;
		}
		if (name in emptyStyle) {
			return name;
		}

		return (vendorProps[name] = vendorPropName(name) || name);
	}

	return finalPropName;
});
