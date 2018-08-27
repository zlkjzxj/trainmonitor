package com.zlkj.trainmonitor.services;

import com.zlkj.trainmonitor.bean.CommonUserDetails;
import com.zlkj.trainmonitor.bean.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {
    //    @Autowired
//    UserDao userDao
    @Override
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