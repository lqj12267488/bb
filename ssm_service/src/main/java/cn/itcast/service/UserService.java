package cn.itcast.service;

import cn.itcast.domain.SysRole;
import cn.itcast.domain.SysUser;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService  {
    PageInfo<SysUser> findAllUser(Integer pageNum, Integer pageSize);

   void add(SysUser user);


    SysUser findUserById(Integer id);

    List<SysRole> findAllRole();

    void addRole(Integer userId, Integer [] id);

    SysUser findUser(Integer userId);
}
