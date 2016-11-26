package com.romanov.sorting.bench;

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.MergeSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MergeSortBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
//        a = Helper.gen(100000);
        a = Helper.getArray();
    }

    @Benchmark
    public void measureMergeSort(Blackhole bh) {
        bh.consume(MergeSort.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}