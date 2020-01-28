package app;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES WHERE id = #{id}")
    Message getMessage(@Param("id") Integer id);
}