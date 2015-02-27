/**   
* @Title: UserTest.java 
* @Package com.renho 
* @Description: TODO
* @author renho   
* @date 2013年8月26日 下午2:05:57 
* @version V1.0   
*/
package com.renho;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class UserTest {

	@Test
	public void testIsEmpty() {
		boolean b = new User().isEmpty(true);
		Assert.assertEquals(true, b);
		b = new User().isEmpty(false);
		Assert.assertEquals(false, b);
	}

}

