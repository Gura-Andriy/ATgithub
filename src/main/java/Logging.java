import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logging {
    String file;
    public Logging(String file) {
        this.file = file;
    }

    public void writeLog(boolean action, String actionName) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (action) {
            printWriter.println("method " + actionName + " done");
        } else {
            printWriter.println("method " + actionName + " lose");
        }
        printWriter.close();
    }
}
