package cn.itcast.service;

import cn.itcast.domain.SysRole;

import javax.management.relation.Role;
import java.util.List;

public interface RoleService {
    List<SysRole> findAllRole();

    void saveRole(SysRole role);
}
