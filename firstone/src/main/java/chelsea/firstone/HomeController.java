package chelsea.firstone;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping(value = "/")
    public String Welcome(){
        return "WELCOME, PLEASED TO MEET YOU";
    }
}