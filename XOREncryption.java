import java.io.*;
import java.lang.*;
import java.math.BigInteger;

public class XOREncryption
{
  public static void main(String [] args) throws Exception
  {

    String codebook = new BigInteger("audrey ".getBytes()).toString(2);
    final int segLength = codebook.length();
    int piecesUsed  = 0;
    int startIndex = 0;
    int endIndex  = codebook.length() - 1;

    String message;
    String binMessage;
    String binMessageSeg;
   // String encryptedMessage = "";
    String binEncryptedMessage = "";



  //STEP 1
    BufferedReader inFromUser =
      new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Please enter your message here: ");

    message = inFromUser.readLine();

  //STEP 2.
    binMessage = new BigInteger(message.getBytes()).toString(2);
    //System.out.println(binaryMessage);

  //STEP 3
    while(binMessage.length() - 1 > endIndex)
    {
      binMessageSeg = binMessage.substring(startIndex, endIndex);

       for(int i = 0; i<binMessageSeg.length(); i++)
      {
        if(codebook.charAt(i) == binMessageSeg.charAt(i))
        {
          binEncryptedMessage = binEncryptedMessage + '0';
        }
        else
        {
          binEncryptedMessage = binEncryptedMessage + '1';
        }
      }//for

      //Update Indexes to move to next section of binMessage
      startIndex = endIndex + 1;
      endIndex = startIndex + segLength - 1;
      piecesUsed++;

      /*if(message.length() < segLength)
      {
        endIndex = message.length() - 1;
        trigger = true;

      }
      else
      {
        endIndex = segLength - 1;
      }
    //System.out.println("out of if");

      binMessageSeg = binaryMessage.substring(startIndex, endIndex);
      if(trigger != true)
      {
        message = message.substring(segLength - 1);
      }
      System.out.println(binMessageSeg);
*/
    }//while

    endIndex = binMessage.length() - 1;

    binMessageSeg = binMessage.substring(startIndex, endIndex);

       for(int i = 0; i<binMessageSeg.length(); i++)
      {
        if(codebook.charAt(i) == binMessageSeg.charAt(i))
        {
          binEncryptedMessage = binEncryptedMessage + '0';
        }
        else
        {
          binEncryptedMessage = binEncryptedMessage + '1';
        }
      }//for

  //STEP 7
  String encryptedMessage = new String(new BigInteger(binEncryptedMessage, 2).toByteArray());

  System.out.println("Binary Encrypted Message: " + binEncryptedMessage);
  System.out.println("Encrypted Message: " + encryptedMessage);

  }//main
}//class