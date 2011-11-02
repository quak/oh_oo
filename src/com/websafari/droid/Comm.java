package com.websafari.droid;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.LinkedList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.R;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class Comm extends AsyncTask<String, Void, JSONObject>{
	
	ListActivity a = null;
	
	@Override
	protected JSONObject doInBackground(String... urls) {
		
		/*######START: get JSONObject######*/
		JSONObject ret_jobj=null;
		
	    try {
	        HttpClient client = new DefaultHttpClient();
	        HttpGet request = new HttpGet();
	        request.setURI(new URI(urls[0]));
	        HttpResponse response = client.execute(request);
	        InputStream ips  = response.getEntity().getContent();
	        BufferedReader buf = new BufferedReader(new InputStreamReader(ips,"UTF-8"));

	        StringBuilder sb = new StringBuilder();
	        String s;
	        while(true )
	        {
	            s = buf.readLine();
	            if(s==null || s.length()==0)
	                break;
	            sb.append(s);

	        }
	        buf.close();
	        ips.close();
	        
	        ret_jobj = new JSONObject(sb.toString());
	        
	        return ret_jobj;	

	        } 
	    catch(Exception e) {
	               // Exception Code
	    }
	    

	    return ret_jobj;
	}
	
	public ListActivity getC() {
		return a;
	}

	public void setC(ListActivity a) {
		this.a = a;
	}

	@Override
	protected void onPostExecute(JSONObject result){
        int i=0;
       
        LinkedList<ArrayAdapterEntry> ll = new LinkedList<ArrayAdapterEntry>();
        
        try {
        	JSONObject jobj_entry;
			for(i=0;i<10;i++){
				
				jobj_entry = result.getJSONObject("entry"+i);
				ll.add(new ArrayAdapterEntry(jobj_entry.getString("datetime"),jobj_entry.getString("title"),jobj_entry.getString("short"), "http://web27.dev.websafari.eu/cms/uploads/pics/resized/", jobj_entry.getString("image")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
        Object[] aae = ll.toArray();
		
		a.setListAdapter(new MyArrayAdapter((Activity)a, aae));

		
		
	}
	
	
	

}
