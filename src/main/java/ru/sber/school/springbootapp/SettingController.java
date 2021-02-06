package ru.sber.school.springbootapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {

    private final Setting setting;

    public SettingController(Setting setting) {
        this.setting = setting;
    }

    @GetMapping("/setting")
    public ResponseEntity<Setting> getSettings() {
        return new ResponseEntity<Setting>(this.setting, HttpStatus.OK);
    }

}
