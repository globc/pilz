package net;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client implements Runnable{

	protected DatagramSocket socket;
	protected InetAddress serverIP;
	protected boolean running;
	
	public Client(String ip) {
		
		try {
			socket = new DatagramSocket();
			serverIP = InetAddress.getByName(ip);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		this.running = true;
		
		new Thread(this).start();
	}
	
	@Override
	public void run() { /* listen */
		while(running) {
			
		}
		
	}

}
