package com.renho.chapter1.recipe10.core;

import com.renho.chapter1.recipe10.group.MyThreadGroup;
import com.renho.chapter1.recipe10.task.Task;

/**
 * Main class of the example
 *
 */
public class Main {

	/**
	 * Main method of the example. Creates a group of threads of MyThreadGroup
	 * class and two threads inside this group
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Create a MyThreadGroup object
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		// Create a Taks object
		Task task = new Task();
		// Create and start two Thread objects for this Task
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(threadGroup, task);
			t.start();
		}
	}

}
