package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import Dao.CityBean;
import Dao.Impl.cityDaoImpl;
import net.sf.json.JSONArray;

public class cityServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		int id = Integer.parseInt(cid);
		request.setCharacterEncoding("utf-8");
		cityDaoImpl dao = new cityDaoImpl();
		try {
			String list = dao.findAllJson(id);
			//XStream xStream = new XStream();
			//xStream.alias("city", CityBean.class);
			//xStream.useAttributeFor(CityBean.class, "id");
			//String xml = xStream.toXML(list);
			//System.out.println("xml="+xml);
			
//			JSONArray jsonarray = JSONArray.fromObject(list);
//			String json = jsonarray.toString();
//			System.out.println("json="+json);
			response.setContentType("application;charset=utf-8");
			Writer out = response.getWriter();
			out.write(list);
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
