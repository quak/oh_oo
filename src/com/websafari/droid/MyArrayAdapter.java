package com.websafari.droid;

import android.app.Activity;
import android.content.Context;
import android.text.style.SubscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<Object> {
	private final Activity context;
	private final Object[] aae;

	
	public MyArrayAdapter(Activity context, Object[] aae) {
		super(context, R.layout.rowlayout, aae);
		this.context = context;
		this.aae = aae;
	
	}

	// static to save the reference to the outer class and to avoid access to
	// any members of the containing class
	static class ViewHolder {
		public ImageView thumbnail;
		public TextView date;
		public TextView title;
		public TextView subtitle;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// ViewHolder will buffer the assess to the individual fields of the row
		// layout

		ViewHolder holder;
		// Recycle existing view if passed as parameter
		// This will save memory and time on Android
		// This only works if the base layout for all classes are the same
		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.rowlayout, null, true);
			holder = new ViewHolder();
			holder.title = (TextView) rowView.findViewById(R.id.title);
			holder.thumbnail = (ImageView) rowView.findViewById(R.id.icon);
			holder.subtitle = (TextView) rowView.findViewById(R.id.subtitle);
			holder.date = (TextView) rowView.findViewById(R.id.datum);
			rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}
		String subtitle = ((ArrayAdapterEntry)aae[position]).getText();
		subtitle = subtitle.substring(0, 30);
		holder.subtitle.setText(subtitle);
		holder.title.setText(((ArrayAdapterEntry)aae[position]).getTitle());
		holder.date.setText(((ArrayAdapterEntry)aae[position]).getDate());
		
		loadImage li = new loadImage();
		comObject co = new comObject(((ArrayAdapterEntry)aae[position]).getPath(), ((ArrayAdapterEntry)aae[position]).getFilename(), holder.thumbnail, context,((ArrayAdapterEntry)aae[position]).getDate());
		li.execute(co);

		return rowView;
	}
}

			
