package com.iAnalyze.microservice.reportsservice.api;

import com.iAnalyze.microservice.reportsservice.model.Transaction;
import com.iAnalyze.microservice.reportsservice.repository.TransactionRepository;
import com.iAnalyze.microservice.reportsservice.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private ReportService service;

    @GetMapping("/fraud/rawdata")
    public List<Transaction> getFraudData() {
        return repository.findByIsFraud();
    }

    @GetMapping("/fraud/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }

    @GetMapping("/fraud")
    public String generatePDFHtmlReports() throws FileNotFoundException, JRException {
        return service.exportReport();
    }
}
