package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class MyServlet extends HttpServlet {

	private static final long	serialVersionUID	= 7722079853885256436L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();

		pw.println("<html>" + //
				"<head>" + //
				"<style>" + //
				"table,th,td" + //
				"{" + //
				"border:1px solid black;" + //
				"border-collapse:collapse;" + //
				"}" + //
				"</style>" + //
				"</head>" + //
				"<body>");

		pw.print("" //
				+ "<h1>TEST SERVLET</H1>" //
				+ "jsessionid=" + req.getSession().getId() + "<br />" //
				+ "host=" + req.getServerName() + "<br />" //
				+ "port=" + req.getServerPort() + "<br />" //
				+ "path=" + req.getServletPath() + "<br />" //
				+ "env=<br /><table><tr><th>key</th><th>value</th></tr>");
		for (Map.Entry<String, String> e : System.getenv().entrySet()) {
			pw.println("<tr><td>" + e.getKey() + "</td><td>" + e.getValue() + "</td></tr>");
		}
		pw.println("</table><br /><br />");

		pw.println("props=<br /><table><tr><th>key</th><th>value</th></tr>");
		for (Map.Entry<Object, Object> e : System.getProperties().entrySet()) {
			pw.println("<tr><td>" + e.getKey() + "</td><td>" + e.getValue() + "</td></tr>");
		}
		pw.println("</table></body></html>");

	}
}
