package com.innobitsystems.simulator.ipisSimulator;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IpisSimulatorApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(IpisSimulatorApplication.class, args);
		
//TcpClient tcpClient = new TcpClient();
//String dataStr = "hi this is xlient";
//String serverData=" hi this is server";
//InetAddress ip = InetAddress.getByName("192.168.0.129");


//tcpClient.sendReceiveTcpMsg(serverData.getBytes(), ip, 5000);
//tcpClient.sendTcpMsg(dataStr.getBytes(), ip, 5000);
	}

}
