package com.ssc.test;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	@MyAnnotation(name = "123")
	public void test() {
		String file = Test.class.getResource("").getFile();
		System.out.println(file);
		fail("Not yet implemented");
	}

}
