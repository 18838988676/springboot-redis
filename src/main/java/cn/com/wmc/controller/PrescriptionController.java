package cn.com.wmc.controller;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.wmc.entity.PrescriptionVO;
import cn.com.wmc.service.impl.PrescriptionServiceImpl;

/**
 * 处方
 * @author wmc
 * @email 18838988676@gmail.com
 * @date 2018-10-19 12:50:23
 */
 
//@RestController
@Controller
@RequestMapping("/prescriptionController")
public class PrescriptionController {
    @Autowired
    private PrescriptionServiceImpl prescriptionServiceImpl;

    @RequestMapping("/index")
    public String list(){
        return "index";
    }
    
    
    /**
     * 列表
     */
    //http://localhost:8088/prescriptionController/list
    @RequestMapping("/list")
    public String  list(@RequestParam Map<String, Object> params,HttpServletRequest request){
          List<PrescriptionVO> prescriptions = prescriptionServiceImpl.list(params);
          request.setAttribute("list", prescriptions);
        return "list";
    }

    /**
     * 信息
     */
    //http://localhost:8088/prescriptionController/info?id=6
    @RequestMapping("/info")
    public PrescriptionVO info(Integer id){
			PrescriptionVO prescription = prescriptionServiceImpl.selectById(id);
        return prescription;
    }
  
    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public String save(@RequestBody PrescriptionVO prescription){
		Integer num=prescriptionServiceImpl.insert(prescription);
        return "success";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public String update(@RequestBody PrescriptionVO prescription){
		Integer num=prescriptionServiceImpl.updateById(prescription);
        return "success";
    }

	 /**  
     * 删除单个
     */
//    http://localhost:8088/prescriptionController/delete?id=6
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(Integer id){
		Integer num=prescriptionServiceImpl.deleteById(id);
        return "success";
    }

    /**
     * 删除多个
     */
    //http://localhost:8088/prescriptionController/delete?id=7,8
    @ResponseBody
    @RequestMapping("/deletes")
    public String deletes(@RequestBody Integer[] ids){
		Integer num=prescriptionServiceImpl.deleteByIds(Arrays.asList(ids));
        return "success";
    }
}
