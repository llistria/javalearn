package com.mjc813;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamExample2 {
    public static void main() throws Exception{
        Path path = Paths.get(Objects.requireNonNull(StreamExample2.class.getResource("data.txt")).toURI());
        Stream<String> stream = Files.lines(path, Charset.defaultCharset());
        stream.forEach(System.out::println);
        stream.close();
    }
}
