package com.yrdce.ipo.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {
	private double iopNum;// 持仓量
	private double buyNum;// 申购量
	private String sucRate;// 中签率
	private String decimalNum;
	long tmp = 0l;
	private List<String> endNumList = new ArrayList<String>();

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Selection s = new Selection();
		int test = 0;
		List<String> temp = s.MainSelection(5855458, 50855458);

		for (int i = 0; i < temp.size(); i++) {
			System.out.println(temp.get(i));
			test += s.OwnMatchingEndNum(1000000001, 855458, temp.get(i));
			test += s.OwnMatchingEndNum(1000855458, 50000000, temp.get(i));
			// test+=s.OwnMatchingEndNum(10505700,100000,temp.get(i));
			// test+=s.OwnMatchingEndNum(10605700,400000,temp.get(i));

		}
		System.out.println("尾号个数" + temp.size());
		System.out.println("可匹配的个数" + s.tmp);
		System.out.println("分开匹配总和" + test);
		System.out.println("中签率" + (s.iopNum / s.buyNum));
		s.tmp = 0l;
		s.MatchingEndNum(temp);
		System.out.println("可匹配的个数" + s.tmp);

	}

	// 对外开放主接口
	public List<String> MainSelection(double ipoNum, double buyNum) {
		this.iopNum = ipoNum;
		this.buyNum = buyNum;
		System.out.println("发售量：" + ipoNum);
		System.out.println("申购量：" + buyNum);
		tmp = 0l;
		endNumList.clear();
		double result = this.iopNum / this.buyNum;
		if (result >= 1) {
			for (int i = 0; i <= 9; i++) {
				endNumList.add(String.valueOf(i));
			}
			return endNumList;
		}
		GetSucRate(result);
		SplitSucRate();
		MatchingEndNum(endNumList);
		AdjustmentNum();
		return endNumList;
	}

	// 总体中签数匹配
	private void MatchingEndNum(List<String> temp) {
		System.out.println("总体中签数匹配开始");
		for (int i = 0; i < temp.size(); i++) {
			String endNum = temp.get(i);
			int len = endNum.length();
			String buyNumString = String.valueOf((int) buyNum);
			if (Long.parseLong(buyNumString.substring(buyNumString.length() - len, buyNumString.length())) >= Long.parseLong(endNum)) {
				if (buyNumString.length() == len)
					tmp += 1;
				else
					tmp += Long.parseLong(buyNumString.substring(0, buyNumString.length() - len)) + 1l;
			} else {
				if (buyNumString.length() == len)
					tmp += 1;
				else
					tmp += Long.parseLong(buyNumString.substring(0, buyNumString.length() - len));
			}
		}
		System.out.println("总体中签数匹配结束");

	}

	// 个人中签数匹配
	public int OwnMatchingEndNum(int numStart, int numCounts, String numEnd) {

		String strNumStart = String.valueOf(numStart);
		if (strNumStart.length() < numEnd.length()) {
			return 0;
		}
		int tempEnd = numStart + numCounts - 1;
		int iNumEnd = Integer.parseInt(numEnd);
		String strTempEnd = String.valueOf(tempEnd);
		String numStartEnd = strNumStart.substring(strNumStart.length() - numEnd.length(), strNumStart.length());
		int lenEndNum = numEnd.length();
		strNumStart = strNumStart.substring(0, strNumStart.length() - lenEndNum);
		strTempEnd = strTempEnd.substring(0, strTempEnd.length() - lenEndNum);
		int tempNumStart = Integer.parseInt(strNumStart);
		int tempNumEnd = Integer.parseInt(strTempEnd);
		if (tempNumEnd > tempNumStart) {
			if (IsContainRight(tempEnd, numEnd) && IsContainLeft(numStart, numEnd)) {
				return tempNumEnd - tempNumStart + 1;
			} else if (IsContainRight(tempEnd, numEnd) || IsContainLeft(numStart, numEnd)) {
				return tempNumEnd - tempNumStart;
			} else {
				return tempNumEnd - tempNumStart - 1;
			}

		} else if (tempNumEnd == tempNumStart) {
			if (Integer.parseInt(numStartEnd) <= iNumEnd && Integer.parseInt(numStartEnd) + numCounts - 1 >= iNumEnd) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	// 判断尾号开始是否在区间内
	private boolean IsContainLeft(int num, String numEnd) {
		String strNum = String.valueOf(num);
		int iNumEnd = Integer.parseInt(numEnd);
		strNum = strNum.substring(strNum.length() - numEnd.length(), strNum.length());
		if (Integer.parseInt(strNum) <= iNumEnd) {
			return true;
		} else {
			return false;
		}
	}

	// 判断尾号结束是否在区间内
	private boolean IsContainRight(int num, String numEnd) {
		String strNum = String.valueOf(num);
		int iNumEnd = Integer.parseInt(numEnd);
		strNum = strNum.substring(strNum.length() - numEnd.length(), strNum.length());
		if (Integer.parseInt(strNum) >= iNumEnd) {
			return true;
		} else {
			return false;
		}
	}

	// 号码补齐
	private void AdjustmentNum() {
		System.out.println("号码补齐开始" + tmp + ":" + iopNum);
		String strEndNum;
		while (tmp < iopNum) {
			int temp = (int) Math.pow(10, String.valueOf((int) buyNum).length());

			String zero = String.valueOf(temp).substring(1, String.valueOf(temp).length());
			DecimalFormat df = new DecimalFormat(zero);
			Random rd = new Random();
			if (String.valueOf((int) buyNum).length() > 1) {
				int iTemp = Integer.parseInt(String.valueOf((int) buyNum).substring(1, String.valueOf((int) buyNum).length()));
				strEndNum = String.valueOf(rd.nextInt(((int) buyNum - iTemp)) + iTemp);
				while (!DeleSame(strEndNum)) {
					strEndNum = String.valueOf(rd.nextInt(((int) buyNum - iTemp)) + iTemp);
				}
			} else {
				strEndNum = String.valueOf(rd.nextInt((int) buyNum));
			}

			if (strEndNum.length() < String.valueOf((int) buyNum).length())
				strEndNum = df.format(Integer.parseInt(strEndNum));
			endNumList.add(strEndNum);
			tmp++;

		}
		System.out.println("号码补齐结束");
	}

	// 获取中签率
	private void GetSucRate(double result) {

		System.out.println("中签率：" + result);
		int iTemp = String.valueOf((int) buyNum).length();
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(iTemp);
		df.setGroupingSize(0);
		df.setRoundingMode(RoundingMode.FLOOR);
		sucRate = df.format(result);
		String[] a_splitSucRate = sucRate.split("\\.");
		decimalNum = a_splitSucRate[1];
		System.out.println("中签率：" + decimalNum);
	}

	// 拆分中签率
	private void SplitSucRate() {
		if (String.valueOf((int) buyNum).length() - 2 < 0) {
			return;
		}
		if (String.valueOf((int) buyNum).length() - 2 == 0) {
			SplitSucRate(0);
		} else if (String.valueOf((int) buyNum).length() - 2 > decimalNum.length()) {
			for (int i = 0; i < decimalNum.length(); i++) {
				SplitSucRate(i);
			}
		} else {
			for (int i = 0; i < String.valueOf((int) buyNum).length() - 2; i++) {
				SplitSucRate(i);
			}
		}
	}

	private void SplitSucRate(int i) {
		String m_Decimal = decimalNum.substring(i, i + 1);
		if (!m_Decimal.equals("0")) {
			int m_num = (int) Math.pow(10, i + 1);
			GetOtherEndNum(Integer.parseInt(m_Decimal), m_num);
		}
	}

	// 尾号查重
	private boolean DeleSame(String strRd) {
		if (endNumList.size() != 0) {
			for (int i = 0; i < endNumList.size(); i++) {
				if (strRd.endsWith(endNumList.get(i))) {
					return false;
				}
			}
			return true;
		} else {

			return true;
		}
	}

	private boolean DeleSame(int m_num, int m_result, int temp, DecimalFormat df) {
		for (int i = 0; i < m_num; i++) {
			int endNum = (m_result + i * (temp / m_num)) % temp;
			if (endNum == 0) {
				endNum++;
			}
			if (!DeleSame(df.format(endNum))) {
				return false;
			}
		}
		return true;
	}

	// 生成尾号
	private void GetOtherEndNum(int m_num, int temp) {
		if (temp % m_num == 0) {
			Random rd = new Random();
			int m_result = rd.nextInt(temp);
			String zero = String.valueOf(temp).substring(1, String.valueOf(temp).length());
			DecimalFormat df = new DecimalFormat(zero);
			while (!DeleSame(m_num, m_result, temp, df)) {
				m_result = rd.nextInt(temp);
			}
			for (int i = 0; i < m_num; i++) {
				int endNum = (m_result + i * (temp / m_num)) % temp;
				if (endNum == 0) {
					endNum++;
				}
				endNumList.add(df.format(endNum));
			}

		} else {
			fnSplitNum(m_num, temp);
		}
	}

	// 中签率拆分后 不整除 中签率拆分
	private void fnSplitNum(int m_num, int temp) {
		if (m_num == 3) {
			GetOtherEndNum(1, temp);
			GetOtherEndNum(2, temp);
		} else if (m_num == 4) {
			GetOtherEndNum(2, temp);
			GetOtherEndNum(2, temp);
		} else if (m_num > 5) {
			GetOtherEndNum(5, temp);
			GetOtherEndNum(m_num % 5, temp);
		}
	}

}
