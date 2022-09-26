package com.innobitsystems.simulator.ipisSimulator.Ha;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class ReceivingHeartBeats extends TimerTask {

	Ha_Initialization ti = new Ha_Initialization();

	public String receiveHeartBeat(int receiverPort) throws Exception {

		try {

			DatagramSocket serverSocket = new DatagramSocket(receiverPort);

			byte[] receivingDataBuffer = new byte[1024];

			DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);

			serverSocket.receive(inputPacket);

			String receivedData = new String(inputPacket.getData());

			System.out.println("recived from the other machine: " + receivedData);

			serverSocket.close();

			return receivedData;

		}

		catch (SocketException e) {

			return e.toString();
		}
	}

	public void switchover() throws Exception {
		ti.changeMsg("SendingMsg", "m");

		ti.configureVip(ti.adapter_name, ti.virtual_ip, ti.subnet_mask, ti.gateway, ti.dns1, ti.dns2);

		ti.portForwarding(ti.listen_address, ti.listen_port, ti.connect_address, ti.connect_port);

		System.out.println("switch over become master");

	}

	public void timeout() throws Exception {
		try {

			ExecutorService executor = Executors.newCachedThreadPool();

			Callable<Object> task = new Callable<Object>() {
				public Object call() throws Exception {
					try {
						return receiveHeartBeat(ti.receiver_port);
					} catch (Exception e) {
						return e;
					}
				}
			};

			Future<Object> future = executor.submit(task);

			try {

				Object result = future.get(ti.timer_value, TimeUnit.SECONDS);

			} catch (TimeoutException ex) {
				switchover();

			} catch (InterruptedException e) {
				throw new Exception( e.toString());
			} catch (ExecutionException e) {
				throw new Exception(e.toString());

			} finally {
				future.cancel(true);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			
			timeout();
//			String[] command = { "cmd", };
//			Process process;
//			
//				process = Runtime.getRuntime().exec(command);
//				new Thread(new SyncPipe(process.getErrorStream(), System.err)).start();
//				new Thread(new SyncPipe(process.getInputStream(), System.out)).start();
//				PrintWriter stdin = new PrintWriter(process.getOutputStream());
//				stdin.println("mkdir C:\\Users\\innobit\\Documents\\backup\\newfolder");
			
			Process process = Runtime.getRuntime().exec("pg_basebackup -h 192.168.2.3 -p 5432 -U postgres -D \"C:\\Program Files\\PostgreSQL\\14\\data\" -Fp -Xs -R");
			 
		    BufferedReader reader = new BufferedReader(
		            new InputStreamReader(process.getInputStream()));
		    String line;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		 
		    reader.close();
		    ProcessBuilder builder = new ProcessBuilder(
		            "cmd.exe", "/c", "cd \"C:\\Program Files\\PostgreSQL\\14\"  &&rmdir /s /q E:\\data ");
		        builder.redirectErrorStream(true);
		        Process p = builder.start();
		        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        String line1;
		        while (true) {
		            line1 = r.readLine();
		            if (line1 == null) { break; }
		            System.out.println(line1);
		        }
//		    }

			String msg = receiveHeartBeat(ti.receiver_port);

			char c = msg.charAt(0);
			System.out.println(c + "   106");
			switch (c) {
			case 'u':
				ti.unconfigureVip(ti.adapter_name, ti.virtual_ip, ti.subnet_mask, ti.gateway);
				if (ti.SendingMsg.equals("u") && ti.SendingMsg.equals("m")) {
					ti.configureVip(ti.adapter_name, ti.virtual_ip, ti.subnet_mask, ti.gateway, ti.dns1, ti.dns2);

					ti.portForwarding(ti.listen_address, ti.listen_port, ti.connect_address, ti.connect_port);

					ti.changeMsg("SendingMsg", "m");
				} else if (ti.default_pc.equals("s") && ti.SendingMsg.equals("u")) {
					ti.changeMsg("SendingMsg", "s");

				}

				break;
			case 'm':
				System.out.println("inside case m");
				ti.unconfigureVip(ti.adapter_name, ti.virtual_ip, ti.subnet_mask, ti.gateway);

				ti.changeMsg("SendingMsg", "s");
//				stdin.println("net stop postgresql-x64-14");
//				stdin.println("rmdir /s /q C:\\\\Program Files\\\\PostgreSQL\\\\14\\\\data");
//				stdin.println("mkdir C:\\\\\\\\Program Files\\\\\\\\PostgreSQL\\\\\\\\14\\\\\\\\data");
//				stdin.println("netsh interface pg_basebackup -h 192.168.2.3 -p 5432 -U postgres -D \"C:\\Program Files\\PostgreSQL\\14\\data\" -Fp -Xs -R");
//				stdin.println("net start postgresql-x64-14");



				break;

			case 's':

				ti.changeMsg("SendingMsg", "m");

				ti.configureVip(ti.adapter_name, ti.virtual_ip, ti.subnet_mask, ti.gateway, ti.dns1, ti.dns2);

				ti.portForwarding(ti.listen_address, ti.listen_port, ti.connect_address, ti.connect_port);
		


//				stdin.println("netsh interface ipv4 set dns " + adapter_name + " static " + dns1 + " primary");
//
//				stdin.println("netsh interface ipv4 add dns " + adapter_name + " " + dns2 + " index=2 ");

//				stdin.close();


				break;

			default: {
				System.out.println("141.........");
				if (ti.SendingMsg.equals("u")) {
					System.out.println("143.........");
					ti.unconfigureVip(ti.adapter_name, ti.virtual_ip, ti.subnet_mask, ti.gateway);
				} else if (ti.SendingMsg.equals("m")) {
					System.out.println("146.........");
					ti.configureVip(ti.adapter_name, ti.virtual_ip, ti.subnet_mask, ti.gateway, ti.dns1, ti.dns2);

				} else if (ti.SendingMsg.equals("s")) {
					System.out.println("150.........");
					ti.unconfigureVip(ti.adapter_name, ti.virtual_ip, ti.subnet_mask, ti.gateway);
				}
				break;
			}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
