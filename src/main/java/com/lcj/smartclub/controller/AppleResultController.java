package com.lcj.smartclub.controller;

import com.lcj.smartclub.pojo.AppleResult;
import com.lcj.smartclub.result.Result;
import com.lcj.smartclub.service.AppleResultService;
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
@RequestMapping("/appleResult")
public class AppleResultController {

    @Autowired
    private AppleResultService appleResultService;

    /**
     *查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<AppleResult> lists = appleResultService.findAll();

        return Result.success(lists);
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(int id){
        AppleResult appleResult = appleResultService.findById(id);
        String fileName = appleResult.getNdvi().replace("/apple/ndvi/","");
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"ndvi";

        //实际的文件地址
        File ndviDest = new File(filePath+System.getProperty("file.separator")+fileName);
        //先删除文件
        ndviDest.delete();

        int count = appleResultService.deleteById(id);
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
    public Result insert(HttpServletRequest request,@RequestParam("file")MultipartFile ndviFile){
        //获取AppleResult参数
        String id = request.getParameter("id").trim();
        String ndviName = request.getParameter("ndviName").trim();
        float ndviData = Float.valueOf(request.getParameter("ndviData").trim());

        if(ndviFile.isEmpty()){
            return Result.fail();
        }
        //文件名：当前时间毫秒加上原文件名
        String fileName = System.currentTimeMillis()+ndviFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"ndvi";

        File file1 = new File(filePath);
        //如果文件路径不存在，新增该路径
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String ndvi = "/apple/ndvi/"+fileName;
        int count = 0;
        try {
            ndviFile.transferTo(dest);
            //新建插入的对象
            AppleResult appleResult = new AppleResult();
            if(!id.isEmpty()){
                appleResult.setId(Integer.parseInt(id));
            }
            appleResult.setNdviName(ndviName);
            appleResult.setNdviData(ndviData);
            appleResult.setNdvi(ndvi);
            //插入数据库
            count = appleResultService.insert(appleResult);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return Result.success(count);
        }
    }
}