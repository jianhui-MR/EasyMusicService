package rex.service.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import rex.service.bean.Song;

import java.util.List;

public class SongListUtil {

    public static JSONArray getSongListJson(List<Song> songList){
        JSONArray json=new JSONArray();
        for (Song song : songList) {
            JSONObject object = new JSONObject();
            object.put("id", song.getSongId());
            object.put("songName", song.getSongName());
            object.put("singer", song.getSinger());
            object.put("coverUrl", song.getCoverUrl());
            object.put("audioUrl", song.getAudioUrl());
            object.put("lrcUrl", song.getLrcUrl());
            object.put("album", song.getAlbum());
            json.add(object);
        }
        return json;
    }
}
