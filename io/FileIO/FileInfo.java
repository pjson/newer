package com.newer.io.FileIO;

import java.io.File;

public class FileInfo {

	private File dir;
	private long length;//大小
	private long dirSize;//目录中子目录中的数量
	private long fileSize;//目录中文件的数量

	public FileInfo() {
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getDirSize() {
		return dirSize;
	}

	public void setDirSize(long dirSize) {
		this.dirSize = dirSize;
	}

	public void add(FileInfo info){
		length+=info.getLength();
		fileSize+=info.getFileSize();
		dirSize+=info.getDirSize();
	}

	public void print(){
		System.out.println(dir.getAbsolutePath());
		System.out.println("------------------------");
		System.out.printf("%d 字节\n",length);
		System.out.printf("%d 文件\n",fileSize);
		System.out.printf("%d 目录\n",dirSize);

	}
	/**
	 * 保存（写入文件）
	 * @param path
     */
	public void save(File path){

	}
}
