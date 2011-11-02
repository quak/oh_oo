package com.websafari.droid;

public class ArrayAdapterEntry {

	String title;
	String text;
	String path;
	String filename;
	String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayAdapterEntry(String date, String title, String text, String path, String filename) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.text=text;
		this.path=path;
		this.filename=filename;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
