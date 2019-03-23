package rex.service.Service;

import rex.service.Util.SongListUtil;
import rex.service.Bean.Song;
import rex.service.Mapper.SongListMapper;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MRJH
 * @create 2018/12/6
 **/
@Service
public class SongListService {
    @Autowired
    SongListMapper mapper;

    public JSONObject getTypeSongList(int typeId)
    {
        JSONObject jsonObject=new JSONObject();
        try {
            List<Song> songList=mapper.getTypeSongList(typeId);
            JSONArray json = SongListUtil.getSongListJson(songList);
            jsonObject.put("status",0);
            jsonObject.put("songList",json);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return  jsonObject;
    }

    public JSONObject addTypeSongList(int typeId,int songId,String songName,String singer,String coverUrl,String audioUrl,String lrcUrl, String album)
    {
        JSONObject jsonObject=new JSONObject();
        try{
            mapper.addTypeSongList(typeId,songId,songName,singer,coverUrl,audioUrl,lrcUrl,album);
            jsonObject.put("status",0);
        }catch (Exception e)
        {
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }

    public JSONObject deleteTypeSongList(int typeId,int songId)
    {
        JSONObject jsonObject=new JSONObject();
        try{
            mapper.deleteTypeSongList(typeId,songId);
            jsonObject.put("status",0);
        }catch (Exception e)
        {
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }


}
