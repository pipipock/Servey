package survey.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import survey.mapper.AdminMapper;
import survey.pojo.Admin;
import survey.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;
    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


    @Override
    public List<Admin> findAll() {
        return adminMapper.query(null);
    }

    @Override
    public Admin queryOne(Admin admin) {
        try{
            return adminMapper.queryOne(admin);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void register(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public void modifyPassword(int id, String newPassword) {
        Admin admin = new Admin();
        System.out.println(admin);
        admin.setId(id);
        admin.setPassword(newPassword);
        System.out.println(admin.getStatus());
        modify(admin);
    }

    @Override
    public void modify(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public void login(Admin admin) {
        adminMapper.modifyStatus(admin.getId(), true);
        admin.setStatus(true);
    }

    @Override
    public void logout(Admin admin) {
        adminMapper.modifyStatus(admin.getId(), false);
    }


    @Override
    public boolean checkUsername(String username) {
        return queryByUsername(username) != null;
    }

    @Override
    public Admin queryByUsername(String username) {

        Admin admin = new Admin();
        admin.setUsername(username);

        return queryOne(admin);
    }

}
