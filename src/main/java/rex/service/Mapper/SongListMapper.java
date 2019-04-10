package rex.service.Mapper;

import rex.service.Bean.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MRJH
 * @create 2018/12/6
 **/
@Mapper
public interface SongListMapper {
    //获取一个自定义名称歌单的歌曲
    List<Song> getTypeSongList(int typeId);

    //添加歌曲到一个歌单
    void addTypeSongList(int typeId,int songId,String songName,String singer,String coverUrl,String audioUrl,String lrcUrl, String album,long time);

    //从歌单里删除歌曲
    void deleteTypeSongList(int typeId,int songId);
}
