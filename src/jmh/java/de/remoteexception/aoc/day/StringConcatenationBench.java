package de.remoteexception.aoc.day;

import de.remoteexception.util.StringConcatenation;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringConcatenationBench {
    private String[] strings;

    @Setup
    public void prepare() {
        strings = new String[1000000];
        for (int i = 0; i < 1000000; i++) {
            strings[i] = "test" + i;
        }
    }

    @Benchmark
    public void measureJoinViaConcat(Blackhole blackhole) {
        blackhole.consume(StringConcatenation.joinViaConcat(strings));
    }

    @Benchmark
    public void measureJoinViaPlus(Blackhole blackhole) {
        blackhole.consume(StringConcatenation.joinViaPlus(strings));
    }

    @Benchmark
    public void measureJoinViaAppend(Blackhole blackhole) {
        blackhole.consume(StringConcatenation.joinViaAppend(strings));
    }
}