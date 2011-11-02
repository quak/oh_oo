package com.websafari.droid;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class comObject{
	
	private String path;
	private String filename;
	private String date;
	private ImageView iv;
	private Drawable d;
	private Context c;
	
	public comObject(String path, String filename, ImageView iv, Context c,String date) {
		// TODO Auto-generated constructor stub
		this.setPath(path);
		this.setFilename(filename);
		this.setIv(iv);
		this.setC(c);
		this.setDate(date);
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

	public ImageView getIv() {
		return iv;
	}

	public void setIv(ImageView iv) {
		this.iv = iv;
	}

	public Drawable getImg() {
		return d;
	}

	public void setImg(Drawable d) {
		this.d = d;
	}

	public Context getC() {
		return c;
	}

	public void setC(Context c) {
		this.c = c;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}
