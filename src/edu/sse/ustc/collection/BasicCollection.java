package edu.sse.ustc.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Basic Collection
 * @author iustc
 *
 */
public class BasicCollection {

	public static void main(String[] args) {
		List<Integer> intLists = new ArrayList<Integer>();
		intLists.add(1);
		intLists.add(2);
		intLists.add(3);
		intLists.add(4);
		intLists.add(5);
		intLists.add(6);
		
		Iterator<Integer> iterator = intLists.iterator();
		iterator.next();
		iterator.remove();// before remove, should do next(), else NoSuchElementException
		System.out.println(intLists);
		iterator.next();
		iterator.remove();
		System.out.println(intLists);
		
		// LinkedList
		List<String> linkedLists = new LinkedList<>();
		linkedLists.add("aaa");
		linkedLists.add("bbb");
		linkedLists.add("ccc");
		
		ListIterator<String> listItr = linkedLists.listIterator();
		listItr.next();// skip the first item
		listItr.add("ddd");
		System.out.println(linkedLists);
	}
}