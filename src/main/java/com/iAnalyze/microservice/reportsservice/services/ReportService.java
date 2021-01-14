package com.iAnalyze.microservice.reportsservice.services;

import com.iAnalyze.microservice.reportsservice.model.Transaction;
import com.iAnalyze.microservice.reportsservice.repository.TransactionRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private TransactionRepository repository;

    private final String path = "/Users/jethroglaudin/Documents/capstone/reports";

    private JasperPrint jasperPrint;

    public String exportReport() throws FileNotFoundException, JRException {
        configureJasperReport();
        exportPDFReport();
        exportHTMLReport();
        return "Report generated in path: " + path;
    }

    public void configureJasperReport() throws FileNotFoundException, JRException {

        List<Transaction> fraudTrasanctions = repository.findByIsFraud();

        //Load file and compile it
        File file = ResourceUtils.getFile("classpath:fraud_transactions.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(fraudTrasanctions);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Jethro Glaudin");

        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
    }
    public void exportPDFReport() throws JRException {
        JasperExportManager.exportReportToPdfFile(jasperPrint,  path + "/fraud_transactions.pdf");
    }

    public void exportHTMLReport() throws JRException {
        JasperExportManager.exportReportToHtmlFile(jasperPrint,  path + "/fraud_transactions.html");
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException  {
        configureJasperReport();

        if(reportFormat.equalsIgnoreCase("html")) {
            exportHTMLReport();
        }

        if(reportFormat.equalsIgnoreCase("pdf")) {
            exportPDFReport();
        }
        return "Report generated in path: " + path;
    }
}
