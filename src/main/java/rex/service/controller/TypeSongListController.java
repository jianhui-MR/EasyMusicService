package rex.service.controller;

import rex.service.service.SongListService;
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
@RequestMapping("/typeSongList")
public class TypeSongListController {
    @Autowired
    SongListService service;

    @RequestMapping("/addToSongList")
    public JSONObject addSongList(@RequestParam("typeId")int typeId, @RequestParam("songId") int songId,
                                  @RequestParam("songName") String songName,@RequestParam("singer") String singer,
                                  @RequestParam("coverUrl") String coverUrl,@RequestParam("audioUrl") String audioUrl,
                                  @RequestParam("lrcUrl") String lrcUrl,@RequestParam("album") String album)
    {
        return service.addTypeSongList(typeId,songId,songName,singer,coverUrl,audioUrl,lrcUrl,album);
    }

    @RequestMapping("/deleteFromSongList")
    public JSONObject deleteSongList(@RequestParam("typeId")int typeId, @RequestParam("songId") int songId)
    {
        return service.deleteTypeSongList(typeId,songId);
    }

    @RequestMapping("/getSongList")
    public JSONObject getSongList(@RequestParam("typeId")int typeId)
    {
        return service.getTypeSongList(typeId);
    }
}
