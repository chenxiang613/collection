package designPatterns.chainOfResponsibility.target;

/**
 * @author Administrator
 *  敏感词过滤器
 */
public class SensitiveWordFilter implements Filter {

	@Override
	public void doFilter(Request request,FilterChain filterChain) {
		System.out.println("1 SensitiveWordFilter");
		request.getRequestStr().replaceAll("CNM", "");
		filterChain.doFilter4AllFilter(request, filterChain);
		System.out.println("2 SensitiveWordFilter");
	}

	@Override
	public void doFirst() {
		System.out.println("execute doFirst() SensitiveWordFilter");
		
	}

	@Override
	public void doEnd() {
		System.out.println("execute doEnd SensitiveWordFilter");
	}
}
