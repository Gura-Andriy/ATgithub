import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logging {
    String file;
    FileWriter fileWriter;
    PrintWriter printWriter;


    public Logging(String file) {
        this.file = file;

        try {
            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Write log without element name
    public void writeLog(String methodName) {
        try {
            writeGoodLog(methodName);
        } catch (Exception e) {
            writeBadLog(methodName, e);
        }
    }

    public void writeGoodLog(String actionName) {
        printWriter.println("method " + actionName + " done.");
    }

    public void writeBadLog(String actionName, Exception exception) {
        printWriter.println("method " + actionName + " failed. " + "Stacktrace -> " + exception.getMessage());
    }

    //Close file
    public void close() {
        printWriter.close();
    }

}
