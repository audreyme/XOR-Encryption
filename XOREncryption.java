import java.io.*;
import java.lang.*;
import java.math.BigInteger;

public class XOREncryption
{
  public static void main(String [] args) throws Exception
  {
    final int segLength = 32;
    int pieceNum = 0;
    int endIndex;
    boolean trigger = false;
    String codebook = new BigInteger("audrey ".getBytes()).toString(2);

    String message;
    String binaryMessage;
    String binMessageSeg;
    String encryptedMessage = "";
    String binaryEncryptedMessage;


  //STEP 1
    BufferedReader inFromUser =
      new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Please enter your message here: ");

    message = inFromUser.readLine();

  //STEP 2.
    binaryMessage = new BigInteger(message.getBytes()).toString(2);
    //System.out.println(binaryMessage);

  //STEP 3
        //May need some help with indexing
        //need to account for end case in loop variable
    //LOOP WHILE THERE IS STILL PORTIONS OF THE MESSAGE NEEDING ENCRYPTING
    while(trigger != true)
    {
      if(message.length() < segLength)
      {
      //  System.out.println("into if");
        endIndex = message.length() - 1;
        trigger = true;

      }
      else
      {
        endIndex = segLength - 1;
      }
    //System.out.println("out of if");

      binMessageSeg = binaryMessage.substring(0, endIndex);
      if(trigger != true)
      {
        message = message.substring(segLength - 1);
      }
      System.out.println(binMessageSeg);


    //STEP 4
      for(int i = 0; i<binMessageSeg.length(); i++)
      {
        if(codebook.charAt(i) == binMessageSeg.charAt(i))
        {
          encryptedMessage = encryptedMessage + '0';
        }
        else
        {
          encryptedMessage = encryptedMessage + '1';
        }
      }//for
    }//while
  System.out.println("Binary Message: " + binaryMessage);
  System.out.println("Encrypted Message: " + encryptedMessage);

  }//main
}//class