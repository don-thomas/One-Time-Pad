/**
 * This program encrypts and decrypts messages using keys and cipher/plaiun texts
 * Date Created: 06 17, 2016
 * @Author: Thomas Don and Udayakumar Praveen
 **/

public class OneTimePad
{
  /** *** Method 
    * obtains the encryption/decryption key and the plain/cipher text then output's a encrypted or decrypted message
    * parameters: prompt1 and prompt2 respectively store a string which will be concatenated in a output string. It is used to simplify the program 
    * parameter: the calculationType1 determines which calculation to use
    **/
  public static void convertor(String prompt1,String prompt2,boolean calculationType1)
  { 
    // *** output
    System.out.println("Please enter the key you will be using:");// Asks the user to input a key
    // *** input and variable
    String userInput1= In.getString();//user's key
    // *** output 
    System.out.println("Please enter the "+prompt1+" to "+prompt2+":");// Asks the user to enter plaintext/ciphertext(dependent on parameters)
    // *** input and variable 
    String userInput2= In.getString();//User's plaintext/ciphertext
    // *** processing 
    if (calculationType1)//Calculation to encrypt
    {
      for(int i=0;(i<(userInput1.length()))&&(i<(userInput2.length()));i++)//This loop will determine how many words to print
        // *** output
        //This calculation converts string to char then to integers and does numeric calculation and finally converts it as a char
        System.out.print((char)(((((int)(userInput1.charAt(i))-194)+((int)(userInput2.charAt(i))))%26)+97));//This will do a calculation to find the ciphertext
    }                                                                                                       //and print it
    // *** processing 
    else{ // Calculation to decrypt
      for(int i=0;(i<(userInput1.length()))&&(i<(userInput2.length()));i++)//This loop will determine how many words to print
        // *** output
        //This calculation converts string to char then to integers and does numeric calculation and finally converts it as a char
        System.out.print((char)((((((26-((int)(userInput1.charAt(i))-97))%26)+((int)(userInput2.charAt(i))-97)))%26)+97));//This will do a calculation to find the plaintext 
    }                                                                                                                     //and print it
    // *** output                                                                                                       
    System.out.println();//Goes to the next line
  }
  
  /**
   * Main Method
   **/
  public static void main(String[] args)
  {
    // *** variable
    Boolean stayInLoop=true;// This variable decides whether to stay in the loop or not
    
    //The main loop of this program
    do  
    { 
      // *** output
      System.out.println("Would you like to encrypt (e), decrypt (d) or finish (f) ?");// Asks the user for their decision
      // *** input and variable
      String userDecision = In.getString();//User's decision
      // Programs decides what to do next with the user' decision
      
      // *** processing
      if (userDecision.equals("e"))// Checks if the user wants to encrypt
        convertor("plaintext","encrypt",true);// This method is used to find more information ,and also to decide which calculation to use and outputs that text   
      // *** processing 
      else if (userDecision.equals("d"))// Checks if the user wants to decrypt
        convertor("ciphertext","decrypt",false);// This method is used to find more information and also to decide which calculation to use and outputs that text
      // *** processing 
      else if (userDecision.equals("f"))// Checks if the user wants to exit the program
        stayInLoop=false;//If false the program will exit the main loop
      // *** processing 
      else // if the user enters any other words this will be executed
        // *** output
        System.out.println("INVALID RESPONSE; TYPE EITHER (e) encrypt, (d) decrypt or (f)finish");//tells the user to enter either (e),(d) or(f)
    }
    while(stayInLoop);// when stayInLoop is false then this program will exit the main loop
  }  
}
