package com.newer.io.FileIO;

import java.io.*;
import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

/**
 * 文件工具类
 *
 * @author wtao
 */
public class FileUtil {

    /**
     * 获得目录的大小（字节）
     *
     * @param dir 目录
     * @return long 目录的大小
     */
    public static long length(File dir) {
        if (dir.isFile()) {
            return dir.length();
        }

        long size = 0;
        // 遍历目录
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                // 文件，则累加
                size += f.length();
            } else {
                // 目录，则递归（调用方法自身）
                size += length(f);
            }
        }
        return size;
    }

    /**
     * 统计目录中文件的数量
     *
     * @param dir
     * @return
     */
    public static long fileSize(File dir) {
        int size = 0;
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    size += fileSize(f);
                } else {
                    size++;
                }
            }
        } else {
            size++;
        }
        return size;
    }

    /**
     * 统计目录中文件夹的数量
     *
     * @param dir
     * @return
     */
    public static long dirSize(File dir) {
        int size = 0;
        if (dir.isDirectory()) {
            size++;
            File[] files = dir.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    size += dirSize(f);
                }
            }
        }
        return size - 1;
    }

    /**
     * 复制目录（目录结构和空文件）mkdir/createNewFile
     *
     * @param dir  源目录（D:\Java\jdk1.8.0_121\db）
     * @param path 目录路径
     */
    public static void copy(File dir, File path) {
        if (!path.exists()) {
            path.mkdirs();
        }
        File newDir = new File(path, dir.getName());
        newDir.mkdir();

        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                File newFile = new File(newDir, f.getName());
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                copy(f, newDir);
            }
        }
    }

    /**
     * Called by the garbage collector on an object when garbage collection
     * determines that there are no more references to the object.
     * A subclass overrides the {@code finalize} method to dispose of
     * system resources or to perform other cleanup.
     * <p>
     * The general contract of {@code finalize} is that it is invoked
     * if and when the Java&trade; virtual
     * machine has determined that there is no longer any
     * means by which this object can be accessed by any thread that has
     * not yet died, except as a result of an action taken by the
     * finalization of some other object or class which is ready to be
     * finalized. The {@code finalize} method may take any action, including
     * making this object available again to other threads; the usual purpose
     * of {@code finalize}, however, is to perform cleanup actions before
     * the object is irrevocably discarded. For example, the finalize method
     * for an object that represents an input/output connection might perform
     * explicit I/O transactions to break the connection before the object is
     * permanently discarded.
     * <p>
     * The {@code finalize} method of class {@code Object} performs no
     * special action; it simply returns normally. Subclasses of
     * {@code Object} may override this definition.
     * <p>
     * The Java programming language does not guarantee which thread will
     * invoke the {@code finalize} method for any given object. It is
     * guaranteed, however, that the thread that invokes finalize will not
     * be holding any user-visible synchronization locks when finalize is
     * invoked. If an uncaught exception is thrown by the finalize method,
     * the exception is ignored and finalization of that object terminates.
     * <p>
     * After the {@code finalize} method has been invoked for an object, no
     * further action is taken until the Java virtual machine has again
     * determined that there is no longer any means by which this object can
     * be accessed by any thread that has not yet died, including possible
     * actions by other objects or classes which are ready to be finalized,
     * at which point the object may be discarded.
     * <p>
     * The {@code finalize} method is never invoked more than once by a Java
     * virtual machine for any given object.
     * <p>
     * Any exception thrown by the {@code finalize} method causes
     * the finalization of this object to be halted, but is otherwise
     * ignored.
     *
     * @throws Throwable the {@code Exception} raised by this method
     * @jls 12.6 Finalization of Class Instances
     * @see WeakReference
     * @see PhantomReference
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    /**
     * 文件的复制
     * @param src
     * @param dest
     */
    public static void copyFile(File src, File dest) {

        BufferedInputStream in=null;
        BufferedOutputStream out=null;
//        FileInputStream iin=new FileInputStream();
        try{
            in=new BufferedInputStream(new FileInputStream(src),1024*32);
            out=new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buf=new byte[1024*32];
            int size;
            while(-1!=(size=in.read(buf))){
                out.write(buf,0,size);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally {

        }
    }
    /*
     在try()括号里面声明IO流，最后可以不必关闭流
     */
    public static void copyFile2(File src,File dest){
        try(
                BufferedInputStream in=new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(dest))){
            byte[]buf=new byte[1024*8];
            int size;
            while(-1!=(size=in.read(buf))){
                out.write(buf,0,size);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 统计目录信息
     *
     * @param dir
     * @return
     */
    public static FileInfo getFileInfo(File dir) {
        FileInfo info =null;

        File[]files=dir.listFiles();
        if(files!=null){
            for(File f:files){
                if(f.isFile()){
                    //文件

                }
            }
        }

        return info;
    }
}
