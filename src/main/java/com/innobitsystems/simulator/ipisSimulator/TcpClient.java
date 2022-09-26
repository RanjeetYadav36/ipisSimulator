package com.innobitsystems.simulator.ipisSimulator;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * This program is a socket client application that connects to a time server to
 * get the current date time.
 *
 * @author www.codejava.net
 */
public class TcpClient {

	public static void sendTcpMsg(byte[] data, String ipAddress, int portNumber) throws Exception {

		try {

			InetAddress ip = InetAddress.getByName(ipAddress);

			Socket s = new Socket(ip, portNumber);

			DataOutputStream dout = new DataOutputStream(s.getOutputStream());

			String str1 = "hii this is client";
			String str2 = "";

//	            while (!str1.equals("stop")) {
			
			List <byte[]> finalList =  new ArrayList<>();
//			-86,-52,5,86,1,101,0,102,1,-127,2,1,80,80,1,1,1,33,0,-2,-2,-1,0,57,0,49,0,50,0,56,0,-2,-1,0,65,0,115,0,104,0,114,0,97,0,109,0,32,0,69,0,120,0,112,0,114,0,101,0,115,0,115,0,-2,-1,0,49,0,50,0,58,0,53,0,50,0,-2,-1,0,65,0,-2,-1,0,51,0,-1,-1,3,1,-35,4,end received
//			-86,-52,5,86,1,101,0,102,1,-127,2,1,80,80,1,1,1,33,0,-2,-2,-1,0,57,0,49,0,50,0,56,0,-2,-1,0,65,0,115,0,104,0,114,0,97,0,109,0,32,0,69,0,120,0,112,0,114,0,101,0,115,0,115,0,-2,-1,0,49,0,50,0,58,0,53,0,50,0,-2,-1,0,65,0,-2,-1,0,51,0,-1,-1,3,1,-35,4,end received

			byte[] test = {-2,-1,0,57,0,49,0,50,0,56,-2,-1,0,65,0,115,0,104,0,114,0,97,0,109,0,32,0,69,0,120,0,112,0,114,0,101,0,115,0,115,-2,-1,0,49,0,50,0,58,0,53,0,50 ,-2,-1,0,65,-2,-1,0,51
};
			
			byte[] rece= {-86,-52,5,88,1,101,0,102,1,-127,2,1,80,80,1,1,1,33,0,-2,-2,-1,0,57,0,49,0,51,0,55,0,-2,-1,0,65,0,78,0,86,0,84,0,32,0,77,0,65,0,85,0,32,0,83,0,70,0,32,0,69,0,88,0,80,0,-2,-1,0,49,0,50,0,58,0,51,0,48,0,-2,-1,0,65,0,-2,-1,0,49,0,-1,-1,3,107,83,4};
			byte[] recev= {80,80,1,1,1,33,-2,-1,0,65,0,78,0,86,0,84,0,32,0,77,0,65,0,85,0,32,0,83,0,70,0,32,0,69,0,88,0,80,0};
			byte[]trainNo= {-2 ,-1 ,0 ,57 ,0 ,49 ,0 ,50 ,0 ,56 };
			
			byte[] byteStr = {-2 ,-1 ,0 ,57 ,0 ,49 ,0 ,50 ,0 ,56, -2, -1, 0, 83, 0, 97, 0, 116, 0, 121, 0, 97, 0, 103, 0, 114, 0, 97, 0, 104, 0, 97, 0, 32,
					0, 69, 0, 120, 0, 112, 0, 114, 0, 101, 0, 115, 0, 115,-2 ,-1 ,0 ,56, 0, 58, 0, 51, 0 ,48 ,-2, -1 ,0 ,49};
			
			byte[] byteStr1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 9, 5, 0, 0, -2, -1, 0, 50, 0, 52, 0, 56, 0, 53,
					-2, -1, 0, 78, 0, 97, 0, 110, 0, 100, 0, 101, 0, 114, 0, 32, 0, 72, 0, 97, 0, 122, 0, 114, 0, 97, 0,
					116, 0, 32, 0, 78, 0, 105, 0, 122, 0, 97, 0, 109, 0, 117, 0, 100, 0, 100, 0, 105, 0, 110, -2, -1, 0,
					49, 0, 48, 0, 58, 0, 48, 0, 50, -2, -1, 0, 65, -2, -1, 0, 50, -1, -1 ,-2, -1 ,0 ,49 };
			
			byte[] strbyte= {-2,-2,-1,0,57,0,49,0,51,0,55,0};

			finalList.add(trainNo);
			
			finalList.add(strbyte);
	 
			 
			byte[] byteList ;
			
//			for(int k=0;k<finalList.size();k++) {
//				byteList[k]=finalList.
//			}
			
			//0xE700
			dout.write(test);
			dout.flush();
//	                str2 = din.readUTF();
			
//	            }

			dout.close();
			s.close();

		} catch (Exception e) {

			throw new Exception();

		}

	}

	public static void main(String[] args) throws Exception {

		sendTcpMsg(null, "192.168.0.102", 5000);
	}

}