package com.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(name="ListTestController",urlPatterns = {"/listtest/*"})
public class ListTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson g = new Gson();
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		List<String> idList = new ArrayList<>();
		idList.add("black");
		idList.add("white");
		idList.add("red");
		idList.add("green");
		idList.add("blue");
		idList.add("yellow");
		String strIdList = g.toJson(idList);
		RequestDispatcher rd = request.getRequestDispatcher("/ListTest.html");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
