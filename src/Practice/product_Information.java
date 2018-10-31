package Practice;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class product_Information {
	public static void main(String[] args) throws IOException {

		String url = "http://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html";

		Document doc = Jsoup.connect(url).get();

		Elements UPC = doc.select("#content_inner > article > table > tbody > tr:nth-child(1) > td");
		Elements Product_Type = doc.select("#content_inner > article > table > tbody > tr:nth-child(2) > td");
		Elements Price_excl_tax = doc.select("#content_inner > article > table > tbody > tr:nth-child(3) > td");
		Elements Price_incl_tax = doc.select("#content_inner > article > table > tbody > tr:nth-child(4) > td");
		Elements Tax = doc.select("#content_inner > article > table > tbody > tr:nth-child(5) > td");
		Elements Availability = doc.select("#content_inner > article > table > tbody > tr:nth-child(6) > td");
		Elements Number_of_reviews = doc.select("#content_inner > article > table > tbody > tr:nth-child(7) > td");

		System.out.println(UPC.text());
		System.out.println(Product_Type.text());
		System.out.println(Price_excl_tax.text());
		System.out.println(Price_incl_tax.text());
		System.out.println(Tax.text());
		System.out.println(Availability.text());
		System.out.println(Number_of_reviews.text());

	}
}
