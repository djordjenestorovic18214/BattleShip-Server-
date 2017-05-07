package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
	BufferedReader inStreamFromClient = null;
	PrintStream outStreamToClient = null;
	Socket communicationSocket = null;
	ServerThread[] players;

	//constructor
	public ServerThread(Socket socket, ServerThread[] players) {
		communicationSocket = socket;
		this.players = players;
	}

	public void run() {
		String move;
		String name;

		try {
			inStreamFromClient = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
			outStreamToClient = new PrintStream(communicationSocket.getOutputStream());

			outStreamToClient.println("Type your name:");
			name = inStreamFromClient.readLine();
			outStreamToClient.println("You joined the game! \nType /exit if you want to leave!");
			
			for (int i = 0; i < players.length; i++) {
				if(players[i] !=null && players[i]!= this)
					players[i].outStreamToClient.println(name + "joined the game!");
			}
			// start of game
						while (true) {
							outStreamToClient.println("•Your move: ");
							move = inStreamFromClient.readLine();

							if (move.startsWith("/exit")) {
								outStreamToClient.println("•••Goodbye, hope to see you soon!•••");
								break;
							}

							for (int i = 0; i < players.length; i++) {
								if(players[i] !=null)
									players[i].outStreamToClient.println(name + " shot position " + move + "!");
							}	
						}
						communicationSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
