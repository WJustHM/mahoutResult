package com.bayes.classification;

import org.apache.mahout.classifier.ClassifierResult;
import org.apache.mahout.math.RandomAccessSparseVector;
import org.apache.mahout.math.Vector;

import java.util.Map;

public class BayesUtil {

	/**
	 * �������ַ���ת��ΪVector
//	 * @param lines
	 * @return
	 */
	public static Vector transformToVector(String[] line){
		Vector v=new RandomAccessSparseVector(line.length);
		for(int i=0;i<line.length;i++){
			double item=0;
			try{
				item=Double.parseDouble(line[i]);
			}catch(Exception e){
				return null; // ���������ת����˵����������������
			}
			v.setQuick(i, item);
		}
		return v;
	}
	/**
	 * ���ݵ÷�ֵ����
	 * @param v
	 * @param labelMap
	 * @return
	 */
	public static String classifyVector(Vector v,Map<Integer, String> labelMap){
		int bestIdx = Integer.MIN_VALUE;
		double bestScore = Long.MIN_VALUE;
		for (Vector.Element element : v.all()) {
			if (element.get() > bestScore) {
				bestScore = element.get();
				bestIdx = element.index();
			}
		}
		if (bestIdx != Integer.MIN_VALUE) {
			ClassifierResult classifierResult = new ClassifierResult(labelMap.get(bestIdx), bestScore);
			return classifierResult.getLabel();
		}
		
		return null;
	}
}
