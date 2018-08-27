package com.zlkj.trainmonitor.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("frmcode")
@Data
public class FrmCodeBean {
    private String xtlb;
    private String dmlb;
    private String dmz;
    private String dmsm1;
    private String dmsm2;
    private String dmsm3;
    private String dmsm4;
    private String dmsx;
    private String sxh;
    private String ywdx;
    private String zt;
    private String csbj;
    private String gxsj;
    private String pic;
    private String pic2;

}
