package kr.or.iei.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class AjaxTest4Servlet
 */
@WebServlet(name = "AjaxTest4", urlPatterns = { "/ajaxTest4.do" })
public class AjaxTest4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest4Servlet() {
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
		String memberId = request.getParameter("memberId");
		//3.비즈니스로직
		MemberService service = new MemberService();
		Member m = service.selectOneMember(memberId);
		//조회결과를 js가 인식할 수 있는 객체 형태로 변환(JSON통신)
		//HashMap<String, Object>
		JSONObject result = null;
		if(m != null) {
			result = new JSONObject();
			result.put("memberNo", m.getMemberNo());
			result.put("memberId", m.getMemberId());
			result.put("memberPw", m.getMemberPw());
			result.put("memberName", m.getMemberName());
			result.put("memberPhone", m.getMemberPhone());
			result.put("memberAddr", m.getMemberAddr());
			result.put("memberLevel", m.getMemberLevel());
			result.put("enrollDate", m.getEnrollDate());
		}
		System.out.println(m);
		//4.결과처리
		response.setCharacterEncoding("utf-8");
		//response.setContentType("application/json"); // 이게 없으면 그냥 String 형태로 들어옴
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
