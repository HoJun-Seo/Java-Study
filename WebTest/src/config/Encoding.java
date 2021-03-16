package config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// url패턴(url-pattern) : ex) *.do, abc.do....
@WebFilter("/*") // 해당 url 로 들어오는 정보에 대해서만 인코딩을 수행한다.(/* 의 경우 모든 파일을 포함하는 패턴이다.)
public class Encoding implements Filter {

   
    public Encoding() {
        
    }


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터 메소드");
		request.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
