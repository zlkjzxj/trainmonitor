package com.zlkj.trainmonitor.services;

import com.zlkj.trainmonitor.bean.SoftInfoBean;
import org.springframework.stereotype.Service;

@Service
public class SoftInfoServices {
    //    @Autowired
//    private SoftInfo softInfo;
    public SoftInfoBean getSoftInfo(SoftInfoBean softInfoBean) {

//        return softInfo.getSoftInfo(softInfoBean);
        return new SoftInfoBean();
    }
}
