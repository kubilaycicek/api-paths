package com.kubilaycicek.product.model;

public class Operation {
    private String url;
    private String method;
    private String className;
    private String type;

    public Operation() {
    }

    public Operation(String url, String method, String className, String type) {
        this.url = url;
        this.method = method;
        this.className = className;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
