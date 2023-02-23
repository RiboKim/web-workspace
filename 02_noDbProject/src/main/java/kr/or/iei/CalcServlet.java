package kr.or.iei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet(name = "Calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		//getParameter는 string이라서 무조건!! 문자열로 들어온다 char oper로 받을 수가 없음
		String oper = request.getParameter("oper");
		//3.비즈니스로직(해당 서블릿이 처리해야할 작업)
		
		//int result;이렇게 하면 쓰레기값이 들어가는데 그러면 switch문에서 돌때
		//컴퓨터입장에서는 result에 아무것도 안들어가면 어떡해? 라고 생각함
		//그러니까 result에 값을 미리 넣어두던지 아니면 switch문에 default를 박던지 ㄱㄱ
		int result = 0;
		
		
		switch(oper) {
		//case 다음에는 붙이면 안됨 case 띄고 괄호는 대체로 안적고 비교할 값
		//switch는 이렇게 문자열 비교까지 해준다
		case "+":
			
				result = su1+su2;
				break;
		case "-":
			
				result = su1-su2;
				break;
		case "*":
			
				result = su1*su2;
				break;	
		case "/":
			
				result = su1/su2;
				break;
		case "%":
			
				result = su1%su2;
				break;
			}
		
		/*
		if(oper.charAt(0) == '+') {
			result = su1+su2;
		} else if(oper.charAt(0) == '-') {
			result = su1-su2;
		} else if(oper.charAt(0) == '*') {
			result = su1*su2;
		} else if(oper.charAt(0) == '/') {
			result = su1/su2;
		} else {
			result = su1%su2;
		}
		*/
		
		System.out.println(result);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>더하기 결과</title></head>");
		out.println("<body>");
		out.println("<style>h2{color:blue;}</style>");
		out.println("<h1>연산 결과</h1>");
		out.println("<hr>");
		out.println("<h2>"+su1+oper+su2+" = "+result+"</h2>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
