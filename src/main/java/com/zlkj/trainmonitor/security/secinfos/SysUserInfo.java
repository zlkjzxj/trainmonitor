package com.zlkj.trainmonitor.security.secinfos;

import com.zlkj.trainmonitor.bean.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SysUserInfo {
    private SysUserBean sysUserBean;//用户信息
    private List<AuthUserBean> authUsers;//用户对应角色集合
    private List<AuthBean> authBeans;//所有角色信息
    private List<AuthSourcesBean> authSourcesBeanList;//角色对应资源集合
    private List<DepartmentBean> deps;//
    private SoftInfoBean softInfo;

    public SysUserInfo(){

    }

    public SysUserInfo(SysUserBean sysUserBean, List<AuthUserBean> authUsers, List<AuthBean> authBeans, List<AuthSourcesBean> authSourcesBeanList, List<DepartmentBean> deps, SoftInfoBean softInfo) {
        this.sysUserBean = sysUserBean;
        this.authUsers = authUsers;
        this.authBeans = authBeans;
        this.authSourcesBeanList = authSourcesBeanList;
        this.deps = deps;
        this.softInfo = softInfo;
    }

    public SysUserBean getSysUserBean() {
        return sysUserBean;
    }

    public void setSysUserBean(SysUserBean sysUserBean) {
        this.sysUserBean = sysUserBean;
    }

    public SoftInfoBean getSoftInfo() {
        return softInfo;
    }

    public void setSoftInfo(SoftInfoBean softInfo) {
        this.softInfo = softInfo;
    }

    /**
     * 功能描述：返回yhdh对应的角色，多个中间，号隔开
     * @return
     */
    public String getUserRoleName()
    {

        StringBuffer roleNames=new StringBuffer();
        for(AuthUserBean aub:authUsers)
        {
            for(AuthBean authBean:authBeans)
            {
                if(StringUtils.equals(aub.getRoleid(), authBean.getRoleid())) roleNames.append(authBean.getRoledesc()+",");
            }
        }
        if(StringUtils.isNotEmpty(roleNames)) return roleNames.substring(0,roleNames.length()-1);
        return "";
    }

    /**
     * 功能描述：返回yhdh对应的部门信息
     * @return
     */
    public DepartmentBean getUserDepInfo()
    {
        for(DepartmentBean departmentBean:deps)
        {
            if(StringUtils.equals(sysUserBean.getBmdh(), departmentBean.getBmdh())) return departmentBean;

        }
        return null;
    }

    /**
     * 功能描述：返回yhdh对应的资源信息
     * @return
     */
    public List<AuthSourcesBean> getUserMenus()
    {
        List<AuthSourcesBean> authList=new ArrayList<AuthSourcesBean>();
        for(AuthUserBean aub:authUsers)
        {
            for(AuthSourcesBean asb:authSourcesBeanList){
                if(StringUtils.equals(aub.getRoleid(),asb.getRoleid()))
                {
                    authList.add(asb);
                }
            }
        }
        if(authList!=null && authList.size()>0) return authList;
        return null;
    }
}
