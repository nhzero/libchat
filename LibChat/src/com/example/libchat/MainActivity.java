package com.example.libchat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		
		return true;
	}
	
	public void clickLogin(View view) throws URISyntaxException {
		
		String un= ((EditText) findViewById(R.id.EditText01)).getText().toString();
		String pass= ((EditText) findViewById(R.id.passConf)).getText().toString();
		String stuff = "http://192.168.1.2:8080/libchattest/login?username="+un+"&pass="+pass;
		if ( pass == "" || un == "") {
			return;
		}
		URL url;
	    HttpURLConnection connection = null;  
	    try {
	    	String urlParameters = "asdf";
	      //Create connection
	      url = new URL(stuff);
	      connection = (HttpURLConnection)url.openConnection();
	      connection.setRequestMethod("GET");

	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      //Send request
	      DataOutputStream wr = new DataOutputStream (
	                  connection.getOutputStream ());
	      wr.writeBytes (urlParameters);
	      wr.flush ();
	      wr.close ();

	      //Get Response
	      int responses = connection.getResponseCode();
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      StringBuffer response = new StringBuffer(); 
	      while((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');
	      }
	      rd.close();
	     

	    } catch (Exception e) {

	      e.printStackTrace();
	     

	    } finally {
	    
	      if(connection != null) {
	        connection.disconnect(); 
	      }
	    }
		
	}
	
	public void clickCreate(View view) {

		Intent intent = new Intent(this, CreateUserActivity.class);
		startActivity(intent);
		
	}

}
