package lab3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Impl.userDaoImpl;

public class checkNameServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		userDaoImpl Dao = new userDaoImpl();
		response.setCharacterEncoding("UTF-8");
		try {
			System.out.println("name="+name);
			boolean isExist = Dao.checkName(name);
			if (isExist) {
				System.out.println(1);
				response.getWriter().write("1");
			} else {
				response.getWriter().write("2");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
