package ewu.ducanh.packageConsoleApp.utils;

import java.io.File;
import java.util.Scanner;

public class IOUtil {
    /**
     * The method returns a File object inputted from the keyboard by the user
     * @param keyboardInput the Scanner object representing the keyboard input
     * @return a File object determined from the user input
     * @throws NullPointerException if keyboardInput is null
     */
    public static File getFileInput(final Scanner keyboardInput) throws NullPointerException {
        if ( keyboardInput == null )
            throw new NullPointerException("Scanner object is null");

        String              inputFileName;
        File                inputFile = null, tmpFile;
        boolean             validFile;

        do {
            System.out.print("Enter the path to the input file -> ");
            inputFileName = keyboardInput.nextLine();
            tmpFile = new File(inputFileName);
            if ( !tmpFile.isFile() ) {
                System.out.println("Invalid file - not normal file");
                validFile = false;
            } else {
                inputFile = tmpFile.isAbsolute() ? (tmpFile) : tmpFile.getAbsoluteFile();
                validFile = true;
            }
            System.out.println();
        } while ( !validFile );

        return inputFile;
    }
}
