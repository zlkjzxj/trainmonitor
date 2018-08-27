package com.zlkj.trainmonitor.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CommonUserDetails  implements UserDetails {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private SysUser sysUser;

    public CommonUserDetails() {

    }

    public CommonUserDetails(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    /*
     *帐号是否不过期，false则验证不通过
     */
    @Override
    public boolean isAccountNonExpired() {
//        logger.info("帐号是否不过期");
//        String yhyxq = "";
//        String mmyxq = "";
//        yhyxq = getSysUserBean().getYhyxq();
//        mmyxq = getSysUserBean().getMmyxq();
//        logger.info("用户有效期：" + yhyxq + "密码有效期：" + mmyxq);
//        return DateUtils.comparToDate1(yhyxq, mmyxq);
        return true;
    }

    /*
     * 帐号是否不锁定，false则验证不通过
     */
    @Override
    public boolean isAccountNonLocked() {
//        boolean resultFlag = false;
//        if (null != getSysUserBean() && "0".equals(getSysUserBean().getIslocked())) {
//            resultFlag = true;
//        }
//        logger.info("帐号是否不锁定--" + resultFlag);
//        return resultFlag;
        return true;
    }

    /*
     * 凭证是否不过期，false则验证不通过
     */
    @Override
    public boolean isCredentialsNonExpired() {
//        boolean resultFlag = false;
//        if (null != getSysUserBean() && "0".equals(getSysUserBean().getIscredentialsexpired())) {
//            resultFlag = true;
//        }
//        logger.info("凭证是否不过期" + resultFlag);
//        return resultFlag;
        return true;
    }

    /*
     * 该帐号是否启用，false则验证不通过
     */
    @Override
    public boolean isEnabled() {
//        boolean resultFlag = false;
//        if (null != getSysUserBean() && "0".equals(getSysUserBean().getIsenabled())) {
//            resultFlag = true;
//        }
//        logger.info("该帐号是否启用" + resultFlag);
//        return resultFlag;
        return true;
    }
}
