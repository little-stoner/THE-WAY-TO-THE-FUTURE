package _nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ppath {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_nio/nio-data.txt");
        System.out.println(Paths.get("."));

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(80);

        channel.read(buffer, 0, " Async ", new CompletionHandler() {

                    @Override
                    public void completed(Object result, Object attachment) {
                        System.out.println(attachment + " complted and " + result + " bytes are written.");
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println(attachment + " failed with exception: " + exc.getMessage());
                    }
                }
            );
        Thread.sleep(2000);
    }

}
