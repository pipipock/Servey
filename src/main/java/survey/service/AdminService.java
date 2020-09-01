package survey.service;


import survey.pojo.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAll();

    void register(Admin admin);

    void login(Admin admin);

    boolean checkUsername(String username);

    Admin queryByUsername(String username);

    void logout(Admin admin);

    Admin queryOne(Admin admin);

    void modify(Admin admin);

    void modifyPassword(int id, String newPassword);
}
