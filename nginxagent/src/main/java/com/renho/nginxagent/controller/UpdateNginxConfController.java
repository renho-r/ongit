package com.renho.nginxagent.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @author: renho
 * @since: 1.0.0
 */

@RestController
@RequestMapping("/api/nginx/conf")
public class UpdateNginxConfController {

    @PostMapping("update")
    public void update(@RequestBody String conf) {
        FileOutputStream confFile = null;
        try {
            confFile = new FileOutputStream("/usr/local/nginx/conf/nginx.conf");
            confFile.write(conf.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != confFile) {
                try {
                    confFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(conf);
        if(checkConf()) {
            reloadConf();
        }

    }

    private void reloadConf() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ps = runtime.exec("/usr/local/nginx/sbin/nginx -s reload");
            ps.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getErrorStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean checkConf() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ps = runtime.exec("/usr/local/nginx/sbin/nginx -t -c /usr/local/nginx/conf/nginx.conf");
            ps.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getErrorStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

}
