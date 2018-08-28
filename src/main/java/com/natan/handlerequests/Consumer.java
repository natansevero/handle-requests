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
public class Consumer implements Runnable {

    private BlockingQueueTask blockingQueueTask;
    
    public Consumer(BlockingQueueTask blockingQueueTask) {
        this.blockingQueueTask = blockingQueueTask;
    }
    
    @Override
    public void run() {
        try {
            int i = this.blockingQueueTask.get();
            System.out.println(i);
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
