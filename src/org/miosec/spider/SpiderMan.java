package org.miosec.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderMan {
	/*static String path = "http://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.1.LlyaR5&id=43618151059&skuId=77172078984&areaId=330500&cat_id=2&rn=5c888c89059b9005dafeda2102360c41&user_id=1797890794&is_b=1";
	static String path2 = "http://detail.tmall.com/item.htm?spm=a220o.1000855.1998025129.3.zzA2VC&id=43981167698&abbucket=_AB-M32_B2&acm=03054.1003.1.291757&aldid=ZOi07Djg&abtest=_AB-LR32-PR32&scm=1003.1.03054.13_43981167698_291757&pos=3";
*/
	public static List getImgs(String path) throws IOException {
		Document doc = Jsoup.connect(path).get();
		Elements elements = doc.getAllElements();
		String[] colors = null;
		String[] imgs;
		List infos = new ArrayList<String>();
		int count = 0;
		for (Element element : elements) {
			if ((element.className()).equals("tm-clear J_TSaleProp tb-img")) {
				Elements nodes = element.getElementsByAttribute("href");
				for (Element node : nodes) {
					String color = node.getElementsByTag("span").text();
					String attr = node.select("a").attr("style");
					String img = attr.substring(attr.indexOf("img"),
							attr.indexOf(")"));
					img = img.replace("40x40", "430x430");
//					System.out.println(color+" "+img);
					infos.add(color+" "+img);
				}
			}

		}
		return infos;
	}
}
