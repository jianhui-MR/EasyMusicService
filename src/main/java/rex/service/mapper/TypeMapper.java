package rex.service.mapper;

import rex.service.bean.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MRJH
 * @created 2018/12/6
 **/
@Mapper
public interface TypeMapper {

    //增加自定义列表
    void addType(String userAccount,String type);

    //删除自定义列表
    void deleteType(int typeId);

    //修改自定义列表名字
    void updateType(int typeId,String type);

    String getTypeCoverUrl(int typeId);

    //获取自定义列表名称
    List<Type> getType(String userAccount);

    int getLastTypeId();
}
