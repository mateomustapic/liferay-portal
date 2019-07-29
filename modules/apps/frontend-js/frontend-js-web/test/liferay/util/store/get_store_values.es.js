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

import getStoreValues from '../../../../src/main/resources/META-INF/resources/liferay/util/store/get_store_values.es';

describe('Liferay.Util.Store.getStoreValues', () => {
	it('throws error if keys parameter is not an array', () => {
		expect(() => getStoreValues(0)).toThrow(
			'Parameter keys must be an array'
		);
	});

	it('throws error if callback parameter is not a function', () => {
		expect(() => getStoreValues(['foo'], 'bar')).toThrow(
			'Parameter callback must be a function'
		);
	});

	it('Makes the request for given parameters', () => {
		global.Liferay = {
			authToken: 'abcd',
			ThemeDisplay: {
				getPathMain: jest.fn(() => {
					return 'http://sampleurl.com';
				}),
				getDoAsUserIdEncoded: jest.fn(() => {
					return 'efgh';
				})
			}
		};

		global.fetch = jest.fn((resource, init) => {
			const formData = new FormData();
			formData.append('key', '["aa","bb"]');

			expect(resource).toEqual(
				'http://sampleurl.com/portal/session_click?cmd=getAll&p_auth=abcd&doAsUserId=efgh'
			);

			expect(init).toEqual({
				body: formData,
				credentials: 'include',
				method: 'POST'
			});

			jest.fn().mockImplementation(() => Promise.resolve(['aa', 'bb']));
		});
	});
});
