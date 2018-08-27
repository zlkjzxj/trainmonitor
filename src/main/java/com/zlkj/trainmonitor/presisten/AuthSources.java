package com.zlkj.trainmonitor.presisten;

import com.zlkj.trainmonitor.bean.AuthSourcesBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthSources {
    public List<AuthSourcesBean> getListAuthSources(AuthSourcesBean authSourcesBean);
}
