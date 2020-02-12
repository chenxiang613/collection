package designPatterns.chainOfResponsibility.origin;

import java.util.List;

/**
 * @author Administrator
 *  过滤器链条
 */
public class FilterChain {

	List<Filter> filterList = null;
	int index = 0;

	public List<Filter> getFilterList() {
		return filterList;
	}

	public void setFilterList(List<Filter> filterList) {
		this.filterList = filterList;
	}

	public void doFilter4AllFilter(Request request,FilterChain filterChain){
		if( index == filterList.size() )
			return;
		Filter filter = filterList.get(index);
		System.out.println(index);
		index ++;
		filter.doFilter(request,filterChain);
	}
}
