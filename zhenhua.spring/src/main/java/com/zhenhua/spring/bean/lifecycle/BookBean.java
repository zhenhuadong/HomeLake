package com.zhenhua.spring.bean.lifecycle;

public class BookBean {

	private String bookName = null;
	
	public BookBean() {
		System.out.println("?th: BookBean");
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
		System.out.println("?th: setBookName");
		
	}
	
	public void bookBeanInitMethod() {
		System.out.println("?th: bookBeanInitMethod");
	}
	
	public void bookBeanDestroyMethod() {
		System.out.println("?th: bookBeanDestroyMethod");
	}

}
