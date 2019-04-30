package rex.service.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rex.service.service.FavouriteMusicService;

import static java.lang.System.out;

@RestController
@RequestMapping("/favouriteMusic")
public class FavouriteMusicController {
    @Autowired
    FavouriteMusicService service;

    @RequestMapping("/getFavouriteMusic")
    public JSONObject getFavouriteMusic(@RequestParam("userAccount") String userAccount)
    {
        return service.getFavouriteMusic(userAccount);
    }

    @RequestMapping("/addFavouriteMusic")
    public JSONObject addFavouriteMusic(@RequestParam("songId") int songId,
                                            @RequestParam("songName") String songName,@RequestParam("singer") String singer,@RequestParam("userAccount") String userAccount,
                                            @RequestParam("coverUrl") String coverUrl,@RequestParam("audioUrl") String audioUrl,@RequestParam("lrcUrl") String lrcUrl,@RequestParam("album") String album)
    {
        out.println("songId:"+songId);
        out.println("songName:"+songName);
        out.println("singer:"+singer);
        out.println("userAccount:"+userAccount);
        out.println("audioUrl:"+audioUrl);
        out.println("audioUrl:"+lrcUrl);
        out.println("coverUrl"+coverUrl);
        out.println("album"+album);
        return service.addFavouriteMusic(songId,userAccount,songName,singer,coverUrl,audioUrl,lrcUrl,album);
    }

    @RequestMapping("/deleteFavouriteMusic")
    public JSONObject deleteFavouriteMusic(@RequestParam("userAccount") String userAccount,@RequestParam("songId") int songId){
        return  service.deleteFavouriteMusic(userAccount,songId);
    }

    @RequestMapping("/isFavouriteMusic")
    public JSONObject isFavouriteMusic(@RequestParam("userAccount") String userAccount,@RequestParam("songId") int songId){
        return service.isFavouriteMusic(userAccount, songId);
    }
}
