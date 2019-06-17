package edu.sse.ustc.basic;

import java.math.BigInteger;

/**
 * 大数值运算
 * @author iustc
 *
 */
public class BasicProgram_BigNumber {
	public static void main(String[] args) {
		BigInteger bigValue = BigInteger.valueOf(1);
		
		// add
		BigInteger addValue = bigValue.add(BigInteger.valueOf(2));
		System.out.println("addValue: " + addValue);
		// multiply
		BigInteger multiplyValue = bigValue.multiply(BigInteger.valueOf(3));
		System.out.println("multiplyValue: " + multiplyValue);
		
	}
}
