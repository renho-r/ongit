package com.renho.guava.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;

public class NewCollections {

	public static void main(String[] args) {
		/**
		 * Multiset
		 */
		HashMultiset<String> hashMultiset = HashMultiset.create();
		hashMultiset.add("renho");
		hashMultiset.add("test");
		hashMultiset.add("renho");
		hashMultiset.add("renho", 100);
		System.out.println(hashMultiset.size());
		System.out.println(hashMultiset.elementSet().size());
		System.out.println(hashMultiset.count("renho"));
		System.out.println(hashMultiset.count("test"));
		
		/**
		 * Multimap
		 */
		Multimap<String, String> multimap = ArrayListMultimap.create();
		multimap.put("renho", "renho-0");
		multimap.put("renho", "renho-1");
		multimap.put("renho", "renho-2");
		System.out.println(1);
		
		/**
		 * BiMap
		 */
		System.out.println("====================>BiMap<====================");
		BiMap<String, Integer> userId = HashBiMap.create();
		userId.put("renho", 1001);
		userId.put("renho", 1000);
		String userForId = userId.inverse().get(1000);
		System.out.println(userForId);
		/**
		 * RangeSet
		 */
	}

}
