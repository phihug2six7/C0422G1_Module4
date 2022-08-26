package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/")
    public String showlist(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String showDetail( @RequestParam Integer id,Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "detail";
    }

    @GetMapping("/rent")
    public String rent(@RequestParam Integer id, Model model) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getAmount() == 0) {
            throw new Exception();
        }
        book.setAmount(book.getAmount() -1);
        iBookService.update(book);
        model.addAttribute("book", iBookService.findById(id));
        return "detail";
    }


    @GetMapping("/pay")
    public String showPay(){
        return "pay";
    }

    @PostMapping("/payment")
    public String payment(@RequestParam int id,Model model) throws Exception {
        Book book= iBookService.findById(id);
        if (book==null){
            throw new Exception();
        }
        if (book.getAmount()>= book.getAmountTotal()){
            model.addAttribute("msg","Đủ sách rồi");
            return "pay";
        }
        book.setAmount(book.getAmount() +1);
        iBookService.update(book);
        return "pay";
    }


    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "error";
    }
}