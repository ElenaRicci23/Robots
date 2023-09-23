package robots;

import robots.view.FileManager;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        fileManager.run();
    }

}
