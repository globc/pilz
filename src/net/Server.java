package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server implements Runnable{

	protected DatagramSocket socket;

	protected boolean running;
	
	public Server() {
		
		try {
			socket = new DatagramSocket(2222);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		running = true;
		
		new Thread(this).start();
	}
	
	@Override
	public void run() { /* listen */
		while (running) {
			try {
				byte[] buf = new byte[256];
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length); /* Packet for receiving */
				socket.receive(packet); /* Client's message copied to packet */
				
				process(packet);
				
				
			} catch (IOException e) {
				
			}
			
		}
		
		socket.close();
		
	}
	
	/* protocol */
	public void process(DatagramPacket packet) {
		byte[] buf = packet.getData();
		
		switch(buf[0]) {
		case 0:
			/* login - send acknowledgement */
			packet = new DatagramPacket(new byte[] {buf[1]}, 1, packet.getAddress(), packet.getPort()); /* Packet for sending */
			
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void stop() {
		this.running = false;
	}

}
