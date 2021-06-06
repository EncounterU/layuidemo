package com.hh.layuidemo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.layuidemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
