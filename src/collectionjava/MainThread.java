/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionjava;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author daolinh
 */
public class MainThread {

    private static HashMap<Integer, Product> mapProduct;
    private static HashMap<Integer, CartItem> shoppingCart;

    static {
        generateProduct();
        shoppingCart = new HashMap<>();
    }

    public static void main(String[] args) {
        generateMenu();
    }

    private static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = 0;
            System.out.println("---------------Hello Shopping---------------");
            System.out.println("1. Lựa chọn sản phẩm.");
            System.out.println("2. Kiểm tra giỏ hàng.");
            System.out.println("3. Thoát chương trình.");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    printListProduct();
                    selectProduct();
                    break;
                case 2:
                    printShoppingCart();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng lựa chọn trong khoảng từ 1 đến 3.");
                    break;
            }
        }
    }

    private static void printListProduct() {
        System.out.println("---------------Danh sách sản phẩm---------------");
        System.out.println("Id\tTên\t\tGiá(VND)");
        for (Map.Entry<Integer, Product> entry : mapProduct.entrySet()) {
            Product product = entry.getValue();
            System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getUnitPrice());
        }
    }

    private static void generateProduct() {
        mapProduct = new HashMap<>();
        Product p = new Product();
        p.setId(1);
        p.setName("Quần đùi");
        p.setUnitPrice(10000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(2);
        p.setName("Quần soóc");
        p.setUnitPrice(50000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(3);
        p.setName("Quần đũi");
        p.setUnitPrice(100000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(4);
        p.setName("Quần ngố");
        p.setUnitPrice(40000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(5);
        p.setName("Áo ba lỗ");
        p.setUnitPrice(10000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(6);
        p.setName("Áo thể thao");
        p.setUnitPrice(100000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(7);
        p.setName("Áo sơ mi");
        p.setUnitPrice(200000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(8);
        p.setName("Giày adidas");
        p.setUnitPrice(200000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(9);
        p.setName("Dép tổ ong");
        p.setUnitPrice(20000);
        mapProduct.put(p.getId(), p);

        p = new Product();
        p.setId(10);
        p.setName("Mũ thể thao");
        p.setUnitPrice(10000);
        mapProduct.put(p.getId(), p);
    }

    private static void selectProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vui lòng nhập id sản phẩm muốn mua: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = mapProduct.get(id);
        if (product == null) {
            System.out.println("Sản phẩm không tồn tại hoặc đã bị xoá.");
            return;
        }
        addCartItem(product);
    }

    private static void addCartItem(Product product) {
        CartItem cartItem = null;
        if (shoppingCart.containsKey(product.getId())) {
            cartItem = shoppingCart.get(product.getId());
            cartItem.setQuantity(cartItem.getQuantity() + 1);            
        } else {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);            
        }
        shoppingCart.put(product.getId(), cartItem);
        System.out.println("Thêm sản phẩm vào giỏ hàng thành công.");
        System.out.println("Sản phẩm: " + cartItem.getProduct().getName());
        System.out.println("Số lượng: " + cartItem.getQuantity());
        System.out.println("Thành tiền (VND): " + cartItem.getProduct().getUnitPrice() * cartItem.getQuantity());
    }

    private static void printShoppingCart() {
        System.out.println("---------------Giỏ hàng---------------");
        System.out.println("Tên sản phẩm\tSố lượng\tThành tiền(VND)");
        int totalPrice = 0;
        for (Map.Entry<Integer, CartItem> entry : shoppingCart.entrySet()) {
            CartItem item = entry.getValue();
            System.out.println(item.getProduct().getName()
                    + "\t"
                    + item.getQuantity()
                    + "\t\t"
                    + item.getQuantity() * item.getProduct().getUnitPrice());
            totalPrice += item.getQuantity() * item.getProduct().getUnitPrice();
        }
        System.out.println("Tổng tiền: " + totalPrice);
    }
}
