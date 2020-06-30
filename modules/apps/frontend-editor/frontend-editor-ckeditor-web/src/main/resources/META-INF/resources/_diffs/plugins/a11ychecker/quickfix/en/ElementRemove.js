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
 * @license Copyright (c) 2014-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or https://ckeditor.com/license
 */

(function () {
	'use strict';

	CKEDITOR.plugins.a11ychecker.quickFixes.get({
		langCode: 'en',
		name: 'QuickFix',
		callback(QuickFix) {

			/**
			 * The ultimate fix for unsolvable problem - removing an element.
			 *
			 * @member CKEDITOR.plugins.a11ychecker.quickFix
			 * @class ElementRemove
			 * @constructor
			 * @param {CKEDITOR.plugins.a11ychecker.Issue} issue
			 */
			function ElementRemove(issue) {
				QuickFix.call(this, issue);
			}

			ElementRemove.prototype = new QuickFix();
			ElementRemove.prototype.constructor = ElementRemove;

			ElementRemove.prototype.display = function (form) {
				form.setInputs({});
			};

			ElementRemove.prototype.fix = function (formAttributes, callback) {
				this.issue.element.remove();

				if (callback) {
					callback(this);
				}
			};

			ElementRemove.prototype.lang = {};
			CKEDITOR.plugins.a11ychecker.quickFixes.add(
				'en/ElementRemove',
				ElementRemove
			);
		},
	});
})();
