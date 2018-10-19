package cn.com.wmc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 处方
 * @author wmc
 * @email 18838988676@gmail.com
 * @date 2018-10-19 12:50:23
 */
public class PrescriptionVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
		private Integer id;
	/**
	 * 挂号id
	 */
	private Integer registerid;
	/**
	 * 处方单号
	 */
	private String prescriptioncode;
	/**
	 * 名称
	 */
	private String prescriptionname;
	/**
	 * 医生id
	 */
	private Integer doctorid;
	/**
	 * 处方性质id
	 */
	private Integer natureid;
	/**
	 * 处方类型id
	 */
	private Integer prescriptiontypeid;
	/**
	 * 处方分类id
	 */
	private Integer classifyid;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 处方诊断
	 */
	private String diagnosis;
	/**
	 * 处方时间
	 */
	private Date prescriptiontime;
	/**
	 * 是否有效
	 */
	private Integer isvalid;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：挂号id
	 */
	public void setRegisterid(Integer registerid) {
		this.registerid = registerid;
	}
	/**
	 * 获取：挂号id
	 */
	public Integer getRegisterid() {
		return registerid;
	}
	/**
	 * 设置：处方单号
	 */
	public void setPrescriptioncode(String prescriptioncode) {
		this.prescriptioncode = prescriptioncode;
	}
	/**
	 * 获取：处方单号
	 */
	public String getPrescriptioncode() {
		return prescriptioncode;
	}
	/**
	 * 设置：名称
	 */
	public void setPrescriptionname(String prescriptionname) {
		this.prescriptionname = prescriptionname;
	}
	/**
	 * 获取：名称
	 */
	public String getPrescriptionname() {
		return prescriptionname;
	}
	/**
	 * 设置：医生id
	 */
	public void setDoctorid(Integer doctorid) {
		this.doctorid = doctorid;
	}
	/**
	 * 获取：医生id
	 */
	public Integer getDoctorid() {
		return doctorid;
	}
	/**
	 * 设置：处方性质id
	 */
	public void setNatureid(Integer natureid) {
		this.natureid = natureid;
	}
	/**
	 * 获取：处方性质id
	 */
	public Integer getNatureid() {
		return natureid;
	}
	/**
	 * 设置：处方类型id
	 */
	public void setPrescriptiontypeid(Integer prescriptiontypeid) {
		this.prescriptiontypeid = prescriptiontypeid;
	}
	/**
	 * 获取：处方类型id
	 */
	public Integer getPrescriptiontypeid() {
		return prescriptiontypeid;
	}
	/**
	 * 设置：处方分类id
	 */
	public void setClassifyid(Integer classifyid) {
		this.classifyid = classifyid;
	}
	/**
	 * 获取：处方分类id
	 */
	public Integer getClassifyid() {
		return classifyid;
	}
	/**
	 * 设置：备注
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：备注
	 */
	public String getNote() {
		return note;
	}
	/**
	 * 设置：处方诊断
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	/**
	 * 获取：处方诊断
	 */
	public String getDiagnosis() {
		return diagnosis;
	}
	/**
	 * 设置：处方时间
	 */
	public void setPrescriptiontime(Date prescriptiontime) {
		this.prescriptiontime = prescriptiontime;
	}
	/**
	 * 获取：处方时间
	 */
	public Date getPrescriptiontime() {
		return prescriptiontime;
	}
	/**
	 * 设置：是否有效
	 */
	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}
	/**
	 * 获取：是否有效
	 */
	public Integer getIsvalid() {
		return isvalid;
	}
	@Override
	public String toString() {
		return "PrescriptionVO [id=" + id + ", registerid=" + registerid + ", prescriptioncode=" + prescriptioncode
				+ ", prescriptionname=" + prescriptionname + ", doctorid=" + doctorid + ", natureid=" + natureid
				+ ", prescriptiontypeid=" + prescriptiontypeid + ", classifyid=" + classifyid + ", note=" + note
				+ ", diagnosis=" + diagnosis + ", prescriptiontime=" + prescriptiontime + ", isvalid=" + isvalid + "]";
	}
	
	
	
}
