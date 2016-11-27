package com.romanov.sorting.bench;

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.QuickSortBinary;
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
public class QuickSortBinaryBench {
    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
//        a = Helper.gen(1000);
        a = Helper.antiQuick(10000);
//        a = Helper.getArray();
//        a = Helper.getArraySmall();
//        a = Helper.getSorted(10000);
    }

    @Benchmark
    public void measureQuickSortBinary(Blackhole bh) {
        bh.consume(QuickSortBinary.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortBinaryBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}