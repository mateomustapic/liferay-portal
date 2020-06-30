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

define(['../core', '../var/document', '../ajax'], (jQuery, document) => {
	'use strict';

	// Prevent auto-execution of scripts when no explicit dataType was provided (See gh-2432)

	jQuery.ajaxPrefilter((s) => {
		if (s.crossDomain) {
			s.contents.script = false;
		}
	});

	// Install script dataType

	jQuery.ajaxSetup({
		accepts: {
			script:
				'text/javascript, application/javascript, ' +
				'application/ecmascript, application/x-ecmascript',
		},
		contents: {
			script: /\b(?:java|ecma)script\b/,
		},
		converters: {
			'text script'(text) {
				jQuery.globalEval(text);

				return text;
			},
		},
	});

	// Handle cache's special case and crossDomain

	jQuery.ajaxPrefilter('script', (s) => {
		if (s.cache === undefined) {
			s.cache = false;
		}
		if (s.crossDomain) {
			s.type = 'GET';
		}
	});

	// Bind script tag hack transport

	jQuery.ajaxTransport('script', (s) => {

		// This transport only deals with cross domain or forced-by-attrs requests

		if (s.crossDomain || s.scriptAttrs) {
			var script, callback;

			return {
				send(_, complete) {
					script = jQuery('<script>')
						.attr(s.scriptAttrs || {})
						.prop({charset: s.scriptCharset, src: s.url})
						.on(
							'load error',
							(callback = function (evt) {
								script.remove();
								callback = null;
								if (evt) {
									complete(
										evt.type === 'error' ? 404 : 200,
										evt.type
									);
								}
							})
						);

					// Use native DOM manipulation to avoid our domManip AJAX trickery

					document.head.appendChild(script[0]);
				},
				abort() {
					if (callback) {
						callback();
					}
				},
			};
		}
	});
});
