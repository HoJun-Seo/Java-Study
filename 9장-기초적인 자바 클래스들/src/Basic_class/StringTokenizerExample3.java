package Basic_class;

import java.util.StringTokenizer;

public class StringTokenizerExample3 {
	public static void main(String[] args) {
		StringTokenizer stok = new StringTokenizer("사과=10|초콜렛=3|샴페인=1", "=|", true);
		while(stok.hasMoreTokens()) {
			String token = stok.nextToken();
			if(token.equals("="))
				System.out.print("\t");
			else if(token.equals("|"))
				System.out.print("\n");
			else
				System.out.print(token);
		}
		// 토큰이 '=' 이면 탭 문자, '|' 이면 줄 바꿈 문자, 그 밖의 문자열이면 토큰을 출력한다. 
	}
}
