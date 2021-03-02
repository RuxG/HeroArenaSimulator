package com.Game;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * This class has the task of printing the outputs in a file.
 */
public class Writer {
    private String outputPath;
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public Writer(final String outputPath) {
        this.outputPath = outputPath;
        try {
            fileWriter = new FileWriter(outputPath);
            printWriter = new PrintWriter(fileWriter);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * @param message is the sentence to be printed as ouput
     */
    public void print(final String message) {
        try {
            printWriter.print(message);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public final String getOutputPath() {
        return outputPath;
    }

    public final FileWriter getFileWriter() {
        return fileWriter;
    }

    public final PrintWriter getPrintWriter() {
        return printWriter;
    }
}
