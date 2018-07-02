package com.example.demotopic03.controllers.restcontrollers;


import com.example.demotopic03.models.Book;
import com.example.demotopic03.models.filters.BookFilter;
import com.example.demotopic03.services.BookService;
import com.example.demotopic03.services.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/book")
@ApiResponses({
        @ApiResponse(code = 200, message = "Ok Custom"),
        @ApiResponse(code = 404, message = "Not found custom")
})
@Api(description = "BookRestController Custom")
public class BookRestController {

    private BookService bookService;
    private UploadService uploadService;

    public BookRestController(BookService bookService, UploadService uploadService) {
        this.bookService = bookService;
        this.uploadService = uploadService;
    }


    @GetMapping("/all")
//    @ApiIgnore
    @ApiOperation(value = "Get All Book no Filter")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }


    @GetMapping("/filter")
    public List<Book> getFilter(BookFilter bookFilter) {
        return this.bookService.bookFilter(bookFilter);
    }



    @PostMapping("")
    public Map<String, Object> create(@RequestBody Book book) {
        this.bookService.create(book) ;

        Map<String, Object> response = new HashMap<>();

        response.put("status", true);
        response.put("book", book);
        response.put("message", "Insert ok looking good!!");

        return response;
    }


    @PutMapping("")
    public Map<String, Object> update(@RequestBody Book book) {

        this.bookService.update(book) ;

        Map<String, Object> response = new HashMap<>();

        response.put("status", true);
        response.put("message", "Update ok looking good!!");

        return response;
    }



    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable("id") Integer id) {
        this.bookService.delete(id);

        Map<String, Object> response = new HashMap<>();

        response.put("status", true);
        response.put("message", "Delete ok looking good!!");

        return response;
    }



    @GetMapping("/{id}")
    public Map<String, Object> findOne(@PathVariable("id") Integer id) {

        Book book = this.bookService.findOne(id);

        Map<String, Object> response = new HashMap<>();

        if (book != null) {
            response.put("status", true);
            response.put("book", book);
            response.put("message", "Ok found looking good!!!");
        }
        else {
            response.put("status", false);
            response.put("book", null);
            response.put("message", "Not ok found!!!");
        }
        return response;
    }


    /*@PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file_btb") MultipartFile file) {

        String filename = this.uploadService.upload(file);

        Map<String, Object> response = new HashMap<>();

        if (filename != null) {
            response.put("status", true);
            response.put("filename", filename);
            response.put("message", "Ok upload file looking good!!!");
        }
        else {
            response.put("status", false);
            response.put("message", "Not ok upload file!!!");
        }
        return response;
    }*/





    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> upload(@RequestParam("file_btb") MultipartFile file) {

        String filename = this.uploadService.upload(file);

        Map<String, Object> response = new HashMap<>();

        if (filename != null) {
            response.put("status", true);
            response.put("filename", filename);
            response.put("message", "Ok upload file looking good!!!");
        }
        else {
            response.put("status", false);
            response.put("message", "Not ok upload file!!!");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PostMapping("/multi")
    public Map<String, Object> create(@RequestBody List<Book> books) {

        Map<String, Object> response = new HashMap<>();

        this.bookService.creates(books);

        response.put("status", true);
        response.put("book", books);
        response.put("message", "Insert ok looking good!!");

        return response;
    }












}
