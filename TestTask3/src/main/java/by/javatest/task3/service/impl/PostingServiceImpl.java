package by.javatest.task3.service.impl;

import by.javatest.task3.entity.Login;
import by.javatest.task3.entity.Posting;
import by.javatest.task3.helper.CSVHelper;
import by.javatest.task3.repository.PostingDao;
import by.javatest.task3.service.LoginService;
import by.javatest.task3.service.PostingService;
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
public class PostingServiceImpl implements PostingService {
    @Autowired
    LoginService loginService;
    @Autowired
    PostingDao postingDao;
    @Autowired
    CSVHelper csvHelper;

    @Override
    public List<Posting> readPostingsFromCSV() throws IOException {
        File file = new File("C:\\Users\\37529\\Desktop\\TestTasks\\TestTask3\\src\\main\\resources\\postings.csv");
        FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
        InputStream input = new FileInputStream(file);
        OutputStream os = fileItem.getOutputStream();
        IOUtils.copy(input, os);


        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        List<Login> logins = loginService.readLoginsFromCSV();
        List<Posting> postings = csvHelper.readCSVPosting(multipartFile.getInputStream());

        for (Posting posting : postings) {
            for (Login login : logins) {
                if (login.getAppAccountName().equals(posting.getUserName()) && login.isActive()) {
                    posting.setAuthorizedPosting(true);
                }
            }
        }
        return postings;
    }

    @Override
    @Transactional
    public void savePostings(List<Posting> postings) {

        postingDao.saveAll(postings);
    }


    @Override
    @Transactional
    public List<Posting> findByParameter(Integer year, Integer month, Integer day, Boolean authorizedPosting) {
        return postingDao.findByParameter(year, month, day, authorizedPosting);
    }


}
