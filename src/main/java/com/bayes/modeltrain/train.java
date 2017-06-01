package com.bayes.modeltrain;

import org.apache.mahout.classifier.naivebayes.training.TrainNaiveBayesJob;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by linux on 17-3-19.
 */
public class train {
    public static void main(String[] args) {
        try {
            String[] str1 = {"-fs", "hdfs://hadoop:9000",
                    "-i", "/mahoutbayes/train/train-seq2parse1/tfidf-vectors",
                    "-o", "/mahoutbayes/train/train1/model",                //	训练文物的输出文件
                    "-li", "/mahoutbayes/train/train1/labelindex",                //	测试任务的输出文件
                    "-c",
                    "-ow",
                    "--tempDir", "/s3"};
            TrainNaiveBayesJob.main(str1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
