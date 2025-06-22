import java.util.*;

class ClothingItem {
    private int id;
    private String name;
    private String category;
    private String gender;
    private String size;

    public ClothingItem(int id, String name, String category, String gender, String size) {
        this.id = id;
        this.name = name.toLowerCase();
        this.category = category.toLowerCase();
        this.gender = gender.toLowerCase();
        this.size = size.toUpperCase();
    }

    public boolean match(String keyword) {
        keyword = keyword.toLowerCase();
        return name.contains(keyword) || category.contains(keyword)
               || gender.contains(keyword) || size.equalsIgnoreCase(keyword);
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Category: " + category +
                ", Gender: " + gender + ", Size: " + size);
    }
}

class ClothingSearchEngine {
    private List<ClothingItem> items;

    public ClothingSearchEngine() {
        items = new ArrayList<>();
    }

    public void addItem(ClothingItem item) {
        items.add(item);
    }

    public List<ClothingItem> search(String keyword) {
        List<ClothingItem> results = new ArrayList<>();
        for (ClothingItem item : items) {
            if (item.match(keyword)) {
                results.add(item);
            }
        }
        return results;
    }
}

public class LinearSearch_Function {
    public static void main(String[] args) {
        ClothingSearchEngine searchEngine = new ClothingSearchEngine();

        searchEngine.addItem(new ClothingItem(1, "Classic White T-Shirt", "T-Shirt", "Men", "M"));
        searchEngine.addItem(new ClothingItem(2, "Blue Denim Jeans", "Jeans", "Women", "L"));
        searchEngine.addItem(new ClothingItem(3, "Hoodie", "Jacket", "Unisex", "XL"));
        searchEngine.addItem(new ClothingItem(4, "Formal Shirt", "Shirt", "Men", "L"));
        searchEngine.addItem(new ClothingItem(5, "Denim Jacket", "Jacket", "Women", "XL"));
        searchEngine.addItem(new ClothingItem(6, "Cotton Shirt", "Shirt", "Unisex", "XL"));
        searchEngine.addItem(new ClothingItem(7, "Formal Shirt", "Shirt", "Men", "L"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Category or Keyword to Search:");
        String searchQuery = sc.nextLine();

        System.out.println("\nSearch results for: " + searchQuery);
        List<ClothingItem> results = searchEngine.search(searchQuery);

        if (results.isEmpty()) {
            System.out.println("No clothing items found.");
        } else {
            for (ClothingItem item : results) {
                item.display();
            }
        }

        sc.close();
    }
}
