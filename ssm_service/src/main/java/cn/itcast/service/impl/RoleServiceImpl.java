package cn.itcast.service.impl;

import cn.itcast.dao.RoleDao;
import cn.itcast.domain.SysRole;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<SysRole> findAllRole() {
        return roleDao.findAllRole();
    }

    @Override
    public void saveRole(SysRole role) {
        roleDao.save(role);
    }
}
