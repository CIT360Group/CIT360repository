package com.example.mathapp;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import android.os.Handler;
import android.os.Message;



public class FruitRunnable implements Runnable{
  
	
	
	@Override
	public void run() {
		
		try { 
			Socket toServer = new Socket("10.0.2.2", 1111);
			final JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
			final JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
			String request = "newFruitProblem";
			outToServer.writeObject(request); 
			ArrayList<Picture> chosenPictures = (ArrayList<Picture>)inFromServer.readObject();
			
			Handler hand = FruitActivity.hand;
			final Message message = new Message();
			message.what = 1;
			message.obj = chosenPictures;
			hand.sendMessage(message);
			} 
		
		catch (UnknownHostException e) {
			System.out.println("Unknown Host");
			//responseView.setText("Unknown Host");
			e.printStackTrace();
		}
		catch (JSONException e) {
			e.printStackTrace(); 
			//responseView.setText("Error: Unable to trade beans with server.");
			System.out.println("Error: Unable to trade beans with server.");
			}
			
		catch(Exception e){ 
			e.printStackTrace(); 
			//responseView.setText("Error: Unable to communicate with server. "+e.getLocalizedMessage());
			System.out.println("Mysterious problem");
			}
		System.out.println("The connection on the client side is now dones");
	}



}
