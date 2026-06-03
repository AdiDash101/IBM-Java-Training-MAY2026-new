package org.eclipse.jakarta.hello;

import java.io.Serializable;
import java.util.UUID;

public class Report implements Serializable {
    private String id;
    private String title;
    private String detail;

    public Report() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
}