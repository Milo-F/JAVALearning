import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionLearning {
    public int testException (int n) throws FileNotFoundException, IOException {
        File f = new File("file path");
        int[] x = new int[5];
        n = x[6];
        BufferedReader reader = new BufferedReader(new FileReader(f));
        reader.close();
        return n;
    }
    public static void main(String[] args) {
        ExceptionLearning exceptionLearning = new ExceptionLearning();
        try {
            exceptionLearning.testException(0);
        } catch (FileNotFoundException e) {
            System.out.println("catch FileNotFoundException");
        } catch (IOException e) {
            System.out.println("catch IOException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch ArrayIndexOutOfBoundsException");
        } finally {
            System.out.println("finally");
        }
    }
}