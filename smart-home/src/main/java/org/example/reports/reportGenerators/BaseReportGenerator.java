package org.example.reports.reportGenerators;

import lombok.Data;

import java.io.PrintWriter;

@Data
public abstract class BaseReportGenerator {

    protected String reportFile;
    protected PrintWriter writer;

    abstract void generateReport();
}
