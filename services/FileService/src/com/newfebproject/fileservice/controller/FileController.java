/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.newfebproject.fileservice.controller;

import com.newfebproject.fileservice.FileService;
import java.lang.String;
import java.io.IOException;
import java.lang.Exception;
import com.wavemaker.runtime.file.model.DownloadResponse;
import javax.servlet.http.HttpServletRequest;
import com.newfebproject.fileservice.FileService.WMFile;
import org.springframework.web.multipart.MultipartFile;
import com.newfebproject.fileservice.FileService.FileUploadResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/file", method = RequestMethod.DELETE)
    public boolean deleteFile(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "relativePath", required = false) String relativePath) throws IOException {
        return fileService.deleteFile(file, relativePath);
    }

    @RequestMapping(value = "/downloadFile", produces = "application/octet-stream", method = RequestMethod.GET)
    public DownloadResponse getDownloadFile(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "relativePath", required = false) String relativePath, @RequestParam(value = "returnName", required = false) String returnName) throws Exception {
        return fileService.getDownloadFile(file, relativePath, returnName);
    }

    @RequestMapping(value = "/downloadFileAsInline", produces = "application/octet-stream", method = RequestMethod.GET)
    public DownloadResponse getDownloadFileAsInline(@RequestParam(value = "file", required = false) String file, @RequestParam(value = "relativePath", required = false) String relativePath, @RequestParam(value = "returnName", required = false) String returnName) throws Exception {
        return fileService.getDownloadFileAsInline(file, relativePath, returnName);
    }

    @RequestMapping(value = "/files", method = RequestMethod.GET)
    public WMFile[] listFiles(HttpServletRequest httpServletRequest, @RequestParam(value = "relativePath", required = false) String relativePath) throws IOException {
        return fileService.listFiles(httpServletRequest, relativePath);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = "multipart/form-data")
    public FileUploadResponse[] uploadFile(@RequestPart(value = "files") MultipartFile[] files, @RequestParam(value = "relativePath", required = false) String relativePath, HttpServletRequest httpServletRequest) {
        return fileService.uploadFile(files, relativePath, httpServletRequest);
    }
}
