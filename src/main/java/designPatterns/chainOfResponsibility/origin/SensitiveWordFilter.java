package designPatterns.chainOfResponsibility.origin;

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

}
