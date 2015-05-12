package com.renho.create.singleton.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		Obj obj = new Obj();
//		
//		Thread to = new Thread(new ThreadOther(obj));
//		to.start();
//		
//		SingletonTestA singletonTestA = SingletonTestA.getInstance();
//				
//		System.out.println(singletonTestA == obj.list.get(0));
		
		SingletonTestA singletonTestA = SingletonTestA.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("renho.data"));
		oos.writeObject(singletonTestA);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("renho.data"));
		SingletonTestA singletonTestB = (SingletonTestA) ois.readObject();
		ois.close();
		
		System.out.println(singletonTestA == singletonTestB);
	}

}
