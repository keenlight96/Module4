package com.example.task04_id8895.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/index")
    public String handler(@RequestParam(name = "city", defaultValue = "Asia/Ho_Chi_Minh") String city, Model model) {
        Date date = getTimeByTimezone(city);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }

    public Date getTimeByTimezone(String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);

        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        return date;
    }
}
