package com.luoyi;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Test {
    File musicFolder;
    File destinationFolder;

    public static void main(String[] args) throws IOException {
        Test test = new Test("/Users/luoyi/Music/Music/Media.localized/Music", "/Users/luoyi/Music/LXmusic");
        test.copy();
        System.out.println("歌曲复制完成！");
    }

    public Test(String sourceFolderPath, String destinationFolderPath) {
        musicFolder = new File(sourceFolderPath);
        destinationFolder = new File(destinationFolderPath);
    }

    public void copy() throws IOException {
        if (!musicFolder.exists()) {
            System.out.println("源文件夹不存在");
            return;
        }

        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs(); // 如果目标文件夹不存在，创建它
        }

        copyMp3Files(musicFolder, destinationFolder);
    }

    private void copyMp3Files(File sourceFolder, File destinationFolder) throws IOException {
        File[] files = sourceFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 如果是子文件夹，递归处理
                    copyMp3Files(file, destinationFolder);
                } else if (file.isFile() && file.getName().toLowerCase().endsWith(".mp3")) {
                    // 如果是 ".mp3" 文件，直接复制到目标文件夹
                    Files.copy(file.toPath(), destinationFolder.toPath().resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("复制文件: " + file.getAbsolutePath() + " 到 " + destinationFolder.getAbsolutePath());
                }
            }
        }
    }
}
