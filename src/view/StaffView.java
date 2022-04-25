package view;

import java.text.ParseException;
import java.util.Scanner;

public class StaffView {
    public StaffView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHÀO BẠN, CHÚC BẠN MỘT NGÀY LÀM VIỆC HIỆU QUẢ!!!");
        System.out.println("CHỌN 1 TRONG CÁC CHẮC NĂNG SAU :");
        System.out.println("1. HIỂN THỊ THÔNG TIN TÀI KHOẢN ");
        System.out.println("2. QUẢN LÝ PHÒNG");
        System.out.println("3. QUẢN LÝ HÓA ĐƠN ");
        System.out.println("4. HIỂN THỊ TẤT CẢ THÔNG TIN TÀI KHOẢN ");
        System.out.println("0. LOGOUT");
        System.out.println("================================================");

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
                System.out.println("CHỌN 1 TRONG CÁC CHẮC NĂNG SAU :");
                System.out.println("1. HIỂN THỊ DANH SÁCH PHÒNG ");
                System.out.println("2. THÊM PHÒNG");
                System.out.println("3. SỬA PHÒNG THEO ID");
                System.out.println("4. HIỂN THỊ PHÒNG CÓ SẴN ");
                System.out.println("5. TÌM PHÒNG THEO ID ");
                System.out.println("6. TÌM PHÒNG CÓ SẴN THEO GIÁ ");
                System.out.println("0. EXIT");
                System.out.println("================================");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 0:
                        new StaffView();
                        break;
                    case 1:
                        new RoomView().showListRoom();
                        break;
                    case 2:
                        new RoomView().createRoom();
                        break;
                    case 3:
                        new RoomView().showRoomList();
                        System.out.println("NHẬP ID PHÒNG BẠN MUỐN TÌM : ");
                        int id = scanner.nextInt();
                        new RoomView().editRoomById(id);
                        break;
                    case 4:
                        new RoomView().showAvailableRoom();
                        break;
                    case 5:
                        new RoomView().findRoomById();
                        break;
                    case 6:
                        new RoomView().findAvailableRoomByPriceRange();
                        break;
                }
                break;
            case 3:
                System.out.println("CHỌN 1 TRONG CÁC CHẮC NĂNG SAU :");
                System.out.println("1. HIỂN THỊ DANH SÁCH HÓA ĐƠN ");
                System.out.println("2. THÊM HÓA ĐƠN ");
                System.out.println("3. SỬA HÓA ĐƠN THEO ID");
                System.out.println("4. XÓA HÓA ĐƠN THEO ID");
                System.out.println("5. TÌM VÀ TÍNH TỔNG HÓA ĐƠN THEO THỜI GIAN");
                System.out.println("6. TÍNH TỔNG DOANH THU");
                System.out.println("0. EXIT");
                System.out.println("==========================================");
                int choice3 = Integer.parseInt(scanner.nextLine());
                switch (choice3) {
                    case 0:
                        new StaffView();
                        break;
                    case 1:
                        new ReceiptView().showListReceipt();
                        break;
                    case 2:
                        try {
                            new ReceiptView().createReceipt();
                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        new ReceiptView().showReceiptList();
                        System.out.println("NHẬP ID HÓA ĐƠN BẠN MUỐN TÌM : ");
                        int id = scanner.nextInt();
                        try {
                            new ReceiptView().editReceiptById(id);
                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        new ReceiptView().deleteReceiptById();
                        break;
                    case 5:
                        new ReceiptView().findReceiptById();
                        break;
                    case 6:
                        new ReceiptView().getTotalRevenue();
                        break;
                }
                break;
            case 4:
                new UserView().showUserList();
                break;
        }
    }

    public static void main(String[] args) {
        new StaffView();
    }
}
