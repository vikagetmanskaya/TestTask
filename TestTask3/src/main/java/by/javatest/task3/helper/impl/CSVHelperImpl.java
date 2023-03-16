package by.javatest.task3.helper.impl;

import by.javatest.task3.entity.Login;
import by.javatest.task3.entity.Posting;
import by.javatest.task3.helper.CSVHelper;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;

@Component
public class CSVHelperImpl implements CSVHelper {

    public List<Login> readCSVLogin(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Login> logins = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Login login = new Login(
                        csvRecord.get("Application"),
                        csvRecord.get("AppAccountName"),
                        Boolean.parseBoolean(csvRecord.get("IsActive")),
                        csvRecord.get("JobTitle"),
                        csvRecord.get("Department"));

                logins.add(login);
            }

            return logins;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public List<Posting> readCSVPosting(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';'))) {

            List<Posting> postings = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            for (CSVRecord csvRecord : csvRecords) {
                Posting posting = new Posting(
                        Long.parseLong(csvRecord.get("Mat. Doc.")),
                        Integer.parseInt(csvRecord.get("Item")),
                        LocalDate.parse((csvRecord.get("Doc. Date")), formatter),
                        LocalDate.parse(csvRecord.get("Pstng Date"), formatter),
                        csvRecord.get("Material Description"),
                        Integer.parseInt(csvRecord.get("Quantity")),
                        csvRecord.get("BUn"),
                        Double.parseDouble(csvRecord.get("Amount LC").replace(',', '.')),
                        csvRecord.get("Crcy"),
                        csvRecord.get("User Name"));

                postings.add(posting);
            }

            return postings;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
