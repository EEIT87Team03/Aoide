package com.aoide.manager._26_EditTask.comtroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.task.JdbcTaskDAO;
import com.aoide.global.dataBaseManipulationObjects.task.TaskDAO;

@WebServlet("/DeleteEditTask")
public class DeleteEditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");

		// String DELETE = request.getParameter("deleteBullet");
		// String 轉 Int
		Integer DELETE = Integer.parseInt(request.getParameter("taskId"));

		TaskDAO dao = new JdbcTaskDAO();
        dao.delete(DELETE);

		System.out.println(request.getParameter("taskId"));
		System.out.println(DELETE);
		String Path = request.getContextPath();
		response.sendRedirect(Path + "/_26_EditTask.view/DeleteTaskDisplay.jsp");

	}
}
