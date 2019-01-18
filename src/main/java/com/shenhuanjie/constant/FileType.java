package com.shenhuanjie.constant;

/**
 * 文件类型（数据字典）
 * 
 * @author shenhuanjie
 *
 */
public enum FileType {
	/**
	 * 文件后面名
	 */
	FILE_XLS(".xls", 1),
	FILE_XLSX(".xlsx", 2),
	FILE_ZIP(".zip", 3);

	private String name;
	private int val;

	FileType(String name, int val) {
		this.name = name;
		this.val = val;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "FileType{" +
				"name='" + name + '\'' +
				", val=" + val +
				'}';
	}
}
