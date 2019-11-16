package com.sangga.exercise.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConverterUtil {

	public static String convertArrayMapToString(List<HashMap<String, String>> list) {
		StringBuffer sbf = new StringBuffer();
		list.forEach((item) -> {
			item.forEach((k,v) -> {
				sbf.append(k);
				sbf.append("=");
				sbf.append(v);
				sbf.append(";");
			});
			sbf.append("\n");
			}
			);
		return sbf.toString();
	}
	
	public static List<HashMap<String, String>> convertStringToArrayMap(String text) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>() ;
		
		List<String> items = Arrays.asList(text.split("\n"));
		items.forEach((item) -> {
			HashMap<String, String> map = new HashMap<String, String>();
			Arrays.asList(item.split(";")).forEach((textMap) -> {
				String[] array = textMap.split("=");
				map.put(array[0], array[1]);
			});
			list.add(map);
		});
		return list;
	}
}
