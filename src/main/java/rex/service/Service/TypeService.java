package rex.service.Service;

import rex.service.Bean.Type;
import rex.service.Mapper.TypeMapper;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MRJH
 * @created 2018/12/6
 **/

@Service
public class TypeService {
    @Autowired
    TypeMapper mapper;

    public JSONObject addType(String userAccount,String type)
    {
        JSONObject jsonObject=new JSONObject();
        try{
            mapper.addType(userAccount,type);
            int typeId=mapper.getLastTypeId();
            jsonObject.put("status",0);
            jsonObject.put("typeId",typeId);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }

    public JSONObject deleteType(int typeId)
    {
        JSONObject jsonObject=new JSONObject();
        try{
            mapper.deleteType(typeId);
            mapper.deleteTypeSongList(typeId);
            jsonObject.put("status",0);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }

    public JSONObject updateType(int typeId,String type)
    {
        JSONObject jsonObject=new JSONObject();
        try{
            mapper.updateType(typeId,type);
            jsonObject.put("status",0);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }

    public JSONObject getType(String userAccount)
    {
        JSONObject jsonObject=new JSONObject();
        try{
            JSONArray jsonArray=new JSONArray();
            List<Type> list=mapper.getType(userAccount);
            for (Type t : list)
            {
                JSONObject object=new JSONObject();
                String coverUrl;
                coverUrl=mapper.getTypeCoverUrl(t.getTypeId());
                object.put("type",t.getType());
                object.put("typeId",t.getTypeId());
                object.put("coverUrl",coverUrl);
                jsonArray.add(object);
            }
            jsonObject.put("typeList",jsonArray);
            jsonObject.put("status",0);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }


}
