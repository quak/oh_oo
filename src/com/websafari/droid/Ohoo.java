package com.websafari.droid;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Ohoo extends ListActivity {
    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int limit = 10;
        int start = 5;
        
        /*JSON Objekt holen*/
        JSONObject jobj=null;
		Comm com = new Comm();
		com.setC(this);
		com.execute(new String[] {"http://web27.dev.websafari.eu/cms/index.php?id=1&eID=wsjson&action=tt_news&limit="+limit+"&start="+start});
		
    }
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		Object o = this.getListAdapter().getItem(position);
		String keyword = o.toString();
		Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_LONG).show();
	}
}