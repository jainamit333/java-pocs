package com.amit.metric;

import com.amit.annotations.SimpleAnnotation;
import com.codahale.metrics.*;
import com.codahale.metrics.annotation.*;
import com.codahale.metrics.servlets.AdminServlet;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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

    @Autowired
    DummyRequestAdapter dummyRequestAdapter;

    public static void main(String[] args) throws NoSuchMethodException {

        Queue<Integer> queue = new LinkedList<Integer>();
        QueueManager queueManager  = new QueueManager(metrics,"gauge",queue);

        System.out.println("Annotation -----------------");
        System.out.println(new DummyRequestAdapter().getClass().getAnnotation(SimpleAnnotation.class));
        System.out.println(new DummyRequestAdapter().getClass().getAnnotation(com.codahale.metrics.annotation.Metered.class));
        System.out.println(new DummyRequestAdapter().getClass().getAnnotation(com.codahale.metrics.annotation.Timed.class));

        System.out.println("METHOD ANNO----------------------------");
        System.out.println(new DummyRequestAdapter().getClass().getMethod("map",String.class).getAnnotation(SimpleAnnotation.class));;
        System.out.println(new DummyRequestAdapter().getClass().getMethod("map",String.class).getAnnotation(Timed.class));;
        System.out.println("Start -----------------");
        Class<DummyRequestAdapter> obj = DummyRequestAdapter.class;
        System.out.println("Class annotation :- " +obj.getDeclaredAnnotations().length);
        for(Annotation annotation:obj.getDeclaredAnnotations()){
            System.out.println(annotation.annotationType().toString());
        }


        System.out.println("DUMMY REQUEST ADAPTER");
        for(Method method:obj.getDeclaredMethods()){
            System.out.println(method.getName());
            System.out.println(method.getDeclaredAnnotations().length);
            for(Annotation annotation : method.getDeclaredAnnotations()){
                System.out.println(annotation.toString());
                System.out.println(annotation.annotationType().toString());
            }

        }

        Class<DummyResponseAdapter> obj2 = DummyResponseAdapter.class;
        System.out.println("DUMMY REQUEST ADAPTER");
        for(Method method:obj2.getDeclaredMethods()){
            System.out.println(method.getName());
            System.out.println(method.getDeclaredAnnotations().length);
            for(Annotation annotation : method.getDeclaredAnnotations()){
                System.out.println(annotation.toString());
                System.out.println(annotation.annotationType().toString());
            }

        }



      //  startReport();
       // startJmxReport();
//        Meter requests = metrics.meter("requests");
//        Meter response = metrics.meter("response");
//        Counter pendingJobs = metrics.counter("custom counter");
//        Histogram histogram = metrics.histogram("custom histogam");
//        Timer timer = metrics.timer("custom timer");
//
//        queue.add(1);
//        pendingJobs.inc();
//        pendingJobs.inc();
//        pendingJobs.inc();
//        pendingJobs.dec();
//        pendingJobs.inc();
//
//
//        histogram.update(3);
//        histogram.update(7);
//        histogram.update(1);
//        histogram.update(12);
//        histogram.update(1222);
//
//        wait5Seconds();
//
//
//        Timer.Context context = timer.time();
//        try {
//            wait5Seconds();
//            wait5Seconds();
//
//        }finally {
//            context.stop();
//        }
//
//        try {
//            wait5Seconds();
//            wait5Seconds();
//            wait5Seconds();
//
//        }finally {
//            context.stop();
//        }

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
