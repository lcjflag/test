package com.lcj.smartclub.controller;

import com.lcj.smartclub.pojo.AppleData;
import com.lcj.smartclub.pojo.AppleResult;
import com.lcj.smartclub.result.Result;
import com.lcj.smartclub.service.AppleDataService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/appleData")
public class AppleDataController {

    @Autowired
    private AppleDataService appleDataService;

    /**
     *查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        List<AppleData> lists = appleDataService.findAll();

        return Result.success(lists);
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(int id){
        AppleData appleData = appleDataService.findById(id);

        //rgb和nir文件名称
        String rgbFileName = appleData.getRgb().replace("/apple/data/rgb/","");
        String nirFileName = appleData.getNir().replace("/apple/data/nir/","");
        //文件路径
        String rgbFilePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"data"+System.getProperty("file.separator")+"rgb";
        String nirFilePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"data"+System.getProperty("file.separator")+"nir";
        //实际的文件地址
        File rgbDest = new File(rgbFilePath+System.getProperty("file.separator")+rgbFileName);
        File nirDest = new File(nirFilePath+System.getProperty("file.separator")+nirFileName);
        //删除文件
        rgbDest.delete();
        nirDest.delete();

        int count = appleDataService.deleteById(id);
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
    public Result insert(HttpServletRequest request, @RequestParam("rgbFile") MultipartFile rgbFile,@RequestParam("nirFile") MultipartFile nirFile){
        //获取AppleData参数
        int id = Integer.parseInt(request.getParameter("id").trim());
        String experiment = request.getParameter("experiment").trim();

        if(rgbFile.isEmpty()||nirFile.isEmpty()){
            return Result.fail();
        }
        //文件名：当前时间毫秒加上原文件名
        String rgbFileName = System.currentTimeMillis()+rgbFile.getOriginalFilename();
        String nirFileName = System.currentTimeMillis()+nirFile.getOriginalFilename();
        //文件路径
        String rgbFilePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"data"+System.getProperty("file.separator")+"rgb";
        String nirFilePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                +System.getProperty("file.separator")+"data"+System.getProperty("file.separator")+"nir";
        File rgbFile1 = new File(rgbFilePath);
        File nirFile1 = new File(nirFilePath);
        //如果文件路径不存在，新增该路径
        if(!rgbFile1.exists()){
            rgbFile1.mkdir();
        }
        if(!nirFile1.exists()){
            nirFile1.mkdir();
        }
        //实际的文件地址
        File rgbDest = new File(rgbFilePath+System.getProperty("file.separator")+rgbFileName);
        File nirDest = new File(nirFilePath+System.getProperty("file.separator")+nirFileName);
        //存储到数据库里的相对文件地址
        String rgbPath = "/apple/data/rgb/"+rgbFileName;
        String nirPath = "/apple/data/nir/"+nirFileName;
        int count = 0;
        try {
            rgbFile.transferTo(rgbDest);
            nirFile.transferTo(nirDest);
            //新建插入的对象
            AppleData appleData = new AppleData();
            appleData.setId(id);
            appleData.setExperiment(experiment);
            appleData.setRgb(rgbPath);
            appleData.setNir(nirPath);
            //插入数据库
            count = appleDataService.insert(appleData);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return Result.success(count);
        }
    }
}
