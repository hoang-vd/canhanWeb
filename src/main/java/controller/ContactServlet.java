package controller;

import util.ResendEmailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContactServlet", urlPatterns = {"/contact"})
@MultipartConfig
public class ContactServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=UTF-8");

		String name = trim(req.getParameter("name"));
		String comment = trim(req.getParameter("comment"));

		// Chỉ cần có ít nhất 1 ký tự chữ hoặc số trong mỗi trường
		if (!hasContent(name) || !hasContent(comment)) {
			writeJson(resp, 400, "Vui lòng nhập ít nhất 1 ký tự cho Họ tên và Nội dung.");
			return;
		}

		String safeComment = escapeHtml(comment).replace("\n", "<br/>");
		String htmlBody = "<p><strong>Liên hệ mới</strong></p>" +
				"<p><b>Tên:</b> " + escapeHtml(name) + "</p>" +
				"<p><b>Nội dung:</b><br/>" + safeComment + "</p>";

			try {
				boolean sent = ResendEmailUtil.send(
						"onboarding@resend.dev", // from sandbox / change to verified domain
						"vdh.hoang06@gmail.com",
						"Contact message from " + name,
						htmlBody
				);
				if (sent) {
					writeJson(resp, 200, "Gửi thành công! Thank you.");
				} else {
					writeJson(resp, 502, "Không gửi được email (kiểm tra RESEND_API_KEY hoặc quota).");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				writeJson(resp, 500, "Lỗi máy chủ: " + ex.getClass().getSimpleName());
			}
	}

	private void writeJson(HttpServletResponse resp, int status, String message) throws IOException {
		resp.setStatus(status);
		try (PrintWriter out = resp.getWriter()) {
			out.write("{\"message\":\"" + jsonEscape(message) + "\"}");
		}
	}

	private String trim(String s) { return s == null ? null : s.trim(); }

	private boolean hasContent(String s) {
		if (s == null) return false;
		// Chấp nhận nếu có ít nhất 1 ký tự chữ hoặc số (kể cả chữ tiếng Việt có dấu)
		return s.codePoints().anyMatch(cp -> Character.isLetterOrDigit(cp));
	}

	private String jsonEscape(String s) {
		return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}

	private String escapeHtml(String s) {
		return s.replace("&", "&amp;")
				.replace("<", "&lt;")
				.replace(">", "&gt;")
				.replace("\"", "&quot;")
				.replace("'", "&#39;");
	}
}
