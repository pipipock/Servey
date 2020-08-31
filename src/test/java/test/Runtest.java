package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import survey.mapper.AdminMapper;
import survey.pojo.Admin;
import survey.service.AdminService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})


public class Runtest {
    @Autowired
    private AdminService adminService;

    @Test
    public void testRun(){
        List<Admin> admins = adminService.findAll();
        System.out.println(admins);
    }

}
