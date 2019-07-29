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
	const anchorHashSampleUrl = 'http://sampleurl.com#foo';
	const sampleUrl = 'http://sampleurl.com';
	const sampleUrlWithParams = 'http://sampleurl.com?param';

	it('throws error if params is not an object or string', () => {
		expect(() => addParams(0)).toThrow(
			'Parameter params must be an object or string'
		);
	});

	it('throws error if url parameter is not a string', () => {
		expect(() => addParams('foo', 0)).toThrow(
			'Parameter url must be a string'
		);
	});

	it('Adds the parameters to the portlet URL', () => {
		expect(addParams({foo: 'bar', bar: 'foo'}, sampleUrl)).toEqual(
			'http://sampleurl.com?foo=bar&bar=foo'
		);
	});

	it('Trims parameter if it has space before and adds it to base url', () => {
		expect(addParams('   foo', sampleUrl)).toEqual(
			'http://sampleurl.com?foo'
		);
	});

	it('Sets anchor hash after base url and parameters', () => {
		expect(
			addParams({foo: 'bar', bar: 'foo'}, anchorHashSampleUrl)
		).toEqual('http://sampleurl.com?foo=bar&bar=foo#foo');
	});

	it('Sets portlet url when base url has parameters', () => {
		expect(
			addParams({foo: 'bar', bar: 'foo'}, sampleUrlWithParams)
		).toEqual('http://sampleurl.com?param&foo=bar&bar=foo');
	});
});
