/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dianmond;

import java.util.Scanner;

/**
 *
 * @author Adam Sun
 */
public class Dianmond {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Scanner input = new Scanner(System.in);
           int userNum =0;
           boolean valid = false;
           while(!valid){   
               try{
                userNum = input.nextInt();
                valid = true;
               }
               catch(Exception e)
               {  System.out.println("nice try");
                  input.nextLine();
               }
           }
           printDiamond(userNum);
           
        // TODO code application logic here
    }    
    public static void printDiamond(int size)
    {   int numSpaces= size-1;
        int numStars= 1;
        
        for(int i=0; i<size; i++)
        {
            for (int num=0;num<numSpaces; num++)
            {
                System.out.print(".");
            }
            for (int num=0; num<numStars; num++)
            {
                System.out.print("* ");
            }
            System.out.println();
            numSpaces--;
            numStars++;
        }
        numSpaces+=2;
        numStars-= 2; 
        for(int i=0; i<size-1; i++)
        {
            for (int num=0;num<numSpaces; num++)
            {
                System.out.print(" ");
            }
            for (int num=0; num<numStars; num++)
            {
                System.out.print("* ");
            }
            System.out.println();
            numSpaces++;
            numStars--;
        }
    
    }
}