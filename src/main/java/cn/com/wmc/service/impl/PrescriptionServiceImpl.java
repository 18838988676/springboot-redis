package cn.com.wmc.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.wmc.dao.PrescriptionDao;
import cn.com.wmc.entity.PrescriptionVO;

@Service("prescriptionService")
public class PrescriptionServiceImpl{

  	@Autowired
    private PrescriptionDao prescriptionDao;
	

	 /**
     * 列表
     */
   public List<PrescriptionVO> list(Map<String, Object> params){
  		return prescriptionDao.list(params);
  	}
  	
  	
  	 /**
     * 信息
     */
  	public PrescriptionVO selectById(Integer id) {
		return prescriptionDao.selectById(id);
	}
	
	
	/**
     * 保存
     */
	public Integer insert(PrescriptionVO prescriptionVO) {
		return prescriptionDao.insert(prescriptionVO);
	}
	
	 /**
     * 修改
     */
	public Integer updateById(PrescriptionVO prescriptionVO) {
		return prescriptionDao.updateById(prescriptionVO);
	}
	
	 /**
     * 删除单个
     */
	public Integer deleteById(Integer id) {
		return  prescriptionDao.deleteById(id);
	}
	
	/**
     * 删除多个
     */
	public Integer deleteByIds(List<Integer> ids) {
		return  prescriptionDao.deleteByIds(ids);
	}
	
	

}
