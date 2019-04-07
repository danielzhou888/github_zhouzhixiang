package com.scmd;

import lombok.Data;

/**
 * @program:
 * @description: 树叶手机构件角色类
 * @author: zhouzhixiang
 * @create: 2018-10-28 14:37
 */
@Data
public class SpecifyMobile extends MobileComponent{

    private String name;

    public SpecifyMobile(String name) {
        this.name = name;
    }

    @Override
    public void printStruct(String pre) {
        System.out.printf(pre+"-"+this.name);
    }
}
