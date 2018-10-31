package Practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class practice2 {
	public static void main(String[] args) throws IOException {

		List<String> urlList = new ArrayList<>();

		urlList.add("http://books.toscrape.com/");

		while (true) {
			String url = urlList.get(0);
			urlList.remove(0);

			if (url == null) {
				break;
			}

			Document doc = Jsoup.connect(url).get();

			if (url.equals("http://books.toscrape.com/")) {
				Element element = doc.selectFirst("#default > div > div > div > div > form > strong:nth-child(2)"); //All products 1000 results

				String text = element.text();
				int pages = Integer.parseInt(text);
				int page_num = pages / 20;
				for (int j = 1; j <= page_num; j++) {
					String temp = String.format("http://books.toscrape.com/catalogue/page-%d.html", j);//%d = integer of the page_num
					urlList.add(temp);
					for (String urlFixed : urlList) {
						Document doc2 = Jsoup.connect(urlFixed).get();
						Elements titles = doc.select(
								"#default > div > div > div > div > section > div:nth-child(2) > ol > li> article > h3 > a");
						for (Element title : titles) {

							System.out.println(title.text());

						}
						String selectorPage = "#default > div > div > div > div > section > div > ol > li > article > h3 > a";

						Elements elements = doc.select(selectorPage);
						for (Element elementBooks : elements) {
							String textUrl = elementBooks.absUrl("href");
							Document doc3 = Jsoup.connect(textUrl).get();

							Elements UPC = doc3
									.select("#content_inner > article > table > tbody > tr:nth-child(1) > td");
							Elements Product_Type = doc3
									.select("#content_inner > article > table > tbody > tr:nth-child(2) > td");
							Elements Price_excl_tax = doc3
									.select("#content_inner > article > table > tbody > tr:nth-child(3) > td");
							Elements Price_incl_tax = doc3
									.select("#content_inner > article > table > tbody > tr:nth-child(4) > td");
							Elements Tax = doc3
									.select("#content_inner > article > table > tbody > tr:nth-child(5) > td");
							Elements Availability = doc3
									.select("#content_inner > article > table > tbody > tr:nth-child(6) > td");
							Elements Number_of_reviews = doc3
									.select("#content_inner > article > table > tbody > tr:nth-child(7) > td");

							System.out.println(UPC.text());
							System.out.println(Product_Type.text());
							System.out.println(Price_excl_tax.text());
							System.out.println(Price_incl_tax.text());
							System.out.println(Tax.text());
							System.out.println(Availability.text());
							System.out.println(Number_of_reviews.text());

						}
					}
				}
//			} else if (url.contains("catalogue/page"))
//
//			{
//				Elements titles = doc.select(
//						"#default > div > div > div > div > section > div:nth-child(2) > ol > li> article > h3 > a");
//				for (Element title : titles) {
//
//					System.out.println(title.text());
//
//				}

			}
			//				else if (url.contains("catalogue/page")) {

			//				Elements titles = doc.select(
			//						"#default > div > div > div > div > section > div:nth-child(2) > ol > li> article > h3 > a");
			//				for (Element title : titles) {
			//					Document doc2 = Jsoup.connect(title.attr("href:abs")).get();
			//
			//					Elements UPC = doc2.select("#content_inner > article > table > tbody > tr:nth-child(1) > td");
			//					Elements Product_Type = doc2
			//							.select("#content_inner > article > table > tbody > tr:nth-child(2) > td");
			//					Elements Price_excl_tax = doc2
			//							.select("#content_inner > article > table > tbody > tr:nth-child(3) > td");
			//					Elements Price_incl_tax = doc2
			//							.select("#content_inner > article > table > tbody > tr:nth-child(4) > td");
			//					Elements Tax = doc2.select("#content_inner > article > table > tbody > tr:nth-child(5) > td");
			//					Elements Availability = doc2
			//							.select("#content_inner > article > table > tbody > tr:nth-child(6) > td");
			//					Elements Number_of_reviews = doc2
			//							.select("#content_inner > article > table > tbody > tr:nth-child(7) > td");
			//
			//					System.out.println(UPC.text());
			//					System.out.println(Product_Type.text());
			//					System.out.println(Price_excl_tax.text());
			//					System.out.println(Price_incl_tax.text());
			//					System.out.println(Tax.text());
			//					System.out.println(Availability.text());
			//					System.out.println(Number_of_reviews.text());
			//
			//				}
			//			}
		}

	}
}
