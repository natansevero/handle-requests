/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natan.handlerequests;

/**
 *
 * @author natan
 */
public class Executor implements Runnable{

    private BlockingQueue blockingQueue;
   
    public Executor(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    
    @Override
    public void run() {
        
    }
    
}
