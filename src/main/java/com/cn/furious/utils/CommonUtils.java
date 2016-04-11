package com.cn.furious.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommonUtils {
	public static Date[] getVisitFreqTimeRange(Date st, Date et) {
		Date nSt = st;
		Date nEt = et;
		// endTime往前退29天，看时间区间是否小于30天，如果是，则补齐30天
		Date tempD = DateUtils.addTime(et, Calendar.DAY_OF_MONTH, -29);
		if (tempD.compareTo(st) < 0) {
			nSt = tempD;
		}

		return new Date[] { nSt, nEt };
	}

	public static long getDays(Date st, Date et) {
		long sDays = st.getTime() / DateUtils.ONE_DAY_MILLI;
		long eDays = et.getTime() / DateUtils.ONE_DAY_MILLI;

		return eDays - sDays + 1;
	}

	public static Map<Integer, Integer> getPagesIndex(Integer listSize,Integer pageSize) {
		Map<Integer,Integer> retMap=new HashMap<Integer, Integer>();
		if (pageSize == null || pageSize.intValue() == 0){
			pageSize=1024;
		}
		
		if(listSize < pageSize){
			retMap.put(0,listSize);
		}else{
			Integer pages=listSize/pageSize;
			for(int i=0;i<pages;i++){
				retMap.put((i*pageSize), ((i+1)*pageSize));
			}
			if((pages*pageSize) != listSize){
				retMap.put((pages*pageSize), listSize);
			}
		}
		return retMap;
	}
	
	public static void main(String[] args) {
		Date date = DateUtils.parseDate("2014-05-20", DateUtils.PATTERN_THREE);
		Date[] newTimeRange = CommonUtils.getVisitFreqTimeRange(date, date);
		Date newSt = newTimeRange[0];
		Date newEt = newTimeRange[1];
		long days = CommonUtils.getDays(newSt, newEt);

		System.out.println(days);
	}
}
