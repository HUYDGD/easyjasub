package com.github.riccardove.easyjasub.jmdict;

/*
 * #%L
 * easyjasub-lib
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


import java.io.File;
import java.util.ArrayList;

import com.github.riccardove.easyjasub.EasyJaSubHomeDir;
import com.github.riccardove.easyjasub.EasyJaSubTestCase;

public class JMDictParserTest extends EasyJaSubTestCase {

	public void testFullFile() throws Exception {
		File jmDictFile = new File(
				EasyJaSubHomeDir.getDefaultHomeDir("easyjasub-cmd"),
				"JMDict_e.xml");
		assertTrue(
				"Can not find JMDict file in " + jmDictFile.getAbsolutePath(),
				jmDictFile.exists() || !isEclipse());
		if (!jmDictFile.exists()) {
			return;
		}
		FakeObserver observer = new FakeObserver();
		new JMDictParser().parse(jmDictFile, observer);
		assertEquals("There are errors in parsing", 0, observer.errors.size());
		if (observer.errors.size() > 0) {
			for (String error : observer.errors) {
				println(error);
			}
		}
	}

	private static void printlnSample(int count, String text) {
		if ((count % 1327) == 42) {
			println(text);
		}
	}

	private class FakeObserver implements JMDictObserver {

		public ArrayList<String> errors = new ArrayList<String>();

		@Override
		public void onError(int index, String entseq, String message) {
			errors.add(index + " " + entseq + " " + message);
		}

		@Override
		public void onEntry(int index, String entseq, String keb, String reb,
				Iterable<IJMDictSense> senses) {
			printlnSample(index, index + " " + entseq + " " + keb + " " + reb);
			assertTrue(keb != null || reb != null);
			assertNotNull(senses);
			assertTrue(senses.iterator().hasNext());
		}

		@Override
		public void onEntry(int index, String entseq, String keb, String reb,
				IJMDictSense sense) {
			printlnSample(index, index + " " + entseq + " " + keb + " " + reb);
			assertTrue(keb != null || reb != null);
		}

	}
}