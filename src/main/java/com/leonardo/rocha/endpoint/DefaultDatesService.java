package com.leonardo.rocha.endpoint;

import com.leonardo.rocha.endpoint.date.DateFormatter;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultDatesService implements DatesService {
    private final Logger logger = LoggerFactory.getLogger(DatesService.class);

    private List<String> dateList = new ArrayList<String>();

    @Override
    public List<String> getDates() {
        return dateList;
    }

    @PostConstruct
    public void initializeDates() {
        String fileName = "./src/test/resources/imageDates.txt";
        try{
            List<String> dates = FileUtils.readLines(new File(fileName),"utf-8");
            formatDates(dates);
        } catch(IOException e) {
            logger.error("Error reading file {}", fileName, e.getStackTrace());
        }
    }

    private void formatDates(List<String> dates){
        for(String date : dates){
            formatAndAddDate(date);
        }
    }

    private void formatAndAddDate(String date){
        try {
            dateList.add(DateFormatter.formatDate(date));
        } catch (ParseException e){
            logger.error("{} is an invalid date.", date, e.getMessage());
        }
    }
}
