package com.ssc.filter.digit;

import java.util.List;

import com.ssc.filter.Filter;

public abstract class DigitFilter implements Filter {

	private String lotteryNumber;
	
	private String filterResult;
	
	public void loadData(Object data) {
		lotteryNumber = (String)data;
	}

	public abstract List dofilter() throws Exception;

	public String getResult() {
		return filterResult;
	}
	
	public String getLotteryNumber() {
		return lotteryNumber;
	}
	
	public void setFilterResult(String filterResult) {
		this.filterResult = filterResult;
	}
}
