package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
            Message message = mapper.getMessage(id);
            response.setStatus(200);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                resp = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
            }
            catch (JsonProcessingException e){
                resp = "";
            }
        }
        catch (NullPointerException e){
            resp = "";
            response.setStatus(500);
        }
        System.out.println("request");
        return resp;
    }
}
