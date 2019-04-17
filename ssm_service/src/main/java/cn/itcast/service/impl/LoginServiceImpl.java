package cn.itcast.service.impl;

import cn.itcast.dao.LogDao;
import cn.itcast.domain.SysLog;
import cn.itcast.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public void add(SysLog log) {
        logDao.add(log);
    }
}
