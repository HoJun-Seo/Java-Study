import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//아파치 웹 서버 연동시 jdbc Driver class 를 인식하지 못하여 ClassNotFoundException 이 발생한다.
/*
 * 만약 MYSQL 서버와 아파치 웹 서버가 서로 다른 컴퓨터에 설치되어 있다면 이 애플릿은 정상적으로 작동하지 않게 된다.
 * -> 애플릿에서 사용하는 데이터베이스는 반드시 애플릿이 있는 웹 서버와 동일한 컴퓨터에 있어야 한다는 규칙 때문이다.
 * 애플릿에 대한 이런 제약은 비단 데이터베이스 서버 뿐만 아니라 모든 서버 프로그램의 경우에 마찬가지로 적용된다.
 * 애플릿에는 그밖에도 몇몇 제약이 더 있는데, 아래는 그런 제약들을 모아서 정리해 놓은 것이다.
 * - 애플릿으로 할 수 없는 일
 * 1. 웹 서버와 다른 IP 주소의 컴퓨터에 있는 데이터베이스 서버에 연결할 수 없다.
 * 2. 웹 서버와 다른 IP 주소의 컴퓨터에 있는 서버 프로그램에 연결 할 수 없다.
 * 3. 애플릿이 실행되고 있는 로컬 컴퓨터에 파일을 읽거나 쓸 수 없다.
 * 4. 애플릿이 실행되고 있는 로컬 컴퓨터에서 새로운 프로그램의 실행을 시작할 수 없다.
 * 5. 애플릿이 실행되고 있는 로컬 컴퓨터에서 자바가 아닌 다른 언어로 작성된 라이브러리의 코드를 실행 할 수 없다.
 * 
 * 애플릿에 이런 제약을 부여한 이유는 나쁜 의도를 가진 프로그래머가 해킹용 애플릿을 만들어서 사용자의 컴퓨터를 해킹하는 것을 방지하기 위해서이다.
 * 하지만 이런 제약은 정적 그런 기능을 필요로 할 경우에도 애플릿으로 구현 할 수 없기 때문에 불편함을 초래할 수도 있다.
 * 그래서 자바에서는 사용자의 확인을 거쳐서 특정 애플릿만 이런 제약 없이 사용할 수 있도록 하는 방법도 제공 하고 있다.
 */
public class GoodsinfoFinderApplet extends JApplet{
	public void init() {
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();
		JTextField text = new JTextField(30);
		JButton button = new JButton("검색");
		panel.add(new JLabel("상품명"));
		panel.add(text);
		panel.add(button);
		contentPane.add(panel, BorderLayout.NORTH);
		String colNames[] = {"상품 코드", "상품명", "단가", "제조사"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		//애플릿 생성
		button.addActionListener(new SearchActionListener(table, text)); //검색 버튼의 리스너 등록
	}
}
