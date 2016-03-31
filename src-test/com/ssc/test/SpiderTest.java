package com.ssc.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class SpiderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws Exception {
		String url = "http://www.bjsat.gov.cn/bjsat/";
		new Spider().analysis(url,0,"亿信华辰");
	}

}
