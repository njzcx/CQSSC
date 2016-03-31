package com.test.sax;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.BeforeClass;
import org.junit.Test;

public class XMLReader {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void readerXML() {
		InputStream in = this.getClass().getResourceAsStream("test.xml");
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(in);
			Element root = doc.getRootElement();
			String content = root.element("bean").element("property").getText();
			System.out.println(content);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
