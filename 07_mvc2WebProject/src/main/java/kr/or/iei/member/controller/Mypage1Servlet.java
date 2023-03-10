package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class Mypage1Servlet
 */
@WebServlet(name = "Mypage1", urlPatterns = { "/mypage1.do" })
public class Mypage1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mypage1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		//3.비즈니스로직
		//마이페이지 화면에 필요한 데이터는 session 저장된 정보로 출력
		//->db작업없음
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/mypage1.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
