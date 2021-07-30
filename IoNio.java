import java.io.*;

public class IoNio {

    public static void main(String[] args) throws IOException {
        //abstract classes
        InputStream inputStream = new FileInputStream("C:\\testout.txt");
        OutputStream outputStream = new FileOutputStream("C:\\testout.txt");
        Reader reader =  new FileReader("C:\\testout.txt");
        Writer writer = new FileWriter("C:\\testout.txt");

        //concrete classes - low
        FileInputStream fileInputStream = new FileInputStream("C:\\testout.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\testout.txt");
        FileReader fileReader = new FileReader("C:\\testout.txt");
        FileWriter fileWriter = new FileWriter("C:\\testout.txt");

        //concrete classes - high
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); //or inputStream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream); //or outputStream
        BufferedReader bufferedReader = new BufferedReader(fileReader); //or reader //has readLine() method
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //or writer

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); //or inputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); //or outputStream
        
        //this two also take String or File
        PrintStream printStream = new PrintStream(fileOutputStream); //boolean = autoFlush
        PrintWriter printWriter = new PrintWriter(writer); //or outputStream or fileOuputStream

    }
}
