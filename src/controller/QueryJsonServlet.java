package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ProvinceDao;
import entity.Province;

public class QueryJsonServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//默认值，{} ： 表示json格式的数据
		String json = "{}";
		//获取前端页面请求参数 获取id
		String strProid = req.getParameter("proid");
		//判断strProid有值时，调用dao查询数据
		if (strProid !=null && strProid.trim().length() > 0) {
			ProvinceDao dao = new ProvinceDao();
			Province p = dao.queryProviceById(Integer.valueOf(strProid));
			//需要使用jackson 把 Province对象转化为json字符串
			ObjectMapper om = new ObjectMapper();
			json = om.writeValueAsString(p);
		}
		//把获取到的数据，通过网络传给ajax中的异步对象，响应结果数据
		//指定服务器端（servlet)返回给浏览器的时json格式的数据
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
}
