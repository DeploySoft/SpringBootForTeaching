package com.andres.alianzabe.controller;

import com.andres.alianzabe.constant.ResourceMapping;
import com.andres.alianzabe.delegate.IDelegateController;
import com.andres.alianzabe.dto.ResponseData;
import com.andres.alianzabe.dto.UserDto;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private IDelegateController delegateController;


    @GetMapping(ResourceMapping.USER)
    public ResponseEntity<ResponseData> getUsers() {
        return delegateController.getUsers();
    }

    @PostMapping(ResourceMapping.USER)
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        return delegateController.createUser(userDto);
    }

    @PutMapping(ResourceMapping.USER + "/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return delegateController.updateUser(id, userDto);
    }

    @DeleteMapping(ResourceMapping.USER + "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        return delegateController.deleteUser(id);
    }

    @GetMapping(value = ResourceMapping.USER + ResourceMapping.EXPORT, produces = "text/csv")
    public void getUsersCSV(HttpServletResponse response) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        String filename = "users.csv";
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        StatefulBeanToCsv<UserDto> writer = new StatefulBeanToCsvBuilder<UserDto>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        writer.write(Objects.requireNonNull(delegateController.getUsers().getBody()).getData());
    }
}
