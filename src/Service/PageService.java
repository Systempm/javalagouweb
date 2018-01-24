package Service;

import java.util.ArrayList;
import java.util.List;

import com.attempt.select.dao.SelectDaoImpl;
import com.attempt.select.vo.PageVo;
import com.attempt.vo.newHvo;

import Bean.PageBean;
import Dao.HnewDao;



public class PageService {

	public PageBean Page(int pageNum, int pageSize)
	{
		HnewDao hd =new HnewDao();
		PageBean pb =null;
   		int totalRecord;
		try {
			totalRecord = hd.getPage(pageSize);
			 pb = new PageBean (pageNum , pageSize ,totalRecord);
	 		int startIndex = pb .getStartIndex();
			System.out.println("start index");
			System.out.println(startIndex);
			
			pb .setList(hd .SelectAll(startIndex,pageSize));
				}
		
		 catch (Exception e) {
			 System.out.println("pageservice yichang");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		return pb;
	}
	public PageVo SelectPage(String sql ,  int pageNum, int pageSize)
	{
		SelectDaoImpl hd =new SelectDaoImpl();
		PageVo pb =null;
   		int totalRecord;
		try {
	
			totalRecord = hd.getPage(sql,pageSize);
			
	 		 pb = new PageVo (pageNum , pageSize ,totalRecord);
	 	System.out.println("≤‚ ‘ get start inxdex");
			int startIndex = pb .getStartIndex();
	
			System.out.println("start index");
			System.out.println(startIndex);
			 List<newHvo> list = hd .select(sql,startIndex,pageSize);
			pb .setList(list);
		
			//??
			

		}
		
		 catch (Exception e) {
			 System.out.println("pageservice yichang");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		return pb;
	}
	
	
	public static void main(String[] args) {
		PageService ps=new PageService();
		System.out.println(ps.Page(2,30).getEnd());
		System.out.println(ps.Page(2,30).getPageNum());	
		System.out.println(ps.Page(2,30).getPageSize());	
		System.out.println(ps.Page(2,30).getStart());	
		System.out.println(ps.Page(2,30).getStartIndex());	
		System.out.println(ps.Page(2,30).getTotalPage());
		System.out.println(ps.Page(2,30).getTotalRecord());
	}
}
