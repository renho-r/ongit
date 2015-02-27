/**   
* @Title: Apple.java 
* @Package com.renho.finaltest 
* @Description: TODO
* @author renho   
* @date 2013年9月5日 下午4:16:56 
* @version V1.0   
*/
package com.renho.finaltest;

/**
 * 第一次new counter = 0；
 * 同时id 被赋值 counter++
 * @author song
 *
 */
public class Apple {
	
	//final id 每一个对象一个id，赋值后不可更改
	public final long id = counter++;
	
	//static counter 对于所有对象都是唯一一个
	private static long counter;	
	
	public long getId(){
		return id;
	}
	public long getCounter() {
		return counter;
	}
}

