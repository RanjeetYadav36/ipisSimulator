package com.innobitsystems.simulator.ipisSimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class test5 {
    public static void main(String[] args) throws Exception {
//        ProcessBuilder builder = new ProcessBuilder(
//            "cmd.exe", "/c", "cd \"C:\\Program Files\\PostgreSQL\\14\"&& cd data");
//        builder.redirectErrorStream(true);
//        Process p = builder.start();
//        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String line;
//        System.out.println("builderjjjjjjjjjjjj");
//        while (true) {
//            line = r.readLine();
//            if (line == null) { break; }
//            System.out.println(line);
//        }
//        
    	try {
            Process ds=Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"dir && cd \"C:\\\\Program Files\\\\PostgreSQL\\\\14\\\"&&rmdir data /s /q \"");
           File f = new File("C:\\Program Files\\PostgreSQL\\14\\data");
           long count = f.length();
           System.out.println("length "+count); 
      
//           if(count==0)
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \" pg_basebackup -h 192.168.2.2 -p 5432 -U postgres  -Fp -Xs -R -D \"C:\\Program Files\\PostgreSQL\\14\\data\"");         
//            Thread.sleep(5000);
//            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"dir && cd \"C:\\\\Program Files\\\\PostgreSQL\\\\14\\\"&& ren data1 data \"");

    	}
    	catch(Exception e) {
    		System.out.println(e.getLocalizedMessage());
    	}
    }
}
