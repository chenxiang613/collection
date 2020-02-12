package designPatterns.chainOfResponsibility.origin;

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

}
