package view;

import java.util.Scanner;

public class Main {
    public Main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("KHÁCH SẠN 123 KÍNH CHÀO QUÝ KHÁCH!!!");
        System.out.println("CHỌN 1 HOẶC 2");
        System.out.println("1. ĐĂNG KÝ");
        System.out.println("2. ĐĂNG NHẬP");
        System.out.println("====================================");

        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1: new UserView().RegisterView();
                break;
            case 2: new UserView().LoginView();
                break;
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
