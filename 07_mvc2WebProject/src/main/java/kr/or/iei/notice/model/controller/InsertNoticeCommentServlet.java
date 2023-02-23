package kr.or.iei.notice.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.NoticeComment;

/**
 * Servlet implementation class InsertNoticeCommentServlet
 */
@WebServlet(name = "InsertNoticeComment", urlPatterns = { "/insertNoticeComment.do" })
public class InsertNoticeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		NoticeComment nc = new NoticeComment();
		nc.setNcContent(request.getParameter("ncContent"));
		nc.setNcWriter(request.getParameter("ncWriter"));
		nc.setNoticeRef(Integer.parseInt(request.getParameter("noticeRef")));
		nc.setNcRef(Integer.parseInt(request.getParameter("ncRef")));
		//3.비즈니스로직
		NoticeService service = new NoticeService();
		int result = service.insertNoticeComment(nc);
		//4.결과화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title","성공");
			request.setAttribute("msg", "댓글작성완료");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title","실패");
			request.setAttribute("msg", "댓글작성실패");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/noticeView.do?noticeNo="+nc.getNoticeRef());
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
