package com.chun.jgit.util;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lixianchun on 2018/7/6.
 **/
@Slf4j
public class MvnUtil {

    private static final String cmdPrefix = "cmd /k ";

    /**
     * exec cmd by java client
     * @param dir
     * @param command
     */
    public static void cmd(String dir, String command){
        Runtime runtime=Runtime.getRuntime();
        String com = cmdPrefix;
        if (dir != null){
            com  = com + " cd " + dir + " && ";
        }
        com = com + command;
        try {
            runtime.exec(com);
            log.info("命令执行完成：{}",com);
        }catch (Exception e){
            log.error("错误：{}", e.getMessage());
        }

    }

}
