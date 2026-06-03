package org.eclipse.jakarta.hello;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ReportEditBean implements Serializable {

    @Inject
    private ReportService reportService;

    private String id;
    private Report report;

    @PostConstruct
    public void init() {
        report = new Report();
    }

    public void loadData() {
        if (id != null && !id.isEmpty()) {
            Report existing = reportService.getById(id);
            if (existing != null) {
                this.report = existing;
            }
        }
    }

    public String save() {
        if (id == null || id.isEmpty()) {
            reportService.add(report);
        }
        return "reportList.xhtml?faces-redirect=true";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Report getReport() { return report; }
    public void setReport(Report report) { this.report = report; }
}