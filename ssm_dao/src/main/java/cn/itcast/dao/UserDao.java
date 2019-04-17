package cn.itcast.dao;

import cn.itcast.domain.SysRole;
import cn.itcast.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    //查询所有
    @Select("select * from sys_user")
    List<SysUser>findAllUser();


    //添加用户
    @Insert("insert into sys_user values(aa.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    public void add(SysUser user);

    @Select("select * from sys_user where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "roles",javaType = List.class,column = "id",
                    many = @Many(
                            select = "cn.itcast.dao.RoleDao.findRole"
                    ))
    })
    SysUser findUserByName(String username);


    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "roles",javaType = List.class,column = "id",
            many = @Many(
                    select = "cn.itcast.dao.RoleDao.findRole"
            ))
    })
    SysUser findUserById(Integer id);


    @Select("select * from sys_role")
    List<SysRole> findAllRole();

    @Insert("insert into sys_user_role values(#{userId},#{id})")
    void addRole(
            @Param(value = "userId") Integer userId,
            @Param(value = "id") Integer id);


    @Delete("delete from sys_user_role where userid=#{id}")
    void del(Integer userId);
    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "roles",javaType = List.class,column = "id",
                    many = @Many(
                            select = "cn.itcast.dao.RoleDao.findRole"
                    ))
    })
    SysUser findUser(Integer userId);
}
