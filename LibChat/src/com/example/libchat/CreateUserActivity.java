package com.example.libchat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CreateUserActivity extends Activity {
	
	@Override
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_create);

	    }
	
	public void clickSubmit(View view) {
		
		String username = ((EditText) findViewById(R.id.username)).getText().toString();
		String pass=((EditText) findViewById(R.id.pass)).getText().toString();
		String passConf=((EditText) findViewById(R.id.passConf)).getText().toString();
		String email=((EditText) findViewById(R.id.email)).getText().toString();
		String emailConf=((EditText) findViewById(R.id.emailConf)).getText().toString();
		String stuff = "http://192.168.1.2:8080/libchattest/create?username="+username+"&pass="+pass+"&email="+email;
		if (!pass.equals(passConf) || !email.equals(emailConf)) {
			 TextView error = new TextView(view.getContext());
			 error.setText("password or emails do not match");
			 error.setId(111);
			 RelativeLayout mainLayout = (RelativeLayout) findViewById(R.layout.activity_create);
			 if( mainLayout != null) {
				 mainLayout.addView(error); 
			 }
			
		} else {
			URL url;
		    HttpURLConnection connection = null;  
		    try {
		    	String urlParameters = "asdf";
		      //Create connection
		      url = new URL(stuff);
		      connection = (HttpURLConnection)url.openConnection();
		      connection.setRequestMethod("POST");

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
		
		
	}

}
