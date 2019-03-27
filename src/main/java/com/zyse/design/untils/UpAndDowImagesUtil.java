package com.zyse.design.untils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 图片上传和删除工具类实现
 * @description: 功能描述
 * @Author: 梦醒灬纠结
 * @Date: 2018/12/10 19:27
 */
@Component
public class UpAndDowImagesUtil {

    @Autowired
    Environment en;
    @Autowired
    ImageUtil imageUtil;
    /**
     * @param: 服务器路径
     * @return:
     * @Author: yc
     * @date: 2018/12/10 19:18
     */
    @Value("${uploadImageUrl}")
    private String uploadImageUrl;

    private static Logger logger = LoggerFactory.getLogger(UpAndDowImagesUtil.class);

    /**
     * 进行图片的上传
     * @description:功能描述
     * @param file 上传图片名称
     * @param path 上传图片路径
     * @param name 用于接受返回内容
     * @return: java.lang.String
     * @Author: yc
     * @date: 2018/12/7 17:36
     */
    public  String uploadImages(MultipartFile file, String path) {
        String name = null;
        String masseges = null;
        try {
            name = imageUtil.saveImg(file,path);
            JSONObject object = JSON.parseObject(name);
            path = uploadImageUrl+object.get("result").toString();
            masseges = object.get("massege").toString();
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("图片上传失败"+path+file);
            return masseges;
        }
    }
    /**
     * 进行图片的删除
     * @description:功能描述
     * @param file 上传图片名称
     * @param path 上传图片路径
     * @return: java.lang.String
     * @Author: yc
     * @date: 2018/12/7 17:36
     */
    public String downloadImages(String path,String name) {
        String massege = null;
        try {
            name = imageUtil.delFile(path);
            JSONObject object = JSON.parseObject(name);
            massege = object.get("massege").toString();
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("图片查看失败"+path);
            return massege;
        }
    }
}
