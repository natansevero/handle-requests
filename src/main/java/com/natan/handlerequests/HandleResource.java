/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natan.handlerequests;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author natan
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/handle")
public class HandleResource {
    
    private int data = 0;
    private Object lock = new Object();
    
    @GetMapping
    public String handle() throws InterruptedException, ExecutionException {
        return "";
    }
}
