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
	ObjectInputStream inputStream=null;
	ObjectOutputStream outputStream=null;
	boolean readyStart=false;
	Player player;
	Move move;

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
			if(players[0]==this)players[0].outStreamToClient.println("FIRST");
			if(players[1]==this){
				players[1].outStreamToClient.println("SECOND");
				players[0].outStreamToClient.println("NOW");
				
			}
			Object o = inputStream.readObject();
			player=(Player)o;
			String ready=inStreamFromClient.readLine();
			if(ready.startsWith("Ready"))readyStart=true;
			
			for(int i=0;i<2;i++){
				if(players[i]!=this){
					if(players[i].readyStart){
						
						outStreamToClient.println("Ready");
				
						players[i].outStreamToClient.println(player.getName());
						outStreamToClient.println(players[i].player.getName());
					}else
						outStreamToClient.println("NotReady");
				}
			}
			
			// start of game
						while (true) {								
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
								
							
								
								Ship ship=destroyedShip(move);
								for(int i=0;i<2;i++){
									if(players[i]==this){
									String response=players[i].inStreamFromClient.readLine();
										players[i].outputStream.writeObject(ship);
										players[i].outputStream.flush();
									}
									
								}
								
								
								
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
			System.exit(0);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Ship destroyedShip(Move move2) {
		for(int i=0;i<2;i++){
			if(players[i]!=this){
		for(Ship ship:players[i].player.startingPosition){
			for(Position p:ship.positions){
				if(p.getColumn()==move2.getIndexKolona()&&p.getRow()==move2.getIndexRed())return ship;
			}
		}
			}
		}
		return null;
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
		return false;
	}
}
