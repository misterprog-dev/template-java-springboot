package com.dsoumaila.swagger.Exception;

public class BookDuplicateException extends Exception {
    public BookDuplicateException() {
        super("This book already exists, please register another one!");
    }
}
