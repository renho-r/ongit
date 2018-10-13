package com.renho.share.controller;

import com.renho.share.domain.vo.Res;
import com.renho.share.utils.ShareProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Controller
@RequestMapping("/res")
public class ResController {

    @Autowired
    private ShareProperties shareProperties;

    @RequestMapping("")
    public String index() {
        return "res/index";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Res> list() {
        List<Res> ress = new ArrayList<>();
        File rootDirs = new File(shareProperties.getBasepath());
        File[] files = rootDirs.listFiles();
        getRess(ress, files);
        return ress;
    }

    private void getRess(List<Res> ress, File[] files) {
        for(File file: files) {
            if(file.isFile()) {
                Res res = new Res();
                res.setName(file.getName());
                res.setPath(file.getAbsolutePath());
                res.setType("1");
                ress.add(res);
            }
        }
    }

    @RequestMapping("listdir")
    @ResponseBody
    public List<Res> list(@RequestParam("dir") String path) {
        if (StringUtils.isBlank(path) || !path.startsWith(shareProperties.getBasepath())) {
            return new ArrayList<>();
        }
        List<Res> ress = new ArrayList<>();
        File rootDirs = new File(path);
        File[] files = rootDirs.listFiles();
        getRess(ress, files);
        return ress;
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(@RequestParam("file") String path) throws IOException {
        File file=new File(path);
        HttpHeaders headers = new HttpHeaders();
        String fileName = new String(FilenameUtils.getName(path).getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
