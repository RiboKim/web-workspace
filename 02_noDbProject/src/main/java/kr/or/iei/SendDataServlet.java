package kr.or.iei;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendDataServlet
 */
@WebServlet(name = "SendData", urlPatterns = { "/sendData.do" })
public class SendDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String str = request.getParameter("str");
		//request.getParameter() : 무조건 문자열로 값을 읽어옴
		//숫자로 사용하고 싶은 경우 읽어온 문자열을 숫자로 변환(Wrapper 클래스 활용)
		//정상적인 숫자가 아닌 경우 숫자 변환과정에서 에러발생
		//->정규표현식으로 숫자가 맞는 경우에 서버로 전송하게 설정
		int num = Integer.parseInt(request.getParameter("num"));
		//radio는 선택된 input의 value가 넘어옴
		String gender = request.getParameter("gender");
		//checkbox는 동일한 name으로 값이 여러개 넘어올 수 있음
		//->동일한 자료형을 여러개 저장 -> 배열
		String[] hobby = request.getParameterValues("hobby");
		//select는 select 태그에 있는 name을 키 값으로
		//선택한 option의 value값이 넘어옴
		String age = request.getParameter("age");
		//hidden : 화면에서 보이지는 않지만 value에 있는 값이 전송됨
		String hiddenData = request.getParameter("hiddentData");
		//readonly : 화면에서 수정은 못하지만 value에 있는 값이 전송됨
		String input1 = request.getParameter("input1");
		//disalbed : 화면에서 수정을 못하고, 데이터 전송도 안함 활성화 되있는게 아니니까!!
		//활성화되있지 않다는거 => 키값이 없다는거 => null이 출력된다.
		String input2 = request.getParameter("input2");
		//textarea : 입력한 값을 전송
		String comment = request.getParameter("comment");
		//div : 데이터 전송을 할 수 없음
		String div = request.getParameter("test3");
		//submit 버튼이 소속되어있는 form태그 내부의 데이터만 전송
		//얘는 form태그 바깥에 있으니까 null이 나옴
		String input3 = request.getParameter("input3");
		
		System.out.println("str : "+str);
		System.out.println("num : "+num);
		System.out.println("gender : "+gender);
		for(int i=0;i<hobby.length;i++) {
			System.out.println("hobby : "+hobby[i]);
		}
		System.out.println("age : "+age);
		System.out.println("hiddenData : "+hiddenData);
		System.out.println("input1 : "+input1);
		System.out.println("input2 : "+input2);
		System.out.println("comment : "+comment);
		System.out.println("div : "+div);
		System.out.println("input3 : "+input3);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
