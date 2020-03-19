package GUI;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/*
 * GUI 프로그래밍으로 만들 수 있는 윈도우 프로그램은 외형 뿐만 아니라 프로그램의 구조면에서도 텍스트 모드의 프로그램과 다르다.
 * 예를 들어 텍스트 모드의 프로그램은 선형 구조로 작성할 수 있지만, 윈도우 프로그램의 경우에는 사용자의 입력을 받아서 처리하고, 그 다음에 또다시 사용자의 입력을 기다리는식의 순환구조로 작성해야 한다.
 * 윈도우 프로그램 에서는 언제 어떤 종류의 입력이 어떤 순서로 들어올지 알 수 없다.(사용자가 확인 버튼을 먼저 누를지 아니면 취소 버튼을 먼저 누를 지 알 수 없음)
 * 그래서 윈도우 프로그램에서는 사용자의 입력을 이벤트(event, 사건)라고 부른다.
 * 윈도우 프로그램은 텍스트 모드의 프로그램에 비해 상당히 복잡한 구조를 갖지만, 전체적인 흐름을 분석해보면 아래와 같이 네 단계로 나눌 수 있다.
 * 1. 윈도우를 구성한다. 2. 윈도우를 디스플레이 한다. 3. 입력을 받아서 그에 따라 메소드를 호출한다. 4. 입력을 처리하는 여러가지 메소드 들이 수행된다.
 * 네 단계중 3단계에 해당하는 로직은 jdk 라이브러리에 있기 때문에 프로그래머가 작성해야 할 필요가 없다.
 * 윈도우의 구성요소 : 프레임, 타이틀 바, content pane, 라벨(label)
 * 프레임(frame) : 윈도우 전체 - 프레임은 두 부분으로 구분되는데, 프로그램의 제목이 쓰여진 윗 부분을 타이틀 바(Title bar) 라고 하고 아래의 나머지 부분을 content pane 이라고 한다.
 * content pane : 프로그램에 필요한 데이터를 입력받거나, 프로그램의 실행 결과를 출력하는 부분. 해당 프로그램에서는 여기에 Hello, Java 라는 텍스트를 표시 했는데
 * 이 부분을 라벨(label) 이라고 부른다.
 * 이렇게 윈도우를 구성하는 여러 가지 구성요소 들을 통틀어 컴포넌트(Component) 라고 부른다.(프레임, 타이틀 바, content pane, label 은 모두 컴포넌트이다.)
 */
