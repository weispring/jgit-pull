package com.chun.jgit.control;

import com.chun.jgit.util.GitUtil;
import com.chun.jgit.util.MvnUtil;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.reftree.Command;

import java.util.Queue;

/**
 * Created by lixianchun on 2018/7/6.
 **/
public class commonControl {

    private static String baseUrl = "http://gitlab";

    public static void main(String[] args){
        String url = "";

        GitUtil.gitDown(baseUrl, "moses","order-query","",null);
        MvnUtil.cmd("C:\\work\\test\\order-query","mvn install");
    }

}
