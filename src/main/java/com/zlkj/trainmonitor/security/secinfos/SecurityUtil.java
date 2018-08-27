package com.zlkj.trainmonitor.security.secinfos;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 *功能描述：从安全认证中获取一些当前登录用户的信息
 *
 */
@Component
public class SecurityUtil {

    /**
     *功能描述：获取当前登录用户的用户代号
     * @return
     */
    public static String getUid(){
        return getUser() == null ? "" : getUser().getSysUserBean().getYhdh();
    }

    /**
     *功能描述：获取一些信息
     * @return
     */
    public static PlateUserDetail getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return (PlateUserDetail) authentication.getPrincipal();
    }
}
