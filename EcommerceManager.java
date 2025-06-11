import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void updatePrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Product: " + name + " | Price: $" + price;
    }
}

public class EcommerceManager {
    private static Map<Integer, Product> productCatalog = new HashMap<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== E-Commerce Product Management ===");

        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Product Price");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    viewProducts();
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Product product = new Product(name, price);
        productCatalog.put(nextId++, product);
        System.out.println("Product added successfully.");
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (productCatalog.containsKey(id)) {
            System.out.print("Enter new price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            productCatalog.get(id).updatePrice(newPrice);
            System.out.println("Product price updated.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (productCatalog.containsKey(id)) {
            productCatalog.remove(id);
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    private static void viewProducts() {
        if (productCatalog.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("=== Product Catalog ===");
            for (Map.Entry<Integer, Product> entry : productCatalog.entrySet()) {
                System.out.println("ID: " + entry.getKey() + " | " + entry.getValue());
            }
        }
    }
}
