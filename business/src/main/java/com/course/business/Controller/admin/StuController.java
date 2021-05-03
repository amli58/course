package com.course.business.Controller.admin;


import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.dto.StuDto;
import com.course.server.service.StuService;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin/stu")
public class StuController {

    private static final Logger LOG = LoggerFactory.getLogger(StuController.class);
    public static final String BUSINESS_NAME = "录取生源信息";

    @Autowired
    @Resource
    private StuService stuService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto){
        LOG.info("pageDto:{}",pageDto);
        ResponseDto responseDto = new ResponseDto();
        stuService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;

    }
    @PostMapping("/save")
    public ResponseDto save(@RequestBody StuDto stuDto){
        LOG.info("stuDto:{}",stuDto);


        // 保存校验

        ValidatorUtil.require(stuDto.getName(), "名字");
        ValidatorUtil.length(stuDto.getName(), "名字", 1, 50);
        ValidatorUtil.require(stuDto.getIdnumber(), "身份证号");
        ValidatorUtil.length(stuDto.getIdnumber(), "身份证号", 18, 18);
        ValidatorUtil.require(stuDto.getPhonenb(), "手机号码");
        ValidatorUtil.length(stuDto.getPhonenb(), "手机号码", 1, 50);
        ValidatorUtil.require(stuDto.getSex(), "性别");
        ValidatorUtil.length(stuDto.getAddress(), "地址", 1, 100);
        ValidatorUtil.length(stuDto.getMajorid(), "专业", 1, 50);


        ResponseDto responseDto = new ResponseDto();
        stuService.save(stuDto);
        responseDto.setContent(stuDto);
        return responseDto;

    }
    @DeleteMapping("/delete/{id}")
    public ResponseDto del(@PathVariable String id){
        LOG.info("id:{}",id);
        ResponseDto responseDto = new ResponseDto();
        stuService.delete(id);
        return responseDto;

    }

    @PostMapping("/excelOut")
    @ResponseBody
    public void excelOut(HttpServletResponse response) throws IOException {
        //LOG.info("pageDto:{}",pageDto);

        List<StuDto> list = stuService.getExcelist();
        //LOG.info("list:{}",list);

    }

            /**
             * 方法名：
             * 功能：导出
             * 描述：文件格式为xls或xlsx
             * 创建人：typ
             * 创建时间：2018/10/19 10:06
             * 修改人：
             * 修改描述：
             * 修改时间：String file = "f:/test.xlsx";
             * 		String str = excelController.importExcel(file);
             * 		System.out.println(str);
             */

            @GetMapping("/export")
            public String exportExcel(HttpServletResponse response) {

                String fileName = "E:/test.xlsx";
                if (fileName == null || "".equals(fileName)) {
                    return "文件名不能为空！";
                } else {
                    if (fileName.endsWith("xlsx")) {
                        Boolean isOk = stuService.exportExcel(response, fileName);
                        if (isOk) {
                            return "导出成功！";
                        } else {
                            return "导出失败！";
                        }
                    }else{
                        return "文件格式有误！";}
                }
            }

            /**
             * 方法名：import
             * 功能：导入
             * 描述：文件格式为xls或xlsx
             * 创建人：typ
             * 创建时间：2018/10/19 10:06
             * 修改人：
             * 修改描述：
             * 修改时间：
             */
            @GetMapping("/import")
            public String importExcel(@RequestBody String fileName) {

                if (fileName == null && "".equals(fileName)) {
                    return "文件名不能为空！";
                } else {
                    if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
                        Boolean isOk = stuService.importExcel(fileName);
                        if (isOk) {
                            return "导入成功！";
                        } else {
                            return "导入失败！";
                        }
                    }
                    return "文件格式错误！";
                }
            }

        }





