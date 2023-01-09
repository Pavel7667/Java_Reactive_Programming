package org.reactor.assignment.code;

import org.reactor.utils.Utils;

public class TestClassForFileService {

    public static void main(String[] args) {

        FileService.read("file01.txt")
                .subscribe(
                        Utils.onNext(),
                        Utils.onError(),
                        Utils.onComplete()
                );

        FileService.write("file03.txt","THis is File 3")
                .subscribe(
                        Utils.onNext(),
                        Utils.onError(),
                        Utils.onComplete()
                );

        FileService.delete("file01.txt")
                .subscribe(
                        Utils.onNext(),
                        Utils.onError(),
                        Utils.onComplete()
                );


    }
}
