package com.attempt.select.vo;

import java.util.ArrayList;
import java.util.List;

import com.attempt.vo.newHvo;







public class PageVo {

	
	private int pageNum;
	private int pageSize;
	private int totalRecord;
	private int totalPage;
	private int startIndex;
	private List<newHvo> list;
	private int start;
	private int end;
	
	public PageVo(int pageNum,int pageSize,int totalRecord)
	{
		this.pageNum=pageNum;
		this.pageSize=pageSize;
		this.totalRecord=totalRecord;
		
		if (totalRecord%pageSize==0){
			//整除 没有多一页
			this.totalPage=totalRecord/pageSize;
		}else {
		this.totalPage=totalRecord/pageSize+1;
		}
		//开始的索引
		this.startIndex=(pageNum-1)*pageSize ;
		this .start=1;
		//end  下面 显示5个标识 
		this.end=5;
		if (totalPage<=5) {
			this.end = this.totalPage;
			
		}else {
			this .start=pageNum -2 ; 
			this .end = pageNum +2;
			if (start <0)
			{
			this .start =1;
			this .end = 5;
			}
			if (end >this.totalPage) {
				this .end =totalPage;
				this .start= end -5;
				
			}
			
		}
	}
	

	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public List<newHvo> getList() {
		return list;
	}
	public void setList(List<newHvo> list) {
		this.list = list;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
