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
// �˴�for ѭ��  ��� result VO	 
	 scoreArr .add(new CreateJson().createresult()) ; //����һ�� Result VO���͵Ķ��� 
	 scoreArr .add(new CreateJson().createresult());
	 scoreArr .add(new CreateJson().createresult());
	 jvo.setResult(scoreArr);
     
     JSONObject obj = JSONObject.fromObject(jvo);
     System.out.println(obj.toString());
}
}
