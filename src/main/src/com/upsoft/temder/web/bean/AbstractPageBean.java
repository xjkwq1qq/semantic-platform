package com.upsoft.temder.web.bean;

public interface AbstractPageBean {

	

	/**
	 * 获取排序方式 asc desc
	 * 
	 * @date 2015年4月18日 下午5:07:10
	 * @author 王强
	 * @return
	 */
	public String getSortOrder();

	/**
	 * 获取排序字段
	 * 
	 * @date 2015年4月18日 下午5:07:40
	 * @author 王强
	 * @return
	 */
	public String getSortName();

	/**
	 * 获取页码数
	 * 
	 * @date 2015年4月18日 下午5:11:09
	 * @author 王强
	 * @return
	 */
	public int getPageSize();

	/**
	 * 获取起始位置
	 * 
	 * @date 2015年4月18日 下午5:11:45
	 * @author 王强
	 * @return
	 */
	public int getStartIndex();

	/**
	 * 设置总页数
	 * 
	 * @date 2015年4月18日 下午5:12:06
	 * @author 王强
	 * @param total
	 */
	public void setTotal(Long total);

	/**
	 * 获取当前页码
	 * 
	 * @date 2015年4月18日 下午5:12:39
	 * @author 王强
	 * @return
	 */
	public int getPageIndex();

}
