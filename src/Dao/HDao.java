package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Vo.HVo;
public class HDao extends DbConnection{
	public List Hselect(){
	List list=new ArrayList();
	
	 Connection con=this.getconnection();
	 Statement st =null;
	 ResultSet rs=null;
	 try {
		st=con.createStatement();
		rs=st.executeQuery("select *from lala");
		while(rs.next()){	
			HVo hvo=new HVo();
			hvo.setId(rs.getString(1));
			hvo.setGongsi(rs.getString(2));
			hvo.setZhiwei(rs.getString(3));
			hvo.setGongzi(rs.getString(4));
			hvo.setMinslary(rs.getInt(5));
			hvo.setMaxslary(rs.getInt(6));
			hvo.setMaxjianminslary(rs.getInt(6)-rs.getInt(5)		);
			hvo.setDidian(rs.getString(7));
			hvo.setTedian(rs.getString(8));
			hvo.setLogo(rs.getString(9));
			hvo.setGongsijieshao(rs.getString(10));
			hvo.setXiangxiwangzhi(rs.getString(11));
			hvo.setRukushijian(rs.getDate(12));
			
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
			this.closeStatement(st);
			this.closeConnection(con);
		}
		 return list;
	}
	public static void main(String[] args) {
		HDao hd =new HDao();
//		HVo hv = new HVo();
		List<HVo> list = hd .Hselect() ;  
//		for  (HVo hvo:list )
//		{
//	   System.out.println(hvo.getId());
//		}
		
		System.out.println( list.get(1).getMaxjianminslary());
		}
}
