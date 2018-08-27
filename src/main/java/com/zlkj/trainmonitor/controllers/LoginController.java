package com.zlkj.trainmonitor.controllers;

import com.zlkj.trainmonitor.bean.ResultBean;
import com.zlkj.trainmonitor.bean.SysUser;
import com.zlkj.trainmonitor.commons.Constant;
import com.zlkj.trainmonitor.services.OutData;
import com.zlkj.trainmonitor.test.ReadInitFile;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class LoginController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OutData outData;

    @RequestMapping(value = "/")
    public String login(Model model) {
        logger.info("开始登录！");
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(ModelMap model) {
        SysUser user = new SysUser();
        user.setId(1);
        user.setUsername("fuck");
        model.addAttribute("user", user);
        return "index";
//        return "ws";
    }

    //    @RequestMapping(value = "/getData")
//    public @ResponseBody SysUser getData() {
//        SysUser user = new SysUser();
//        user.setId(1);
//        user.setUsername("fuck");
//        return user;
//    }
    @RequestMapping(value = "/init/{path}/{trainInfo}/{flag}")
    public @ResponseBody
    ResultBean init(@PathVariable String path, @PathVariable String trainInfo, @PathVariable String flag) {
        ResultBean resultBean = null;
        //给设备写入初始化文件
        path = path.concat(Constant.WRITEINITPATH);//拼接路径
//        logger.info(path);
//        logger.info(trainInfo);
        try {
            resultBean = ReadInitFile.InitFile(path, trainInfo, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultBean;
    }

    @RequestMapping(value = "/outData/{disks}")
    public @ResponseBody
    ResultBean outData(@PathVariable String disks) {
        ResultBean resultBean = null;
        System.out.println(disks);
        outData.outData(disks);
        //writeFile("D:\\devloptools\\websphere.rar","F:\\websphere.rar");
        //writeFile("F:\\tools\\websphere8.5.rar","E:\\websphere.rar");//cy
        //copy("H:\\","E:\\backupU");//cy
        return new ResultBean("1", "" +
                "", null);
    }
}