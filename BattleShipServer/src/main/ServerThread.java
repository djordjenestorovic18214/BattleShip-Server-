package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread {
	BufferedReader inStreamFromClient = null;
	PrintStream outStreamToClient = null;
	Socket communicationSocket = null;
	ServerThread[] players;
	ObjectInputStream inputStream;
	ObjectOutputStream outputStream;
	Player player;
	Move move;
	//constructor
	public ServerThread(Socket socket, ServerThread[] players) {
		communicationSocket = socket;
		this.players = players;
	}

	public void run() {
		
        
		try {
			inStreamFromClient = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
			outStreamToClient = new PrintStream(communicationSocket.getOutputStream());
			inputStream = new ObjectInputStream(communicationSocket.getInputStream());
			outputStream= new ObjectOutputStream(communicationSocket.getOutputStream());
			//receive starting position
			Object o = inputStream.readObject();
			player=(Player)o;
			
			// start of game
						while (true) {
							//outStreamToClient.println("•Your move: ");
							Object oo = inputStream.readObject();
							move=(Move) oo;
							//send move to opponent
							for(int i=0;i<2;i++){
								if(players[i]!=this)players[i].outputStream.writeObject(move);
							};
							//check the move
							if(hit(move)){ 
								players[0].outStreamToClient.println("HIT");
								players[1].outStreamToClient.println("HIT");
							}
							else{ 
								players[0].outStreamToClient.println("NOTHIT");
								players[1].outStreamToClient.println("NOTHIT");
							};
							
							if(destroyed(move)){ 
								players[0].outStreamToClient.println("DESTROYED");
								players[1].outStreamToClient.println("DESTROYED");
							}
							else{ 
								players[0].outStreamToClient.println("NOTDESTROYED");
								players[1].outStreamToClient.println("NOTDESTROYED");
							};
								

						if (end()) {
							players[0].outStreamToClient.println("END");
							players[1].outStreamToClient.println("END");
							break;}
						else{
							players[0].outStreamToClient.println("NOTEND");
						    players[1].outStreamToClient.println("NOTEND");
						}

							
						}
						communicationSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean end() {
		// TODO Auto-generated method stub
		boolean end1=true;
		boolean end2=true;
		for(Ship ship:players[0].player.startingPosition){
			for(Position p:ship.positions){
				if(!p.isHit()){
					end1=false;
					break;
				}
				}
			}
			
		for(Ship ship2:players[1].player.startingPosition){
			for(Position p2:ship2.positions){
				if(!p2.isHit()){
					end2=false;
				    break;
			}
			}
		}
		if(!end1&&!end2)return false;
		
		return true;
	}

	public boolean destroyed(Move move) {
		// TODO Auto-generated method stub
		boolean targetedShip=false;
		for(int i=0;i<2;i++){
			if(players[i]!=this){
				for(Ship ship:players[i].player.startingPosition){
					for(Position p:ship.positions){
						if((move.getIndexRed()==p.getRow()) &&(move.getIndexKolona()==p.getColumn())){ 
							targetedShip=true;
							break;
						}	
						
					}
					if(targetedShip){
						for(Position pos:ship.positions){
							if(!pos.isHit())return false;
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean hit(Move move) {
		for(int i=0;i<2;i++){
			if(players[i]!=this){
				for(Ship ship:players[i].player.startingPosition){
					for(Position p:ship.positions){
				if((move.getIndexRed()==p.getRow()) &&(move.getIndexKolona()==p.getColumn())){ 
					p.setHit(true);
					return true;
				}
				}
				}
			}
			}
		// TODO Auto-generated method stub
		return false;
	}
}
