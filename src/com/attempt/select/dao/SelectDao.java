package com.attempt.select.dao;

import java.util.List;

import com.attempt.vo.newHvo;



//查询 包括 顶部查询 行业  选择的地点  和左边  点击的价格

public interface SelectDao {
	List<newHvo> selectCity(String city);
	List<newHvo> selectPosition(String position);
	List<newHvo> selectSalary(String salary);


}
