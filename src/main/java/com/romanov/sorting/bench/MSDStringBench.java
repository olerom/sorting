package com.romanov.sorting.bench;

import com.romanov.sorting.sort.Helper;
import com.romanov.sorting.sort.MSDStrings;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by olerom on 27.11.16.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MSDStringBench {
    private String[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
//        a = Helper.genStrings(10000);
        a = Helper.getMSDBest(10000);
    }

    @Benchmark
    public void measureMSDStrings(Blackhole bh) {
        bh.consume(MSDStrings.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MSDStringBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}