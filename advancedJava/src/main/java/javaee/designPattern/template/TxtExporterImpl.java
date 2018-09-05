package com.ecvlearning.javaee.designPattern.template;

import java.io.File;

public class TxtExporterImpl extends AbstractFileExporter{
    @Override
    public File export() {
        readWordFile("hello.docx");
        System.out.println("Export TXT file from MS word.");
        return null;
    }
}
