package view;

import controller.RoomController;
import model.Role;
import model.Room;
import model.RoomStatus;
import model.User;
import service.roomService.RoomServiceIMPL;
import service.staffService.UserServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class RoomView {
    Scanner scanner = new Scanner(System.in);
    RoomController roomController = new RoomController();
    List<Room> roomList = RoomServiceIMPL.roomList;
    List<User> userLoggingList = UserServiceIMPL.userLoggingList;


    public void createRoom() {
        System.out.println("TẠO PHÒNG");
        int id;
        if (roomList.size() == 0) {
            id = 1;
        } else {
            id = roomList.get(roomList.size() - 1).getRoomID() + 1;
        }
        System.out.println("MỜI BẠN NHẬP GIÁ PHÒNG : ");
        double priceRoom = Double.parseDouble(scanner.nextLine());
        System.out.println("MỜI BẠN NHẬP SỐ PHÒNG NGỦ : ");
        String numberOfBedroom = scanner.nextLine();
        System.out.println("MỜI BẠN NHẬP SỐ TOILET: ");
        String numberOfToilet = scanner.nextLine();
        Room room = new Room();
        room.setRoomID(id);
        room.setRoomPrice(priceRoom);
        room.setNumberOfBedroom(numberOfBedroom);
        room.setNumberOfToilet(numberOfToilet);
        System.out.println("NHẬP TRẠNG THÁI (1, 2 , 3): ");
        System.out.println("1. AVAILABLE(CÓ)");
        System.out.println("2. UNAVAILABLE(KHÔNG)");
        System.out.println("3. FIXING(ĐANG SỬA CHỮA)");
        int chooseStatus = scanner.nextInt();
        switch (chooseStatus) {
            case 1:
                room.setRoomStatus(RoomStatus.roomStatusName.AVAILABLE);
                break;
            case 2:
                room.setRoomStatus(RoomStatus.roomStatusName.UNAVAILABLE);
                break;
            case 3:
                room.setRoomStatus(RoomStatus.roomStatusName.FIXING);
                break;
        }
        roomController.createRoom(room);
        System.out.println("BẠN ĐÃ TẠO THÀNH CÔNG PHÒNG !!!");
        new StaffView();
    }

    public void showListRoom()  {
        System.out.println(roomController.showListRoom());
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("NHẬP \"QUIT\" ĐỂ TRỞ VỀ MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                for (int i = 0; i < userLoggingList.size(); i++) {
                    if (Role.RoleName.GUEST.equals(userLoggingList.get(i).getRoleName())) {
                        new GuestView();
                    } else {
                        new StaffView();
                    }
                }
            }
        }
    }

    public void showRoomList()  {
        System.out.println(roomController.showListRoom());

    }

    public void showAvailableRoomList() {
        System.out.println(roomController.showAvailableRoom());
    }

    public void findRoomById () {
        System.out.println("NHẬP ID PHÒNG BẠN MUỐN TÌM: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(roomController.findById(id));
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("NHẬP \"QUIT\" ĐỂ TRỞ VỀ MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                for (int i = 0; i < userLoggingList.size(); i++) {
                    if (Role.RoleName.GUEST.equals(userLoggingList.get(i).getRoleName())) {
                        new GuestView();
                    } else {
                        new StaffView();
                    }
                }
            }
        }
    }


    public void showAvailableRoom() {
        System.out.println(roomController.showAvailableRoom());
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("NHẬP \"QUIT\" ĐỂ TRỞ VỀ MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                for (int i = 0; i < userLoggingList.size(); i++) {
                    if (Role.RoleName.GUEST.equals(userLoggingList.get(i).getRoleName())) {
                        new GuestView();
                    } else {
                        new StaffView();
                    }
                }
            }
        }
    }

    public void findAvailableRoomByPriceRange() {
        System.out.println("NHẬP GIÁ PHÒNG THẤP NHẤT : ");
        double minPriceRoom = Double.parseDouble(scanner.nextLine());
        System.out.println("NHẬP GIÁ PHÒNG CAO NHẤT : ");
        double maxPriceRoom = Double.parseDouble(scanner.nextLine());
        System.out.println(roomController.findAvailableRoomByPriceRange(minPriceRoom, maxPriceRoom));
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("NHẬP \"QUIT\" ĐỂ TRỞ VỀ MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                for (int i = 0; i < userLoggingList.size(); i++) {
                    if (Role.RoleName.GUEST.equals(userLoggingList.get(i).getRoleName())) {
                        new GuestView();
                    } else {
                        new StaffView();
                    }
                }
            }
        }
    }

    public void editRoomById(int id) {
        while (true) {
            for (int i = 0; i < roomList.size(); i++) {
                if (id == roomList.get(i).getRoomID()) {
                    System.out.println("CHỌN 1 TRONG CÁC CHỨC NĂNG SAU");
                    System.out.println("1. SỬA GIÁ PHÒNG ");
                    System.out.println("2. SỬA SỐ PHÒNG NGỦ");
                    System.out.println("3. SỬA SỐ TOILET");
                    System.out.println("4. SỬA TRẠNG THÁI PHÒNG");
                    System.out.println("0. EXIT PROGRAM");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 0:
                            new StaffView();
                        case 1:
                            System.out.println("NHẬP GIÁ: ");
                            double roomPrice = Double.parseDouble(scanner.nextLine());
                            roomList.get(i).setRoomPrice(roomPrice);
                            new RoomServiceIMPL().save();
                            System.out.println("NHẬP PHÍM BẤT KỲ ĐỂ TRỞ VỀ MENU: ");
                            String backMenu1 = scanner.nextLine();
                            new StaffView();
                            break;
                        case 2:
                            System.out.println("NHẬP SỐ PHÒNG NGỦ : ");
                            String numberOfBedroom = scanner.nextLine();
                            roomList.get(i).setNumberOfBedroom(numberOfBedroom);
                            new RoomServiceIMPL().save();
                            System.out.println("NHẬP PHÍM BẤT KỲ ĐỂ TRỞ VỀ MENU: ");
                            String backMenu2 = scanner.nextLine();
                            new StaffView();
                            break;
                        case 3:
                            System.out.println("NHẬP SỐ TOILET: ");
                            String numberOfToilet = scanner.nextLine();
                            roomList.get(i).setNumberOfToilet(numberOfToilet);
                            new RoomServiceIMPL().save();
                            System.out.println("NHẬP PHÍM BẤT KỲ ĐỂ TRỞ VỀ MENU : ");
                            String backMenu3 = scanner.nextLine();
                            new StaffView();
                            break;
                        case 4:
                            System.out.println("CHỌN TRẠNG THÁI PHÒNG (1, 2 , 3): ");
                            System.out.println("1. AVAILABLE(CÓ)");
                            System.out.println("2. UNAVAILABLE(KHÔNG)");
                            System.out.println("3. FIXING(ĐANG SỬA CHỮA)");
                            int chooseStatus = scanner.nextInt();
                            switch (chooseStatus) {
                                case 1:
                                    roomList.get(i).setRoomStatus(RoomStatus.roomStatusName.AVAILABLE);
                                    break;
                                case 2:
                                    roomList.get(i).setRoomStatus(RoomStatus.roomStatusName.UNAVAILABLE);
                                    break;
                                case 3:
                                    roomList.get(i).setRoomStatus(RoomStatus.roomStatusName.FIXING);
                                    break;
                            }
                            new RoomServiceIMPL().save();
                            System.out.println("NHẬP PHÍM BẤT KỲ ĐỂ TRỞ VỀ MENU : ");
                            String backMenu4 = scanner.nextLine();
                            new StaffView();
                            break;
                    }
                }
            }
        }
    }
}
