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

define(['../var/document', '../var/support'], (document, support) => {
	'use strict';

	(function () {
		var fragment = document.createDocumentFragment(),
			div = fragment.appendChild(document.createElement('div')),
			input = document.createElement('input');

		// Support: Android 4.0 - 4.3 only
		// Check state lost if the name is set (#11217)
		// Support: Windows Web Apps (WWA)
		// `name` and `type` must use .setAttribute for WWA (#14901)

		input.setAttribute('type', 'radio');
		input.setAttribute('checked', 'checked');
		input.setAttribute('name', 't');

		div.appendChild(input);

		// Support: Android <=4.1 only
		// Older WebKit doesn't clone checked state correctly in fragments

		support.checkClone = div
			.cloneNode(true)
			.cloneNode(true).lastChild.checked;

		// Support: IE <=11 only
		// Make sure textarea (and checkbox) defaultValue is properly cloned

		div.innerHTML = '<textarea>x</textarea>';
		support.noCloneChecked = !!div.cloneNode(true).lastChild.defaultValue;

		// Support: IE <=9 only
		// IE <=9 replaces <option> tags with their contents when inserted outside of
		// the select element.

		div.innerHTML = '<option></option>';
		support.option = !!div.lastChild;
	})();

	return support;
});
