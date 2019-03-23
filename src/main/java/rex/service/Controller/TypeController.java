package rex.service.Controller;

import rex.service.Service.TypeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MRJH
 * @created 2018/12/6
 **/
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    TypeService service;


    @RequestMapping("/addType")
    public JSONObject addType(@RequestParam("userAccount") String userAccount,@RequestParam("type") String type)
    {
        return service.addType(userAccount,type);
    }

    @RequestMapping("/deleteType")
    public JSONObject deleteType(@RequestParam("typeId") int typeId)
    {
        System.out.println(typeId);
        return service.deleteType(typeId);
    }

    @RequestMapping("/updateType")
    public JSONObject updateType(@RequestParam("typeId") int typeId,@RequestParam("type") String type)
    {
        return service.updateType(typeId,type);
    }

    @RequestMapping("/getType")
    public JSONObject getType(@RequestParam("userAccount") String userAccount)
    {
        System.out.println(userAccount);
        return service.getType(userAccount);
    }

}
