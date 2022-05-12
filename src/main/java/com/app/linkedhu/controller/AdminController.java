package com.app.linkedhu.controller;

import com.app.linkedhu.entitites.User;
import com.app.linkedhu.config.UserExcelExporter;
import com.app.linkedhu.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;


    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/disableList")
    public List<User> getAllDisabled(){
        return userService.getAllDisabled();
    }

    @GetMapping("enableList")
    public List<User> getAllEnabled(){
        return userService.getAllEnabled();
    }

    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userService.getAllUsers();

        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);

        excelExporter.export(response);
    }

    @PutMapping("/enable")
    public void enableUser(@RequestParam(name = "userId") Long userId){
        userService.enableUser(userId);
    }
}