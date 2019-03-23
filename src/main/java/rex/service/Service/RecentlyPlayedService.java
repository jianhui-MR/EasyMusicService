package rex.service.Service;

import rex.service.Util.SongListUtil;
import rex.service.Bean.Song;
import rex.service.Mapper.RecentlyPlayedMapper;
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
public class RecentlyPlayedService {

    @Autowired
    RecentlyPlayedMapper mapper;

    public JSONObject getRecentlyPlayedSongs(String userAccount)
    {
        JSONObject jsonObject=new JSONObject();
        try{
            List<Song> songList=mapper.getRecentlyPlayedSongs(userAccount);
            JSONArray json = SongListUtil.getSongListJson(songList);
            jsonObject.put("status",0);
            jsonObject.put("songList",json);
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
            return jsonObject;
        }
    }

    /**
     *
     * @param songId 歌曲I
     * @param userAccount 用户账号
     * @param songName 歌名
     * @param singer 歌手
     * @param time 时间戳
     * @return
     */
    public JSONObject addRecentlyPlayedSong(int songId,String userAccount,String songName,String singer,int time,String albumUrl,String audioUrl,String lrcUrl,String album)
    {
        JSONObject jsonObject=new JSONObject();
        try{
            mapper.addRecentlyPlayedSong(songId,userAccount,songName,singer,time,albumUrl,audioUrl,lrcUrl,album);
            jsonObject.put("status",0);
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
            return jsonObject;

        }
    }

    public void deleteRecentlyPlayerSong(String userAccount,int songId)
    {
        mapper.deleteRecentlyPlayerSong(userAccount,songId);
    }
}
