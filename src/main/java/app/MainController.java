package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    @Autowired
    private MessageMapper mapper;
    @RequestMapping(value = "/index")
    public String index (){
        return "index";
    }

    @GetMapping(value = "message")
    @ResponseBody
    public String getMessage (HttpServletResponse response, @RequestParam(name = "id") int id){
        String resp;
        try {
            resp = mapper.getMessage(id).getMessage();

            response.setStatus(200);
        }
        catch (NullPointerException e){
            resp = "";
            response.setStatus(500);
        }
        System.out.println("request");
        return resp;
    }
}
