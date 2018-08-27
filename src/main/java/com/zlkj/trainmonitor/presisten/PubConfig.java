package com.zlkj.trainmonitor.presisten;

import org.springframework.stereotype.Component;

@Component
public interface PubConfig {
    /**
     * 功能描述：根据参数名称查询参数值
     * @param csmc
     * @return
     */
    public String getPubConfigCsz(String csmc);
}
