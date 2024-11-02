package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static File gamefile = new File("C:/ProgramData/PopCap Games");
    public static File backupfile = new File("./backup/");

    public static void sc(){
        if(gamefile.exists()){
            System.out.println("游戏文件存在");
        }
        else {
            System.out.println("游戏文件不存在");
        }

        if(backupfile.exists()){
            System.out.println("备份文件存在");
        }
        else {
            System.out.println("备份文件不存在");
            try {
                FileUtils.forceMkdir(backupfile);
                System.out.println("创建成功");
            } catch (IOException e) {
                System.out.println("创建失败");
                throw new RuntimeException(e);
            }
        }
    }

    public static void setBackupfile(){
        try {
            if(backupfile.exists()){
                FileUtils.deleteDirectory(new File("./backup/PlantsVsZombies"));
            }
            FileUtils.copyDirectory(gamefile,backupfile);
            System.out.println("备份成功");

        } catch (IOException e) {
            System.out.println("备份失败");
            throw new RuntimeException(e);
        }
    }

    public static void setGamefile(){
        try {
            if(gamefile.exists()){
                FileUtils.deleteDirectory(gamefile);
            }
            FileUtils.copyDirectory(backupfile,gamefile);
            System.out.println("还原成功");
        } catch (IOException e) {
            System.out.println("还原失败");
            throw new RuntimeException(e);
        }
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("By 帝君大人的肥陀");
        System.out.println("免费软件 禁止倒卖");
        clearConsole();


        while (true){
            System.out.println("0:退出程序");
            System.out.println("1：检查游戏文件与备份是否存在");
            System.out.println("2：备份游戏文件");
            System.out.println("3:还原游戏文件");
            int in;
            System.out.print("请输入:");
            Scanner scanner =new Scanner(System.in);
            in=scanner.nextInt();
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (in){
                case 0:
                    return;
                case 1:
                    sc();
                    break;
                case 2:
                    setBackupfile();
                    break;
                case 3:
                    setGamefile();
                    break;
            }

            clearConsole();

        }
    }
}