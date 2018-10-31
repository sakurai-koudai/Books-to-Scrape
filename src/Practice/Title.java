package Practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Title {
	public static void main(String[] args) throws IOException {

//		Animal animal = new Animal();
//		animal.makeSound();
//
//		Dog dog = new Dog();
//		dog.makeSound();

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
				Element element = doc.selectFirst("#default > div > div > div > div > form > strong:nth-child(2)");
				String text = element.text();
				int pages = Integer.parseInt(text);
				int page_num = pages / 20;
				for (int j = 1; j <= page_num; j++) {
					String temp = String.format("http://books.toscrape.com/catalogue/page-%d.html", j);
					urlList.add(temp);
				}

			} else if(url.contains("catalogue/page"))

			 {
				Elements titles = doc.select(
						"#default > div > div > div > div > section > div:nth-child(2) > ol > li> article > h3 > a");
				for (Element title : titles) {

					System.out.println(title.text());

				}
			}
		}





	}
}

//class Animal{
//	public void makeSound() {
//		System.out.println("...");
//	}
//}
//
//class Dog extends Animal{
//
//	public void makeSound() {
//		System.out.println("WANG WANG");
//	}
//}
//
//class Cat extends Animal{
//
//	public void makeSound() {
//		System.out.println("\meow mwow");
//	}
//}
//
//
//class Human{
//	public void eat(String food) {
//		//EAT
//	}
//
//	public void eat(String food, String type) {
//
//	}
//
//	public static void main() {
//		eat("RAMEN");
//		eat("RAMEN", "LUNCH");
//	}
//}
