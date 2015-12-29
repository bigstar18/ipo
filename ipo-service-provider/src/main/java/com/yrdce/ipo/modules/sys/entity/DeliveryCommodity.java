package com.yrdce.ipo.modules.sys.entity;

/**
 * 交收属性设置商品
 * 
 * @author chenjing
 *
 */
public class DeliveryCommodity {

	private String commodityId; // 商品代码

	private String commodityName; // 商品名称

	private Long breedId;// 品种代码

	private String breedName;// 品种名称

	private Long categoryId;// 分类代码

	private String categoryName;// 分类名称

	private Short deliveryProp;// 是否配置交收属性

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Long getBreedId() {
		return breedId;
	}

	public void setBreedId(Long breedId) {
		this.breedId = breedId;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Short getDeliveryProp() {
		return deliveryProp;
	}

	public void setDeliveryProp(Short deliveryProp) {
		this.deliveryProp = deliveryProp;
	}

	@Override
	public String toString() {
		return "DeliveryCommodity [commodityId=" + commodityId
				+ ", commodityName=" + commodityName + ", breedId=" + breedId
				+ ", breedName=" + breedName + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + ", deliveryProp="
				+ deliveryProp + "]";
	}

}
