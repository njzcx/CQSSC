package com.ssc;

import java.util.List;

import com.ssc.calc.DataAnalyzer;
import com.ssc.filter.Filter;
import com.ssc.filter.impl.BigSmallFilter;
import com.ssc.io.LotteryFileReader;

public class MainRuner {

	public static void main(String[] args) throws Exception {
		
		String filepath = "d:/重庆时时彩B.txt";
		LotteryFileReader filereader = new LotteryFileReader();
		List data = filereader.readfile(filepath);
		Filter filter = new BigSmallFilter(0, 0);
		DataAnalyzer analyzer = new DataAnalyzer(data, filter);
		analyzer.doAnalysis();
		System.out.println(data.size());
	}
}
