package common;

import java.math.BigDecimal;
import java.util.*;


public class Common {
	
	
	/**
	 * null�u��
	 * @param str �Ώە�����@�@repstr �ϊ�������
	 * @return �ϊ�������
	 */
	public static String nvl(String str, String repStr){
		  return (str == null)?repStr:str;
		}
	
	/**
	 * null�u��
	 * @param num �Ώې��l�@�@repNum �ϊ����l
	 * @return �ϊ����l
	 */
	public static BigDecimal nvlnum(BigDecimal num, BigDecimal repNum){
			BigDecimal ZEROO = new BigDecimal(0);
		  return (num == null || num == ZEROO)?repNum:num;
		}
	

	
	/**
	 * ���t������X���b�V���ҏW
	 * @param ymd ���t������(YYYYMMDD)
	 * @return ���ʕ�����
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
