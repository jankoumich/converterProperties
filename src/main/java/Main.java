public class Main {
    /**
     * TODO:
     *  user input
     *  find where / are added to property file -> store properties, override it
     *  readme
     *  tests
     */
    public static void main(String[] args) {
        System.out.println("Converter Java Properties is starting work");
        Converter converter =  new Converter("/Users/janko/Desktop/test.csv", "/Users/janko/Desktop/test.properties");
        converter.convert(0);
        System.out.println("...and it is done, enjoy :)");
    }


}
