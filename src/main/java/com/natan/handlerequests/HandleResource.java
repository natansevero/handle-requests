/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natan.handlerequests;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    
    private Object lock = new Object();
    
    private BlockingQueueTask blockingQueueTask = new BlockingQueueTask();
    private Task task = new Task();
    ExecutorService service = Executors.newCachedThreadPool();
    
    @GetMapping
    public String handle() throws InterruptedException, ExecutionException {
        service.execute(new Producer(blockingQueueTask, task));
//        service.execute(new Consumer(blockingQueueTask));
        
        int a = blockingQueueTask.get();

        return "teste " + a;
    }
}
