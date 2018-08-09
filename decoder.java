/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoder.mavenproject1;

import java.util.Scanner;

public class Decoder {
    
    
     public static void main(String [ ] args)throws Exception{
         
        int option, stringLength, counter, modulusCounter, offset;
        char key[] = new char[9];
        char quit, afterEncode, afterDecode;
        String keyString, toEncodeString,  toDecodeString;
         
        System.out.println("Please select your option : ");
        System.out.println("1) ENCODE ");
        System.out.println("2) DECODE ");
        
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
        
        if(option == 1)//Encode
        {
        System.out.println("Please key in your encoding key");
        keyString = sc.next();
            for(int i=0; i!= 9; i++)
            {
            key[i] = keyString.charAt(i);
            }
            quit = 'F';
            
            while(quit == 'F')
            {
                System.out.println("Key in the phrase to ENCODE");
                toEncodeString = sc.next();
                stringLength = 0; 
                stringLength =  toEncodeString.length();
                counter = 0;
                while(counter < stringLength)
                {
                modulusCounter = counter % 9;

                offset = determine_offset(key[modulusCounter]);
                afterEncode =encode_char(toEncodeString.charAt(counter), offset);
                System.out.print(""+afterEncode);
                counter = counter + 1;
                }
                quit = 'T';
            }
            
            
        }
        else if(option ==2)//Decode
        
        {
        System.out.println("Please key in your encoding key");
        keyString = sc.next();
            for(int i=0; i!= 9; i++)
            {
            key[i] = keyString.charAt(i);
            }
            quit = 'F';
            
            while(quit == 'F')
            {
                System.out.println("Key in the phrase to DECODE");
                toDecodeString = sc.next();
                stringLength = 0; 
                stringLength =  toDecodeString.length();
                counter = 0;
                while(counter < stringLength)
                {
                modulusCounter = counter % 9;
                
                offset = determine_offset(key[modulusCounter]);
                afterDecode =decode_char(toDecodeString.charAt(counter), offset);
                System.out.print(""+afterDecode);
                counter = counter + 1;
                }
                quit = 'T';
            }
        }
     }
     
     
     public static int determine_offset(char offset)
     {
         int calculatedOffset = 0;
        if(Character.isDigit(offset))
        {
            calculatedOffset = Character.getNumericValue(offset);
            
        }
        else if(Character.isLetter(offset))
        {
                calculatedOffset = offset - 'A' + 1;
                
        }
     return calculatedOffset;
     }
     public static char encode_char(char toBeEncoded, int offset)
      {
       int encodeIntNew;
       char encodeCharNew;
       encodeIntNew = toBeEncoded - 'A'+ offset;
       if( encodeIntNew >= 26)
       {
       encodeIntNew = encodeIntNew % 26;
       }
       encodeCharNew = (char)('A' + encodeIntNew);
      return encodeCharNew;
      }
     
       public static char decode_char(char toBeDecoded, int offset)
      {
       int decodeIntNew;
       char decodeCharNew;
       decodeIntNew = toBeDecoded - 'A'- offset;
       if( decodeIntNew < 0)
       {
       decodeIntNew = decodeIntNew + 26;
       }
       decodeCharNew = (char)('A' + decodeIntNew);
      return decodeCharNew;
      }
     
     
     
}
