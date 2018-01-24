package com.attempt.select.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attempt.select.dao.SelectDao;
import com.attempt.select.dao.SelectDaoImpl;
import com.attempt.select.vo.PageVo;
import com.attempt.select.vo.SelectVo;

import Bean.PageBean;
import Dao.HnewDao;
import Service.PageService;

@Controller
public class selectcontroller {

	@RequestMapping("/selectcity")
	public String selectcity(Model model,HttpServletRequest request ) throws Exception{
		//解析点的是第几页
		System.out.println("456");//
		//先判断  city 有没有值 ；
		if (request.getParameter("city")!=null)
		{
			System.out.println("city 不为空 ");
			//在判断 是不是 有session 里面是不是有 selecinfo 
			if(request.getSession().getAttribute("selectinfo")==null)
			{
				System.out.println("第一次new ");
				//没有 session 第一次  需要new 对象 
				SelectVo svo = new SelectVo();
				svo.setCity((String)request.getParameter("city"));	
				request.getSession().setAttribute("selectinfo",svo );
			}else{
				//有session 了  说明里面已经有了  一个city ；
				 System.out.println("第二次了");
				String city  =  (String)request.getParameter("city");
				SelectVo svo=(SelectVo)request.getSession().getAttribute("selectinfo");
				String[] splitcity=svo .getCity() . split("#");
				int i = 0;
				for (String s :splitcity)
				{
					if (city .equals(s))
					{
						i ++;
					}
				
				}
				//证明 已有 列表里面没有这个city
				
			 if (i ==0)
			 {
				 svo.setCity(svo .getCity()+"#"+city );		 
			 }
				
			request.getSession().setAttribute("selectinfo",svo );	
			}
				
		}
		
		
	//生成sql
		
		SelectVo svo=	(SelectVo)request.getSession().getAttribute("selectinfo");
		String  sql ="select * from lagou where 1=1 " ;
		if (svo.getCity()!=null)
		{
			// city 有#  
			String city = svo.getCity();
			String[] splitcity = city .split("#");
			System.out.println("splitsize "+splitcity.length);
		   for (int i = 0 ;i <splitcity.length;i++)
		   {
			   if (i ==0) {
				   sql = sql +"and city= "+  "\"" +  splitcity[i]+ "\"";
				   
			   }else 
			   {
				   sql = sql +" or city= "+"\""+ splitcity[i]+"\"";
			   }
			   
		   }
		
		}
		if (svo.getPosition()!=null)
		{
			String position = svo.getPosition();
			sql = sql + "and  position="+ position; 
		}
		System.out.println("city sql 为" +sql );
		// 拿 sql 去分页 ；
		//下面 是  放到 分页 里面 ！
		
		/*
		 * 
		 *  分页
		 */
		

		
		int page=1;
		if (request.getParameter("page")=="null")
		{
			//如果参数多 就需要考虑传值 Map 类型了 
			 SelectDaoImpl sDao = new SelectDaoImpl();
			  PageService pg = new PageService();
			PageVo pb=  pg .SelectPage(sql, page, 30);
				 model.addAttribute("pageBean", pb);
		}
		else {
			 SelectDaoImpl sDao = new SelectDaoImpl();
			 if (request.getParameter("page")==null)
			 {
					System.out.print("page=");
					System.out.println(1);
					PageService pg = new PageService();
					PageVo pb=  pg .SelectPage(sql,1, 30);
					System.out.println(pb);
					System.out.println(pb.getList().get(1).getCompanyFullName());
						 model.addAttribute("pageBean", pb);
					
			 }
			 else {
			String s=request.getParameter("page");
			page=Integer.parseInt(s);
			System.out.print("page=");
			System.out.println(page);
			PageService pg = new PageService();
			PageBean pb=  pg .Page(page, 30);
			
			System.out.println(pb.getList().get(3).getCompanshortname());
				 model.addAttribute("pageBean", pb);
			 }
		}
		
		
		
		
		
		//hasmaplist {columnnum=1, label13=1, label12=2, label11=3}
//		 model.addAttribute("json", stt.getjson());//json wenjian """"str"""""
		return "selectlist";
	}
	
	@RequestMapping("/selectposition")
	public String selectposition(Model model,HttpServletRequest request ) throws Exception{
	
		System.out.println("123");//
		//先判断  city 有没有值 ；
		if (request.getParameter("position")!=null)
		{
			System.out.println("position 不为空 ");
			//在判断 是不是 有session 里面是不是有 selecinfo 
			if(request.getSession().getAttribute("selectinfo")==null)
			{
				System.out.println("第一次new ");
				//没有 session 第一次  需要new 对象 
				SelectVo svo = new SelectVo();
				svo.setPosition((String)request.getParameter("position"));	
				request.getSession().setAttribute("selectinfo",svo );
			}else{
				//有session 了  说明里面已经有了  一个city ；
				 System.out.println("第二次了");
				String position  =  (String)request.getParameter("position");
				SelectVo svo=(SelectVo)request.getSession().getAttribute("selectinfo");
			request.getSession().setAttribute("selectinfo",svo );	
			}
			
			
			
			
		}
		
		System.out.println("错误前");
		SelectVo svo=	(SelectVo)request.getSession().getAttribute("selectinfo");
		System.out.println(svo.getPosition());
		
       //hasmaplist {columnnum=1, label13=1, label12=2, label11=3}
//		 model.addAttribute("json", stt.getjson());//json wenjian """"str"""""
		return "selectlist";
	}
}
