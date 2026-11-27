package com.example.demo.Controller;

import com.example.demo.Entity.t_three_entity;
import com.example.demo.Repository.t_three_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private t_three_repo myTableRepo;

    @GetMapping("/tones")
    public List<t_three_entity> getAllData() {
        return myTableRepo.findAll();
    }

    @GetMapping("/insert")
    public String insertData() {
        t_three_entity obj = new t_three_entity();
        obj.setNumda(444);
        obj.setNameda("collector");
        myTableRepo.save(obj);
        return "Data Inserted";
    }

    @PostMapping("/insert")
    public String insertData1(@RequestBody t_three_entity obj) {
        myTableRepo.save(obj);
        return "Inserted";
    }

    
    @PostMapping("/insertmany")
    public String insertMany(@RequestBody List<t_three_entity> objList) {
        myTableRepo.saveAll(objList);
        return objList.size() + " Records Inserted";
    }

    @GetMapping("/find/{id}")
    public t_three_entity getById(@PathVariable int id) {
        return myTableRepo.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public String updateRecord(@PathVariable int id, @RequestBody t_three_entity updatedObj) {
        t_three_entity existing = myTableRepo.findById(id).orElse(null);
        if (existing == null) {
            return "Record Not Found";
        }
        existing.setNameda(updatedObj.getNameda());
        existing.setSalary(updatedObj.getSalary());
        existing.setSlab(updatedObj.getSlab());
        myTableRepo.save(existing);
        return "Record Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRecord(@PathVariable int id) {
        myTableRepo.deleteById(id);
        return "Record Deleted";
    }
}
