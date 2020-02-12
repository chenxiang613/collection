package designPatterns.chainOfResponsibility.origin;

public interface Filter {

	public void doFilter(Request request,FilterChain filterChain);
}
