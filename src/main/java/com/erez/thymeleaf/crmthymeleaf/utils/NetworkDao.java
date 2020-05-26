package com.erez.thymeleaf.crmthymeleaf.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.springframework.stereotype.Component;




import retrofit2.Retrofit;



@Component
public class NetworkDao {
	
	   
	
	public String requetToJsonString(String endpoint) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		
		
		
		//Open http Connection
		URL url = new URL(endpoint);
		HttpURLConnection urlConnection = (HttpURLConnection)   url.openConnection();
		
		try {
			// Stream in the bytes
			InputStream   inputStream   =  urlConnection.getInputStream();
			BufferedInputStream  bufferedInputStream = new BufferedInputStream(inputStream);

			// read the bytes as characters 
			InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
			BufferedReader  bufferedReader = new BufferedReader(inputStreamReader);

			String inputLine = bufferedReader.readLine();
			while(inputLine != null) {
				sb.append(inputLine);
				inputLine = bufferedReader.readLine();

			}

		}finally {
			urlConnection.disconnect();
		}

		return sb.toString();
	}
	
	
	public Retrofit fetch(String searchFilter)throws Exception{
		
		 Retrofit.Builder builder   = new Retrofit.Builder().baseUrl("http://localhost:8080/customers");
		 Retrofit retrofit = builder.build();
		return retrofit;
		
	}

}
