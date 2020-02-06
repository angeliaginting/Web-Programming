package com.example.ppw.controller;

import com.example.ppw.model.test;
import com.example.ppw.repository.testNotFoundException;
import com.example.ppw.repository.testRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class testController {
    @Autowired
    testRepo testRepo;
    @CrossOrigin

    @GetMapping("/")
    public List<test>retrieveAlltest()
    { return  testRepo.findAll(); }

    @GetMapping("/{id}")
    public test retrievetest(@PathVariable  Integer id){
        Optional<test> test= testRepo.findById(id);
        if (!test.isPresent())
            throw new testNotFoundException("id-" + id);
        return test.get();
    }

    @PostMapping("/save")
    public test save(@RequestBody  test test){
        test test1=new test(
                test.getId(),
                test.getNama(),
                test.getKelas()
        );
        return testRepo.save(test1);
        //return "Sukses";
    }

    @DeleteMapping("/{id}")
    public void deletetest(@PathVariable Integer id){
        testRepo.deleteById(id);
    }



}
