package E-commerce_Search_function;

import java.util.*;

class ClothingItem {
    private int id;
    private String name;
    private String category;  // T-Shirt, Jeans
    private String gender;    // Men, Women
    private String size;      //S, M, L, XL

    public ClothingItem(int id, String name, String category, String gender, String size) {
        this.id = id;
        this.name = name.toLowerCase();
        //this.age = age;
        this.category = category.toLowerCase();
        this.gender = gender.toLowerCase();
        this.size = size.toUpperCase();
    }

    public boolean match(String keyword) {
        keyword = keyword.toLowerCase();
        return name.contains(keyword) || category.contains(keyword) || gender.contains(keyword) || size.equalsIgnoreCase(keyword);
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Category: " + category +
                ", Gender: " + gender + ", Size: " + size);
    }
}

// Search Engine
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

public class Cloth_Search_Engine {
public static void main(String[] args) {
        ClothingSearchEngine searchEngine = new ClothingSearchEngine();

        
        searchEngine.addItem(new ClothingItem(1, "Classic White T-Shirt", "T-Shirt", "Men", "M"));
        searchEngine.addItem(new ClothingItem(2, "Blue Denim Jeans", "Jeans", "Women", "L"));
        searchEngine.addItem(new ClothingItem(3, "Hoodie", "Jacket", "Unisex", "XL"));
        searchEngine.addItem(new ClothingItem(4, "Formal Shirt", "Shirt", "Men", "L"));
        searchEngine.addItem(new ClothingItem(5, "Denim Jacket", "Jacket", "Women", "XL"));
        searchEngine.addItem(new ClothingItem(6, "Cotton Shirt", "Shirt", "Unisex", "XL"));
        searchEngine.addItem(new ClothingItem(6, "Formal Shirt", "Shirt", "Men", "L"));
        
        
        
        System.out.println("Enter the Category of Shopping");
        Scanner sc = new Scanner(System.in);
        String searchQuery = sc.next(); // Try: "shirt", "L", "jeans", "hoodie"
        System.out.println("Search results for: " + searchQuery);
        List<ClothingItem> results = searchEngine.search(searchQuery);

        if (results.isEmpty()) {
            System.out.println("No clothing items found.");
        } else {
            for (ClothingItem item : results) {
                item.display();
            }
        }
    }
}

