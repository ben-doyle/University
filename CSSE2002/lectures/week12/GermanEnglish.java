package week12;

import java.util.*;

public class GermanEnglish {
	
	public static void main(String[] args) {
		Map<String,String> map = new TreeMap<String,String>();
		fill(map);
		System.out.println(map);
		System.out.println("-------------------");
		
		Set<String> keys = map.keySet();
		for (String word: keys) {
			System.out.println(word + "=" + map.get(word));
		}
		System.out.println("-------------------");
		
		Set<Map.Entry<String,String>> entries = 
			map.entrySet();
		for (Map.Entry<String,String> e: entries)
			System.out.println(e);
		System.out.println("-------------------");
		
		Collection<String> values = map.values();
		values = new TreeSet<String>(values);
		for (String value: values) {
			for (String key: keys) {
				if (map.get(key).equals(value))
					System.out.println(value + "=" + key);
			}
		}
		
	}
	
	private static void fill(Map<String,String> map){
		map.put("Eis","ice");
		map.put("Hof","yard");
		map.put("Hut","hat");
		map.put("Lob","praise");
		map.put("Mal","mark");
		map.put("Mut","courage");
		map.put("Ohr","ear");
		map.put("Ost","east");
		map.put("Rad","wheel");
		map.put("Rat","advice");
		map.put("Tag","day");
		map.put("Tor","gate");
		map.put("Uhr","clock");
		map.put("Wal","whale");
		map.put("Zug","train");
	}
		
}
