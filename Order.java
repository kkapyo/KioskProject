package Kiosk;

import java.util.ArrayList;
import java.util.List;

class Order {
    private List<Product> cart;

    public Order() {
        cart = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cart.add(product);
        System.out.println(product.getName() + "이(가) 장바구니에 추가되었습니다.");
    }

    public void viewCart() {
        System.out.println("장바구니 목록:");
        int total = 0;
        for (Product product : cart) {
            System.out.println(product.getName() + " - 가격: " + product.getPrice());
            total += product.getPrice();
        }
        System.out.println("총 가격: " + total);
    }

    public void clearCart() {
        cart.clear();
    }
}
