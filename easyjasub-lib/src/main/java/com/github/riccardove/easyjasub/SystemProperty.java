package com.github.riccardove.easyjasub;

/*
 * #%L
 * easyjasub
 * %%
 * Copyright (C) 2014 Riccardo Vestrini
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


class SystemProperty {
	
	static {
		UserDir = System.getProperty("user.dir");
		LineSeparator = System.getProperty("line.separator");
		Encoding = System.getProperty("file.encoding");
	}
	
	private static final String UserDir;
	private static final String LineSeparator;
	private static final String Encoding;
	
	public static String getUserDir() {
		return UserDir;
	}
	
	public static String getLineSeparator() {
		return LineSeparator;
	}

	public static String getEncoding() {
		return Encoding;
	}
}