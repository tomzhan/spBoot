package com.earl.spBoot.bean.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * 新生报名
 * 
 * @author earl
 * @date 2017-05-22 20:57:59
 */
@ApiModel(value = "WechatRegister",description = "新生报名" )
public class WechatRegister   {

	@ApiModelProperty(value  = "")
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long registerId;
		@ApiModelProperty(value  = "姓名")
		private String name;
		@ApiModelProperty(value  = "专业")
		private String profession;
		@ApiModelProperty(value  = "1:男 2：女  默认是1")
		private Integer sex;
		@ApiModelProperty(value  = "电话号码")
		private String phone;
		@ApiModelProperty(value  = "短号")
		private String shortNum;
		@ApiModelProperty(value  = "类型.  1:hiphop  2：popping 3:jazz  4:breaking 5:现代舞 6::民族舞")
		private Integer type;
		@ApiModelProperty(value  = "")
		private String address;
		@ApiModelProperty(value  = "")
		private String series;
		@ApiModelProperty(value  = "年级")
		private Integer grade;
		@ApiModelProperty(value  = "头像")
		private String img;
		@ApiModelProperty(value  = "描述")
		private String description;
		@ApiModelProperty(value  = "取消理由")
		private String modifyDesc;
		@ApiModelProperty(value  = "取消提交。1为同意申请，0为不申请,2修改申请")
		private Integer modifyStatus;
		@ApiModelProperty(value  = "")
		private String openId;
		@ApiModelProperty(value  = "")
		private String appId;
		@ApiModelProperty(value  = "")
		private Date createTime;
		@ApiModelProperty(value  = "")
		private Date modifyTime;
	
	/**
	 * 设置：
	 */
	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}
	/**
	 * 获取：
	 */
	public Long getRegisterId() {
		return registerId;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：专业
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * 获取：专业
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * 设置：1:男 2：女  默认是1
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：1:男 2：女  默认是1
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：电话号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话号码
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：短号
	 */
	public void setShortNum(String shortNum) {
		this.shortNum = shortNum;
	}
	/**
	 * 获取：短号
	 */
	public String getShortNum() {
		return shortNum;
	}
	/**
	 * 设置：类型.  1:hiphop  2：popping 3:jazz  4:breaking 5:现代舞 6::民族舞
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型.  1:hiphop  2：popping 3:jazz  4:breaking 5:现代舞 6::民族舞
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setSeries(String series) {
		this.series = series;
	}
	/**
	 * 获取：
	 */
	public String getSeries() {
		return series;
	}
	/**
	 * 设置：年级
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	/**
	 * 获取：年级
	 */
	public Integer getGrade() {
		return grade;
	}
	/**
	 * 设置：头像
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：头像
	 */
	public String getImg() {
		return img;
	}
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：取消理由
	 */
	public void setModifyDesc(String modifyDesc) {
		this.modifyDesc = modifyDesc;
	}
	/**
	 * 获取：取消理由
	 */
	public String getModifyDesc() {
		return modifyDesc;
	}
	/**
	 * 设置：取消提交。1为同意申请，0为不申请,2修改申请
	 */
	public void setModifyStatus(Integer modifyStatus) {
		this.modifyStatus = modifyStatus;
	}
	/**
	 * 获取：取消提交。1为同意申请，0为不申请,2修改申请
	 */
	public Integer getModifyStatus() {
		return modifyStatus;
	}
	/**
	 * 设置：
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
}
