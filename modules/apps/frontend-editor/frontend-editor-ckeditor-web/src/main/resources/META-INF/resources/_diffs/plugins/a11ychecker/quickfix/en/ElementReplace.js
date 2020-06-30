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
			 * Replaces provided element with element that a different tag name, preserving its children.
			 *
			 * @member CKEDITOR.plugins.a11ychecker.quickFix
			 * @class ElementReplace
			 * @constructor
			 * @param {CKEDITOR.plugins.a11ychecker.Issue} issue
			 */
			function ElementReplace(issue) {
				QuickFix.call(this, issue);
			}

			ElementReplace.prototype = new QuickFix();
			ElementReplace.prototype.constructor = ElementReplace;

			/**
			 * Returns the name of the tag that issue.element should be converted to.
			 *
			 * @member CKEDITOR.plugins.a11ychecker.quickFix.ElementReplace
			 * @param {Object} formAttributes Form attributes from {@link #fix}.
			 * @returns {String}
			 */
			ElementReplace.prototype.getTargetName = function (formAttributes) {
				return 'h1';
			};

			ElementReplace.prototype.display = function (form) {
				form.setInputs({});
			};

			ElementReplace.prototype.fix = function (formAttributes, callback) {
				var newElement = new CKEDITOR.dom.element(
					this.getTargetName(formAttributes)
				);

				newElement.replace(this.issue.element);
				this.issue.element.moveChildren(newElement);

				this.issue.element = newElement;

				if (callback) {
					callback(this);
				}
			};

			ElementReplace.prototype.lang = {};
			CKEDITOR.plugins.a11ychecker.quickFixes.add(
				'en/ElementReplace',
				ElementReplace
			);
		},
	});
})();
