package com.aoide.member._30_AccuseDanmuku.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.accusementDanmuku.AccusementDanmukuVO;
import com.aoide.global.dataBaseManipulationObjects.member.MemberVO;
import com.aoide.global.dataBaseManipulationObjects.suggestion.SuggestionVO;
import com.aoide.member._30_AccuseDanmuku.model.GetAccuseDanmukuService;
import com.aoide.member._30_AccuseDanmuku.model.SaveAccuseDanmukuService;

/**
 * Servlet implementation class SaveAccuseDanmukuServlet
 */
@WebServlet("/SaveAccuseDanmukuServlet.member")
public class SaveAccuseDanmukuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		Integer accused_id = Integer.parseInt((String) request.getSession().getAttribute("accused_id"));
		String accused_text = (String) request.getSession().getAttribute("accused_text");
		String text = request.getParameter("replyContent").trim();
		
		//System.out.println("現在檢舉人的ID:"+ member.getMemberId());
 		//System.out.println("現在被檢舉的彈幕會員ID:"+accused_id);
		//System.out.println("現在被檢舉的彈幕內容:"+accused_text);
		//System.out.println("檢舉的內文:"+text);
		
		
		//創建一個新的AccusementDanmukuVO物件並將資訊放進去後存入資料庫
		AccusementDanmukuVO new_accusementDanmukuVO = new AccusementDanmukuVO();
		
		new_accusementDanmukuVO.setAccuseId(member.getMemberId());
		new_accusementDanmukuVO.setAccusedId(accused_id);
		new_accusementDanmukuVO.setContentFile(text);
		new_accusementDanmukuVO.setDanmukuContent(accused_text);
		new_accusementDanmukuVO.setState(false);
		
		
		Integer accusement_danmuku_id = new SaveAccuseDanmukuService().InsertNewAccusementDanmuku(new_accusementDanmukuVO);
		
		//System.out.println(accusement_danmuku_id);
		//以剛剛存進資料庫所回傳的PK來查詢該筆資料並跳到顯示的頁面
		AccusementDanmukuVO accusementDanmukuVO = new GetAccuseDanmukuService().GetAccusementDanmukuByPK(accusement_danmuku_id);
		
		request.getSession().setAttribute("accusementDanmukuVO", accusementDanmukuVO);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/views/member/_30_AccuseDanmuku.view/AccuseSucessPageTemplate.jsp");
		//response.sendRedirect(contextPath + "/_30_AccuseDanmuku.view/AccuseSucessPage.jsp");
		
		
		
		
		
		
		
	}

}
