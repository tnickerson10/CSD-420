import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadBinaryIO {
    public static void main(String[] args) {

        try (RandomAccessFile readFile = new RandomAccessFile("Nickerson-datafile.dat", "r")){
            String line;
            while ( (line = readFile.readLine()) != null ) {
                System.out.println(line);
            }

            System.out.println();
        } catch (FileNotFoundException e) {
        } catch (IOException ioe) {
            System.err.println(ioe);
        }

    }
}
