import java.util.*;

class ClothingItem implements Comparable<ClothingItem> {
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

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Category: " + category +
                ", Gender: " + gender + ", Size: " + size);
    }

    public int compareTo(ClothingItem other) {
        return this.name.compareTo(other.name);
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

    public void sortItemsByName() {
        Collections.sort(items);
    }

    public ClothingItem binarySearchByName(String keyword) {
        keyword = keyword.toLowerCase();
        int low = 0, high = items.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            ClothingItem midItem = items.get(mid);
            int comparison = midItem.getName().compareTo(keyword);

            if (comparison == 0) {
                return midItem;  // found
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // not found
    }

    public void displayAllItems() {
        for (ClothingItem item : items) {
            item.display();
        }
    }
}

public class BinarySearch_Function {
    public static void main(String[] args) {
        ClothingSearchEngine searchEngine = new ClothingSearchEngine();


        searchEngine.addItem(new ClothingItem(1, "Classic White T-Shirt", "T-Shirt", "Men", "M"));
        searchEngine.addItem(new ClothingItem(2, "Blue Denim Jeans", "Jeans", "Women", "L"));
        searchEngine.addItem(new ClothingItem(3, "Hoodie", "Jacket", "Unisex", "XL"));
        searchEngine.addItem(new ClothingItem(4, "Formal Shirt", "Shirt", "Men", "L"));
        searchEngine.addItem(new ClothingItem(5, "Denim Jacket", "Jacket", "Women", "XL"));
        searchEngine.addItem(new ClothingItem(6, "Cotton Shirt", "Shirt", "Unisex", "XL"));


        searchEngine.sortItemsByName();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the exact clothing name to search (e.g., 'classic white t-shirt'): ");
        String searchQuery = sc.nextLine();

        ClothingItem result = searchEngine.binarySearchByName(searchQuery);

        if (result != null) {
            System.out.println("\nClothing item found:");
            result.display();
        } else {
            System.out.println("\nNo clothing item found with name: " + searchQuery.toLowerCase());
        }

        sc.close();
    }
}
