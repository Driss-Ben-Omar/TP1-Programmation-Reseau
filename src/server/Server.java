package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{

	public static void main(String[] args) throws Exception 
	{
		ServerSocket ss=new ServerSocket(1234);
		System.out.println("--------------j'attend la connexin------------------");
		Socket s=ss.accept();
		System.out.println("le client "+s.getRemoteSocketAddress()+" est connecter ");
		
		InputStream is=s.getInputStream();
		OutputStream os=s.getOutputStream();
		
		System.out.println("--------------------j'attend la donne ------------------");
		int number=is.read();
		
		int result=number%2;
		
		os.write(result);
		s.close();
	}

}
