/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrusingtess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nasat
 */
public class patientName {
    
    
    private static String emptySpace= "";
    private static String Name= "Name";
    private static String name= "name:";
    private static String MR="MR";
    private static String MRwithdot="MR.";
    private static String MRS="MRS";       
    private static String Mrswithdot="Mrs.";
    private static String semiColon= ";";
    private static String colon= ":";
       
    
    //private String ocrString; 
    public static ArrayList<String>  patientName(String ocrString)
    
    {
    
        ArrayList<String> strWithoutSpaces = new ArrayList<String>();
	String str[] = ocrString.split(" ");
	List<String> al = new ArrayList<String>();
        ArrayList<String> returnString = new ArrayList<String>();
	al = Arrays.asList(str);
        //ArrayList<String> returnDate = new ArrayList<String>();

	for(String s: al){
	   if (s.equals(emptySpace)){
              
               continue ;
           }
     else{
            strWithoutSpaces.add(s);   
           }
	}
        //System.out.println(strWithoutSpaces);
    for(int i=1; i<=strWithoutSpaces.size(); i++){ 
        //System.out.println(strWithoutSpaces.get(i).getClass().getName());
       try{ 
                 
        if((strWithoutSpaces.get(i-1).equalsIgnoreCase(Name)))
        {
          //  System.out.println("entered first if");
            if (strWithoutSpaces.get(i).matches(":")
               |strWithoutSpaces.get(i).matches(";"))
            {
               //  System.out.println("entered 2nd if");
                if (strWithoutSpaces.get(i+1).equalsIgnoreCase(MR)
                    |strWithoutSpaces.get(i+1).equalsIgnoreCase(MRwithdot)
                    |strWithoutSpaces.get(i+1).equalsIgnoreCase(MRS)
                    |strWithoutSpaces.get(i+1).equalsIgnoreCase(Mrswithdot)) 
                {
                   //  System.out.println("entered 3rd if");
                    returnString.add(strWithoutSpaces.get(i+2));
                    returnString.add(strWithoutSpaces.get(i+3));
                }
                else
                {
                 //    System.out.println("entered 3rd else");
                    returnString.add(strWithoutSpaces.get(i+1));
                    returnString.add(strWithoutSpaces.get(i+2));
                }
            }
                
            else
            {
               //  System.out.println("entered 2nd else");
                continue; 
            }       
        }
        else
        {
             //System.out.println("entered 1st else");
            if (strWithoutSpaces.get(i).equalsIgnoreCase(name))
            {
               //  System.out.println("entered first else  if");
                if (strWithoutSpaces.get(i+1).equalsIgnoreCase(MR)
                    |strWithoutSpaces.get(i+1).equalsIgnoreCase(MRwithdot)
                    |strWithoutSpaces.get(i+1).equalsIgnoreCase(MRS)
                    |strWithoutSpaces.get(i+1).equalsIgnoreCase(Mrswithdot)) 
                {
                    returnString.add(strWithoutSpaces.get(i+2));
                    returnString.add(strWithoutSpaces.get(i+3));
                }
                else
                {
                     //System.out.println("entered first else else");
                    returnString.add(strWithoutSpaces.get(i+1));
                    returnString.add(strWithoutSpaces.get(i+2));
                   // System.out.println(returnString);
                }
               //System.out.println(returnString); 
            }
        
            //System.out.println(returnString);
       }
       } 
       catch(Exception e) {
       continue;    
       }  
    
    }
    //return returnString;
    //System.out.println("fianlly "+returnString);
    return returnString;
    }
}

