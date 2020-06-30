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
	'../data/var/dataPriv',
	'./support',

	'../event',
	'./trigger',
], (jQuery, dataPriv, support) => {
	'use strict';

	// Support: Firefox <=44
	// Firefox doesn't have focus(in | out) events
	// Related ticket - https://bugzilla.mozilla.org/show_bug.cgi?id=687787
	//
	// Support: Chrome <=48 - 49, Safari <=9.0 - 9.1
	// focus(in | out) events fire after focus & blur events,
	// which is spec violation - http://www.w3.org/TR/DOM-Level-3-Events/#events-focusevent-event-order
	// Related ticket - https://bugs.chromium.org/p/chromium/issues/detail?id=449857

	if (!support.focusin) {
		jQuery.each({focus: 'focusin', blur: 'focusout'}, (orig, fix) => {

			// Attach a single capturing handler on the document while someone wants focusin/focusout

			var handler = function (event) {
				jQuery.event.simulate(
					fix,
					event.target,
					jQuery.event.fix(event)
				);
			};

			jQuery.event.special[fix] = {
				setup() {

					// Handle: regular nodes (via `this.ownerDocument`), window
					// (via `this.document`) & document (via `this`).

					var doc = this.ownerDocument || this.document || this,
						attaches = dataPriv.access(doc, fix);

					if (!attaches) {
						doc.addEventListener(orig, handler, true);
					}
					dataPriv.access(doc, fix, (attaches || 0) + 1);
				},
				teardown() {
					var doc = this.ownerDocument || this.document || this,
						attaches = dataPriv.access(doc, fix) - 1;

					if (!attaches) {
						doc.removeEventListener(orig, handler, true);
						dataPriv.remove(doc, fix);
					}
					else {
						dataPriv.access(doc, fix, attaches);
					}
				},
			};
		});
	}

	return jQuery;
});
