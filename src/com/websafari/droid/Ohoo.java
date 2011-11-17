package com.websafari.droid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ohoo extends ListActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        int limit = 30;
        int start = 80;
        
        /*JSON Objekt holen*/
       
		Comm com = new Comm(this);
		com.setC(this);
		com.execute(new String[] {"http://web27.dev.websafari.eu/cms/index.php?id=1&eID=wsjson&action=tt_news&limit="+limit+"&start="+start});
		
    }
    
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		super.onListItemClick(l, v, position, id);
	
		ArrayAdapterEntry entry = (ArrayAdapterEntry)this.getListAdapter().getItem(position);

		String date = entry.getDate();
		String title = entry.getTitle();
		String sub_title = entry.getSub_title();
		String text = entry.getText();
		String img_path = entry.getFilename();
		
		Intent myIntent = new Intent(v.getContext(), news_singleview.class);
		
		myIntent.putExtra("title", title );
		myIntent.putExtra("sub_title", sub_title );
		myIntent.putExtra("date", date );
		myIntent.putExtra("text", text );
		myIntent.putExtra("img_path", v.getContext().getCacheDir()+"/"+img_path );
		
		startActivity(myIntent);
		
	}
}