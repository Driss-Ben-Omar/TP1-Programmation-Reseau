package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("-----------l'ai connect -----------");
		
		Socket s=new Socket("localhost", 1234);
		
		InputStream is=s.getInputStream();
		OutputStream os=s.getOutputStream();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("entrer un nombre entier");
		
		os.write(scanner.nextInt());
		
		System.out.println("j'attend la reponse de mon request ");
		
		int result=is.read();
		
		if(result==0)
		{
			System.out.println("le nombre qui envoie est paire ");
		}
		else
		{
			System.out.println("le nombre qui envoie est impair");
		}
	}
}
