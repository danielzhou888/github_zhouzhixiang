package com.scmd;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 树枝手机构件角色类
 * @author: zhouzhixiang
 * @create: 2018-10-28 14:43
 */
@Data
public class MobileComposite extends MobileComponent{

    private String name;
    private List<MobileComponent> childComponents = new ArrayList<MobileComponent>();

    public MobileComposite(String name) {
        this.name = name;
    }

    public void addChild(MobileComponent child) {
        childComponents.add(child);
    }

    public void removeChild(MobileComponent child) {
        childComponents.remove(child);
    }

    public void removeChildByIndex(int index) {
        childComponents.remove(index);
    }

    public List<MobileComponent> getChilds() {
        return childComponents;
    }

    @Override
    public void printStruct(String pre) {
        System.out.printf(pre+"+"+this.name);
        if(this.childComponents != null) {
            pre += "  ";
            for(MobileComponent mobileComponent : childComponents){
                mobileComponent.printStruct(pre);
            }
        }
    }


}
