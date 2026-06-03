package org.eclipse.jakarta.hello;

import jakarta.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ReportService implements Serializable {
    private List<Report> reports = new ArrayList<>();

    public List<Report> getReports() {
        return reports;
    }

    public void add(Report report) {
        reports.add(report);
    }

    public Report getById(String id) {
        return reports.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void delete(String id) {
        reports.removeIf(r -> r.getId().equals(id));
    }
}