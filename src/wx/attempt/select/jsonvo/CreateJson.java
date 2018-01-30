package wx.attempt.select.jsonvo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CreateJson  {

	public CreateJson() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public  ResultVo  createresult() {
		ResultVo a = new ResultVo();
		
		
		return a ;
		
	}
	
public static void main(String[] args) {
	
	
	Jsonvo jvo= new Jsonvo();
	 JSONArray scoreArr = new JSONArray();
// 此处for 循环  打包 result VO	 
	 scoreArr .add(new CreateJson().createresult()) ; //加入一个 Result VO类型的东西 
	 scoreArr .add(new CreateJson().createresult());
	 scoreArr .add(new CreateJson().createresult());
	 jvo.setResult(scoreArr);
     
     JSONObject obj = JSONObject.fromObject(jvo);
     System.out.println(obj.toString());
}
}
