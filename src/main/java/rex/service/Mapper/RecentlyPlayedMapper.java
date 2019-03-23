package rex.service.Mapper;

import rex.service.Bean.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MRJH
 * @created 2018/12/5
 **/
@Mapper
public interface RecentlyPlayedMapper {
    //根据用户Id获取最近播放歌曲
    List<Song> getRecentlyPlayedSongs(String userAccount);

    //增加用户最近播放的歌曲
    void addRecentlyPlayedSong(int songId,String userAccount,String songName,String singer,int time,String coverUrl,String audioUrl,String lrcUrl,String album);

    //删除用户最近播放的指定歌曲
    void deleteRecentlyPlayerSong(String userAccount,int songId);
}
