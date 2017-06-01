package com.bayes.modeltrain;

import org.apache.mahout.text.SequenceFilesFromDirectory;

/**
 * Created by linux on 17-3-14.
 */
public class TestSeqdirectory {
    public static void main(String[] args) {
        String[] argtest1 = {"-fs", "hdfs://hadoop:9000",
                "-ow",
                "-i", "/mahoutbayes/data/Testdataclean/test1",
                "-o", "/mahoutbayes/test/seqdirtest1",
                "--tempDir", "/st1"};
        String[] argtrain1 = {"-fs", "hdfs://hadoop:9000",
                "-ow",
                "-i", "/mahoutbayes/data/Trainingdataclean/train1",
                "-o", "/mahoutbayes/train/seqdirtrain1",
                "--tempDir", "/st2"};
        try {
            SequenceFilesFromDirectory.main(argtest1);
            SequenceFilesFromDirectory.main(argtrain1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
