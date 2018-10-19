package cn.com.wmc.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import cn.com.wmc.entity.PrescriptionVO;

/**
 * 处方
 * 
 * @author wmc
 * @email 18838988676@gmail.com
 * @date 2018-10-19 12:50:23
 */
@Mapper
public interface PrescriptionDao {
	
	List<PrescriptionVO> list(Map<String, Object> params);

	PrescriptionVO selectById(Integer id);

	Integer deleteById(Integer id);

	Integer updateById(PrescriptionVO prescriptionVO);

	Integer deleteByIds(List<Integer> ids);

	Integer insert(PrescriptionVO prescriptionVO);
	
}
