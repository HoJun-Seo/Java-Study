import java.awt.Container;

import javax.swing.JApplet;
/*
 * 애플릿으로 작동하는 그래픽 프로그램
 * HTML 문서 안에 애플릿을 포함 시키기 위해 사용하는 <applet></applet> 태그 사이에<param> 이라는 태그를 쓸 수 있다.
 * 이 태그의 용도는 HTML 문서가 애플릿으로 파라미터 값을 전달하기 위한 것이다.
 * <applet code = "BarGraphApplet.class" width = "500" height = "300">
 * 		<param name = "KOREAN" value = "100">
 * 		<param name = "ENGLISH" value = "85">
 * 		<param name = "MATH" value = "99">
 *		//애플릿 클래스에 전달되는 파라미터
 * </applet>
 * param 태그의 name = 다음에 오는 값은 파라미터의 이름이고, value = 다음에 오는 값은 파라미터의 값이다.
 * 이 파라미터 값은 애플릿 클래스 안에서 getParameter method 를 호출해서 가져 올 수 있다.
 * getParameter method 의 호출방법은 아래와 같다.
 * public class BarGraphApplet extends JApplet{
 * 		public void init(){
 * 			String str1 = getParamete("KOREAN");
 * 			String str2 = getParamete("ENGLISH");
 * 			String str3 = getParamete("MATH");
 * 			//HTML 문서에 있는 애플릿 파라미터를 가져오는 getParameter method
 * 		}
 * }
 */
public class BarGraphApplet extends JApplet{
	public void init() {
		int korean = Integer.parseInt(getParameter("KOREAN"));
		int english = Integer.parseInt(getParameter("ENGLISH"));
		int math = Integer.parseInt(getParameter("MATH"));
		//HTML 문서에 있는 param 태그의 값을 가져온다.
		Container contentPane = getContentPane();
		contentPane.add(new DrawingPanel(korean, english, math));
		//그림을 그리는 패널을 생성해서 애플릿에 추가한다. 
	}
}
