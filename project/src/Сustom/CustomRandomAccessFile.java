package Сustom;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class CustomRandomAccessFile{

    private byte[] bytes;
    private long position;
    private String nameOfFile;

    public CustomRandomAccessFile(String nameOfFile) throws IOException {
        bytes = Files.readAllBytes(Paths.get(nameOfFile));
        this.nameOfFile = nameOfFile;
        this.position = 0;
    }

    public void seek(long position){
        this.position += position;
    }

    private void skipString(){
        int i = (int) position;
        while(i < bytes.length && bytes[i]!=10){
            i++;
        }
        seek(i + 1 - (int) position);
    }

    public void goToStringEnd(int number){
        for(int i = 0; i < number; i++){
            skipString();
        }
        skipString();
        seek(-2);
    }

    public void writeBytes(String str){
        byte[] stringBytes = str.getBytes();
        byte[] temp = new byte[bytes.length + stringBytes.length];
        System.arraycopy(bytes, 0, temp, 0, (int) position);
        System.arraycopy(stringBytes, 0,temp, (int) position,stringBytes.length);
        System.arraycopy(bytes, (int) position, temp, (int) position+ stringBytes.length, bytes.length - (int) position);
        bytes = temp;
    }

    public void close() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(nameOfFile));
        fos.write(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        fos.close();
    }
}
