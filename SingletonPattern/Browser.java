package SingletonPattern;

public class Browser {
    private static Browser instance;

    private Browser() {
        System.out.println("Browser instance created");
    }

    public static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public void displayMsg() {
        System.out.println("Singleton Pattern");
    }
}
