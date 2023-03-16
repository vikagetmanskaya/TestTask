package by.javatest.task3.service.impl;

import by.javatest.task3.entity.Login;
import by.javatest.task3.helper.CSVHelper;
import by.javatest.task3.repository.LoginDao;
import by.javatest.task3.service.LoginService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    CSVHelper csvHelper;
    @Autowired
    LoginDao loginDao;

    @Override
    public List<Login> readLoginsFromCSV() throws IOException {
        File file = new File("C:\\Users\\37529\\Desktop\\TestTasks\\TestTask3\\src\\main\\resources\\logins.csv");
        FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());

        InputStream input = new FileInputStream(file);
        OutputStream os = fileItem.getOutputStream();
        IOUtils.copy(input, os);


        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

        List<Login> logins = csvHelper.readCSVLogin(multipartFile.getInputStream());

        return logins;
    }

    @Override
    @Transactional
    public void saveLogins(List<Login> logins) {

        loginDao.saveAll(logins);


    }

    @Override
    @Transactional
    public List<Login> getLogins() {
        return loginDao.findAll();
    }
}
