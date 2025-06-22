public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first logger message.");
        logger2.log("This is the second logger message.");

        if (logger1 == logger2) {
            System.out.println("SingleTon confirmed(both logger instances are same)");
        } else {
            System.out.println("Different logger instances (Singleton failed).");
        }
    }
}
