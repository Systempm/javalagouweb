package com.attempt.select.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.attempt.common.DbConnection;
import com.attempt.select.vo.SelectVo;
import com.attempt.vo.newHvo;

public class SelectDaoImpl extends DbConnection implements SelectDao{

	
	

	  public int getPage(String sql ,int pagesize) throws Exception{
		  Connection con=this.getconnection();
		  PreparedStatement ps =null;
		  ResultSet rs=null;
	        //��coun(*)��ȡ��ǰ���������ע�ⷵ�ص�ֻ��һ�����ݣ�������������
	     
	        ps=con.prepareStatement(sql);
	        rs=ps.executeQuery();
	        //��ôrs.next()��Ȼ��ָ����һ��
	        rs.next();
	        //��Ϊ������������Ȼ�Ǹ�����������Ҫ����1.0���С����Ȼ����Math.ceil��ȡ ���ڻ��ߵ��� ��ǰ���� ��С����ֵ��
	        int pageCount=(int)Math.ceil(1.0*rs.getInt(1)/pagesize);
	        return pageCount;
	    }
	
	@Override 
	public List<newHvo> selectCity(String city){
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
	
	
	public ArrayList<newHvo> select(String sql , int pageSize, int  startIndex){
        //����һ����ǰҪ��ȡ��������͵����飻
	  Connection con=this.getconnection();
	  PreparedStatement ps =null;
	  ResultSet rs=null;
        ArrayList<newHvo> list=new ArrayList<newHvo>();
        //mysql�ķ�ҳ��䣻
     
       
        try {
			ps=con.prepareStatement(sql);
			System.out.println(startIndex);
			System.out.println(pageSize);
        ps.setInt(1, pageSize);
        ps.setInt(2, startIndex);
        rs=ps.executeQuery();
 
        //���rs.next��true�����Ȱ�Ҫ��ֵ����ʵ��������ôͨ��whileѭ����ÿ���ֶ�Ԫ�ظ�ֵ����Ӧ����ı����У�
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
        }
        } catch (SQLException e) {
        	// TODO Auto-generated catch block
        	System.out.println("pageDao yichang");
        	e.printStackTrace();
        }
        finally{
			this.closeResultSet(rs);
			this.closeStatement(ps);
			this.closeConnection(con);
		}
        //��󷵻س�ȥ
        

        return list;
    }
	
//	public List<newHvo> select(SelectVo svo){
//		List list=new ArrayList();
//		String  sql ="select * from lagou where 1=1 " ;
//		//���� svo
//		
//	
//		
//		
//		Connection con=this.getconnection();
//			Statement st =null;
//			  ResultSet rs=null;
//			 try {
//				 st=con.createStatement();
//				
//				rs=st.executeQuery(sql);
//				while(rs.next()){	
//					newHvo hvo=new newHvo();
//					hvo.setCompanshortname(rs.getString(1));
//					hvo.setCompanyFullName(rs.getString(2));
//					hvo.setPositionName(rs.getString(3));
//					hvo.setPositionId(rs.getString(4));
//					hvo.setPositionAdvantage(rs.getString(5));
//					hvo.setSalary(rs.getString(6));
//					hvo.setMinsalary(rs.getInt(7));
//					hvo.setMaxsalary(rs.getInt(8));
//					hvo.setMaxjianminslary(rs.getInt(8)-rs.getInt(7)		);
//					hvo.setWorkYear(rs.getString(9));
//					hvo.setEducation(rs.getString(10));
//					hvo.setCity(rs.getString(11));
//					hvo.setDistrict(rs.getString(12));
//					hvo.setCompanySize(rs.getString(13));
//					hvo.setCompanyLogo("//"+rs.getString(14));
//					hvo.setCompanyLabelList(rs.getString(15));
//					hvo.setCreateTime(rs.getDate(16));
//					list.add(hvo);
//					
//				}
//			} catch (SQLException e) {
//					
//					e.printStackTrace();
//				}finally{
//					this.closeResultSet(rs);
//					this.closeStatement(st);
//					this.closeConnection(con);
//				}
//			  System.out.println(sql);
//				 
//			  
//			  return list;
//		
//		 
//		
//		
//		
//	}

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
