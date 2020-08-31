package survey.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BasicController {

    @RequestMapping("")
    public String defIndex(){
        return "login";
    }


}
