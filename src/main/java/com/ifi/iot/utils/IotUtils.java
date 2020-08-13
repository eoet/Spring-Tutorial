package com.ifi.iot.utils;

import java.util.List;

public final class IotUtils {
	public static void printVar(String message, Object obj) {
		System.out.println("**********************************");
		System.out.println(message);
		System.err.println(obj);
	}
	
	public static boolean isEmpty(List lst) {
		return lst == null || lst.isEmpty();
	}
}
