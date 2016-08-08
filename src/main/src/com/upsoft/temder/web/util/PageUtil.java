package com.upsoft.temder.web.util;

import com.upsoft.temder.web.bean.PageBean;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * Copyright (c) 2015,重庆扬讯软件技术有限公司<br>
 * All rights reserved.<br>
 * 
 * 文件名称：PageUtil.java<br>
 * 摘要：分页操作类<br>
 * -------------------------------------------------------<br>
 * 当前版本：1.1.1<br>
 * 作者：Awesan<br>
 * 完成日期：2015年1月23日<br>
 * -------------------------------------------------------<br>
 * 取代版本：1.1.0<br>
 * 原作者：Awesan<br>
 * 完成日期：2015年1月23日<br>
 */
public class PageUtil {
	public static final int default_page_size = 10;
	// 当前页数，前端界面request参数命名
	public static final String PAGE_INDEX = "start";
	// 每页记录数，前端界面request参数命名
	public static final String PAGE_SIZE = "length";
	// 总记录数，前端界面request参数命名
	public static final String TOTAL = "pager.totalRows";
	// 排序列名称，前端界面request参数命名
	public static final String SORT_NAME = "order[0][column]";
	// 排序顺序，默认desc，前端界面request参数命名
	public static final String SORT_ORDER = "order[0][dir]";
	// 默认排序规则
	public static final String DEFAULT_SORT_DIRECTION = "desc";

	/**
	 * 通过request获取PageBean
	 * 
	 * @param request
	 * @return
	 */
	public static PageBean parseRequest2PageBean(HttpServletRequest request) {
		int length = getPageSize(request);
		int start = getPageNo(request);
		PageBean pageBean = new PageBean(start / length + 1, length, null);
		pageBean.setSortName(PageUtil.getSortName(request));
		pageBean.setSortOrder(PageUtil.getSortOrder(request));
		pageBean.setDraw(request.getParameter("draw"));
		return pageBean;
	}

	/**
	 * 获取页码
	 * 
	 * @param request
	 * @return
	 */
	public static int getPageNo(HttpServletRequest request) {
		int pageNo = 1;
		String page_str = request.getParameter(PAGE_INDEX);
		if (StringUtils.isNotBlank(page_str) && Pattern.matches("\\d*", page_str)) {
			pageNo = Integer.parseInt(page_str);
		}
		return pageNo;
	}

	public static int getPageSize(HttpServletRequest request) {
		String selectPageSize = request.getParameter(PAGE_SIZE);
		if (StringUtils.isNotBlank(selectPageSize) && Pattern.matches("\\d*", selectPageSize)) {
			return Integer.parseInt(selectPageSize);
		} else {
			return getDefaultPageSize();
		}
	}

	/**
	 * 获取默认分页参数
	 * 
	 * @return
	 */
	public static int getDefaultPageSize() {
		return default_page_size;
	}

	/**
	 * 获取分页大小，如果配有字典可以设置为默认值
	 * 
	 * @param request
	 * @param defaultValue
	 * @return
	 */
	public static int getPageSize(HttpServletRequest request, int defaultValue) {
		int pageSize = defaultValue;
		String selectPageSize = request.getParameter(PAGE_INDEX);
		if (StringUtils.isNotBlank(selectPageSize) && Pattern.matches("\\d*", selectPageSize)) {
			pageSize = Integer.parseInt(selectPageSize);
		}
		return pageSize;
	}

	public static String getSortName(HttpServletRequest request) {
		return request.getParameter(SORT_NAME);
	}

	public static String getSortOrder(HttpServletRequest request) {
		return request.getParameter(SORT_NAME);
	}
}
