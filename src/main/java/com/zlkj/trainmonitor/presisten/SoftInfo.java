package com.zlkj.trainmonitor.presisten;

import com.zlkj.trainmonitor.bean.SoftInfoBean;
import org.springframework.stereotype.Component;


@Component
public interface SoftInfo {
    public SoftInfoBean getSoftInfo(SoftInfoBean softInfoBean);
}
