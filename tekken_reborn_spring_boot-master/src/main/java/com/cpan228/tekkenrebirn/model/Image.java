package com.cpan228.tekkenrebirn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String contentType;
    @NotEmpty
    private String fileName;

    @Lob
    @JsonIgnore//Not including the data bytes info in the JSON object bc it's too long
    private byte[] data;

    public Image(){}

    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public void setContent(byte[] bytes) {
        this.data = bytes;
    }
}