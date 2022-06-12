package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BmiServlet extends HttpServlet{
	@Override
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
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
