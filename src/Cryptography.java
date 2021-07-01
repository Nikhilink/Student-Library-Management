/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rahul,Ajay,Nikhil :-)
 * 
 * 
 */
public class Cryptography 
{
    public String StringEncrypt(String plainText,int Key)
    {
        char ch;
        String cipherText = "";
        for(int i = 0;i < plainText.length();i++)
        {
            ch = plainText.charAt(i);
            if(ch >= 'a' && ch <= 'z')
            {
                ch = (char)(ch + Key);
                if(ch > 'z')
                {
                    ch = (char)(ch - 'z' + 'a' - 1);
                }
                cipherText +=ch;
            }
            else if(ch >= 'A' && ch <= 'Z')
            {
                ch = (char)(ch + Key);
                if(ch > 'Z')
                {
                    ch = (char)(ch - 'Z' + 'A' - 1);
                }
                cipherText += ch;
            }
            else
            {
                cipherText += ch;
            }
        }
        return cipherText;
    }
    public String StringDecrypt(String cipherText,int Key)
    {
        char ch;
        String plainText = "";
        for(int i = 0;i < cipherText.length();++i)
        {
            ch = cipherText.charAt(i);
            if(ch >= 'a' && ch <= 'z')
            {
                ch = (char)(ch - Key);
                if(ch < 'a')
                {
                    ch = (char)(ch + 'z' - 'a' + 1);
                }
                plainText +=ch;
                        
            }
            else if(ch >= 'A' && ch <= 'Z')
            {
                ch = (char)(ch - Key);
                if(ch < 'A')
                {
                    ch = (char)(ch + 'Z' - 'A' + 1);
                }
                plainText += ch;
            }
            else{
                plainText += ch;
            }
        }
        return plainText;
    }

    /**
     *
     * 
     */
    
}
