import java.io.*;
import java.lang.*;
import java.math.BigInteger;

public class OldXOR
{
  public static void main(String [] args) throws Exception
  {

    String codebook = new BigInteger("AUDREY".getBytes()).toString(2);
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

  //STEP 2: TRANSLATE INTO BYTES
    binMessage = new BigInteger(message.getBytes()).toString(2);

  //STEP 3: SEGMENT OFF CODEBOOK SIZED PIECE
    while(binMessage.length() - 1 > endIndex)
    {
      System.out.println("in the segmenter");
      binMessageSeg = binMessage.substring(startIndex, endIndex);
      System.out.println("startIndex: " + startIndex + "        endIndex: "
                    + endIndex);
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

      //Update Indexes to move to next FULL section of binMessage
      startIndex = endIndex + 1;
      endIndex = startIndex + segLength - 1;
      piecesUsed++;

    }//while

    //endIndex = binMessage.length() - 1;

    //STEP 4: ENCODE BINARY MESSAGE SEGMENT
   System.out.println("startIndex: " + startIndex + "        endIndex: "
                  + endIndex);
    endIndex = binMessage.length() - 1;
    binMessageSeg = binMessage.substring(startIndex, endIndex);

      for(int i = 0; i<binMessageSeg.length(); i++)
      {
        System.out.println(i);
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

  System.out.println("Encrypted Message: " + encryptedMessage);


  //STEP 8 WHERE binMessage = binEncryptedMessage, binEncryptedMessage = newMessage

    String newMessage = "";
    startIndex = 0;
    endIndex  = codebook.length() - 1;

    if(codebook.length()-1 > binMessage.length() -1 )
    {
      endIndex = binMessage.length() - 1;
    }


    String eMessage = new BigInteger(message.getBytes()).toString(2);
    String binEncryptedMessageSeg = eMessage.substring(startIndex, endIndex);

    while(eMessage.length() - 1 > endIndex)
    {
      binEncryptedMessageSeg = eMessage.substring(startIndex, endIndex);

      for(int i = 0; i<binEncryptedMessageSeg.length(); i++)
      {
        if(codebook.charAt(i) == binEncryptedMessageSeg.charAt(i))
        {
          newMessage = newMessage + '0';
        }
        else
        {
          newMessage = newMessage + '1';
        }
      }//for

      //Update Indexes to move to next section of binEncryptedMessage
      startIndex = endIndex + 1;
      endIndex = startIndex + segLength - 1;
      piecesUsed++;

    }//while

    endIndex = eMessage.length() - 1;



       for(int i = 0; i<binEncryptedMessageSeg.length(); i++)
      {
        if(codebook.charAt(i) == binEncryptedMessageSeg.charAt(i))
        {
          newMessage = newMessage + '0';
        }
        else
        {
          newMessage = newMessage + '1';
        }
      }//for

  String decryptedMessage = new String(new BigInteger(eMessage, 2).toByteArray());
    System.out.println("Decrypted message: " + decryptedMessage);
  }//main
}//class