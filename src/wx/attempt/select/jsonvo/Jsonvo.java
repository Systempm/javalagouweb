package wx.attempt.select.jsonvo;

import java.util.Date;

import net.sf.json.JSONArray;

public class Jsonvo {

	private String code ;
	private String msg ;
	private long date ;
	private int  num;
	private JSONArray result;
	public Jsonvo() {
		// TODO Auto-generated constructor stub
super();
this .code = "OK";
this. msg = "³É¹¦";
this .date =  new Date().getTime();  
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}



	public JSONArray getResult() {
		return result;
	}



	public void setResult(JSONArray result) {
		this.result = result;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}

}
