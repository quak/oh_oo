package com.websafari.droid;

import android.graphics.drawable.Drawable;

public class ArrayAdapterEntry {

	String title;
	String text;
	String path;
	String filename;
	String date;
	String sub_title;
	Drawable img;
	
	public ArrayAdapterEntry(String date, String title, String sub_title, String text, String path, String filename) {
		// TODO Auto-generated constructor stub
		this.title=title;
		this.text=text;
		this.path=path;
		this.filename=filename;
		this.date = date;
		this.sub_title = sub_title;
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
	
	public Drawable getImg() {
		return img;
	}

	public void setImg(Drawable img) {
		this.img = img;
	}

	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
