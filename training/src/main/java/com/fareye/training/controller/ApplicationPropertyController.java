package com.fareye.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fareye.training.utills.CrunchifyGetPropertyValues;

import java.io.IOException;
import java.util.Properties;

@RestController
public class ApplicationPropertyController {

    @Autowired
    CrunchifyGetPropertyValues c;
    @GetMapping(path = "/application_properties")
    public Properties hello() throws IOException {
       return c.getPropValues();
    }

}
