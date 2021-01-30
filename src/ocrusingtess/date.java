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
public class date {
     
    
    
    // github and gitlab
    
    public static ArrayList<String>  date(String ocrString) {
    String regex1 = "\\d{2}"+ "\\-" + "\\d{2}"+ "\\-"+ "\\d{4}";
    String regex2 = "\\d{2}"+ "\\." + "\\d{2}"+ "\\."+ "\\d{4}";
    String regex3 = "\\d{2}"+ "/" + "\\d{2}"+ "/"+ "\\d{4}";
    String regex4 = "\\d{1}"+ "/" + "\\d{2}"+ "/"+ "\\d{4}";
    String regex5 = "\\d{2}"+ "/" + "\\d{1}"+ "/"+ "\\d{4}";
    String regex6 = "\\d{1}"+ "/" + "\\d{1}"+ "/"+ "\\d{4}";
    String emptySpace= "";
    
    ArrayList<String> stringWithoutSpaces = new ArrayList<String>();
    ArrayList<String> returnDate = new ArrayList<String>();
    String str[] = ocrString.split(" ");
    List<String> al = new ArrayList<String>();
    al = Arrays.asList(str);
    for(String s: al){
	   if (s.equals(emptySpace)){
              
               continue ;
           }
     else{
            stringWithoutSpaces.add(s);   
           }
	}
    //System.out.println(stringWithoutSpaces);
    for(int i=1; i<=stringWithoutSpaces.size(); i++){
    try {
        //System.out.println("entered try");
    if (stringWithoutSpaces.get(i).equals(regex1)) {
        //System.out.println("Adding due to - " + stringWithoutSpaces.get(i));
            returnDate.add(stringWithoutSpaces.get(i));
        }
         if (stringWithoutSpaces.get(i).matches(regex2)) {
        //System.out.println("Adding due to .   " + stringWithoutSpaces.get(i));
        returnDate.add(stringWithoutSpaces.get(i));
        }
        
        
        if (stringWithoutSpaces.get(i).matches(regex3)) {
        //System.out.println("Adding due to / " + stringWithoutSpaces.get(i));
        returnDate.add(stringWithoutSpaces.get(i));
        }
    if (stringWithoutSpaces.get(i).matches(regex3)) {
        //System.out.println("Adding due to / " + stringWithoutSpaces.get(i));
        returnDate.add(stringWithoutSpaces.get(i));
        }
    if (stringWithoutSpaces.get(i).matches(regex4)) {
        //System.out.println("Adding due to / " + stringWithoutSpaces.get(i));
        returnDate.add(stringWithoutSpaces.get(i));
        }
    if (stringWithoutSpaces.get(i).matches(regex5)) {
        //System.out.println("Adding due to / " + stringWithoutSpaces.get(i));
        returnDate.add(stringWithoutSpaces.get(i));
        }
    if (stringWithoutSpaces.get(i).matches(regex6)) {
        //System.out.println("Adding due to / " + stringWithoutSpaces.get(i));
        returnDate.add(stringWithoutSpaces.get(i));
        }
        
    }
    catch(Exception e) {
       continue;    
       } } 
    return returnDate;    
}}