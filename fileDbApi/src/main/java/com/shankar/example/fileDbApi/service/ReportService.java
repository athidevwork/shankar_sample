package com.shankar.example.fileDbApi.service;

import com.shankar.example.fileDbApi.data.ReportsRepository;
import com.shankar.example.fileDbApi.data.UserRepository;
import com.shankar.example.fileDbApi.model.Report;
import com.shankar.example.fileDbApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportsRepository reportsRepository;

    public List<Report> getAllUsers() {
        List<Report> reports = new ArrayList<Report>();
        reportsRepository.findAll().forEach(report -> reports.add(report));
        return reports;
    }

    public Report getUserById(int id) {
        return reportsRepository.findById(id).get();
    }

    public void saveOrUpdate(Report user) {
        reportsRepository.save(user);
    }

    public void delete(int id) {
        reportsRepository.deleteById(id);
    }
}
