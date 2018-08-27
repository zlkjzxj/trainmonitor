package com.zlkj.trainmonitor.presisten;

import com.zlkj.trainmonitor.bean.AuthBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Auth {
    /**
     * 功能描述：角色表按条件查询
     * @param authBean
     * @return
     */
    public List<AuthBean> getListAuth(AuthBean authBean);
}
