package com.scmd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.*;

/**
 * Created by zhouzhixiang on 2018/10/21.
 */
public class WechatMsgSendJob {
    private static Log log = LogFactory.getLog(WechatMsgSendJob.class);
    private static BlockingQueue<WechatMsg> msgs = new LinkedBlockingQueue<>(10000);

    public static void addMsg(WechatMsg msg){
        try{
            msgs.put(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void init(){
        try{
            ExecutorService executorService = Executors.newFixedThreadPool(8);
            for (int i = 0; i < 8; i++){
                executorService.submit(new Runnable(){
                    @Override
                    public void run() {
                        while (true){
                            try{
                                WechatMsg msg = msgs.take();
                                if(msg!=null){

                                }
                            }catch (Exception e){
                                e.printStackTrace();
                                log.error("callWechatSendApi error",e);
                            }
                        }
                    }
                });
            }
        }catch (Exception e){
            log.error("sendMsg eror",e);
        }
    }
}
