package common;

import java.math.BigDecimal;
import java.util.*;


public class Common {
	
	
	/**
	 * null置換
	 * @param str 対象文字列　　repstr 変換文字列
	 * @return 変換文字列
	 */
	public static String nvl(String str, String repStr){
		  return (str == null)?repStr:str;
		}
	
	/**
	 * null置換
	 * @param num 対象数値　　repNum 変換数値
	 * @return 変換数値
	 */
	public static BigDecimal nvlnum(BigDecimal num, BigDecimal repNum){
			BigDecimal ZEROO = new BigDecimal(0);
		  return (num == null || num == ZEROO)?repNum:num;
		}
	

	
	/**
	 * 日付文字列スラッシュ編集
	 * @param ymd 日付文字列(YYYYMMDD)
	 * @return 結果文字列
	 */
	public  String fmtSlash(String ymd){
	  if(ymd == null || ymd.length() != 8){
	    return ymd;
	  }
	  
	  return ymd.substring(0,4) + "-" +
	         ymd.substring(4,6) + "-" +
	         ymd.substring(6,8);
	}
}
