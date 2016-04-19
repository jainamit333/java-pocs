package com.amit.metric;

import com.codahale.metrics.*;
import com.codahale.metrics.servlets.AdminServlet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import static com.codahale.metrics.MetricRegistry.name;

/**
 * Created by amit on 19/4/16.
 */
public class GetStarted {

    static final MetricRegistry metrics = new MetricRegistry();
    static final MetricRegistry gaugeMetrics = new MetricRegistry();


    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<Integer>();
        QueueManager queueManager  = new QueueManager(metrics,"gauge",queue);


        startReport();
       // startJmxReport();
        Meter requests = metrics.meter("requests");
        Meter response = metrics.meter("response");
        Counter pendingJobs = metrics.counter("custom counter");
        Histogram histogram = metrics.histogram("custom histogam");
        Timer timer = metrics.timer("custom timer");

        queue.add(1);
        pendingJobs.inc();
        pendingJobs.inc();
        pendingJobs.inc();
        pendingJobs.dec();
        pendingJobs.inc();


        histogram.update(3);
        histogram.update(7);
        histogram.update(1);
        histogram.update(12);
        histogram.update(1222);

        wait5Seconds();


        Timer.Context context = timer.time();
        try {
            wait5Seconds();
            wait5Seconds();

        }finally {
            context.stop();
        }

        try {
            wait5Seconds();
            wait5Seconds();
            wait5Seconds();

        }finally {
            context.stop();
        }

//
//
//        requests.mark();
//        response.mark();
//        requests.mark();
//        requests.mark();
//        requests.mark(9l);
//        response.mark(5l);
//        wait5Seconds();
    }

    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);
    }


    static void  startJmxReport(){
        final JmxReporter reporter = JmxReporter.forRegistry(metrics).build();
        reporter.start();
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(5*1000);
        }
        catch(InterruptedException e) {}
    }


//    public void addJob(Job job) {
//        pendingJobs.inc();
//        queue.offer(job);
//    }
//
//    public Job takeJob() {
//        pendingJobs.dec();
//        return queue.take();
//    }

}
