package com.chun.jgit.util;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixianchun on 2018/7/6.
 **/
@Slf4j
public class GitUtil {

    //下载保存
    private static String saveUrl = "C:\\work\\test";

    //git官网
    private static String baseUrl = "http://gitlab";

    //用户名
    private static final String userName = "li@com.cn";


    /**
     * 密码
     */
    private static final String passWod = "----";


    /**
     * clone git project
     * @param baseUrl
     * @param group
     * @param projectName
     * @param branch
     * @param remote
     */
    public static void gitDown(String baseUrl, String group, String projectName, String branch,String remote){
        try{
            String url = baseUrl + "/" + group + "/" +projectName + ".git" ;
            log.info("下载，地址：{}",url);

            //Git git = Git.open(new File("C:\\work\\moses\\.git"));
            final CloneCommand cc = Git.cloneRepository().setURI(url);
            cc.setBranch(branch);
            UsernamePasswordCredentialsProvider provider = new UsernamePasswordCredentialsProvider(userName, passWod);
            List<String> branchs = new ArrayList<String>();
            branchs.add(branch);
            cc.setBranchesToClone(branchs);
            //添加认证
            cc.setCredentialsProvider(provider);
            cc.setRemote(remote);

            saveUrl = saveUrl + "\\" + projectName;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        cc.setDirectory(new File(saveUrl)).call();
                    }catch (Exception e){
                        log.error("下载异常 ： {}",e.getMessage());
                    }
                    log.info("下载完成");
                }
            }).start();

            //git.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
