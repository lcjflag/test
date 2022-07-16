package com.lcj.smartclub.controller;

import com.lcj.smartclub.pojo.AppleResult;
import com.lcj.smartclub.pojo.OtherData;
import com.lcj.smartclub.result.Result;
import com.lcj.smartclub.service.OtherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/otherData")
public class OtherDataController {

    @Autowired
    private OtherDataService otherDataService;

    /**
     *查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<OtherData> lists = otherDataService.findAll();
        for (OtherData otherData:lists){
            otherData.setUrl(otherData.getUrl().replace("/apple/other/",""));
        }

        return Result.success(lists);
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(int id){
        OtherData otherData = otherDataService.findById(id);
        String fileName = otherData.getUrl().replace("/apple/other/","");
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"other";

        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //先删除文件
        dest.delete();

        int count = otherDataService.deleteById(id);
        if(count==0){
            return Result.fail();
        }
        return Result.success(count);
    }

    /**
     * 添加数据
     * @return
     */
    @RequestMapping("/insert")
    public Result insert(HttpServletRequest request, @RequestParam("file") MultipartFile file){
        //获取AppleResult参数
        String id = request.getParameter("id").trim();
        String description = request.getParameter("description").trim();

        if(file.isEmpty()){
            return Result.fail();
        }
        //文件名：当前时间毫秒加上原文件名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"other";

        File file1 = new File(filePath);
        //如果文件路径不存在，新增该路径
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String url = "/apple/other/"+fileName;
        int count = 0;
        try {
            file.transferTo(dest);
            //新建插入的对象
            OtherData otherData = new OtherData();
            if(!id.isEmpty()){
                otherData.setId(Integer.parseInt(id));
            }
            otherData.setDescription(description);
            otherData.setUrl(url);

            //插入数据库
            count = otherDataService.insert(otherData);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return Result.success(count);
        }
    }
}
