package com.example.listview;

public class Person implements CharSequence {
	
	private int img;
	private String name,course;
	public Person(int img, String name, String course) {
		super();
		this.img = img;
		this.name = name;
		this.course = course;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public char charAt(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public CharSequence subSequence(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
