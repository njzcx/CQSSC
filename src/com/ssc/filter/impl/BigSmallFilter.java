package com.ssc.filter.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.ssc.bean.DataBean;
import com.ssc.filter.Filter;

public class BigSmallFilter implements Filter {
	
	int lowerLimit;
	
	int upperLimit;
	
	Stack datastack;
	
	List data;
	
	public BigSmallFilter(int lowerLimit, int upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	
	public void loadData(List data) {
		this.data = data;
		this.datastack = new Stack();
	}

	public List dofilter() throws Exception {
		List filterData = new ArrayList();
		if (data == null || data.size() == 0) {
			throw new Exception("There no data for filter! You may be load data for this operation.");
		}
		Iterator it = data.iterator();
		while(it.hasNext()) {
			DataBean databean = (DataBean)it.next();
			//XXX 拆分号码
			checkData(databean, filterData);
		}
		return filterData;
	}

	private void checkData(DataBean databean, List filterData) {
		if (datastack.isEmpty() || needPushStack(databean)) {
			datastack.push(databean);
		} else {
			if (datastack.size() > lowerLimit && datastack.size() < upperLimit) {
				filterData.add(datastack.subList(0, datastack.size()));
			}
			datastack.clear();
			datastack.push(databean);
		}
	}

	private boolean needPushStack(DataBean databean) {
		// TODO Auto-generated method stub
		return false;
	}

}
