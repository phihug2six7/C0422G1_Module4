package com.example.controller;

import com.example.model.Phone;
import com.example.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private IPhoneService iPhoneService;

    @GetMapping("/list")
    public ResponseEntity<Page<Phone>> listPhone(@PageableDefault Pageable pageable) {
        Page<Phone> phonePage = this.iPhoneService.findAll(pageable);
        if (!phonePage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phonePage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createPhone(@RequestBody Phone phone){
        iPhoneService.save(phone);
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Integer id){
        Phone phone = this.iPhoneService.findById(id);
        if (phone == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iPhoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/updateForm/{id}")
    public ResponseEntity<Phone> updateForm(@PathVariable int id){
        return new ResponseEntity<>(this.iPhoneService.findById(id), HttpStatus.OK);
    }
}
