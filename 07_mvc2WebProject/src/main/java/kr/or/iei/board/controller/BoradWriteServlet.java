package kr.or.iei.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.board.model.service.BoardService;
import kr.or.iei.board.model.vo.Board;

/**
 * Servlet implementation class BoradWriteServlet
 */
@WebServlet(name = "BoradWrite", urlPatterns = { "/boardWrite.do" })
public class BoradWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoradWriteServlet() {
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
		
		//multipart/form-data(파일업로드)형식이면 데이터를 변환 후 출력
		// ->cos.jar 라이브러리를 이용(/WEB-INF/lib)폴더에 해당 라이브러리가 있어야함
		//2-1파일이 업로드될 경로를 지정
		//webapp폴더의 절대경로를 구하는 방법
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/board";
		//2-2.파일 업로드 최대용량 설정(일반적으로 웹은 10MB)
		int maxSize = 10*1024*1024; //10+키로바이트+메가바이트
		//2-3.multipart/form-data에서 데이터를 꺼내기 위한 객체 변환
		//request -> Multipartrequest 객체로 변환(cos.jar)
		//매개변수 5개를 전달하면 변환
		//1)request, 2)파일저장경로, 3)파일최대크기, 4)인코딩타입, 5)파일중복처리객체
		
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		//request -> MultipartRequest로 변환 완료
		//-> 파일 업로드가 완료되는 시점
		//입력정보를 추출(MultipartRequest에서 추출)
		String boardTitle = mRequest.getParameter("boardTitle");
		String boardWriter = mRequest.getParameter("boardWriter");
		String boardContent = mRequest.getParameter("boardContent");
		//실제로 첨부한 파일이름(중복처리 전 파일명)
		String fileName = mRequest.getOriginalFileName("upfile");
		//실제로 서버에 업로드된 파일이름(중복처리 후 파일명)
		String filePath = mRequest.getFilesystemName("upfile");
		Board b = new Board();
		b.setBoardTitle(boardTitle);
		b.setBoardWriter(boardWriter);
		b.setBoardContent(boardContent);
		b.setFileName(fileName);
		b.setFilePath(filePath);
		//3.비즈니스로직
		BoardService service = new BoardService();
		int result = service.insertBoard(b);
		//4.결과화면 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "작성성공");
			request.setAttribute("msg", "게시글이 작성되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "작성실패");
			request.setAttribute("msg", "오류가 발생했습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/boardList.do?requestPage=1");
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
