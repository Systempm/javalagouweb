package com.attempt.select.dao;

import java.util.List;

import com.attempt.vo.newHvo;



//��ѯ ���� ������ѯ ��ҵ  ѡ��ĵص�  �����  ����ļ۸�

public interface SelectDao {
	List<newHvo> selectCity(String city);
	List<newHvo> selectPosition(String position);
	List<newHvo> selectSalary(String salary);


}
