package edu.sse.ustc.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author imarklei90
 * @since 2019.05.09
 */
public class Demo {

	@Test
	public void test(){ // list元素去重
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(3);

		// list去重
		Set<Integer> set = new HashSet<>();
		set.addAll(list);

		List<Integer> newLists = new ArrayList<>();
		newLists.addAll(set);
		for(Integer value : newLists){
			System.out.println(value);
		}

	}

}
