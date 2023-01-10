package org.reactor.assignmentThree;

import org.reactor.utils.Utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderTest {

    public static void main(String[] args) {


        FileReaderService readerService = new FileReaderService();

        Path path = Paths.get("src/main/resources/assignment/section1/file02.txt");
        readerService.read(path)
                .take(10)
                .subscribe(Utils.subscriber());



    }
}
