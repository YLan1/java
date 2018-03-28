package com.lhzs.springbootdemo.model;


import org.springframework.data.domain.Page;

public class ResponseModel {
    private String message;
    private Object data;
    private Integer code;
    private DataInfoModel dataInfoModel;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataInfoModel getDataInfoModel() {
            return dataInfoModel;
    }

    public void setDataInfoModel(Page page) {
        dataInfoModel = new DataInfoModel();
        long totalElements = page.getTotalElements();
        dataInfoModel.setTotalElements(page.getTotalElements());
       dataInfoModel.setNumber(page.getNumber());
       dataInfoModel.setTotalPages(page.getTotalPages());
       dataInfoModel.setSize(page.getSize());
       this.data=page.getContent();
    }
}
