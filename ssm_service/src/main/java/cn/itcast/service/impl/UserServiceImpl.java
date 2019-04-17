package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.SysRole;
import cn.itcast.domain.SysUser;
import cn.itcast.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("serviceUser")
@Transactional
public class UserServiceImpl implements UserService ,UserDetailsService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public PageInfo<SysUser> findAllUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> list = userDao.findAllUser();
        PageInfo<SysUser> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public void add(SysUser user) {
        //对密码加密
        String pwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pwd);
        userDao.add(user);
    }

    @Override
    public SysUser findUserById(Integer id) {
      SysUser user =   userDao.findUserById(id);

        return user;
    }

    @Override
    public List<SysRole> findAllRole() {
        return userDao.findAllRole();
    }

    @Override
    public void addRole(Integer userId, Integer [] id) {
        //首先清空表中数据
        userDao.del(userId);
        for (Integer integer : id) {

        userDao.addRole(userId,integer);
        }
    }

    @Override
    public SysUser findUser(Integer userId) {
        SysUser user = userDao.findUser(userId);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = userDao.findUserByName(username);

        List<GrantedAuthority>list = new ArrayList<>();

        //list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        List<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
            //System.out.println(role.getRoleName());
        }


        User user1 = new User(user.getUsername(),user.getPassword(),user.getStatus()==1?true:false,true,true,true, list);

        return user1;
    }
}
