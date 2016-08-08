/*
 * PageBean.java
 * Created on 2015年1月23日 下午4:49:47
 * Copyright (c) 重庆扬讯软件技术有限公司  All Rights Reserved.
 * http://www.upsoft.com.cn
 *
 * This software is the confidential and proprietary information of UPSoft.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with UPSoft.
 */
package com.upsoft.temder.web.bean;

import com.upsoft.temder.web.util.PageUtil;
import org.apache.commons.lang3.StringUtils;


/**
 * Copyright (c) 2015,重庆扬讯软件技术有限公司<br>
 * All rights reserved.<br>
 * 
 * 文件名称：PageBean.java<br>
 * 摘要：简要描述本文件的内容<br>
 * -------------------------------------------------------<br>
 * 当前版本：1.1.1<br>
 * 作者：蒋迪<br>
 * 完成日期：2015年1月23日<br>
 * -------------------------------------------------------<br>
 * 取代版本：1.1.0<br>
 * 原作者：蒋迪<br>
 * 完成日期：2015年1月23日<br>
 */
public class PageBean implements AbstractPageBean {

	// 当前页
	private int pageIndex;
	// 每页记录条数
	private int pageSize;
	// 总页数
	private Long total;
	// 排序列
	private String sortName;
	private String draw;
	// 排序规则
	private String sortOrder = PageUtil.DEFAULT_SORT_DIRECTION;

	public PageBean(int pageIndex, int pageSize, Long total) {
		// TODO JiangDi 测试用构造函数，需删除
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.total = total;
	}

	public PageBean(int pageIndex, int pageSize, long total, String sortName, String sortOrder) {
		// TODO JiangDi 测试用构造函数，需删除
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.total = total;
		this.sortName = sortName;
		this.sortOrder = sortOrder;
	}

	/**
	 * 根据当前页，每页记录条数，返回起始查询index
	 * 
	 * @date 2015年1月26日 上午10:48:28
	 * @author 蒋迪
	 * @return
	 */
	public int getStartIndex() {
		return (pageIndex - 1) * pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		if (StringUtils.isNoneBlank(sortOrder)) {
			this.sortOrder = sortOrder;
		}
	}
}
