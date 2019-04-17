package cn.itcast.controller;

import cn.itcast.domain.SysRole;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.relation.Role;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findAll")
    public String findAllRole(Model model) {
        List<SysRole> list = roleService.findAllRole();
        model.addAttribute("rList",list);
        return "/role/roleList";
    }

    @RequestMapping("/addRoleUI")
    public String addRoleUI() {
        return "/role/roleAdd";

    }

    @RequestMapping("/roleAdd")
    public String roleAdd(SysRole role) {
        //System.out.println(role);
        roleService.saveRole(role);
        return "redirect:/role/findAll";
    }
}
