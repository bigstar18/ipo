package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
import java.util.HashMap;

/**
 * 根据中签率生成中签号码
 * @author zyg
 *
 */
public class MathUtil {
	/**
	 * 
	 * @param data
	 * @param flag
	 *            0 深市新股摇号 其它 沪市新股摇号
	 * @return
	 */
	public  List<String> getRandomResult(double data, int flag) {
		Map codes = new HashMap();
		List<String> results = new ArrayList<String>();
		String dataStr = formatFloatNumber(data);
		String str = dataStr.substring(dataStr.indexOf(".") + 1);
		for (int i = 0; i < str.length(); i++) {
			int num = Integer.parseInt(str.charAt(i) + "");
			String[] result = getDataByNumAndLen(num, i + 1, flag, codes);
			if (null != result) {
				List list = Arrays.asList(result);
				results.addAll(list);
			}
		}
		return results;
	}

	/**
	 * 当浮点型数据位数超过10位之后，数据变成科学计数法显示。用此方法可以使其正常显示。
	 * 
	 * @param value
	 * @return Sting
	 */
	public String formatFloatNumber(double value) {
		BigDecimal bd = new BigDecimal(String.valueOf(value));
		int scale = bd.scale();
		String format = "0.";
		for (int i = 0; i < scale; i++) {
			format += "0";
		}
		java.text.DecimalFormat df = new java.text.DecimalFormat(format);
		return df.format(value);

	}

	public String[] getDataByNumAndLen(int num, int len, int flag, Map codes) {
		String[] results = null;
		switch (num) {
		case 1: {
			results = new String[1];
			results[0] = String.valueOf(getOneCode(len, codes));
			break;
		}
		case 2: {
			results = getTwoCode(len, codes);
			break;
		}
		case 3: {
			results = getThirdCode(len, codes);
			break;
		}
		case 4: {
			results = getFourCode(len, codes);
			break;
		}
		case 5: {
			results = getFiveCode(len, codes);
			break;
		}
		case 6: {
			results = getSixCode(len, codes);
			break;
		}
		case 7: {
			results = getSevenCode(len, codes);
			break;
		}
		case 8: {
			results = getEightCode(len, codes);
			break;
		}
		case 9: {
			results = getNineCode(len, codes, flag);
			break;
		}
		}
		return results;
	}

	/**
	 * 生成随机数
	 * 
	 * @param min
	 *            随机数最小值
	 * @param max
	 *            随机数最大值
	 * @return
	 */
	public long getRandomCode(Long min, Long max) {
		long code = (long) (min + Math.random() * (max - min + 1));
		return code;
	}

	/**
	 * 得到正确显示的数，如果少于指定 位数，左边补0
	 * 
	 * @param data
	 *            相减后的整数
	 * @param len
	 *            小数位数
	 * @return
	 */
	public String getRightCode(long data, int len) {
		String value = String.valueOf(data);
		int valueLen = value.length();
		if (valueLen < len) {
			int len2 = len - valueLen;
			for (int i = 0; i < len2; i++) {
				value = "0" + value;
			}
		}
		return value;
	}

	/**
	 * 末尾为1
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * @return
	 */
	public long getOneCode(int len, Map codes) {
		long min = (long) Math.pow(10, len - 1);
		long max = (long) Math.pow(10, len) - 1;
		long code = getRandomCode(min, max);
		String codeStr = String.valueOf(code);

		// 防止后续 号码重复
		while (codes.containsKey(codeStr)) {
			codeStr = String.valueOf(getRandomCode(min, max));
		}

		codes.put(codeStr, true);
		return code;
	}

	/**
	 * 末尾为2
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * @return
	 */
	public String[] getTwoCode(int len, Map codes) {
		String[] datas = new String[2];
		long base = getOneCode(len, codes);
		long chushu = (long) Math.pow(10, len) / 2;
		// 如果随机数等于除数，重新随机一个基本号码
		while ((base == chushu)) {
			base = getOneCode(len, codes);
		}

		datas[0] = String.valueOf(base);

		// 基本数大于除数就减
		if (base > chushu) {
			datas[1] = getRightCode(base - chushu, len);
		} else {
			datas[1] = String.valueOf(base + chushu);
		}
		codes.put(datas[1], true);
		return datas;
	}

	/**
	 * 末尾为3
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * @return
	 */
	public String[] getThirdCode(int len, Map codes) {
		String[] datas = new String[3];

		long one = getOneCode(len, codes);
		datas[0] = String.valueOf(one);

		String twos[] = getTwoCode(len, codes);
		datas[1] = twos[0];
		datas[2] = twos[1];
		return datas;
	}

