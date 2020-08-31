package survey.service;


import survey.pojo.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAll();

    boolean register(Admin admin);

    Admin login(Admin admin);

    boolean checkUsername(String username);

    Admin queryById(String username);
}
