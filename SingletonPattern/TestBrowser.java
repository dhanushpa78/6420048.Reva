package SingletonPattern;

public class TestBrowser {
    public static void main(String[] args) {
        Browser browser1 = Browser.getInstance();
        browser1.displayMsg();

        Browser browser2 = Browser.getInstance();
        browser2.displayMsg();

        System.out.println("Are both objects the same? " + (browser1 == browser2));
    }
}