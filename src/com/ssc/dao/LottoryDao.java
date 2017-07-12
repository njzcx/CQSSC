package com.ssc.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ssc.bean.DataBean;

public class LottoryDao extends BaseDao {
	
	public void insert(List<DataBean> beans) throws Exception {
		String sql = "insert into lottery(lottery_no_,issue_,time_) values (?,?,?)";
		PreparedStatement stmt = getConnection().prepareStatement(sql);
		for (int i = 0; i < beans.size(); i++) {
			DataBean o = beans.get(i);
			stmt.setString(1, o.getLotteryNumbers());
			stmt.setString(2, o.getIssue());
			stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			stmt.addBatch();
			if (i%200 == 0 || i == beans.size()) {
				stmt.executeBatch();
				stmt.clearBatch();
			}
		}
		
	}
	
	public DataBean select() throws Exception {
		String sql = "select * from lottery t";
		Statement st = getConnection().createStatement();
		st.executeQuery(sql);
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		DataBean d1 = new DataBean();
		d1.setDate(String.valueOf(System.currentTimeMillis()));
		d1.setIssue("052");
		d1.setLotteryNumbers("654789");
		List list = new ArrayList<DataBean>();
		list.add(d1);
		new LottoryDao().insert(list);
	}
}
