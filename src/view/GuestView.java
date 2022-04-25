package view;

import java.util.Scanner;

public class GuestView {
    public GuestView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("XIN CHÀO QUÝ KHÁCH , CẢM ƠN ĐÃ SỬ DỤNG CỦA CHÚNG TÔI !!!");
        System.out.println("CHỌN 1 CÁC CHỨC NĂNG SAU : ");
        System.out.println("1. HIỂN THỊ THÔNG TIN TÀI KHOẢN ");
        System.out.println("2. QUẢN LÝ PHÒNG");
        System.out.println("3. QUẢN LÝ HÓA ĐƠN");
        System.out.println("0. LOGOUT");
        System.out.println("========================================================");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 0:
                new UserView().logout();
                new Main();
                break;
            case 1:
                new UserView().showUserLogging();
                break;
            case 2:
                System.out.println("CHỌN 1 CÁC CHỨC NĂNG SAU :");
                System.out.println("1. HIỂN THỊ DANH SÁCH PHÒNG ");
                System.out.println("2. HIỂN THỊ PHÒNG CÓ SẴN");
                System.out.println("3. TÌM PHÒNG THEO ID");
                System.out.println("4. TÌM PHÒNG CÓ SẴN TRONG PHẠM VI GIÁ ");
                System.out.println("0. EXIT");
                System.out.println("===================================================================");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 0:
                        new GuestView();
                        break;
                    case 1:
                        new RoomView().showListRoom();
                        break;
                    case 2:
                        new RoomView().showAvailableRoom();
                        break;
                    case 3:
                        new RoomView().findRoomById();
                        break;
                    case 4:
                        new RoomView().findAvailableRoomByPriceRange();
                        break;
                }
                break;
            case 3:
                System.out.println("CHỌN 1 CÁC CHỨC NĂNG SAU :");
                System.out.println("1. TÌM HÓA ĐƠN THEO ID PHÒNG");
                System.out.println("0. EXIT");
                System.out.println("=============================");
                int choice3 = Integer.parseInt(scanner.nextLine());
                switch (choice3) {
                    case 0:
                        new GuestView();
                        break;
                    case 1:
                        new ReceiptView().findReceiptByRoomId();
                        break;
                }
        }
    }
    public static void main (String[]args){
        new GuestView();
    }
}
