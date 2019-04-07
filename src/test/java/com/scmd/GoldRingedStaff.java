package com.scmd;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/15.
 */
public class GoldRingedStaff implements Serializable{

    private float height = 100.0f;
    private float diameter = 10.0f;

    public void grow(){
        this.height *= 2;
        this.diameter *= 2;
    }

    public void shrink(){
        this.height /= 2;
        this.diameter /= 2;
    }
}
