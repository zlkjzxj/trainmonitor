package com.zlkj.trainmonitor.presisten;

import com.zlkj.trainmonitor.bean.DepartmentBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Department {
    public List<DepartmentBean> getListDep(DepartmentBean departmentBean);
    public DepartmentBean getDepObjByGlbm(String glbm);
    public List<DepartmentBean> getListDepByGlbmOrSjbm(DepartmentBean departmentBean);
}
