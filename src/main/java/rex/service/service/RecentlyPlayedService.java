package rex.service.service;

import rex.service.util.SongListUtil;
import rex.service.bean.Song;
import rex.service.mapper.RecentlyPlayedMapper;
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
     * @return
     */
    public JSONObject addRecentlyPlayedSong(int songId,String userAccount,String songName,String singer,String albumUrl,String audioUrl,String lrcUrl,String album)
    {
        JSONObject jsonObject=new JSONObject();
        long time= System.currentTimeMillis();
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
