package lab3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import Util.JDBCUtil02;

public class DemoServlet01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("收到请求...");
		

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name + age);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("收到请求...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("收到请求post...");
		doGet(request, response);
	}

}
