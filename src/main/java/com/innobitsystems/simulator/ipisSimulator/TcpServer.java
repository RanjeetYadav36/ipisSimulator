package com.innobitsystems.simulator.ipisSimulator;

// A Java program for a Server
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.Color;
import java.io.*;

public class TcpServer {
	public static List<Byte> listStr = new ArrayList<>();
	public static List<Byte> listStrcopy = new ArrayList<>();

	public static byte[] dataRecived;
	public static List<byte[]> dataR = new ArrayList<byte[]>();

	public static String receivingMsg(int port) throws Exception {
		ServerSocket sc = new ServerSocket(port);
		Socket ss = sc.accept();
		System.out.println("connection established successfully");
		DataInputStream dout = new DataInputStream(ss.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		while(true) {
		dataRecived = dout.readAllBytes();
		for (int i = 0; i < dataRecived.length; i++) {
			System.out.print(dataRecived[i] + ",");
			listStr.add(dataRecived[i]);

		}
		sc.close();


//			if(dataRecived.equals("exit"))
//				break;
//		}
		System.out.println("end received");
		return null;

	}

	public static String convertByteToString(byte byteValue) {
		String stringValue = "" + byteValue;

		return (stringValue);
	}

	public static void main(String[] args) throws Exception {
		receivingMsg(5000);

		String bytstr = "";
		List<String> st = new ArrayList<>();

		System.out.println();
		for (byte str : listStr) {
//	System.out.println("kjk");
			byte str1 = str;
			String stringValue;

			// Convert byte to string
			stringValue = convertByteToString(str);
			st.add(stringValue);

		}

		converter conv = new converter();

//		String datstr[] = dataRecived.toString().split("-2");
//
//		for (int k = 0; k < datstr.length; k++) {
//			System.out.println(datstr[k] + " dddddddddddd");
//		}

		st.add(dataRecived.toString());
//		for (int l = 0; l < st.size(); l++) {
//			
//		}
//		for (int s = 12; s < listStr.size(); s++) {
//			dataR.add(listStr.get(s), dataRecived);
//
//		}
		System.out.println("list------");
		for(int f=0;f<listStr.size();f++) {
			System.out.print(listStr.get(f)+",");
		}
		
		
		for(int m=20;m<listStr.size()-6;m++) {
			listStrcopy.add(listStr.get(m));
			
		}
		System.out.println("copy list");
		for(int g=0;g<listStrcopy.size();g++) {
			System.out.print(listStrcopy.get(g)+",");
		}
		byte[] strnew = new byte[listStrcopy.size()];
//		
		System.out.println("array list");
		for(int k=0;k<listStrcopy.size();k++) {
			strnew[k]=listStrcopy.get(k);
			System.out.print(strnew[k]+",");
		}
		
		
		
		String recived = conv.conv(strnew);
		System.out.println(recived);


		JFrame f;

		JButton b, b1, b2;
		JLabel l;
		f = new JFrame("panel");
		l = new JLabel(recived);
		JPanel p = new JPanel();
		p.add(l);
		p.setBackground(Color.blue);
		f.add(p);
		f.setSize(300, 300);

		f.show();
	}

}
