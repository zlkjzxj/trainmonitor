package com.zlkj.trainmonitor.services;

import com.zlkj.trainmonitor.bean.AuthSourcesBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthSourcesServices {
    //    @Autowired
//    private AuthSources authSources;
    public List<AuthSourcesBean> getListAuthSources(AuthSourcesBean authSourcesBean) {
//        return authSources.getListAuthSources(authSourcesBean);
        return new ArrayList<AuthSourcesBean>();

    }
}
