package com.course.server.service;

import com.course.server.domain.ExcelData;
import com.course.server.domain.Stu;
import com.course.server.domain.StuExample;
import com.course.server.dto.PageDto;
import com.course.server.dto.StuDto;
import com.course.server.mapper.StuMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.ExcelUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class StuService {

    @Resource
    private StuMapper stuMapper;

    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        StuExample stuExample = new StuExample();
        List<Stu> stuList = stuMapper.selectByExample(stuExample);
        PageInfo<Stu> pageInfo = new PageInfo<>(stuList);
        pageDto.setTotal(pageInfo.getTotal());
        List<StuDto> stuDtoList = CopyUtil.copyList(stuList, StuDto.class);
        pageDto.setList(stuDtoList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(StuDto stuDto) {
        Stu stu = CopyUtil.copy(stuDto, Stu.class);
        if (StringUtils.isEmpty(stuDto.getId())) {
            this.insert(stu);
        } else {
            this.update(stu);
        }
    }

    /**
     * 新增
     */
    private void insert(Stu stu) {
        stu.setId(UuidUtil.getShortUuid());
        stuMapper.insert(stu);
    }

    /**
     * 更新
     */
    private void update(Stu stu) {
        stuMapper.updateByPrimaryKey(stu);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        stuMapper.deleteByPrimaryKey(id);
    }
    /**
     * 数据导出
     * @return
     */
    public List<StuDto> getExcelist() {
        //PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        StuExample stuExample = new StuExample();
        List<Stu> stuList = stuMapper.selectByExample(stuExample);
        //PageInfo<Stu> pageInfo = new PageInfo<>(stuList);
        List<StuDto> stuDtoList = CopyUtil.copyList(stuList, StuDto.class);
        //pageDto.setList(stuDtoList);
        return stuDtoList;
    }
    private static final Logger LOG = LoggerFactory.getLogger(StuService.class);

    public Boolean exportExcel(HttpServletResponse response, String fileName) {
        LOG.info("导出数据开始。。。。。。");
        //查询数据并赋值给ExcelData
        StuExample stuExample = new StuExample();
        List<Stu> userList = stuMapper.selectByExample(stuExample);
        //List<Stu> userList = StuMapper.find();
        List<String[]> list = new ArrayList<String[]>();
        for (Stu user : userList) {
            String[] arrs = new String[userList.size()+9];
            arrs[0] = String.valueOf(user.getId());
            arrs[1] = String.valueOf(user.getName());
            arrs[2] = String.valueOf(user.getIdnumber());
            arrs[3] = String.valueOf(user.getPhonenb());
            arrs[4] = String.valueOf(user.getSex());
            arrs[5] = String.valueOf(user.getAddress());
            arrs[6] = String.valueOf(user.getBirthnb());
            arrs[7] = String.valueOf(user.getMajorid());
            list.add(arrs);

        }
        LOG.info("list:{}",list);
        //表头赋值
        String[] head = {"序列", "用户名", "身份证号", "手机号码","性别","地址","年龄","专业"};
        ExcelData data = new ExcelData();
        data.setHead(head);
        data.setData(list);
        data.setFileName(fileName);
        //实现导出
        try {
            ExcelUtil.exportExcel(response, data);
            LOG.info("导出数据结束。。。。。。");
            return true;
        } catch (Exception e) {
            LOG.info("导出数据失败。。。。。。");
            return false;
        }
    }

    public Boolean importExcel(String fileName) {
        return null;
    }


}
