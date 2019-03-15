package org.ssr.tech.premier.requestmodels;

import java.util.List;

public class AuthorCreate {
	
	private String name;
	
	private List<Long> bookIds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getBookIds() {
		return bookIds;
	}

	public void setBookIds(List<Long> bookIds) {
		this.bookIds = bookIds;
	}
	 
}