public class WindowExample1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Java Program");
		frame.setLocation(500, 400); //윈도우의 위치를 바꾸는 메소드, JFrame class 의 setLocation method 
		//파라미터로 넘겨준 것은 픽셀 단위의 좌표이다.(x(300) - 가로, y(200) - 세로)
		frame.setPreferredSize(new Dimension(300, 200)); //윈도우의 크기를 바꾸는 메소드, JFrame class 의 setPreferredSize method
		//300 - 넓이, 200 - 높이
		//이 메소드는 Dimension 타입의 파라미터만 받는 메소드이기 때문에, 윈도우의 크기를 위와 같이 Dimension 객체로 만들어서 넘겨줘야 한다.
		//Dimension 은 java.awt 패키지에 속하는 클래스이다.
		/*
		 * 생성한 JFrame 객체는 프레임이 된다, 프레임을 생성하면 그에 부속된 타이틀 바와 content pane 도 자동으로 만들어지기 때문에 따로 만들 필요가 없다.
		 * 하지만 생성자 파라미터 없이 프레임을 만들면 타이틀 바에 프로그램 이름이 표시되지 않기 때문에, 타이틀 바에 "Hello Java Program" 이라는 이름이 표시되도록 하려면, 
		 * 생성자 파라미터로 이 이름을 넘겨줘야 한다.
		 */
		Container contentPane = frame.getContentPane();
		/*
		 * 여기서 사용한 Container 타입은 java.awt 패키지에 속하는 클래스 이름이다.
		 * 이 클래스에는 add 라는 메소드가 있는데, 이 메소드를 이용하면 앞에서 만든 라벨을 content pane 위에 올려놓을 수 있다.
		 */
		JLabel label = new JLabel("Hello, Java", SwingConstants.CENTER);
		//JLabel class 로 만든 라벨은 기본적으로 텍스트를 왼쪽에 표시하는데, JLabel 객체를 생성할 때 두번째 파라미터로 위와 같은 값을 넘겨주면 라벨의 위치가 중앙에 오게 된다.
		//여기서 사용한 SwingConstants 라는 이름은 javax.swing 패키지에 속하는 클래스 이름이다.
		//이 클래스에서는 여러가지 상수들이 정의되어 있는데, 위에서 사용한 CENTER 라는 이름도 그 중 한 상수의 이름이다.
		/*
		 * 라벨을 만들때는 javax.swing.JLabel class 를 이용해서 만들 수 있다.
		 * 그런데 이렇게 생성된 라벨은 content pane 과는 아무런 관련이 없기 때문에, 이 라벨을 content pane 위에 올려놓는 작업이 필요하다.
		 * 그런 일을 하기 위해서는 먼저 JFrame 에 종속된 content pane 을 가져와야 하는데, 그런 일은 프레임에 대해 getContentPane method 를 호출해서 할 수 있다.(28행) 
		 */
		contentPane.add(label); //contentPane component 위에 label component 를 올려놓는다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// x 버튼을 눌렀을 때 윈도우가 닫혀지고 프로그램이 완전히 종료되도록 하려면 setDefaultCloseOperation method 를 호출한다.
		//여기서 파라미터로 사용한 JFrame.EXIT_ON_CLOSE 라는 이름은 JFrame class 에 선언되어 있는 EXIT_ON_CLOSE 라는 상수의 이름이다.
		// 이 상수는 글자 그대로 닫기(close) 버튼을 눌렀을 때 프로그램을 종료(exit) 하라는 의미를 갖는다.
		frame.pack();
		frame.setVisible(true);
		/*
		 * 프레임을 디스플레이 하면 그 위에 있는 컴포넌트 들도 자동으로 디스플레이 되기 때문에, 알아야 할 것은 단지 프레임의 디스플레이 방법 뿐이다.
		 * 하지만 프레임을 디스플레이 하기 전에 먼저 해야 할 일이 있다.
		 * 프레임에 부속된 컴포넌트 들의 크기에 맞게 프레임의 크기를 조정하는 일이다. - pack method 를 호출해서 할 수 있다.
		 * frame.pack(); - 프레임을 적절한 크기로 만드는 메소드
		 * pack method 를 호출하고 난 다음에는 setVisible method 를 호출해서 프레임을 디스플레이 할 수 있다.
		 * frame.setVisible(true); - 파라미터 값으로 true 를 넘겨주면 frame 을 디스플레이 한다.
		 */
	}
}
/*
 * 윈도우 프로그램의 컴포넌트를 만드는데 사용되는 클래스는 대부분 jdk 라이브러리의 javax.swing 패키지와 java.awt 패키지 안에 있다.
 * 이 중 java.awt 패키지는 jdk 의 최초 버전부터 있어왔던 패키지이고, javax.swing 패키지는 성능과 플랫폼 중립성을 고려하여 나중에 추가, 개선된 패키지이다.
 * 그렇기 때문에 이 두 패키지에 유사한 기능의 클래스가 있을 때에는javax.swing 패키지에 있는 것을 사용하는 것이 좋다.
 * 윈도우의 가장 밑바탕이 되는 프레임만 하더라도 java.awt.Frame class를 이용해서 만들수도 있고, javax.swing.JFrame class 를 이용해서 만들수도 있는데, 이 두 클래스 중에서는 JFrame class 를 사용하는 것이 좋다.
 */
