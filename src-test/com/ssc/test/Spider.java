package com.ssc.test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider {
	List gotlink = new ArrayList();
	List queue = new ArrayList();
	int maxdeep = 3;
	
	public void analysis(String url,int deep, String searchtext) {
		if (url != null && "".equals(url) && !queryLink(url)) {
			gotlink.add(url);
			try {
				Document doc = Jsoup.connect(url).get();
				if (doc.text().contains(searchtext)) {
					System.out.println(url);
				}
				if (deep >= maxdeep) {
					return;
				}
				Elements suburls = doc.select("a[href]");
				for (Element suburl : suburls) {
					analysis(suburl.attr("abs:href"), deep+1, searchtext);
				}
			} catch (Exception e) {
				return;
			}
		}
	}
	
	private boolean queryLink(String url) {
		Iterator it = gotlink.iterator();
		while(it.hasNext()) {
			String goturl = (String)it.next();
			if (url.equals(goturl)) {
				return true;
			}
		}
		return false;
	}
}
