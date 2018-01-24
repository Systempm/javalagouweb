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
		//��������ǵڼ�ҳ
		System.out.println("456");//
		//���ж�  city ��û��ֵ ��
		if (request.getParameter("city")!=null)
		{
			System.out.println("city ��Ϊ�� ");
			//���ж� �ǲ��� ��session �����ǲ����� selecinfo 
			if(request.getSession().getAttribute("selectinfo")==null)
			{
				System.out.println("��һ��new ");
				//û�� session ��һ��  ��Ҫnew ���� 
				SelectVo svo = new SelectVo();
				svo.setCity((String)request.getParameter("city"));	
				request.getSession().setAttribute("selectinfo",svo );
			}else{
				//��session ��  ˵�������Ѿ�����  һ��city ��
				 System.out.println("�ڶ�����");
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
				//֤�� ���� �б�����û�����city
				
			 if (i ==0)
			 {
				 svo.setCity(svo .getCity()+"#"+city );		 
			 }
				
			request.getSession().setAttribute("selectinfo",svo );	
			}
				
		}
		
		
	//����sql
		
		SelectVo svo=	(SelectVo)request.getSession().getAttribute("selectinfo");
		String  sql ="select * from lagou where 1=1 " ;
		if (svo.getCity()!=null)
		{
			// city ��#  
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
		System.out.println("city sql Ϊ" +sql );
		// �� sql ȥ��ҳ ��
		//���� ��  �ŵ� ��ҳ ���� ��
		
		/*
		 * 
		 *  ��ҳ
		 */
		

		
		int page=1;
		if (request.getParameter("page")=="null")
		{
			//��������� ����Ҫ���Ǵ�ֵ Map ������ 
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
		//���ж�  city ��û��ֵ ��
		if (request.getParameter("position")!=null)
		{
			System.out.println("position ��Ϊ�� ");
			//���ж� �ǲ��� ��session �����ǲ����� selecinfo 
			if(request.getSession().getAttribute("selectinfo")==null)
			{
				System.out.println("��һ��new ");
				//û�� session ��һ��  ��Ҫnew ���� 
				SelectVo svo = new SelectVo();
				svo.setPosition((String)request.getParameter("position"));	
				request.getSession().setAttribute("selectinfo",svo );
			}else{
				//��session ��  ˵�������Ѿ�����  һ��city ��
				 System.out.println("�ڶ�����");
				String position  =  (String)request.getParameter("position");
				SelectVo svo=(SelectVo)request.getSession().getAttribute("selectinfo");
			request.getSession().setAttribute("selectinfo",svo );	
			}
			
			
			
			
		}
		
		System.out.println("����ǰ");
		SelectVo svo=	(SelectVo)request.getSession().getAttribute("selectinfo");
		System.out.println(svo.getPosition());
		
       //hasmaplist {columnnum=1, label13=1, label12=2, label11=3}
//		 model.addAttribute("json", stt.getjson());//json wenjian """"str"""""
		return "selectlist";
	}
}
