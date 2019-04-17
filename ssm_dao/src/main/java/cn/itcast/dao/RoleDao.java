package cn.itcast.dao;

import cn.itcast.domain.SysRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import javax.management.relation.Role;
import java.util.List;

public interface RoleDao {
    //查询所有
    @Select("select * from sys_role")
    List<SysRole> findAllRole();
    @Insert("insert into sys_role values(com_sequence.nextval,#{roleName},#{roleDesc})")
    void save(SysRole role);

    @Select("select * from sys_role where id in(select roleid from sys_user_role where userid = #{id})")
    List<SysRole>findRole();
}
