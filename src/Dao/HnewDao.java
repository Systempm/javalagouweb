package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vo.newHvo;
public class HnewDao extends DbConnection{
	public List Hselect(String city){
	List list=new ArrayList();
	
	 Connection con=this.getconnection();
	PreparedStatement ps =null;
	  ResultSet rs=null;
	 try {
		ps=con.prepareStatement("select * from lagou where city =?");
		ps.setString(1, city);
		rs=ps.executeQuery();
		while(rs.next()){	
			newHvo hvo=new newHvo();
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
			
			hvo.setCreateTime(rs.getDate(16));
			list.add(hvo);
			
//		System.out.println("ID："+rs.getString(1));
//		System.out.println("公司："+rs.getString(2));
//		System.out.println("职位："+rs.getString(3));
//		System.out.println("工资范围："+rs.getString(4));
//		System.out.println("最低工资："+rs.getInt(5));
//		System.out.println("最高工资："+rs.getInt(6));	
//		System.out.println("工作地点："+rs.getString(7));	
//		System.out.println("特点："+rs.getString(8));	
//		System.out.println("logo："+rs.getString(9));	
//		System.out.println("公司url："+rs.getString(10));	
//		System.out.println("工作url："+rs.getString(11));	
//		System.out.println("入库时间："+rs.getDate(12));	
////		
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
	public static void main(String[] args) {
		HnewDao hd =new HnewDao();
//		HVo hv = new HVo();
		List<newHvo> list = hd .Hselect("上海") ;  
		for  (newHvo hvo:list )
		{
	   System.out.println(hvo.getCompanyLogo());
		}
		
//		System.out.println( list.get(1).getCompanshortname());
		}
}
