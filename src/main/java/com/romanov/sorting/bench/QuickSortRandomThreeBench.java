package com.romanov.sorting.bench;

/**
 * Created by olerom on 21.11.16.
 */

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.QuickSortRandomThree;
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
public class QuickSortRandomThreeBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
//        a = Helper.gen(1000);
//        a = Helper.antiQuick(1000);
        a = Helper.getArray();
    }

    @Benchmark
    public void measureQuickSortRandomThree(Blackhole bh) {
        bh.consume(QuickSortRandomThree.qsort(a, 0, a.length - 1));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortRandomThreeBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}