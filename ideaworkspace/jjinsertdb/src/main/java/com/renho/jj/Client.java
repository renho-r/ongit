package com.renho.jj;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.renho.jj.dao.JjDAOImpl;
import com.renho.jj.pojo.Jj;
import com.renho.jj.utils.PropertiesUtils;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by renho on 2017/7/7.
 */
public class Client {

    static {
        PropertyConfigurator.configure("etc/log4j.properties");
    }

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws IOException {
        JjDAOImpl jjDAO = new JjDAOImpl();
        Gson gson = new GsonBuilder().create();
        BufferedReader br = new BufferedReader(new FileReader(PropertiesUtils.INSTANCE.getProperty("datafile")));
        String line = br.readLine();
        Jj jj = null;
        while(null != line) {
            try {
                jj = gson.fromJson(line, Jj.class);
                logger.debug("process " + jj.getFundcode());
                jjDAO.insert(jj);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                line = br.readLine();

            }
        }
        br.close();
    }

}
