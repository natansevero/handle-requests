/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natan.handlerequests;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class BlockingQueueTask {
    
    private LinkedBlockingQueue<Task> queue = new LinkedBlockingQueue<>();
    
    public void set(Task task) {
        try {
            queue.put(task);
        } catch (InterruptedException ex) {
            Logger.getLogger(BlockingQueueTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int get() {
        try {
            Task task = queue.take();
            task.doSomething();
            return task.getData();
        } catch (InterruptedException ex) {
            Logger.getLogger(BlockingQueueTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
}
