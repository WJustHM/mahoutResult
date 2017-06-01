package com.bayes.modeltrain;


import org.apache.mahout.vectorizer.SparseVectorsFromSequenceFiles;

/**
 * Created by linux on 17-3-18.
 */
public class Seq2sparse {

    public static void main(String[] args){
        try {
            String[] strtest1={"-fs", "hdfs://hadoop:9000",
                    "-i","/mahoutbayes/test/seqdirtest1",
                    "-o","/mahoutbayes/test/test-seq2parse1",
                    "-a", "org.apache.lucene.analysis.core.WhitespaceAnalyzer",
                    "-lnorm",
                    "-nv",
                    "-ow",
                    "-wt","tfidf" //主要完成字典生成，给词编号，统计词频   转换乘向量模式
            };
            String[] strtrain1={"-fs", "hdfs://hadoop:9000",
                    "-i","/mahoutbayes/train/seqdirtrain1",
                    "-o","/mahoutbayes/train/train-seq2parse1",
                    "-a", "org.apache.lucene.analysis.core.WhitespaceAnalyzer",
                    "-lnorm",
                    "-nv",
                    "-ow",
                    "-wt","tfidf" //主要完成字典生成，给词编号，统计词频   转换乘向量模式
            };
            SparseVectorsFromSequenceFiles.main(strtest1);
            SparseVectorsFromSequenceFiles.main(strtrain1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
