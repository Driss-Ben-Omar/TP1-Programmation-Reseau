package server;

import java.net.ServerSocket;
import java.net.Socket;
import client.Conversation;

public class MultiThread extends Thread{
	
	private int nombreClient;
	
	public static void main(String[] args) 
	{
		new MultiThread().start();
	}

	@Override
	public void run() 
	{
		try 
		{
			ServerSocket ss=new ServerSocket(1221);
			System.out.println("le serveur est demmarer ");
			
			while (true) 
			{
				Socket socket=ss.accept();
				nombreClient++;
				new Conversation(socket,nombreClient).start();
			}
			
		} catch (Exception e) 
		{
			
		}
	}
	
}
