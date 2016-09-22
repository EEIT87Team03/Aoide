package com.aoide.member._14_Score.controller;

import java.awt.Point;
import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoide.global.dataBaseManipulationObjects.score.JdbcScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreDAO;
import com.aoide.global.dataBaseManipulationObjects.score.ScoreVO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;
import com.aoide.manager._27_ReplySuggestions.model.SuggestionService;
import com.aoide.member._14_Score.model.ScoreService;

@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Connection conn =null;
		// Statement stmt =null;
		// String scorevalue = request.getParameter("SV");
		//
		// java.sql.Date date = null;
		//
		// String songId = null;
		// String comment = null;
		// String memberId = null;
		//
		//
		// ScoreVO sd = new ScoreVO(memberId, songId, date,
		// ,scorevalue,comment);
		//
		//

	}

	// List<ScoreVO> inscorevalue = new ScoreService().getPoint();
	//
	// for(ScoreVO ipoint : inscorevalue){
	// System.out.println(ipoint.getScoreValue());
	//
	// }
	//
	// request.getSession().setAttribute("inscorevalue", inscorevalue);
	//
	// String contextPath = request.getContextPath();
	// response.sendRedirect(contextPath + "/_14_Score.view/getScore1.jsp");
	//
	//
	//
	//
	//
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = null;
		ScoreVO score = null;
		ScoreVO updatescore = null;
		ScoreService scoreService = null;

		String scoreValue = request.getParameter("sv").trim();
		if (scoreValue != null && scoreValue.length() != 0) {
																
			
			session = request.getSession();
			score = (ScoreVO) session.getAttribute("score");
			session.removeAttribute("score");
			score.setScoreValue(4);
			score.setComment(scoreValue);

			System.out.println("score: " + score);
			System.out.println("score: " + score.getScoreValue());
			System.out.println("score: " + score.getComment());
			
			
			scoreService = new ScoreService();
			scoreService.updateScore(score);		
			System.out.println("update score ok");
		}else{ // no reply content, replyState = 0
			System.out.println("you must be enter");
		}
		
		updatescore = scoreService.updateScore(score);
		session.setAttribute("updatescore", updatescore);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_14_Score.view/getScoreUpdate.jsp");
			// session = request.getSession(false);
			// if (session == null) { // 使用逾時
			// response.sendRedirect(getServletContext().getContextPath() +
			// "/_14_Score.view/getScore1.jsp");
			// return;
			// }
			// //取出session物件內的ShoppingCart物件
			// ScoreService sc= (ScoreService)session.getAttribute("ScoreVO");
			// if (sc == null) {
			// // 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// // 導向首頁
			// response.sendRedirect(getServletContext().getContextPath() +
			// "/_14_Score.view/getScore1.jsp" );
			// return;
			// }
			// cmd可能是DEL或是MOD
			// String cmd = request.getParameter("cmd");
			// String bookIDStr = request.getParameter("bookID");
			// int bookID = Integer.parseInt(bookIDStr.trim());
			// if (cmd.equalsIgnoreCase("DEL")) {
			// sc.deleteBook(bookID); // 刪除購物車內的某項商品
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/_14_Score.view/getScore1.jsp");
			// rd.forward(request, response);
			// return;
			// } else if (cmd.equalsIgnoreCase("MOD")) {
			// String newQtyStr = request.getParameter("newQty");
			// int newQty = Integer.parseInt(newQtyStr.trim());
			// sc.modifyQty(bookID, newQty); // 修改某項商品的數項
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/_14_Score.view/getScore1.jsp");
			// rd.forward(request, response);
			// return;
			// }
			//
		}

	}

