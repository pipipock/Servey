package survey.Controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import survey.pojo.Admin;
import survey.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "")
    public String defIndex(){
        return "login";
    }


    @RequestMapping(value = "/login")
    public String login(Admin admin, Model model){
        if(admin.getUsername() != "" && admin.getPassword() != "") {
            Admin ad = adminService.login(admin);
            if (ad != null) {
                model.addAttribute("admin", ad);
                return "index";
            }else{
                model.addAttribute("login_error", "用户名或密码错误");
                return  "login";
            }
        }
        model.addAttribute("login_error", "用户名或密码不能为空");
        return "login";
    }

    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "register";
    }

    @RequestMapping(value = "/register")
    public String register(Admin admin, Model model){

        if(admin.getUsername() != "" && admin.getPassword() != "" && admin.getName() != "") {
            if (adminService.register(admin)) {
                model.addAttribute("admin", admin);
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
        System.out.println(username);
        if(adminService.checkUsername(username)){
            System.out.println(1);
            return "该用户名已被使用";
        }
        System.out.println(0);
        return "当前用户名可以使用";
    }
}
