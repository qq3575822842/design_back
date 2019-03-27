package com.zyse.design.untils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Component
/**
 * 工具类进行图片上传和删除
 * @description:功能描述
 * @ClassName:ImageUtil.java
 * @Author: yc
 * @date: 2018/12/10 19:18
 * @Version:1.0
 */
public class ImageUtil {

    @Autowired
    Environment en;
    /**
     * @param: 服务器路径
     * @return:
     * @Author: yc
     * @date: 2018/12/10 19:18
     */
    @Value("${uploadImageUrl}")
    private String uploadImageUrl;

    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 保存文件，直接以multipartFile形式
     *
     * @param multipartFile
     * @param path          文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public String saveImg(MultipartFile file, String path) throws IOException {
        if (file != null && file.getOriginalFilename() != null && file.getOriginalFilename().trim().length() > 0) {
            //拼接路径
            if (null == path) {
                path = "";
            } else {
                path = "/" + path;
            }
            String realuUploadBrandPath = en.getProperty("uploadImagePath");
            // 上传文件原始名称
            String originFileName = file.getOriginalFilename();
            // 新的文件名称
            String newFileName = UUID.randomUUID() + originFileName.substring(originFileName.lastIndexOf("."));
            //如果路径文件夹不存在就创建
            File dir = new File(realuUploadBrandPath + path);

            if (!dir.exists()) {
                try {
                    dir.mkdirs();
                } catch (Exception e) {

                }
            }
            File newFile = new File(realuUploadBrandPath + path + File.separator + newFileName);

            // 将内存中的文件写入磁盘
            try {
                file.transferTo(newFile);
                String name = path + File.separator + newFileName;
                String result = JSON.toJSONString(new ResultUtil(0, true, "图片上传成功", name));
                return result;
            } catch (IllegalStateException | IOException e) {
                String result = JSON.toJSONString(new ResultUtil(-1, false, "图片上传异常"));
                return result;
            }
        }
        return "";
    }

    /**
     * 删除服务器图片
     *
     * @param path 图片服务器的路径
     */
    public String delFile(String path) throws IOException {
        try {
            int urlLegth = uploadImageUrl.length();
            String str = path.substring(urlLegth);
            String realuUploadBrandPath = en.getProperty("uploadImagePath");
            String patha = realuUploadBrandPath + str;
            File file = new File(patha);
            if (file.exists() && file.isFile()) {
                file.delete();
                logger.debug("图片删除成功" + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("图片删除失败" + path);
        }
        return "";
    }

}
