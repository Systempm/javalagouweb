package controller;



import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import deal.DealStr;

@Controller
public class AController {
//	@RequestMapping("/ago")
//	public ModelAndView ad(Avo b) throws Exception{
//		ModelAndView mv = new ModelAndView("b");
//		//mv.addObject("a", "name");
//		//mv.setViewName("b");
//		System.out.println(b.getName());
//		return mv;
//	}

//	@RequestMapping("/toweb_inf")
//	public ModelAndView toweb_inf( ) throws Exception{
//		System.out.println("111");
//		ModelAndView mv = new ModelAndView("addmessage");
//		//mv.addObject("a", "name");
//		//mv.setViewName("b");
//		return mv;
//	}

	@RequestMapping("/gomain")
	public ModelAndView gomain( ) throws Exception{
		DealStr stt= new DealStr();
		HashMap hashmap;
		hashmap= stt .done();
		ModelAndView mv = new ModelAndView("tables");
		
		mv.getModel().put("list", hashmap);
		//mv.addObject("a", "name");
		mv.setViewName("tables");
		return mv;
	}
	
	@RequestMapping("/go1p")
	public ModelAndView go1p() throws Exception{
		System.out.println("111");
		ModelAndView mv = new ModelAndView("s1");
		//mv.addObject("a", "name");
		return mv;
	}
}
