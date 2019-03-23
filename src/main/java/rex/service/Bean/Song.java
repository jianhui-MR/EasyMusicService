package rex.service.Bean;

/**
 * @author MRJH
 * @created 2018/12/5
 **/
public class Song {

    //歌曲Id值
    int songId;
    //歌曲名字
    String songName;
    //歌手名字
    String singer;
    //歌曲所对应的歌单名字（所属歌单）
    String type;
    //专辑封面图链接
    String coverUrl;
    //播放链接
    String audioUrl;
    //歌词链接
    String lrcUrl;
    //专辑
    String album;

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getAlbum() {
        return album;
    }
    public String getAudioUrl() {
        return audioUrl;
    }

    public String getLrcUrl() {
        return lrcUrl;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getSinger() {
        return singer;
    }

    public String getType() {
        return type;
    }

}

