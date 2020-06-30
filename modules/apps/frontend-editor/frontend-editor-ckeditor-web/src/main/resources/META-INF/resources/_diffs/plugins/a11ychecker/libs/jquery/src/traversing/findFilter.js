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
	'../var/indexOf',
	'../var/isFunction',
	'./var/rneedsContext',
	'../selector',
], (jQuery, indexOf, isFunction, rneedsContext) => {
	'use strict';

	// Implement the identical functionality for filter and not

	function winnow(elements, qualifier, not) {
		if (isFunction(qualifier)) {
			return jQuery.grep(elements, (elem, i) => {
				return !!qualifier.call(elem, i, elem) !== not;
			});
		}

		// Single element

		if (qualifier.nodeType) {
			return jQuery.grep(elements, (elem) => {
				return (elem === qualifier) !== not;
			});
		}

		// Arraylike of elements (jQuery, arguments, Array)

		if (typeof qualifier !== 'string') {
			return jQuery.grep(elements, (elem) => {
				return indexOf.call(qualifier, elem) > -1 !== not;
			});
		}

		// Filtered directly for both simple and complex selectors

		return jQuery.filter(qualifier, elements, not);
	}

	jQuery.filter = function (expr, elems, not) {
		var elem = elems[0];

		if (not) {
			expr = ':not(' + expr + ')';
		}

		if (elems.length === 1 && elem.nodeType === 1) {
			return jQuery.find.matchesSelector(elem, expr) ? [elem] : [];
		}

		return jQuery.find.matches(
			expr,
			jQuery.grep(elems, (elem) => {
				return elem.nodeType === 1;
			})
		);
	};

	jQuery.fn.extend({
		find(selector) {
			var i,
				ret,
				len = this.length,
				self = this;

			if (typeof selector !== 'string') {
				return this.pushStack(
					jQuery(selector).filter(function () {
						for (i = 0; i < len; i++) {
							if (jQuery.contains(self[i], this)) {
								return true;
							}
						}
					})
				);
			}

			ret = this.pushStack([]);

			for (i = 0; i < len; i++) {
				jQuery.find(selector, self[i], ret);
			}

			return len > 1 ? jQuery.uniqueSort(ret) : ret;
		},
		filter(selector) {
			return this.pushStack(winnow(this, selector || [], false));
		},
		not(selector) {
			return this.pushStack(winnow(this, selector || [], true));
		},
		is(selector) {
			return !!winnow(
				this,

				// If this is a positional/relative selector, check membership in the returned set
				// so $("p:first").is("p:last") won't return true for a doc with two "p".

				typeof selector === 'string' && rneedsContext.test(selector)
					? jQuery(selector)
					: selector || [],
				false
			).length;
		},
	});
});
