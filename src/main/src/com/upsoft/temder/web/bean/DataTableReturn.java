package com.upsoft.temder.web.bean;

public class DataTableReturn {
	private String draw;
	private long recordsTotal;
	private long recordsFiltered;
	private Object data;

	public DataTableReturn(String draw, long recordsTotal, long recordsFiltered, Object data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
