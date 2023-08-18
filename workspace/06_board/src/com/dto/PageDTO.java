package com.dto;

import java.util.List;

public class PageDTO {
	
	//4가지 정보
	List<BoardDTO> list; //3개의 목록 넣을 변수 선언, 컬렉션이나 해시맵 사용해도 됨
	
	int perPage = 3; //페이지당 보여줄 행 개수
	int totalCount; // 전체 레코드 개수
	int curPage; // 현재 페이지 번호
	
	//생성자는 만들 필요 없음
	//getter / setter 메서드
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	

}
