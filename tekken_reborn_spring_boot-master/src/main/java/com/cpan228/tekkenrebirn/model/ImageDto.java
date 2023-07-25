package com.cpan228.tekkenrebirn.model;
import java.io.Serializable;
import java.util.Base64;

public class ImageDto implements Serializable {

    private Integer id;
    private String fileName;
    private String fileType;
    private byte[] data;

    public ImageDto(Integer id, String fileName, String fileType, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    // getters and setters for all fields

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    public String getBase64() {
        return Base64.getEncoder().encodeToString(data);
    }
}


