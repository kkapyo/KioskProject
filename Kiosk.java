package Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Kiosk.Menu;
import Kiosk.Product;

public class Kiosk {
    private static List<Menu> mainMenu;
    private static List<Product> productMenu;
    private static Order order;

    public static void main(String[] args) {
        mainMenu = new ArrayList<>();
        productMenu = new ArrayList<>();
        order = new Order();

        initializeMainMenu();
        initializeProductMenu();

        displayMainMenu();
    }

    private static void initializeMainMenu() {
        mainMenu.add(new Menu("1. 버거 메뉴", "왓더버거 등 맛있는 버거가 많아요!"));
        mainMenu.add(new Menu("2. 사이드 메뉴", "인기 최고 오지치즈 감자튀김이 있어요!"));
        mainMenu.add(new Menu("3. 드링크 메뉴", "어른, 아이 가릴거 없이 모두를 사로잡은 음료가 있어요!"));
    }

    private static void initializeProductMenu() {
        productMenu.add(new Product("왓더 버거", 6800, "왓더버거만의 달콤한 특제 꿀맛소스에 100% 수제패티!" , "버거메뉴" ));
        productMenu.add(new Product("셧더 버거", 7800, "왓더버거만의 바베큐소스에 베이컨+패티+볶은양파+피클의 환상적인 조화!", "버거메뉴"));
        productMenu.add(new Product("지못미 버거", 8100, "매콤달콤 특제 숙성 스리라차마요 소스에 100% 수제패티 스크램블이 폭탄!", "버거메뉴"));
        productMenu.add(new Product("통 새우버거", 7800, "달콤한 와사마요 특제소스에 통새우 패티와 새우링토핑의 환상적인 조화!", "버거메뉴"));
        productMenu.add(new Product("시그니쳐 버거", 6800, "깔끔한 수제 머스타드 소스에 100% 수제패티 리얼 아메리카 버거!", "버거메뉴"));
        productMenu.add(new Product("오지치즈 감자튀김", 5800, "바삭한 감자튀김에 찐한치즈와 특제소스를 얹은 왓더버거의 인기메뉴!", "사이드메뉴"));
        productMenu.add(new Product("감자튀김", 3800, "누가와도 맛있다고 느끼는 왓더버거의 감자튀김!", "사이드메뉴"));
        productMenu.add(new Product("해쉬브라운", 3000, "시키면 후회없이 맛있게 먹을 수 있는 해쉬브라운!", "사이드메뉴"));
        productMenu.add(new Product("치즈볼", 4200, " 촉촉하고 쫀득하며 단짠단짠 중독되는 치즈볼!", "사이드메뉴"));
        productMenu.add(new Product("치즈스틱", 2800, "고소하고 쭈~욱 늘어나는 치즈스틱!", "사이드메뉴"));
        productMenu.add(new Product("쉬림프링", 3800, "겉은 바삭! 속은 촉촉~ 씹는 맛이 즐거운 쉬림프링!", "사이드메뉴"));
        productMenu.add(new Product("코카콜라", 2000, "펩시는 취급안합니다. ", "드링크메뉴"));
        productMenu.add(new Product("사이다", 2000, "스프라이트 취급안합니다. ", "드링크메뉴"));
        productMenu.add(new Product("환타", 2000, "제가 좋아해서 넣었습니다. ", "드링크메뉴"));
        productMenu.add(new Product("하이네켄", 3800, "하이네 켄 ", "드링크메뉴"));
        productMenu.add(new Product("코젤다크", 3900, "코젤 다크 ", "드링크메뉴"));
        productMenu.add(new Product("곰표밀맥주", 4200, "곰표 밀맥주 ", "드링크메뉴"));
        productMenu.add(new Product("버드와이저", 3400, "버드와이저 ", "드링크메뉴"));

    }

    private static void displayMainMenu() {
        System.out.println("=== ★왓더버거★ ===");
        for (Menu menu : mainMenu) {
            System.out.println(menu.getName() + " - " + menu.getDescription());
        }
        System.out.println("주문 - 주문 조회");
        System.out.println("종료 - 키오스크 종료");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                displayProductMenu("버거메뉴");
                break;
            case "2":
                displayProductMenu("사이드메뉴");
                break;
            case "3":
                displayProductMenu("드링크메뉴");
                break;
            case "주문":
                displayOrderMenu();
                break;
            case "종료":
                break;
            default:
                System.out.println("값을 제대로 입력해주세요!");
                displayMainMenu();
        }
    }

    private static void displayProductMenu(String category) {
        System.out.println("=== " + category + " ===");
        for (Product product : productMenu) {
            if (product.getCategory().equals(category)) {
//          if (product.getDescription().startsWith(category)) { // 이전까지 이 코드를 사용하고있었음 그래서 각 카테고리에 해당하는 음식들이 들어가지 못하였음
                System.out.println(product.getName() + " - 가격: " + product.getPrice() + "원 - " + product.getDescription());
            }
        }
        System.out.println("메뉴 - 메인 메뉴로 되돌아가기");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("메뉴")) {
            displayMainMenu();
        } else {
            for (Product product : productMenu) {
                if (product.getName().equals(input)) {
                    confirmProduct(product);
                    return;
                }
            }
            System.out.println("유효하지 않은 입력입니다!");
            displayProductMenu(category);
        }
    }

    private static void confirmProduct(Product product) {
        System.out.println("정말로 " + product.getName() + " 을(를) 담으시겠습니까? (Y/N)");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("Y")) {
            order.addToCart(product);
            displayMainMenu();
        } else if (input.equals("N")) {
            displayMainMenu();
        } else {
            System.out.println("값을 제대로 입력해주세요!");
            confirmProduct(product);
        }
    }

    private static void displayOrderMenu() {
        System.out.println("=== ★왓더 버거★ ===");
        order.viewCart();
        System.out.println("확인 - 주문하기");
        System.out.println("취소 - 주문취소");
        System.out.println("메뉴 - 메인으로 되돌아가기");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("확인")) {
            completeOrder();
        } else if (input.equals("메뉴")) {
            displayMainMenu();
        } else if (input.equals("취소")) {
            cancelOrder();
        } else {
            System.out.println("값을 제대로 입력해주세요!");
            displayOrderMenu();
        }
    }
    private static int orderNumber = 0;

    private static void completeOrder() {
        orderNumber++;
        System.out.println("주문이 완료되었습니다! 대기번호는 " + orderNumber + "번 입니다!");
        order.viewCart();
        order.clearCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        displayMainMenu();
    }

    private static void cancelOrder() {
        System.out.println("주문을 취소하시겠습니까? (Y/N)");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("Y")) {
            order.clearCart();
            System.out.println("주문이 취소되었습니다!");
            displayMainMenu();
        } else if (input.equals("N")) {
            displayMainMenu();
        } else {
            System.out.println("값을 제대로 입력해주세요!");
            cancelOrder();
        }
    }
}
