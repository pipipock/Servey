package survey.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
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
    public boolean register(Admin admin) {
        Admin ad = queryById(admin.getUsername());
        if(ad == null){
            adminMapper.insert(admin);
            return true;
        }
        return false;

    }

    @Override
    public Admin login(Admin admin) {
        return adminMapper.queryOne(admin);
    }

    @Override
    public boolean checkUsername(String username) {
        return queryById(username) != null;
    }

    @Override
    public Admin queryById(String username) {

        Admin admin = new Admin();
        admin.setUsername(username);

        try{
            System.out.println(adminMapper.queryOne(admin));
            return adminMapper.queryOne(admin);
        }catch(Exception e){
            return null;
        }
    }

}
