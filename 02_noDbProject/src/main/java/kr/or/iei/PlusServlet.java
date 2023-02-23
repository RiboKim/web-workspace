package kr.or.iei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlusServlet
 */
@WebServlet(name = "Plus", urlPatterns = { "/plus.do" })
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlusServlet() {
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
		//2.값 추출
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		//3.비즈니스로직(해당 서블릿이 처리해야할 작업)
		int result = num1+num2;
		//4.사용자 화면처리
		response.setContentType("text/html;charset=utf-8");
		//HTML을 작성하는 객체 생성
		PrintWriter out = response.getWriter();
		//결과화면 제작
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>더하기 결과</title></head>");
		out.println("<body>");
		out.println("<style>h2{color:blue;}</style>");
		out.println("<h1>더하기 결과</h1>");
		out.println("<hr>");
		out.println("<h2>"+num1+" + "+num2+" = "+result+"</h2>");
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
