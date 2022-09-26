package com.innobitsystems.simulator.ipisSimulator;

public class test {
public static void main(String[] args) throws Exception {
	 Integer a = new Integer(-86);
	 
     // Converting integer number to byte value
     // using byteValue() method
     byte b = a.byteValue();

     // Printing the corresponding byte value
     System.out.println(b);
     
     System.out.println(getDecimal("0xef"));
     System.out.println("kllll");
     System.out.println("fdf");

     
     String str= "0xE7";
     char ar[] = str.toCharArray();
     int x = 0;
     for(int i=0;i<ar.length;i++) {
    	 x=ar[i];
    	 
     }
     
     int s=255;
     
     byte neww= (byte)s;
     System.out.println(neww);
     System.out.println(x+"jjjjjjjjjjjj");
}

public static int getDecimal(String hex){
    String digits = "0123456789ABCDEF";
             hex = hex.toUpperCase();
             int val = 0;
             for (int i = 0; i < hex.length(); i++)
             {
                 char c = hex.charAt(i);
                 int d = digits.indexOf(c);
                 val = 16*val + d;
             }
             return val;
}
}
