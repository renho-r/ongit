package com.renho.chapter1.e2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Client {

	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		Thread.State[] states = new Thread.State[10];
		
		for(int i=0; i<10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if(0 == (i%2)) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread-" + i);
		}
		try(
			FileWriter fw = new FileWriter(".\\data\\log.txt");
			PrintWriter pw = new PrintWriter(fw);){
			
			for(int i=0; i<10; i++) {
				pw.println("Main: status of Thread" + i + ":" + threads[i].getState());
				states[i] = threads[i].getState();
			}
			for(int i=0; i<10; i++) {
				threads[i].start();
			}
			
			boolean finish = false;
			while(!finish) {
				for(int i=0; i<10; i++) {
					if(states[i] != threads[i].getState()) {
						writeThreadInfo(pw, threads[i], states[i]);
						states[i] = threads[i].getState();
					}
				}
				finish = true;
				for(int i=0; i<10; i++) {
					finish = finish && (threads[i].getState() == State.TERMINATED);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writeThreadInfo(PrintWriter pw, Thread t, State s) {
		pw.printf("Main: ID %d - %s\n", t.getId(), t.getName());
		pw.printf("Main: Priority %d\n", t.getPriority());
		pw.printf("Main: Old State %s\n", s);
		pw.printf("Main: New State %s\n", t.getState());
		pw.printf("Main: *******************\n");
	}
}
