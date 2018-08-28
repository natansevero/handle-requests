/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natan.handlerequests;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class Producer implements Runnable {

    private BlockingQueueTask blockingQueueTask;
    private Task task;
    
    public Producer(BlockingQueueTask blockingQueueTask, Task task) {
        this.blockingQueueTask = blockingQueueTask;
        this.task = task;
    }
    
    @Override
    public void run() {
        try {
            blockingQueueTask.set(task);
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
