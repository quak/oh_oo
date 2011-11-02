package com.websafari.droid;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;


import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class loadImage extends AsyncTask<comObject, Void, comObject>{
	
	@Override
	protected comObject doInBackground(comObject... co) {
	  
		try {	Drawable image=null;
	           
	         
	           	if(co[0].getIv()==null){
	           		Log.e("!","quak");
	           	}
				//URL url = new URL("http://web27.dev.websafari.eu/cms/uploads/pics/resized/ooe_fahne_01.jpg");
				URL url = new URL(co[0].getPath()+""+co[0].getFilename()); //you can write here any link
	            //File f = new File(Environment.getExternalStorageDirectory().toString()+"/"+co[0].getFilename());
				Log.e("!",co[0].getPath()+co[0].getFilename());

	            /* Open a connection to that URL. */
	            URLConnection ucon = url.openConnection();

	            InputStream is = ucon.getInputStream();

	            image = Drawable.createFromStream(is, "src");

//	            BufferedInputStream bis = new BufferedInputStream(is);
//	
//	            /*
//	             * Read bytes to the Buffer until there is nothing more to read(-1).
//	             */
//	            ByteArrayBuffer baf = new ByteArrayBuffer(50);
//	            int current = 0;
//	            while ((current = bis.read()) != -1) {
//	                    baf.append((byte) current);
//	            }
			
//	            /* Convert the Bytes read to a String. */
//	            f.createNewFile();
//	            FileOutputStream fos = new FileOutputStream(f);
//	            fos.write(baf.toByteArray());
//	            fos.close();
	            
	            co[0].setImg(image);
	            
	            return co[0];
		    } catch (IOException e) {
		          Log.e("loadImg", "Fail");
		    }

		return null;
	}
	
	@Override
	protected void onPostExecute(comObject co){
		


		co.getIv().setImageDrawable(co.getImg());
//		if(co.getIv()!=null)
//			co.getIv().setImageResource(R.drawable.up);
//		Toast.makeText(co.getC(), "yeah", Toast.LENGTH_LONG).show();
		//Toast.makeText(co.getC(), co.getImg().toString(), Toast.LENGTH_LONG).show();
		

		
	}
}