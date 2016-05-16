package lib;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

    private String filename;
    private String content;

    public FileReader(String name)  {
        filename = name;
        try {
            read();
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void read() throws IOException {
        Scanner s;
        if(filename.startsWith("/")) {
            s = new Scanner(new File(filename));
        } else {
            s = new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
        }
        StringBuilder builder = new StringBuilder();
        while(s.hasNextLine()) builder.append(s.nextLine() + "\n");
        s.close();
        content = builder.toString();
    }

    public String getContent() {
        return content;
    }
}
