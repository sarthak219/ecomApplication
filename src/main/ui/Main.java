package ui;

public class Main {
    public static void main(String[] args) {
        //new MyApp();
        String[] options = {"Back",
                "Show Products", "Search Products", "Add to Wishlist",
                "Add to Cart"};
        new ScreenTemplate("Home", options);
    }
}
