package com.integrate.ssm.model.mapper;

import com.integrate.ssm.model.Person;
import com.integrate.ssm.model.PersonCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PersonMapper {
    @SelectProvider(type=PersonSqlProvider.class, method="countByExample")
    long countByExample(PersonCriteria example);

    @DeleteProvider(type=PersonSqlProvider.class, method="deleteByExample")
    int deleteByExample(PersonCriteria example);

    @Delete({
        "delete from person",
        "where PID = #{pid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer pid);

    @Insert({
        "insert into person (PID, NAME, ",
        "AGE, ADDRESS)",
        "values (#{pid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR})"
    })
    int insert(Person record);

    @InsertProvider(type=PersonSqlProvider.class, method="insertSelective")
    int insertSelective(Person record);

    @SelectProvider(type=PersonSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="PID", property="pid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="AGE", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<Person> selectByExample(PersonCriteria example);

    @Select({
        "select",
        "PID, NAME, AGE, ADDRESS",
        "from person",
        "where PID = #{pid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="PID", property="pid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="AGE", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="ADDRESS", property="address", jdbcType=JdbcType.VARCHAR)
    })
    Person selectByPrimaryKey(Integer pid);

    @UpdateProvider(type=PersonSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonCriteria example);

    @UpdateProvider(type=PersonSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Person record, @Param("example") PersonCriteria example);

    @UpdateProvider(type=PersonSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Person record);

    @Update({
        "update person",
        "set NAME = #{name,jdbcType=VARCHAR},",
          "AGE = #{age,jdbcType=INTEGER},",
          "ADDRESS = #{address,jdbcType=VARCHAR}",
        "where PID = #{pid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Person record);
}