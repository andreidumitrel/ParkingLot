package com.parking.parkinglot1.common;

public class CarPhotoDto {

    private Long id;
    private String filename;
    private String fileType;
    private byte[] fileContent;

    public CarPhotoDto(Long id, String filename, String fileType, byte[] fileContent) {
        this.id = id;
        this.filename = filename;
        this.fileType = fileType;
        this.fileContent = fileContent;
    }

    public String getFilename() {
        return filename;
    }

    public Long getId() {
        return id;
    }

    public String getFileType() {
        return fileType;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

}
