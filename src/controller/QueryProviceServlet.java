package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProvinceDao;

public class QueryProviceServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			//获取去求参数
			String proid = req.getParameter("proid");
			String name = "默认无数据";
			//访问数据库，进行数据库查询
			if (proid !=null && !"".equals(proid.trim())) {
				//创建dao对象，调用它的方法
				ProvinceDao dao = new ProvinceDao();
				 name = dao.queryProviceNameById(Integer.valueOf(proid));
			}
			out.print(name);
			out.flush();
			out.close();
			
		}
}
