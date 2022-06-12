package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BmiPrintServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收请求参数
		String strName=req.getParameter("name");
		String height = req.getParameter("h");
		String weight = req.getParameter("w");
		
		//计算bmi : bmi = 体重 / 身高的平方
		float h = Float.valueOf(height);
		float w = Float.valueOf(weight);
		float bmi = w / (h * h);
		
		//判断bmi的范围
		String msg = "";
		if(bmi <=18.5) {
			msg="您比较瘦";
		}else if (bmi > 18.5 && bmi <=23.9) {
			msg = "你的bmi是正常的";
		}else if (bmi >24 && bmi <=27) {
			msg= "你的身体比较胖";
		} else {
			msg = "你的身体太胖";
		}
		
		System.out.println("msg" +msg);
		
		msg = "尊敬的"+strName+"先生，您的身高是"+height+"，体重是"+weight+",你的bmi值是："+bmi+","+ msg;
		//使用HttpServletResponse输出数据
		resp.setContentType("text/html;charset=utf-8");
		//获取PrintWriter
		PrintWriter out = resp.getWriter();
		//输出数据
		out.println(msg);
		//清空缓存
		out.flush();
		//关闭close
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
