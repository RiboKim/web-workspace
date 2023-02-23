package kr.or.iei;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendData1Servlet
 */
@WebServlet(name = "SendData1.do", urlPatterns = { "/sendData1.do" })
public class SendData1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청하는 정보 한글 있는 경우 인코딩
		request.setCharacterEncoding("utf-8");
		//요청정보 중 전달된 데이터 추출
		///name=김건형     &      test=abc
		String name = request.getParameter("name");
		String test = request.getParameter("test");
		//없는 이름으로 데이터를 추출하면 null 리턴
		String data = request.getParameter("data");
		
		System.out.println("name : "+name);
		System.out.println("test : "+test);
		System.out.println("data : "+data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
