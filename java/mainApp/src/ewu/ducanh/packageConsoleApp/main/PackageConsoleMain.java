package ewu.ducanh.packageConsoleApp.main;

import ewu.ducanh.packageConsoleApp.utils.IOUtil;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PackageConsoleMain {
    public static void main ( String[] args ) {
        File                fileInput;
        FileWriter          fileOutput;
        Scanner             kbInp, fileReader;

        kbInp = new Scanner(System.in);
        fileInput = IOUtil.getFileInput(kbInp);
    }
}
