package com.romanov.sorting.bench;

/**
 * Created by olerom on 20.11.16.
 */

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.QuickSort;
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
public class QuickSortBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
//        a = Helper.gen(1000);
        a = Helper.antiQuick(10000);
//        a = Helper.getArray();
//        a = Helper.getSorted(10000);
    }

    @Benchmark
    public void measureQuickSort(Blackhole bh) {
        bh.consume(QuickSort.sort(a, 0, a.length - 1));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}