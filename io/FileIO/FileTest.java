package com.newer.io.FileIO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest {

	// 内部类，实现了文件过滤器
	static class MyFilter implements FilenameFilter {

		/**
		 * dir 当前目录 name 文件名
		 */
		@Override
		public boolean accept(File dir, String name) {
			// System.out.println(dir.getName());
			// File f = new File(dir, name);
			return name.endsWith(".zip");
		}

	}

	static class FFilter implements FileFilter {

		@Override
		public boolean accept(File f) {
			return f.isDirectory();
		}

	}

	public static void main(String[] args) {

		// 目录的遍历
		// list/listFile
		File dir = new File("d:\\Java\\jdk1.8.0_121");

		File[] files = dir.listFiles(new FFilter());

		for (File f : files) {
			String text = String.format(
					"%s\t%,14d Byte\t%7.2f MB\t%s",
					(f.isFile() ? "F" : "D"), 
					FileUtil.length(f),
					FileUtil.length(f) / 1024.0 / 1024,
					f.getName()
					);
			
			System.out.println(text);
		}

		// 名称数组
		// String[] filenames = dir.list(new MyFilter());
		// System.out.println(filenames.length);
		//
		// for (String f : filenames) {
		// System.out.println(f);
		// }

		// d:/org/apache/Hello.java
		// File f1 = new File("d:/org/apache/hi.c");
		// System.out.println(f1.delete());
		// System.out.println(f1.getParentFile().delete());
		// System.out.println(f1.getParentFile().getParentFile().delete());

		// 删除文件
		// f1.delete();

		// File f2 = new File(f1.getParentFile(), "hi.c");
		// System.out.println(f1.renameTo(f2));

		// 文件所在目录需要存在
		// if (!f1.getParentFile().exists()) {
		// System.out.println(f1.getParentFile().mkdirs());
		// }
		//
		// try {
		// // 创建文件
		// System.out.println(f1.createNewFile());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}

	private static void demo1() {
		// windows ; unix/linux/mac :
		System.out.println(File.pathSeparator);

		// windows \ unix /
		System.out.println(File.separator);

		// 新建文件
		File f1 = new File("file.txt");
		try {
			System.out.println(f1.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("路径不存在或权限");
		}

		// 新建目录
		File dir = new File("d:/abc");

		String msg = dir.mkdir() ? "成功" : "失败";
		System.out.println(msg);
	}

}
