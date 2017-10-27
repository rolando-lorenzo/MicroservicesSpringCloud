package com.optimissa.trineo.proxy.receptores.utils;

import java.lang.reflect.Field;

/**
 * Utils class to microservice receptores
 * 
 * @author Rolando Lorenzo
 *
 */
public final class ReceptoresUtils {

	/**
	 * Method to convert stacktrace to string
	 * @param StackTraceElement data
	 * @return string representation.
	 */
	public static String getStackTrace(final StackTraceElement[] data) {
		StringBuilder info = new StringBuilder();
		if (data != null && data.length > 0) {
			int i = 0;
			for (StackTraceElement el : data) {
				info.append(el.toString()).append(((i++) < (data.length - 1)) ? "|" : "");
			}

		}
		return info.toString();
	}
	
	/**
	 * Returns the string representation of bean object
	 * 
	 * @param obj
	 * @return String
	 */
	public static String getToString(Object obj) {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(obj.getClass().getName());
		result.append(" [");
		result.append(newLine);
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
	
			for (Field field : fields) {
				if (field.getName().equals("serialVersionUID")) {
					continue;
				}
				result.append("  ");
				
				result.append(field.getName());
				result.append(": ");
				result.append(field.get(obj));
				
				result.append(newLine);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		result.append("]");

		return result.toString();
	}

}
