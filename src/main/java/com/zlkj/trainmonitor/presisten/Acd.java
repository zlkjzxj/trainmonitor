package com.zlkj.trainmonitor.presisten;


import com.zlkj.trainmonitor.bean.AcdInfoBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Acd {
    /**
     * 功能描述：返回事故信息数量
     * @param acdInfoBean
     * @return
     */
    public AcdInfoBean getAcdInfoByGlbm(AcdInfoBean acdInfoBean);

    /**
     * 功能描述：返回道路类型发生事故数量信息
     * @param acdInfoBean
     * @return
     */
    public List<AcdInfoBean> getAcdInfoDllxByGlbm(AcdInfoBean acdInfoBean);

    /**
     * 功能描述：返回城市，高速的简易事故、死亡事故、财产损失事故、伤人事故
     * @return
     */
    public List<AcdInfoBean> getAcdFileByDllxZhidui();
}
