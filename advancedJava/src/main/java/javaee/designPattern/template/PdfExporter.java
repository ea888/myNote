package com.ecvlearning.javaee.designPattern.template;

import java.io.File;

public class PdfExporter extends AbstractFileExporter{
    @Override
    public File export() {
        readWordFile("hello.docx");
        System.out.println("Export PDF file from MS word.");
        return null;
    }
}
