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

import setStoreValue from '../../../../src/main/resources/META-INF/resources/liferay/util/store/set_store_value.es';

describe('Liferay.Util.Store.setStoreValue', () => {
	let globalLiferay;

	afterEach(() => {
		global.Liferay = globalLiferay;
	});

	beforeEach(() => {
		globalLiferay = global.Liferay;

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
	});

	it('throws error if key parameter is not a string', () => {
		expect(() => setStoreValue(0, '')).toThrow(
			'Parameter key must be a string'
		);
	});

	it('throws error if value parameter is not an object or string', () => {
		expect(() => setStoreValue('', 0)).toThrow(
			'Parameter value must be boolean or an object or string'
		);
	});

	it('applies default settings if none are given', () => {
		global.fetch = jest.fn((resource, init) => {
			const formData = new FormData();
			formData.append('key', 'bar');

			expect(resource).toEqual(
				'http://sampleurl.com/portal/session_click?p_auth=abcd&doAsUserId=efgh'
			);

			expect(init).toEqual({
				body: formData,
				credentials: 'include',
				method: 'POST'
			});

			return Promise.resolve();
		});

		setStoreValue('key', 'bar');
	});
});