	/**
	 * 末尾为4
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * 
	 * @return
	 */
	public String[] getFourCode(int len, Map codes) {
		String[] datas = new String[4];
		long base = getOneCode(len, codes);
		datas[0] = String.valueOf(base);

		long chushu = (long) Math.pow(10, len) / 4;
		// 如果随机数等于除数，重新随机一个基本号码
		while ((base == chushu)) {
			base = getOneCode(len, codes);
		}

		// 基本数大于除数就减
		if (base > chushu * 3) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 - chushu;
			datas[3] = getRightCode(data3, len);
		} else if (base < chushu) {
			long data1 = base + chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 + chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 + chushu;
			datas[3] = getRightCode(data3, len);
		} else if ((base > chushu) && (base < chushu * 2)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = base + chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 + chushu;
			datas[3] = getRightCode(data3, len);
		} else if ((base > chushu * 2) && (base < chushu * 3)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = base + chushu;
			datas[3] = getRightCode(data3, len);
		}
		codes.put(datas[1], true);
		codes.put(datas[2], true);
		codes.put(datas[3], true);
		return datas;
	}

	/**
	 * 末尾为5
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * 
	 * @return
	 */
	public String[] getFiveCode(int len, Map codes) {
		String[] datas = new String[5];
		long base = getOneCode(len, codes);
		datas[0] = String.valueOf(base);

		long chushu = (long) Math.pow(10, len) / 5;
		// 如果随机数等于除数，重新随机一个基本号码
		while ((base == chushu)) {
			base = getOneCode(len, codes);
		}

		// 基本数大于除数就减
		if (base > chushu * 4) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 - chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 - chushu;
			datas[4] = getRightCode(data4, len);
		} else if (base < chushu) {
			long data1 = base + chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 + chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 + chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 + chushu;
			datas[4] = getRightCode(data4, len);
		} else if ((base > chushu) && (base < chushu * 2)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = base + chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 + chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 + chushu;
			datas[4] = getRightCode(data4, len);
		} else if ((base > chushu * 2) && (base < chushu * 3)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = base + chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 + chushu;
			datas[4] = getRightCode(data4, len);
		} else if ((base > chushu * 3) && (base < chushu * 4)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 - chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = base + chushu;
			datas[4] = getRightCode(data4, len);
		}
		codes.put(datas[1], true);
		codes.put(datas[2], true);
		codes.put(datas[3], true);
		codes.put(datas[4], true);
		return datas;
	}

	/**
	 * 末尾为6
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * 
	 * @return
	 */
	public String[] getSixCode(int len, Map codes) {
		String[] datas = new String[6];
		long base = getOneCode(len, codes);
		datas[0] = String.valueOf(base);
		String[] fiveDatas = getFiveCode(len, codes);
		datas[1] = fiveDatas[0];
		datas[2] = fiveDatas[1];
		datas[3] = fiveDatas[2];
		datas[4] = fiveDatas[3];
		datas[5] = fiveDatas[4];
		return datas;
	}

	/**
	 * 末尾为7
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * 
	 * @return
	 */
	public String[] getSevenCode(int len, Map codes) {
		String[] datas = new String[7];

		String[] twoDatas = getTwoCode(len, codes);
		String[] fiveDatas = getFiveCode(len, codes);

		datas[0] = twoDatas[0];
		datas[1] = twoDatas[1];
		datas[2] = fiveDatas[0];
		datas[3] = fiveDatas[1];
		datas[4] = fiveDatas[2];
		datas[5] = fiveDatas[3];
		datas[6] = fiveDatas[4];
		return datas;
	}

	/**
	 * 末尾为7
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * 
	 * @return
	 */
	public String[] getEightCode(int len, Map codes) {
		String[] datas = new String[8];
		long base = getOneCode(len, codes);
		datas[0] = String.valueOf(base);

		long chushu = (long) Math.pow(10, len) / 8;
		// 如果随机数等于除数，重新随机一个基本号码
		while ((base == chushu)) {
			base = getOneCode(len, codes);
		}

		// 基本数大于除数就减
		if (base > chushu * 7) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 - chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 - chushu;
			datas[4] = getRightCode(data4, len);
			long data5 = data4 - chushu;
			datas[5] = getRightCode(data5, len);
			long data6 = data5 - chushu;
			datas[6] = getRightCode(data6, len);
			long data7 = data6 - chushu;
			datas[7] = getRightCode(data7, len);
		} else if (base < chushu) {
			long data1 = base + chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 + chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 + chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 + chushu;
			datas[4] = getRightCode(data4, len);
			long data5 = data4 + chushu;
			datas[5] = getRightCode(data5, len);
			long data6 = data5 + chushu;
			datas[6] = getRightCode(data6, len);
			long data7 = data6 + chushu;
			datas[7] = getRightCode(data7, len);
		} else if ((base > chushu) && (base < chushu * 2)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = base + chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 + chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 + chushu;
			datas[4] = getRightCode(data4, len);
			long data5 = data4 + chushu;
			datas[5] = getRightCode(data5, len);
			long data6 = data5 + chushu;
			datas[6] = getRightCode(data6, len);
			long data7 = data6 + chushu;
			datas[7] = getRightCode(data7, len);
		} else if ((base > chushu * 2) && (base < chushu * 3)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = base + chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 + chushu;
			datas[4] = getRightCode(data4, len);
			long data5 = data4 + chushu;
			datas[5] = getRightCode(data5, len);
			long data6 = data5 + chushu;
			datas[6] = getRightCode(data6, len);
			long data7 = data6 + chushu;
			datas[7] = getRightCode(data7, len);
		} else if ((base > chushu * 3) && (base < chushu * 4)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 - chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = base + chushu;
			datas[4] = getRightCode(data4, len);
			long data5 = data4 + chushu;
			datas[5] = getRightCode(data5, len);
			long data6 = data5 + chushu;
			datas[6] = getRightCode(data6, len);
			long data7 = data6 + chushu;
			datas[7] = getRightCode(data7, len);
		} else if ((base > chushu * 4) && (base < chushu * 5)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 - chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 - chushu;
			datas[4] = getRightCode(data4, len);
			long data5 = base + chushu;
			datas[5] = getRightCode(data5, len);
			long data6 = data5 + chushu;
			datas[6] = getRightCode(data6, len);
			long data7 = data6 + chushu;
			datas[7] = getRightCode(data7, len);
		} else if ((base > chushu * 5) && (base < chushu * 6)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 - chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 - chushu;
			datas[4] = getRightCode(data4, len);
			long data5 = data4 - chushu;
			datas[5] = getRightCode(data5, len);
			long data6 = base + chushu;
			datas[6] = getRightCode(data6, len);
			long data7 = data6 + chushu;
			datas[7] = getRightCode(data7, len);
		} else if ((base > chushu * 6) && (base < chushu * 7)) {
			long data1 = base - chushu;
			datas[1] = getRightCode(data1, len);
			long data2 = data1 - chushu;
			datas[2] = getRightCode(data2, len);
			long data3 = data2 - chushu;
			datas[3] = getRightCode(data3, len);
			long data4 = data3 - chushu;
			datas[4] = getRightCode(data4, len);
			long data5 = data4 - chushu;
			datas[5] = getRightCode(data5, len);
			long data6 = data5 - chushu;
			datas[6] = getRightCode(data6, len);
			long data7 = base + chushu;
			datas[7] = getRightCode(data7, len);
		}
		codes.put(datas[1], true);
		codes.put(datas[2], true);
		codes.put(datas[3], true);
		codes.put(datas[4], true);
		return datas;
	}

	/**
	 * 末尾为9
	 * 
	 * @param len
	 *            小数位数
	 * @param codes
	 *            记得号码是否重复
	 * 
	 * @return
	 */
	public String[] getNineCode(int len, Map codes, int flag) {
		String[] datas = new String[9];

		if (flag == 0) {// 深市新股摇号多采用5+4规则
			String[] fourDatas = getFourCode(len, codes);
			String[] fiveDatas = getFiveCode(len, codes);
			datas[0] = fourDatas[0];
			datas[1] = fourDatas[1];
			datas[2] = fourDatas[2];
			datas[3] = fourDatas[3];
			datas[4] = fiveDatas[0];
			datas[5] = fiveDatas[1];
			datas[6] = fiveDatas[2];
			datas[7] = fiveDatas[3];
			datas[8] = fiveDatas[4];
		} else { // 沪市新股摇号多采用8+1规则
			long base = getOneCode(len, codes);
			datas[0] = String.valueOf(base);
			String[] eightDatas = getEightCode(len, codes);
			datas[1] = eightDatas[0];
			datas[2] = eightDatas[1];
			datas[3] = eightDatas[2];
			datas[4] = eightDatas[3];
			datas[5] = eightDatas[4];
			datas[6] = eightDatas[5];
			datas[7] = eightDatas[6];
			datas[8] = eightDatas[7];
		}

		return datas;
	}
}
