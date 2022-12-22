package client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Conversation extends Thread
{
	private Socket socket;
	private int nombreClient;
	public Conversation(Socket socket,int nombreClient) 
	{
		this.nombreClient=nombreClient;
		this.socket=socket;
	}
	public Socket getSocket() 
	{
		return socket;
	}
	public void setSocket(Socket socket) 
	{
		this.socket = socket;
	}
	public int getNombreClient() 
	{
		return nombreClient;
	}
	public void setNombreClient(int nombreClient) 
	{
		this.nombreClient = nombreClient;
	}
	
	@Override
	public void run() 
	{
		try 
		{
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os,true);
			
			String ip=socket.getRemoteSocketAddress().toString();
			System.out.println("connexion de client numero "+nombreClient+
					"------l'adresse ip est "+ip);
			pw.println("salut le client numero "+nombreClient);
			
			while(true)
			{
				String request=br.readLine();
				System.out.println("le client "+ip+"a envoye une requete "+request);
				pw.println(request.length());
			}
		} catch (Exception e) 
		{
			
		}
	}
}