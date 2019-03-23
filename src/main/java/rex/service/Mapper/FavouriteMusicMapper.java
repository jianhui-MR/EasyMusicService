package rex.service.Mapper;

import org.apache.ibatis.annotations.Mapper;
import rex.service.Bean.Song;

import java.util.List;

@Mapper
public interface FavouriteMusicMapper {

    //根据用户Id获取最近播放歌曲
    List<Song> getFavouriteMusic(String userAccount);

    //增加用户最近播放的歌曲
    void addFavouriteMusic(int songId,String userAccount,String songName,String singer,String coverUrl,String audioUrl,String lrcUrl,String album);

    //删除用户最近播放的指定歌曲
    void deleteFavouriteMusic(String userAccount,int songId);

    Song isFavouriteMusic(String userAccount,int songId);
}
