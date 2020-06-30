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
		langCode: 'de',
		name: 'AttributeRename',
		callback(AttributeRename) {

			/**
			 * QuickFix renaming an attribute {@link #attributeName} to another name
			 * {@link #attributeTargetName} using a proposed default value
			 * based on the value of {@link #attributeTargetName}.
			 *
			 * @member CKEDITOR.plugins.a11ychecker.quickFix
			 * @class AttributeRenameDefault
			 * @constructor
			 * @param {CKEDITOR.plugins.a11ychecker.Issue} issue Issue QuickFix is created for.
			 */
			function AttributeRenameDefault(issue) {
				AttributeRename.call(this, issue);
			}

			AttributeRenameDefault.prototype = new AttributeRename();

			AttributeRenameDefault.prototype.constructor = AttributeRenameDefault;

			AttributeRenameDefault.prototype.getProposedValue = function () {
				var element = this.issue.element;

				return (
					element.getAttribute(this.attributeTargetName) ||
					element.getAttribute(this.attributeName) ||
					''
				);
			};

			AttributeRenameDefault.prototype.lang = {};
			CKEDITOR.plugins.a11ychecker.quickFixes.add(
				'de/AttributeRenameDefault',
				AttributeRenameDefault
			);
		},
	});
})();
