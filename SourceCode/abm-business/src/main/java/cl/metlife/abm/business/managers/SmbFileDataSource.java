package cl.metlife.abm.business.managers;

import jcifs.smb.SmbFile;

import javax.activation.DataSource;
import javax.activation.FileTypeMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SmbFileDataSource implements DataSource
{
    private SmbFile _file;

    public SmbFileDataSource(SmbFile file) {
        this._file = file;
    }

    public InputStream getInputStream() throws IOException {
        return _file.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return _file.getOutputStream();
    }

    public String getContentType() {
        return FileTypeMap.getDefaultFileTypeMap().getContentType(this._file.getName());
    }

    public String getName() {
        return this._file.getName();
    }

    public SmbFile getFile() {
        return this._file;
    }

}
