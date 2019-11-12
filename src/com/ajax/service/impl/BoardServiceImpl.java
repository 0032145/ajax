package com.ajax.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.dao.BoardDAO;
import com.ajax.dao.impl.BoardDAOImpl;
import com.ajax.service.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		return bdao.selectBoard(board);
	}

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		return bdao.selectBoardList(board);
	}

	@Override
	public Map<String, String> insertBoard(Map<String, String> board) {
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg", "저장실패");
		if(bdao.insertBoard(board)==1) {
			rMap.put("msg","저장성공");
		}
		return rMap;
	}

	@Override
	public Map<String, String> updateBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> deleteBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}

}
