//package com.scmd;
//
//import java.util.Collection;
//import java.util.Queue;
//import java.util.concurrent.*;
//
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
//
///**
// * @program:
// * @description: 将串行递归转换为并行递归
// * @author: zhouzhixiang
// * @create: 2018-11-15 20:54
// */
//public class ThreadTest4 {
//
//    public<T> void sequentialRecursive(List<Node<T>> nodes, Collection<T> results) {
//        for(Node<T> n : nodes){
//            results.add(n.compute);
//            sequentialRecursive(n.getChild, results);
//        }
//    }
//
//    public<T> void parallelRecursive(final Executor exec, List<Node<T>> nodes, Collection<T> results) {
//        for(final Node<T> n : nodes) {
//            exec.execute(new Runnable() {
//                @Override
//                public void run() {
//                    results.add(n.compute());
//                }
//            });
//            parallelRecursive(exec, n.getChild, results);
//        }
//    }
//
//
//    public<T> Collection<T> getParallelResults(List<Node<T>> nodes) throws InterruptedException {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        Queue<T> queue = new ConcurrentLinkedQueue<>();
//        parallelRecursive(exec, nodes, queue);
//        exec.shutdown();
//        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
//        return queue;
//    }
//}
