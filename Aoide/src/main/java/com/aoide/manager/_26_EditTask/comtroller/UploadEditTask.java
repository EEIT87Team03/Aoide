package com.aoide.manager._26_EditTask.comtroller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.task.JdbcTaskDAO;
import com.aoide.global.dataBaseManipulationObjects.task.TaskDAO;
import com.aoide.global.dataBaseManipulationObjects.task.TaskVO;

@WebServlet("/UploadEditTask")
public class UploadEditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 mId 欄位內的資料，注意大小寫
		// getParameter必是String類型
		//取系統時間
		//Date date = new Date(System.currentTimeMillis());
		//String date = request.getParameter("date");
		String name = request.getParameter("Name");
		String contentFile = request.getParameter("contentFile");
		Double reward = Double.parseDouble(request.getParameter("reward")); 
		Integer periodHour = Integer.parseInt(request.getParameter("periodHour"));
		
		//取值  String 型
		String beginDate01 = request.getParameter("beginDate");
		String closeDate01 = request.getParameter("closeDate");
        //設規格 	這裡待解決請勿使用      錯誤 -> "Cannot format given Object as a Date"
//		SimpleDateFormat DateNorm = new SimpleDateFormat("MM/dd/yyyy/HH");
//		String beginDate01 = DateNorm.format(beginDate);
//		String closeDate01 = DateNorm.format(closeDate);
		//轉Long 型
		Long beginDate02 = Long.parseLong(beginDate01);
		Long closeDate02 = Long.parseLong(closeDate01);
	    //轉 sql.Date 型
		java.sql.Date beginDatePatterns = new java.sql.Date(beginDate02);
		java.sql.Date closeDatePatterns = new java.sql.Date(closeDate02);
		//存入後date格式(xxxx-xx-xx xx:xx:xx:xxxx)

		TaskDAO dao = new JdbcTaskDAO();
		TaskVO taskVO = new TaskVO();
		
		taskVO.setName(name);
		taskVO.setContentFile(contentFile);
		taskVO.setReward(reward);
		taskVO.setPeriodHour(periodHour);
		taskVO.setBeginDate(beginDatePatterns);
		taskVO.setCloseDate(closeDatePatterns);
        dao.insert(taskVO);
		
		request.getSession().setAttribute("taskVO", taskVO);
		String Path = request.getContextPath();
		response.sendRedirect(Path + "/_26_EditTask.view/UploadTaskDisplay.jsp");		
	}
}
