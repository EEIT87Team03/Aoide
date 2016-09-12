package com.aoide.manager._26_EditTask.comtroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aoide.global.dataBaseManipulationObjects.task.TaskVO;
import com.aoide.manager._26_EditTask.model.TaskService;

@WebServlet("/EditTaskList")
public class EditTaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("In TaskServlet doGet()");
		// get the suggestion list from service
		List<TaskVO> taskList = new TaskService().getUnreplyTaskVO();
		// 包入BulletList
		request.getSession().setAttribute("TaskList", taskList);

		// go suggestionList.jsp
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/_26_EditTask.view/TaskList.jsp");
	}// end doGet()

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}