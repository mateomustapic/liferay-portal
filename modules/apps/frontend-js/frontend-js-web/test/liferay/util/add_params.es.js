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

import addParams from '../../../src/main/resources/META-INF/resources/liferay/util/add_params';

describe('Liferay.Util.addParams', () => {
	const sampleUrl = 'http://sampleurl.com';
	const sampleUrlWithParams = 'http://sampleurl.com?param';

	it('throws error if params is not an object or string', () => {
		expect(() => addParams(0)).toThrow(
			'Parameter params must be an object or string'
		);
	});

	it('throws error if url parameter is not a string', () => {
		expect(() => addParams('sampleId', 0)).toThrow(
			'Parameter baseUrl must be a string'
		);
	});

	it('adds the parameters to the portlet URL', () => {
		expect(addParams({id: 'sampleId', order: 'asc'}, sampleUrl)).toEqual(
			'http://sampleurl.com/?id=sampleId&order=asc'
		);
	});

	it('trims parameter if it has space before and adds it to base url', () => {
		expect(addParams('   sampleId', sampleUrl)).toEqual(
			'http://sampleurl.com/?sampleId='
		);
	});

	it('sets portlet url when base url has parameters', () => {
		expect(
			addParams({id: 'sampleId', size: '10'}, sampleUrlWithParams)
		).toEqual('http://sampleurl.com/?param=&id=sampleId&size=10');
	});
});
