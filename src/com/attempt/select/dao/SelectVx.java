package com.attempt.select.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.attempt.common.DbConnection;
import com.attempt.vo.newHvo;

import wx.attempt.select.jsonvo.ResultVo;

public class SelectVx extends DbConnection implements SelectDao {
 
	public List<newHvo> selectCity(){
		List list=new ArrayList();
		
		 Connection con=this.getconnection();
		PreparedStatement ps =null;
		  ResultSet rs=null;
		 try {
			ps=con.prepareStatement("select * from lagou ");
			rs=ps.executeQuery();
			while(rs.next()){	
				ResultVo hvo=new ResultVo();
				hvo.setCompanshortname(rs.getString(1));
				hvo.setCompanyFullName(rs.getString(2));
				hvo.setPositionName(rs.getString(3));
				hvo.setPositionId(rs.getString(4));
				hvo.setPositionAdvantage(rs.getString(5));
				hvo.setSalary(rs.getString(6));
				hvo.setMinsalary(rs.getInt(7));
				hvo.setMaxsalary(rs.getInt(8));
				hvo.setMaxjianminslary(rs.getInt(8)-rs.getInt(7)		);
				hvo.setWorkYear(rs.getString(9));
				hvo.setEducation(rs.getString(10));
				hvo.setCity(rs.getString(11));
				hvo.setDistrict(rs.getString(12));
				hvo.setCompanySize(rs.getString(13));
				hvo.setCompanyLogo("//"+rs.getString(14));
				hvo.setCompanyLabelList(rs.getString(15));
				hvo.setCreateTime(rs.getDate(16).toString());
				list.add(hvo);
				
			}
		} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				this.closeResultSet(rs);
				this.closeStatement(ps);
				this.closeConnection(con);
			}
			 return list;
		}

	@Override
	public List<newHvo> selectCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<newHvo> selectPosition(String position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<newHvo> selectSalary(String salary) {
		// TODO Auto-generated method stub
		return null;
	}
}
