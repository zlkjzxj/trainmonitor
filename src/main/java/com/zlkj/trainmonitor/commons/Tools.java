package com.zlkj.trainmonitor.commons;

public class Tools {
    /**
     * 功能描述：根据传入的管理部门和部门级别，返回截取的管理部门字符串
     * @param glbm
     * @param bmjb
     * @return
     */
    public static String getGlbmStr(String glbm,String bmjb){
        String returnGblm = glbm;
        if("2".equals(bmjb)){
            returnGblm = glbm.substring(0,2);
        }else if("3".equals(bmjb)){
            returnGblm = glbm.substring(0,4);
        }else if("4".equals(bmjb)){
            returnGblm = glbm.substring(0,8);
        }
        return returnGblm;
    }
    /**
     *功能描述：根据传入的部门级别返回，要按那个字段分组
     * @param bmjb
     * @return
     */
    public static String getGlbmField(String bmjb){
        String returnGblm = "glbm";
        if("2".equals(bmjb)){
            returnGblm = "glbmfr";
        }else if("3".equals(bmjb)){
            returnGblm = "glbmet";
        }else if("4".equals(bmjb)){
            returnGblm = "glbmet";
        }
        return returnGblm;
    }
}
