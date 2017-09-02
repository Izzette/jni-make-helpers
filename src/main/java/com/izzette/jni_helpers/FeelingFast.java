package com.izzette.jni_helpers;

import cz.adamh.utils.NativeUtils;

import java.io.IOException;

public abstract class FeelingFast {
	protected static boolean FEELING_FAST = false;

	protected static void load(String libname) {
		try {
			System.loadLibrary (libname);
			FEELING_FAST = true;
		} catch (UnsatisfiedLinkError el) {
			try {
				NativeUtils.loadLibraryFromJar (
						String.format ("%s%s%s", "/lib/lib", libname, ".so"));
				FEELING_FAST = true;
			} catch (IOException ei) {
				FEELING_FAST = false;
			}
		}
	}
}
