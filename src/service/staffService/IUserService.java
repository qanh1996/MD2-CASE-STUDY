package service.staffService;

import model.User;
import service.IGenericService;

import java.util.List;

public interface IUserService extends IGenericService<User> {
    boolean existedByUsername(String username);

    List<User> findAllLogging();

    void saveLogging(User user);

    void logout();

    List<User> findAllGuest();

    List<User> findAllStaff();

    User findStaffById(int id);

    User findGuestById(int id);

    void saveStaff(User user);

    void saveGuest(User user);
}
