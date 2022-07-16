package com.lcj.smartclub.controller;

import com.lcj.smartclub.pojo.AppleIllSecond;
import com.lcj.smartclub.result.Result;
import com.lcj.smartclub.service.AppleIllSecondService;
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
@RequestMapping("/appleIllSecond")
public class AppleIllSecondController {
    
    @Autowired
    private AppleIllSecondService appleIllSecondService;

    /**
     *查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<AppleIllSecond> lists = appleIllSecondService.findAll();

        return Result.success(lists);
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(int id){
        AppleIllSecond appleIllSecond = appleIllSecondService.findById(id);
        String fileName = appleIllSecond.getImg().replace("/apple/ill/second/","");
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"ill"+System.getProperty("file.separator")+"Second";

        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //先删除文件
        dest.delete();

        int count = appleIllSecondService.deleteById(id);
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
    public Result insert(HttpServletRequest request, @RequestParam("file") MultipartFile imgFile){
        //获取参数
        String experiment = request.getParameter("experiment").trim();

        if(imgFile.isEmpty()){
            return Result.fail();
        }
        //文件名：当前时间毫秒加上原文件名
        String fileName = System.currentTimeMillis()+imgFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"ill"+System.getProperty("file.separator")+"second";

        File file1 = new File(filePath);
        //如果文件路径不存在，新增该路径
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String imgPath = "/apple/ill/second/"+fileName;
        int count = 0;
        try {
            imgFile.transferTo(dest);
            //新建插入的对象
            AppleIllSecond appleIllSecond = new AppleIllSecond();
            appleIllSecond.setExperiment(experiment);
            appleIllSecond.setImg(imgPath);
            //插入数据库
            count = appleIllSecondService.insert(appleIllSecond);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return Result.success(count);
        }
    }
}
