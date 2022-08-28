package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import found.BookPay;
import found.BookRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(new Book());
    }

    @Override
    public void update(Book book) throws Exception{
        if (book.getAmount() == 0) {
            throw new BookRent();
        }
        book.setAmount(book.getAmount() -1);
        iBookRepository.save(book);
    }

    @Override
    public void payment(Book book) throws Exception {
        if (book==null){
            throw new BookPay();
        }
        if (book.getAmount()>= book.getAmountTotal()){
//            model.addAttribute("msg","Đủ sách rồi");
//            return "pay";
        }
        book.setAmount(book.getAmount() +1);
        iBookRepository.save(book);
    }
}
