/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natan.handlerequests;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author natan
 */
public class Task {
    
    private final Lock accessLock = new ReentrantLock();
    
    // condiçoes para controlar a escrita e leitura do buffer
    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();
   
    private boolean occupied = false;
    private int data = 0;
    
    public void doSomething() throws InterruptedException {
        accessLock.lock();
        
        try {
            if(occupied) canWrite.await();
            ++data;
            occupied = true;
            canRead.signal();
        } finally {
            accessLock.unlock();
        }
    }
    
    public int getData() throws InterruptedException {
        int readValue = 0;
        accessLock.lock();
        
        try {
            if(!occupied) canRead.await();
            occupied = false;
            readValue = data;
            canWrite.signal();
            
            return readValue;
        } finally {
            accessLock.unlock();
        }
    }
}
