package nl.codefox.tudelft.cse2310.util;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WebLab {
	
	public static ArrayList<String> getDataStringArray(String filepath) {
		String[] data = getData(filepath).split("\n");
		ArrayList<String> result = new ArrayList<>();
		Collections.addAll(result, data);
		return result;
	}
	
	public static double[] getDataDoubleArray(String filepath) {
		String[] data = getData(filepath).split("\n");
		return Arrays.stream(data).mapToDouble(Double::valueOf).toArray();
	}
	
	public static String getData(String filepath) {
		Class<?> caller = getCallerClass();
		StringBuilder sb = new StringBuilder();
		caller.getResourceAsStream(filepath);
		InputStream is = caller.getResourceAsStream(filepath);
		URL resource = caller.getResource(filepath);
		Scanner sc = new Scanner(is);
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine()).append("\n");
		}
		sb.deleteCharAt(sb.length() - 1); // Delete last newline
		return sb.toString();
	}
	
	public int getDataIntArray(String filepath) {
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	private static Class getCallerClass() {
		String callerName = null;
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		for (StackTraceElement e : stackTrace) {
			String name = e.getClassName();
			if (!name.endsWith("WebLab") && !name.endsWith("Thread")) {
				callerName = name;
				break;
			}
		}
		
		Class caller = null;
		try {
			caller = Class.forName(callerName);
		} catch (ClassNotFoundException e) {
			assert false : "Should be unreachable code";
		}
		return caller;
	}
	
}
