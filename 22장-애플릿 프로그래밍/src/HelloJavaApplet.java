
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/*
 * 애플릿에 대하여 
 * 애플릿의 가장 큰 특성은 HTML 문서와 마찬가지로 웹 서버에 저장되고, HTML 문서의 일부로서 웹 브라우저에 전송되어 웹 브라우저 안에서 실행된다는 것이다.
 * 하지만 애플릿은 그 자체가 프로그램 이기 때문에 사용자의 키보드 입력과 마우스 입력에 대해 독자적으로 반응하거나 그에 대한 처리를 할 수 있다.
 * 애플릿은 웹 브라우저 안에서 복잡한 로직의 프로그램을 작동시켜야 할 필요가 있을 때 사용된다.(채팅 프로그램, 게임 프로그램)
 * 애플릿은 웹 서버에 설치해 놓기만 하면 전세계 어느 곳이든 웹 브라우저만 가지고 바로 실행할 수 있기 때문에, 전국적으로 또는 전 세계적으로 사원이 분포된 대규모 기업에서 인트라넷 프로그램용 으로도 사용하고 있다.
 * 애플릿은 웹 서버가 있어야만 제대로 작동한다.(아파치 등)
 */
public class HelloJavaApplet extends JApplet{
		public void init() {
			Container contentPane = getContentPane(); //애플릿의 content pane 을 가져온다.
			contentPane.add(new JLabel("Hello, Java", SwingConstants.CENTER)); //라벨을 생성해서 content pane 위에 추가한다.
		}
}
/*
 * 애플릿의 작성법(애플릿이 아닌 자바 프로그램들은 모두 자바 애플리케이션 이라고 한다.)
 * 애플릿으로 작동하는 Hello, Java 프로그램(19장에섶 학습했던 GUI 프로그래밍을 활용한다.)
 * 애플릿의 Hello, Java 라고 쓰여진 부분은 GUI 프로그램을 작성할 때 사용했던 JLabel class 를 가지고 만들 수 있다.
 * 애플릿 위에 JLabel 컴포넌트를 만들어서 올려놓는 방법 - 애플릿은 반드시 java.awt.Applet class 나 java.swing.JApplet class 를 상속받는 서브 클래스로 선언해야 한다.
 * 그리고 public class 로 선언해야 한다, 이 중 하나의 규칙만 지키지 않아도 웹 브라우저는 애플릿을 띄울 수 없다.
 * 위의 두 클래스 중 하나를 상속받는 서브 클래스를 선언하고 나면 그 다음은 애플릿에 라벨을 만들어서 추가해줘야 한다.
 * 그런데 그 라벨은 애플릿이 처음 나타날 때 부터 애플릿 위에 있어야 한다. - 라벨을 추가하는 일은 애플릿이 생성되자 마자 해야 한다.
 * 애플릿이 생성되고 나서 바로 다음에 해야 할 일은 애플릿 클래스(JApplet 또는 Applet 의 서브 클래스)에 init method 를 선언해두고 그 안에 쓰면 된다.
 * 이 메소드는 리턴 값과 파라미터가 없는 public 메소드로 선언해야 하기 때문에 아래와 같이 선언하면 된다.
 * public class HelloJavaApplet extends JApplet{
 * 		public void init(){
 * 			//애플릿이 생성되고 나서 해야 할 일은 이 메소드 안에 써야 한다.
 * 		}
 * }
 * 이렇게 선언된 init method 는 애플릿이 생성되고 난 다음에 자동으로 호출되기 때문에, 이 메소드 안에 있는 명령문도 그 때 실행된다.
 * 이 메소드 안에 라벨을 만들어서 애플릿 위에 올려놓는 명령문을 쓰면 된다.
 * JApplet class 에는 JFrame 과 마찬가지로 content pane 이 있다, 그 content pane 을 가져와서 그 위에 라벨을 추가하면 된다.
 * JApplet 의 content pane 을 사용하는 방법은 JFrame 의 경우와 마찬가지이기 때문에 해당 프로그램과 같이 만들수 있다.
 * 이렇게 만들어진 HelloJavaApplet.class 파일은 애플릿으로 사용될 수 있다.
 * 애플릿은 독자적으로는 웹 브라우저 안에서 실행 될 수 없고, 반드시 HTML 문서의 일부로서 실행되어야 한다.
 * 그렇기 때문에 이 애플릿을 HTML 문서의 일부로 만들어야 한다.
 * HTML 문서에 애플릿을 포함 시키는 일은 APPLET 태그를 사용해서 할 수 있다.
 * 아파치 웹 서버에 애플릿을 설치하려면, 애플릿의 클래스 파일과 HTML 문서를 document directory(웹 서버를 통해 제공되는 HTML 문서 등을 저장하는 디렉토리)에 복사해 놓기만 하면 된다.
 * 아파치 웹 서버의 document directory 는 htdocs 디렉토리 이니까 이 디렉토리에 앞에서 만든 애플릿과 HTML 문서를 복사한다.
 */
