package com.innobitsystems.simulator.ipisSimulator;

import java.io.IOException;  
import java.nio.charset.StandardCharsets;  

public class converter
{
    public String conv(byte[] byteList)  
{     
try  
{     
// byte[] b = "9137".getBytes(StandardCharsets.UTF_16);     //byte array   
// for(int i=0; i<b.length;i++){
    
// System.out.print(b[i]);
// }
// byte[] byteList = [0 0   0   0   0   0   0   0   0   0   0   0   4   9   5   0   0   -2   -1   0   57   0   49   0   51   0   55   -2   -1   0   65   0   78   0   86   0   84   0   32   0   77   0   65   0   85   0   32   0   83   0   70   0   32   0   69   0   88   0   80   -2   -1   0   49   0   50   0   58   0   51   0   48   -2   -1   0   65   -2   -1   0   49   -1   -1   -86];
//byte[] byteList ={-2 ,-1 ,0 };
// byte[] byteList =new byte [];
 String string = new String(byteList, StandardCharsets.UTF_16);   //string with "UTF-8" encoding  
 System.out.println(string);   
 return string ;  

}  
catch(Exception e)  
{  
return e.getMessage();
}
}  
}
