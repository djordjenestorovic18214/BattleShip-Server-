package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static ServerSocket serverSocket;
	static ServerThread[] players = new ServerThread[2];
	
	public static void main(String[] args) {
		int port = 5533;
		
		if(args.length >0)
			port = Integer.parseInt(args[0]);
		
		Socket clientSocket = null;
		try {
			serverSocket = new ServerSocket(port);
	
				while (true) {
				clientSocket = serverSocket.accept();
				for (int i = 0; i < players.length; i++) {
					if(players[i]==null) {
						players[i]=new ServerThread(clientSocket, players);
						players[i].start();
						break;
					}
				}
			}
		}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}
