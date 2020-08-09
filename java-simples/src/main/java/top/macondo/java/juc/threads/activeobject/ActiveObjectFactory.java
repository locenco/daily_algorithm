package top.macondo.java.juc.threads.activeobject;

import top.macondo.java.juc.threads.activeobject.message.ActiveObject;
import top.macondo.java.juc.threads.activeobject.message.Servant;

public final class ActiveObjectFactory {

    private ActiveObjectFactory() {
        
    }
    
    public static ActiveObject createActiveObject() {
        Servant servant = new Servant();
        ActivationQueue queue = new ActivationQueue();
        SchedulerThread schedulerThread = new SchedulerThread(queue);
        ActiveObjectProxy proxy = new ActiveObjectProxy(schedulerThread, servant);
        schedulerThread.start();
        return proxy;
    }
}