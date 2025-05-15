package com.asset.avenues.UserDetailService.controller;

import com.asset.avenues.UserDetailService.entity.User;
import com.asset.avenues.UserDetailService.service.CustomerRequestService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletOutputStream;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://qr-code-project-pria.onrender.com/")
@RestController
@RequestMapping("/api/requests")
public class CustomerRequestController {

    @Autowired
    private CustomerRequestService service;

    @PostMapping
    public User saveRequest(@RequestBody User request) {
        return service.saveRequest(request);
    }

    // Get all users
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = service.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Export users to Excel
    @GetMapping("/exportUsers")
    public void exportUsersToExcel(HttpServletResponse response) throws IOException {
        List<User> users = service.getAllUsers();

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users");

        int rowNum = 0;
        Row header = sheet.createRow(rowNum++);
        header.createCell(0).setCellValue("Name");
        header.createCell(1).setCellValue("Mobile");
        header.createCell(2).setCellValue("Email");
        header.createCell(3).setCellValue("Profession");
        header.createCell(4).setCellValue("Loan Type");
        header.createCell(5).setCellValue("AA Code");
        header.createCell(6).setCellValue("Home Loan Type");
        header.createCell(7).setCellValue("Loan Against Securities");

        for (User user : users) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getName());
            row.createCell(1).setCellValue(user.getMobileNumber());
            row.createCell(2).setCellValue(user.getEmail());
            row.createCell(3).setCellValue(user.getProfession());
            row.createCell(4).setCellValue(user.getLoanType());
            row.createCell(5).setCellValue(user.getAacode());
            row.createCell(6).setCellValue(user.getHomeLoanType());
            row.createCell(7).setCellValue(user.getLoanAgainstSecurities());
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    // Health check endpoint
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
