package com.lubuwei2.ssm.utils.fileUpload;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

@Component
public class FileUploadProgressListener implements ProgressListener {
    @Override
    public void update(long read, long length, int items) {
//        status.setRead(read);
//        status.setLength(length);
//        status.setItems(items);
    }
}
