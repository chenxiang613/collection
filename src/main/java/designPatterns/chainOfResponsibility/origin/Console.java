package designPatterns.chainOfResponsibility.origin;

import java.util.ArrayList;
import java.util.List;

public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Request request = new Request("我CNM，我很爱中国<chenxiang> touring ");
		Response response = new Response("<jack> ");
		FilterChain filterChain = new FilterChain();
		List<Filter> filterList = new  ArrayList<Filter>();	
		filterList.add(new SymbolFilter());
		filterList.add(new SensitiveWordFilter());
		filterChain.setFilterList(filterList);
		filterChain.doFilter4AllFilter(request,filterChain);
		System.out.println(request.getRequestStr());		
	}

}
