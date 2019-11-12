package com.ajax.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.service.BoardService;
import com.ajax.service.impl.BoardServiceImpl;
import com.google.gson.Gson;

// 아무것도 안하면 레이지로딩(게으른) loadOnStartup=1은 먼저 로딩하는 프리로딩
@WebServlet(name = "BoardController", urlPatterns = { "/ajax/board/*", "/jsp/board/*" }, loadOnStartup = 1)
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
	private Gson g = new Gson();

	/*
	 * public BoardController() { System.out.println("1.보드컨트롤러 생성"); } public void
	 * init() { // 초기화 System.out.println("2.생성자 호출 뒤 실행"); }
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("3.get방식이 일어날때마다 호출");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String cmd = request.getParameter("cmd");
		if ("list".equals(cmd)) {
			List<Map<String, String>> boardList = bs.selectBoardList(null);
			pw.print(g.toJson(boardList));
		} else if ("view".equals(cmd)) {
			Map<String, String> param = new HashMap<>();
			param.put("biNum", request.getParameter("biNum"));
			Map<String, String> board = bs.selectBoard(param);
			pw.print(g.toJson(board));
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader br = request.getReader();
		String str = null;
		String json = "";
		while ((str = br.readLine()) != null) {
			json += str;
		}
		Map<String, String> board = g.fromJson(json, Map.class);
		response.setContentType("application/json;charset=utf-8");
		json = g.toJson(bs.insertBoard(board));
		PrintWriter pw = response.getWriter();
		pw.print(json);
	}
}
