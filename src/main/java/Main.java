import java.util.Scanner;

public class Main {
    /**
     * TODO:
     *  user input
     *  find where / are added to property file -> store properties, override it
     *  readme
     *  tests
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Converter to Properties");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a path to your file: ex. /Users/testUser/Desktop/test.csv");
        String pathToRead = reader.next();
        System.out.println("Enter a path where to write a file: ex. /Users/testUser/Desktop");
        String pathToWrite = reader.next();
        System.out.println("How should we call your new property file? ex. test.properties");
        String fileName = reader.next();
        System.out.println("Should we escape special characters with HTML escape sequence? yes -> 1, no -> 0 ");
        int mode = reader.nextInt();
        System.out.println("Converter Java Properties is starting work");

        Converter converter =  new Converter(pathToRead, pathToWrite + "/" + fileName);

        converter.convert(mode);
        System.out.println("...and it is done, enjoy :)");
    }


}
