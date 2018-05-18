package outils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.StringTokenizer;


public class FileStr
{
    private static final int EOF = -1;

    public FileStr() {}

    public static String[] read(String paramString)
    {
        try
        {
            BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString));
            StringBuffer localStringBuffer = new StringBuffer(localBufferedInputStream.available());
            int i = localBufferedInputStream.read();
            while (i != -1) {
                localStringBuffer.append((char)i);
                i = localBufferedInputStream.read();
            }
            localBufferedInputStream.close();
            StringTokenizer localStringTokenizer = new StringTokenizer(localStringBuffer.toString(), "\r\n");
            int j = localStringTokenizer.countTokens();
            String[] arrayOfString = new String[j];
            for (int k = 0; k < j; k++) arrayOfString[k] = localStringTokenizer.nextToken();
            return arrayOfString;
        } catch (FileNotFoundException localFileNotFoundException) {
            localFileNotFoundException.printStackTrace();return null;
        } catch (IOException localIOException) { localIOException.printStackTrace(); } return null;
    }


    public static void write(String paramString, String[] paramArrayOfString)
    {
        try
        {
            OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(paramString), Charset.forName("ISO-8859-1"));
            for (int i = 0; i < paramArrayOfString.length; i++) {
                localOutputStreamWriter.write(paramArrayOfString[i], 0, paramArrayOfString[i].length());
                localOutputStreamWriter.write("\r\n", 0, 2);
            }
            localOutputStreamWriter.close();
        } catch (FileNotFoundException localFileNotFoundException) {
            localFileNotFoundException.printStackTrace();
        } catch (IOException localIOException) { localIOException.printStackTrace();
        }
    }
}