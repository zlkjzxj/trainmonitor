package com.zlkj.trainmonitor.security.secservices;

import com.zlkj.trainmonitor.bean.CommonUserDetails;
import com.zlkj.trainmonitor.bean.SysUser;
import com.zlkj.trainmonitor.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

public @Service
class PlateUserDetailServices implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoginService loginService;
    @Autowired
    private AuthServices authServices;
    @Autowired
    private AuthSourcesServices authSourcesServices;
    @Autowired
    private DepartmentServices departmentServices;
    @Autowired
    private SoftInfoServices softInfoServices;

    //    @Override
//    public PlateUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.info("SecurityManagerSupport.loadUserByUsername.userName:" + username);
//        SysUserBean sysUserBean = loginService.getUserInfoByUserName(username);
//        if (sysUserBean == null) {
//            throw new UsernameNotFoundException("用户不存在");
//        }
//        //softInfoServices.getListSoftInfo(new SoftInfoBean())
//        PlateUserDetail userDetails = new PlateUserDetail(sysUserBean,
//                loginService.getAuthUserListByUserName(sysUserBean.getYhdh()),
//                authServices.getListAuth(new AuthBean()),
//                authSourcesServices.getListAuthSources(new AuthSourcesBean()),
//                departmentServices.getListDep(new DepartmentBean()),
//                softInfoServices.getSoftInfo(new SoftInfoBean()));
//        return userDetails;
//    }
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//     SysUser user = userDao.findByUserName(username);
        SysUser user = new SysUser();
        user.setId(1);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "111111";
//        user.setPassword(encoder.encode(user.getRawPassword().trim()));
        user.setPassword(encoder.encode(password));
        user.setUsername("admin");
//        List<SysRole> roles = new ArrayList<>();
//        roles.add(new SysRole(1, "admin"));
//        user.setRoles(roles);
        return new CommonUserDetails(user);
    } //自定义UserDetailsService 接口
}
