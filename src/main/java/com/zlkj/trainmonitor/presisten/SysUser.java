package com.zlkj.trainmonitor.presisten;

import com.zlkj.trainmonitor.bean.SysUserBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysUser {
    /**
     * 功能描述：查询系统用户
     * @param sysUserBean
     * @return
     */
    public List<SysUserBean> getSysUsers(SysUserBean sysUserBean);

    /**
     * 功能描述：查询系统用户
     * @param sysUserBean
     * @return
     */
    public int addUser(SysUserBean sysUserBean);
}
