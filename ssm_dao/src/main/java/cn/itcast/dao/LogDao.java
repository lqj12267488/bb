package cn.itcast.dao;

import cn.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao {
    @Insert("insert into sys_log values(com_sequence.nextval,#{visitTime},#{username},#{ip},#{method},#{executeTime},#{executeResult},#{executeMsg})")
    void add(SysLog log);
    //注释
}
