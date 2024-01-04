package org.example.reports.reportGenerators;

import lombok.Data;
import org.example.generators.events.EventToHandle;

import java.io.PrintWriter;

@Data
public abstract class BaseReportGenerator {

    protected String reportFile;
    protected PrintWriter writer;

    abstract void generateReport();
}
