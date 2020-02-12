package designPatterns.chainOfResponsibility.target;

/**
 * @author Administrator
 *  符号过滤器
 */
public class SymbolFilter implements Filter {
	
	
		
	@Override
	public void doFilter(Request request,FilterChain filterChain) {
		System.out.println("1 SymbolFilter");
		request.getRequestStr().replaceAll("<", "[")
						 .replace(">", "]");
		filterChain.doFilter4AllFilter(request, filterChain);
		System.out.println("2 SymbolFilter");
	}

	@Override
	public void doFirst() {
		System.out.println("execute doFirst() SymbolFilter");
		
	}

	@Override
	public void doEnd() {
		System.out.println("execute doEnd SymbolFilter");
	}

}
