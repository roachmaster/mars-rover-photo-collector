package com.leonardo.rocha.endpoint;

import com.leonardo.rocha.endpoint.date.DateFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
        String fileName = "/imageDates.txt";

        try (InputStream inputStream = getClass().getResourceAsStream(fileName);
            Stream<String> stream = new BufferedReader(new InputStreamReader(inputStream)).lines()) {

            stream.forEach(date -> {
                try {
                    dateList.add(DateFormatter.formatDate(date));
                } catch (ParseException e) {
                    logger.error("{} is an invalid date.", date, e.getMessage());
                }
            });

        } catch (Exception e) {
            logger.error("Error reading file {}", fileName, e.getStackTrace());
        }
    }
}
