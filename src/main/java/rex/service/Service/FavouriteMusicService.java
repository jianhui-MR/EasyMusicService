package rex.service.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rex.service.Util.SongListUtil;
import rex.service.Bean.Song;
import rex.service.Mapper.FavouriteMusicMapper;

import java.util.List;

@Service
public class FavouriteMusicService {

    @Autowired
    FavouriteMusicMapper mapper;

    public JSONObject getFavouriteMusic(String userAccount) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Song> songList = mapper.getFavouriteMusic(userAccount);
            JSONArray json = SongListUtil.getSongListJson(songList);
            jsonObject.put("status", 0);
            jsonObject.put("songList", json);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("status", 1);
            return jsonObject;
        }
    }

    /**
     * @param songId      歌曲I
     * @param userAccount 用户账号
     * @param songName    歌名
     * @param singer      歌手
     * @return
     */
    public JSONObject addFavouriteMusic(int songId, String userAccount, String songName, String singer, String albumUrl, String audioUrl, String lrcUrl, String album) {
        JSONObject jsonObject = new JSONObject();
        try {
            long time= System.currentTimeMillis();
            mapper.addFavouriteMusic(songId, userAccount, songName, singer, albumUrl, audioUrl, lrcUrl, album,time);
            jsonObject.put("status", 0);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("status", 1);
            return jsonObject;

        }
    }

    public JSONObject deleteFavouriteMusic(String userAccount, int songId) {
        JSONObject jsonObject = new JSONObject();
        try {
            mapper.deleteFavouriteMusic(userAccount, songId);
            jsonObject.put("status", 0);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("status", 1);
        }
        return jsonObject;
    }

    public JSONObject isFavouriteMusic(String userAccount,int songId){
        JSONObject jsonObject=new JSONObject();
        try {
            Song song=mapper.isFavouriteMusic(userAccount, songId);
            if (song==null)
                jsonObject.put("isFavouriteMusic",false);
            else
                jsonObject.put("isFavouriteMusic",true);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("isFavouriteMusic",false);
        }
        return jsonObject;
    }
}
