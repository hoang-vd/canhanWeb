package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Central navigation servlet. Usage:
 *   /go?task=chuong3_form  -> forwards/redirects to correspondant resource
 * All targets open in new tab because the links on baitap.jsp use target="_blank".
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/go"})
public class MainServlet extends HttpServlet {

	private Map<String, String> taskMap;

	@Override
	public void init() throws ServletException {
		taskMap = new HashMap<>();
		// Mapping keys -> internal paths (context-relative)
		// taskMap.put("chuong3_form", "/baitap_jsp/chuong3_index.html");
		// taskMap.put("chuong3_servlet", "/chuong3/emailList?action=join");
		taskMap.put("chuong4_servlet", "/chuong4/emailList?action=join");
		taskMap.put("chuong5_servlet", "/chuong5/emailList?action=join");
		taskMap.put("chuong6p1", "/chuong6p1/emailList?action=join");
		taskMap.put("chuong6p2", "/chuong6p2/survey");
		taskMap.put("chuong7p1", "/baitap_jsp/chuong7p1_index.jsp");
		taskMap.put("chuong7p2", "/baitap_jsp/chuong7p2_index.jsp");
		taskMap.put("chuong8", "/chuong8/emailList?action=join");
		// taskMap.put("chuong9p2", "/baitap_jsp/chuong9p2_index.jsp");
		taskMap.put("chuong12_sql", "/baitap_jsp/chuong12p1_index.jsp");
		taskMap.put("chuong13_jpa", "/chuong13/emailList?action=join");
		taskMap.put("chuong13_jpa_ex2", "/chuong13ex2/users?action=list_users");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String task = req.getParameter("task");
		if (task == null || task.isBlank()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing task parameter");
			return;
		}
		String target = taskMap.get(task);
		if (target == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown task: " + task);
			return;
		}
		// Use redirect so it opens cleanly (links already specify target="_blank")
		String contextPath = req.getContextPath();
		resp.sendRedirect(contextPath + target);
	}
}
