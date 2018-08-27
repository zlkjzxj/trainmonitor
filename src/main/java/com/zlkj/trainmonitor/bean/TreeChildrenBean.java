package com.zlkj.trainmonitor.bean;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * layui构建管理部门树用（子节点类）
 */
@Alias("treechildren")
public class TreeChildrenBean {
    private String name;
    private String id;
    private String bmjb;
    private String pid;
    private List<TreeChildrenBean> children;

}
