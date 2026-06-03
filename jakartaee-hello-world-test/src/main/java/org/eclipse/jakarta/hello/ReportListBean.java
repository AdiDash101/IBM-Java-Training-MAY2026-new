package org.eclipse.jakarta.hello;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ReportListBean implements Serializable {

    @Inject
    private ReportService reportService;

    public List<Report> getReports() {
        return reportService.getReports();
    }

    public void delete(String id) {
        reportService.delete(id);
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Report deleted successfully!"));
    }
}