package com.course.server.mapper;

import com.course.server.domain.Stu;
import com.course.server.domain.StuExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StuMapper {
    long countByExample(StuExample example);

    int deleteByExample(StuExample example);

    int deleteByPrimaryKey(String id);

    int insert(Stu record);

    int insertSelective(Stu record);

    List<Stu> selectByExample(StuExample example);

    Stu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Stu record, @Param("example") StuExample example);

    int updateByExample(@Param("record") Stu record, @Param("example") StuExample example);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);

    @Select("select * from user")
    public List<Stu> find();

    @Insert("insert into stu(id,name,idNumber,phoneNb,sex,address,birthNb,majorId,create_at,updated_at) values(#{id},#{name},#{idNumber},#{phoneNb},#{sex},#{address},#{birthNb},#{majorId},#{create_at},#{updated_at})")
    public int add(Stu stu);
}