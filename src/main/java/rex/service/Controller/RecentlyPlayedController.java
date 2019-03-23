package rex.service.Controller;

import rex.service.Service.RecentlyPlayedService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MRJH
 * @created 2018/12/5
 **/
@RestController
@RequestMapping("/recentlyPlayed")
public class RecentlyPlayedController {
    @Autowired
    RecentlyPlayedService service;

    @RequestMapping("/getRecentlyPlayedSongs")
    public JSONObject getRecentlyPlayedSongs(@RequestParam("userAccount") String userAccount)
    {
        return service.getRecentlyPlayedSongs(userAccount);
    }

    @RequestMapping("/addRecentlyPlayedSong")
    public JSONObject addRecentlyPlayedSong(@RequestParam("songId") int songId,
                                            @RequestParam("songName") String songName,@RequestParam("singer") String singer,@RequestParam("userAccount") String userAccount,
                                            @RequestParam("coverUrl") String coverUrl,@RequestParam("audioUrl") String audioUrl,@RequestParam("lrcUrl") String lrcUrl,@RequestParam("album") String album)
    {
        service.deleteRecentlyPlayerSong(userAccount,songId);
        int time= (int) System.currentTimeMillis();
        System.out.println("songId:"+songId);
        System.out.println("songName:"+songName);
        System.out.println("singer:"+singer);
        System.out.println("userAccount:"+userAccount);
        System.out.println("audioUrl:"+audioUrl);
        System.out.println("audioUrl:"+lrcUrl);
        System.out.println("coverUrl"+coverUrl);
        System.out.println("album"+album);
        return service.addRecentlyPlayedSong(songId,userAccount,songName,singer,time,coverUrl,audioUrl,lrcUrl,album);
    }

}
