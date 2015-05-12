package com.renho.e53;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class StringUtilsTest {
	@Test
	public void testRemove() {
		System.out.println(StringUtils.remove("$ÊÇ$", "$"));
		assertTrue(StringUtils.remove("$ÊÇ$", "$").equals("ÊÇ"));
	}
}
