
package com.shenhuanjie.utils;


import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    /**
     * logger
     */
    private static Logger logger = Logger.getLogger(FileUtil.class);

    /**
     * 创建时间戳
     *
     * @return 时间戳
     */
    public static String createTimeSamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhMMss");

        String timesamp = simpleDateFormat.format(new Date());

        logger.info(">do createTimeSamp");
        return timesamp;
    }

    /**
     * 断言Excel文件写入之前的条件
     *
     * @param directory 目录
     * @param fileName  文件名
     * @return file
     * @throws IOException
     */
    public static File assertFile(String directory, String fileName) throws IOException {
        logger.info(">do assertFile");

        File tmpFile = new File(directory +  fileName);
        if (tmpFile.exists()) {
            if (tmpFile.isDirectory()) {
                throw new IOException("File '" + tmpFile + "' exists but is a directory");
            }
            if (!tmpFile.canWrite()) {
                throw new IOException("File '" + tmpFile + "' cannot be written to");
            }
        } else {
            File parent = tmpFile.getParentFile();
            if (parent != null) {
                if (!parent.mkdirs() && !parent.isDirectory()) {
                    throw new IOException("Directory '" + parent + "' could not be created");
                }
            }
        }
        return tmpFile;
    }

    /**
     * 创建临时文件目录
     *
     * @param dirs
     */
    public static void createTempDirs(String dirs) {
        try {
            File file = new File(dirs);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建临时文件夹
     *
     * @param dir 文件目录
     */
    public static void createTempDir(String dir) {
        try {
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件
     *
     * @param ctxpath  文件目录
     * @param fileName 文件名
     */
    private static void downloadFile(String ctxpath, String fileName) {
        // TODO Auto-generated method stub

    }


    /**
     * 删除临时文件以及目录
     *
     * @param dir 文件目录
     */
    private static void deleteTempFileAndDir(String dir) {
        try {
            File files = new File(dir);
            deleteDir(files);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful. If a
     * deletion fails, the method stops attempting to delete and returns
     * "false".
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * zip压缩 zip4j_1.3.1.jar
     *
     * @param zipfile  压缩文件完整路径（包含文件名）
     * @param filePath 压缩文件路径
     * @return
     */
    public static String createZipFile(String zipfile, String filePath) {
        try {
            /*
             * ZipFile zipFile = new ZipFile("E:\\ZipTest\\test.zip"); File folderToAdd =new
             * File("E:\\ZipTest");
             */
            ZipFile zipFile = new ZipFile(zipfile);
            File folderToAdd = new File(filePath);
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            zipFile.addFolder(folderToAdd, parameters);

        } catch (ZipException e) {
            e.printStackTrace();
        }
        return zipfile;
    }
}
