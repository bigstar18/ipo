package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;

/**
 * 交收商品属性管理
 * 
 * @author chenjing
 *
 */
public class DeliveryCommodity implements Serializable {

	private String commodityId; // 商品代码

	private String commodityName; // 商品名称

	private Long breedId;// 品种代码

	private String breedName;// 品种名称

	private Long categoryId;// 分类代码

	private String categoryName;// 分类名称

}
