package org.miosec.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;


public class LaoUtils {
	/**
	 * ��������ת��Ϊ�ַ���
	 * @param is ������
	 * @return �ַ���
	 * @throws IOException
	 */
	public static String convertStreamToString(InputStream is)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringWriter sw = new StringWriter();
		String str = null;
		try {
			while ((str = br.readLine()) != null) {
				sw.write(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		sw.close();
		br.close();
		return sw.toString();
	}
}
