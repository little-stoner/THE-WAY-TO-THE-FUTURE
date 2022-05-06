package _nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FChannel {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_nio/nio-data.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(5);
        int bytesRead = fileChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println();
            System.out.println("read: " + bytesRead);
            buf.flip();
            while (buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = fileChannel.read(buf);
        }
        fileChannel.close();
    }

}
