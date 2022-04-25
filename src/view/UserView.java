package view;

import controller.UserController;
import model.Role;
import model.User;
import service.staffService.UserServiceIMPL;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();
    List<User> userList = UserServiceIMPL.userList;
    List<User> userLoggingList = UserServiceIMPL.userLoggingList;

    public void RegisterView() {
        System.out.println("ĐĂNG KÝ");
        int id;
        if (userList.size() == 0) {
            id = 1;
        } else {
            id = userList.get(userList.size() - 1).getUserID() + 1;
        }

        System.out.println("MỜI BẠN NHẬP TÊN: ");
        String name = scanner.nextLine();

        System.out.println("MỜI BẠN NHẬP TÊN( TỪ 8 ĐẾN 16 KÝ TỰ : ");
        String username;
        boolean checkUserName;
        while (true) {
            username = scanner.nextLine();
            checkUserName = Pattern.matches("[A-Za-z0-9]{8,16}", username);
            if (!checkUserName) {
                System.err.println("TÊN KHÔNG HỢP LỆ !!! MỜI BẠN NHẬP LẠI");
            } else if (userController.existedByUserName(username)) {
                System.err.println("TÊN ĐĂNG NHẬP ĐÃ TỒN TẠI !!! MỜI BẠN NHẬP LẠI");
            } else {
                break;
            }
        }

        System.out.println("MỜI BẠN NHÂP MẬT KHẨU (TỪ 8 ĐẾN 16 KÝ TỰ");
        String password;
        boolean checkPassWord;
        while (true) {
            password = scanner.nextLine();
            checkPassWord = Pattern.matches("^[A-Za-z0-9]{8,16}$", password);
            if (!checkPassWord) {
                System.err.println("MẬT KHẨU KHÔNG HỢP LỆ !!! MỜI BẠN NHẬP LẠI");
            } else {
                break;
            }
        }

        System.out.println("MỜI BẠN NHẬP EMAIL : ");
        String email;
        boolean checkEmail;
        while (true) {
            email = scanner.nextLine();
            checkEmail = Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", email);
            if (!checkEmail) {
                System.err.println("EMAIL KHÔNG HỢP LỆ !!! MỜI BẠN NHẬP LẠI");
            } else {
                break;
            }
        }

        System.out.println("MỜI BẠN NHẬP SỐ ĐIỆN THOẠI : ");
        String phoneNumber;
        boolean checkPhoneNumber;
        while (true) {
            phoneNumber = scanner.nextLine();
            checkPhoneNumber = Pattern.matches("^0[0-9]{8,9}$", phoneNumber);
            if (!checkPhoneNumber) {
                System.err.println("PHONENUMBER FAILED! PLEASE TRY AGAIN!");
            } else {
                break;
            }
        }

        User user = new User();
        user.setUserID(id);
        user.setName(name);
        user.setUserPhoneNumber(phoneNumber);
        user.setUserEmail(email);
        user.setUserName(username);
        user.setPassWord(password);
        System.out.println("CHỌN TƯ CÁCH THÀNH VIÊN : ");
        System.out.println("1. KHÁCH");
        System.out.println("2. NHÂN VIÊN");
        int chooseRole = scanner.nextInt();
        switch (chooseRole) {
            case 1:
                user.setRoleName(Role.RoleName.GUEST);
                break;
            case 2:
                user.setRoleName(Role.RoleName.STAFF);
                break;
        }
        userController.createUser(user);
        if (user.getRoleName() == Role.RoleName.GUEST) {
            userController.createGuest(user);
        } else if (user.getRoleName() == Role.RoleName.STAFF) {
            userController.createStaff(user);
        }
        System.out.println("CHÚC MỪNG BẠN ĐÃ ĐĂNG KÝ THÀNH CÔNG !!!");
        new Main();
    }

    public void LoginView() {
        System.out.println("ĐĂNG NHẬP");

        System.out.println("MỜI BẠN NHẬP TÊN ĐĂNG NHẬP: ");
        String username = scanner.nextLine();
        System.out.println("MỜI BẠN NHẬP MẬT KHẨU : ");
        String password = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName()) && password.equals(userList.get(i).getPassWord())) {
                System.out.println("ĐĂNG NHẬP THÀNH CÔNG !!!");
                count++;
                User user = new User(userList.get(i).getUserID(), userList.get(i).getName(), userList.get(i).getUserPhoneNumber(), userList.get(i).getUserEmail(), userList.get(i).getUserName(), userList.get(i).getPassWord(), userList.get(i).getRoleName());
                userController.updateUserLogging(user);
                if (Role.RoleName.GUEST.equals(userList.get(i).getRoleName())) {
                    new GuestView();
                    break;
                } else {
                    new StaffView();
                    break;
                }
            } else if (count == 0 && i == userList.size() - 1) {
                System.out.println("ĐĂNG NHẬP THẤT BẠI !!! MỜI BẠN THỬ LẠI");
                new UserView().LoginView();
            }
        }
    }

    public void showUserLogging() {
        System.out.println(userController.showUserLogging());
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("NHẤN \"QUIT\" ĐỂ TRỞ VỀ MENU: ");
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

    public void showUserList() {
        System.out.println(userController.showListUser());
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("NHẤN \"QUIT\" ĐỂ TRỞ VỀ MENU: ");
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

    public void showStaffList() {
        System.out.println(userController.showStaffList());
    }

    public void showGuestList() {
        System.out.println(userController.showGuestList());
    }

    public void logout() {
        userController.louout();
    }
}
