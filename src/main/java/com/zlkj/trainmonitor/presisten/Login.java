package com.zlkj.trainmonitor.presisten;

import com.zlkj.trainmonitor.bean.AuthBean;
import com.zlkj.trainmonitor.bean.AuthSourcesBean;
import com.zlkj.trainmonitor.bean.AuthUserBean;
import com.zlkj.trainmonitor.bean.SysUserBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Login{
    //@Select("select * from PUB_SYSUSER WHERE yhdh = #{yhdh}")
    /**
     * 功能描述：根据用户代号查询用户信息
     * @param userName
     * @return
     */
    public SysUserBean getUserInfoByUserName(String userName);
    /**
     * 功能描述：根据用户代号查询用户所对应的是那个角色(看表的结构是应该可对应多个角色)
     * @param yhdh
     * @return
     */
    public List<AuthUserBean> getAuthUserListByUserName(String yhdh);
    /**
     * 功能描述：根据角色Id查询所对应的角色信息
     * @param roleid
     * @return
     */
    public AuthBean getAuthByRoleId(String roleid);
    /**
     * 功能描述：根据角色id查询对应的资源信息
     * @param roleid
     * @return
     */
    public List<AuthSourcesBean> getAuthSourcesListByRoleId(String roleid);
}
