package com.zlkj.trainmonitor.security.secinfos;

import com.zlkj.trainmonitor.bean.*;
import com.zlkj.trainmonitor.commons.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class PlateUserDetail extends SysUserInfo implements UserDetails {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    public PlateUserDetail(){

    }
    public PlateUserDetail(SysUserBean sysUserBean, List<AuthUserBean> authUsers, List<AuthBean> authBeans, List<AuthSourcesBean> authSourcesBeanList, List<DepartmentBean> deps, SoftInfoBean softInfo){
        super(sysUserBean, authUsers, authBeans,  authSourcesBeanList, deps, softInfo);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        logger.info("SysUserInfo类的---getUserRoleName"+getUserRoleName());
        //return AuthorityUtils.createAuthorityList(getUserRoleName());        //先注释掉，用户取角色信息
        return null;
    }

    @Override
    public String getPassword() {
        return getSysUserBean().getMm();
    }

    @Override
    public String getUsername() {
        return getSysUserBean().getYhdh();
    }

    /*
     *帐号是否不过期，false则验证不通过
     */
    @Override
    public boolean isAccountNonExpired() {
        logger.info("帐号是否不过期");
        String yhyxq = "";
        String mmyxq = "";
        yhyxq = getSysUserBean().getYhyxq();
        mmyxq = getSysUserBean().getMmyxq();
        logger.info("用户有效期："+yhyxq+"密码有效期："+mmyxq);
        return DateUtils.comparToDate1(yhyxq,mmyxq);
    }

    /*
     * 帐号是否不锁定，false则验证不通过
     */
    @Override
    public boolean isAccountNonLocked() {
        boolean resultFlag = false;
        if(null != getSysUserBean() && "0".equals(getSysUserBean().getIslocked())){
            resultFlag = true;
        }
        logger.info("帐号是否不锁定--"+resultFlag);
        return resultFlag;
    }

    /*
    * 凭证是否不过期，false则验证不通过
    */
    @Override
    public boolean isCredentialsNonExpired() {
        boolean resultFlag = false;
        if(null != getSysUserBean() && "0".equals(getSysUserBean().getIscredentialsexpired())){
            resultFlag = true;
        }
        logger.info("凭证是否不过期"+resultFlag);
        return resultFlag;
    }

    /*
     * 该帐号是否启用，false则验证不通过
     */
    @Override
    public boolean isEnabled() {
        boolean resultFlag = false;
        if (null != getSysUserBean() && "0".equals(getSysUserBean().getIsenabled())) {
            resultFlag = true;
        }
        logger.info("该帐号是否启用" + resultFlag);
        return resultFlag;
    }

}
