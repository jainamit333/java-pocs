package com.amit.metric;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by amit on 19/4/16.
 */
public class QueueManager {


    private final Queue<Integer> classQueue;

    public QueueManager(MetricRegistry metrics, String name,Queue queue) {
        this.classQueue = queue;
        metrics.register(MetricRegistry.name(QueueManager.class, name, "size"),
                new Gauge<Integer>() {
                    public Integer getValue() {
                        return classQueue.size();
                    }
                });
    }


}
