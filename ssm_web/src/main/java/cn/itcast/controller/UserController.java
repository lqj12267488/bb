package cn.itcast.controller;

import cn.itcast.domain.SysRole;
import cn.itcast.domain.SysUser;
import cn.itcast.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
@RolesAllowed("ROLE_ADMIN")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/findAllUser")
    public String find(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "3") Integer pageSize) {
        PageInfo<SysUser> info = userService.findAllUser(pageNum, pageSize);
        model.addAttribute("uList",info);
        return "/user/userList";
    }


    //添加用户跳转页面
    @RequestMapping(value = "/userAddUI")
    public String add() {
        return "/user/userAdd";
    }

    //添加用户
    @RequestMapping(value = "/userAdd")
    public String addUser(SysUser user) {
        //System.out.println(user);
        userService.add(user);
        return "redirect:/user/findAllUser";
    }
    @RequestMapping("/managerUserRoleUI")
    public String managerUserRoleUI(Integer userId,Model model){
        //System.out.println(id);
        SysUser user = userService.findUserById(userId);
        //System.out.println(user.getRoles());
        model.addAttribute("user",user);
        List<SysRole> list1 = user.getRoles();
        StringBuilder sb = new StringBuilder();
        for (SysRole role : list1) {
            sb.append(role.getRoleName());
            sb.append(",");
        }

        //查询所有的角色
        List<SysRole>list = userService.findAllRole();
        model.addAttribute("roleList",list);
        model.addAttribute("roleUser",sb);
        //System.out.println(sb);
        /*for (SysRole role : list) {
            System.out.println(role);
        }*/
        return "/user/user-role-add";
    }


    //保存
    @RequestMapping("/adduser_role")
    public String adduser_role(Integer userId,Integer [] ids){
       // userService.addRole(userId,ids);

            userService.addRole(userId,ids);
            return "redirect:/user/findAllUser";

    }
    @RequestMapping("/userDetail1")
    public String userDetail(Integer userId,Model model) {
        System.out.println(userId);
        SysUser user = userService.findUser(userId);
        //List<SysRole> list = user.getRoles();
        model.addAttribute("user",user);
        return "/user/userDetail";
    }



}
