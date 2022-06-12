package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Province;

public class Text1 {
		public static void main(String[] args) throws JsonProcessingException {
			Province p = new Province();
			p.setId(1);
			p.setName("河北");
			p.setJiancheng("冀");
			p.setShenghui("石家庄");
			
			ObjectMapper om = new ObjectMapper();
			//writeValueAsString： 把参数的java对象转化为json格式的字符串
			String json = om.writeValueAsString(p);
			System.out.println(json);
		}
}
