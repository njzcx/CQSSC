package com.ssc.filter.digit.impl;

import java.util.List;

import com.ssc.filter.digit.DigitFilter;

public class TenThousandsFilter extends DigitFilter {

	@Override
	public List dofilter() throws Exception {
		String lotteryNumber = getLotteryNumber();
		setFilterResult(lotteryNumber.split("")[0]);
		return null;
	}

}
