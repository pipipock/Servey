package survey.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import survey.pojo.Admin;
import survey.service.AdminService;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {


    private AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "")
    public String defIndex(){
        return "login";
    }


    @RequestMapping(value = "/login")
    public String login(Admin admin, Model model, HttpSession session){
        Admin ad;
        if(!"".equals(admin.getUsername()) && !"".equals(admin.getPassword())) {
            if((ad = adminService.queryOne(admin)) != null) {
                adminService.login(ad);
                session.setAttribute("admin", ad);
                return "index";
            } else {
                model.addAttribute("login_error", "用户名或密码错误");
                return "login";
            }

        }
        model.addAttribute("login_error", "用户名或密码不能为空");
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){

        Admin admin = (Admin)session.getAttribute("admin");
        adminService.logout(admin);
        session.removeAttribute("admin");
        return "login";
    }

    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "register";
    }

    @RequestMapping(value = "/register", produces="text/html;charset=UTF-8")
    public String register(Admin admin, Model model){

        if(!"".equals(admin.getUsername()) && !"".equals(admin.getPassword()) && !"".equals(admin.getName())) {
            if (!adminService.checkUsername(admin.getUsername())) {
                adminService.register(admin);
                return "login";
            }else{
                model.addAttribute("register_error", "注册失败，用户名已重复");
                return "register";
            }
        }
        model.addAttribute("register_error", "用户名或密码或姓名不能为空");
        return "register";
    }

    @RequestMapping(value = "/checkUsername", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String CheckUsername(String username){
        if(adminService.checkUsername(username)){
            return "该用户名已被使用";
        }
        System.out.println(0);
        return "当前用户名可以使用";
    }

    @RequestMapping(value="/modify", produces="text/html;charset=UTF-8")
    public String modify(Admin admin, String[] newPassword, Model model){
        if("".equals(newPassword[0]) || "".equals(admin.getUsername()) || "".equals(admin.getPassword())){
            model.addAttribute("modify_error", "用户名或密码不能为空");
            return "modify";
        }
        if(!newPassword[0].equals(newPassword[1])){
            model.addAttribute("modify_error", "两次新密码不相同");
            return "modify";
        }
        Admin ad;
        if((ad = adminService.queryOne(admin)) != null){
            adminService.modifyPassword(ad.getId(), newPassword[0]);
            model.addAttribute("admin", ad);
            return "index";
        }
        model.addAttribute("modify_error", "用户名密码错误");
        return "modify";
    }

}
