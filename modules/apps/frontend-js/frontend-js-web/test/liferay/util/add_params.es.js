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

'use strict';

import addParams from '../../../src/main/resources/META-INF/resources/liferay/util/add_params.es';

describe('Liferay.Util.addParams', () => {
	const sampleUrl = 'http://sampleurl.com';

	it('throws error if params is not an object or a string', () => {
		expect(() => addParams(0)).toThrow('must be an object or a string');
	});

	it('throws error if url parameter is not a string', () => {
		expect(() => addParams('foo=1', 0)).toThrow('must be a string');
	});

	it('appends key-value pairs of an object as parameters to the given URL', () => {
		expect(addParams({foo: 1, bar: 2}, sampleUrl)).toEqual(
			'http://sampleurl.com?foo=1&bar=2'
		);
	});

	it('appends a string with parameters to the given URL', () => {
		expect(addParams('   foo=1 ', sampleUrl)).toEqual(
			'http://sampleurl.com?foo=1'
		);
	});

	it('sets anchor hash after base url and parameters', () => {
		expect(addParams({foo: 1, bar: 2}, sampleUrl + '#anc')).toEqual(
			'http://sampleurl.com?foo=1&bar=2#anc'
		);
	});

	it('appends parameters to the given URL with existing parameters', () => {
		expect(addParams({foo: 1, bar: 2}, sampleUrl + '?abc=0&foo=4')).toEqual(
			'http://sampleurl.com?abc=0&foo=4&foo=1&bar=2'
		);
	});
});
