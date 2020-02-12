package designPatterns.chainOfResponsibility.target;

public interface Filter {

	public void doFilter(Request request,FilterChain filterChain);
	
	public void doFirst();
	
	public void doEnd();
	
	
}
