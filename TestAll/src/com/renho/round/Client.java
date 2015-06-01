package com.renho.round;

import java.math.BigDecimal;

public class Client {

	public static void main(String[] args) {
		
		/*银行家舍入
		 * 四舍六入五考虑
		 * 五后非零就进一
		 * 五后为零看奇偶
		 * 五前为偶应舍去
		 * 五前为奇要进一
		 */
		
		
		BigDecimal bd005 = BigDecimal.valueOf(100.005D);
		System.out.println(bd005.doubleValue() + ":" + bd005.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
		BigDecimal bd015 = BigDecimal.valueOf(100.015D);
		System.out.println(bd015.doubleValue() + ":" + bd015.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
		BigDecimal bd025 = BigDecimal.valueOf(100.025D);
		System.out.println(bd025.doubleValue() + ":" + bd025.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
		BigDecimal bd035 = BigDecimal.valueOf(100.035D);
		System.out.println(bd035.doubleValue() + ":" + bd035.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
		BigDecimal bd045 = BigDecimal.valueOf(100.045D);
		System.out.println(bd045.doubleValue() + ":" + bd045.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
		BigDecimal bd0335 = new BigDecimal(100.035D);
		System.out.println(bd035.equals(bd0335));
		
		BigDecimal bd01 = new BigDecimal(0.1D);
		System.out.println(bd01 + ":" + bd01.setScale(17, BigDecimal.ROUND_HALF_EVEN));
		
		BigDecimal bd01str = new BigDecimal("0.1");
		System.out.println(bd01str + ":" + bd01str.setScale(17, BigDecimal.ROUND_HALF_EVEN));
		
		System.out.println(bd005.setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println(bd005.setScale(2, BigDecimal.ROUND_HALF_DOWN));
	}

}
