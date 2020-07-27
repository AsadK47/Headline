import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        retrieveBbcNews();
    }

    private static void retrieveBbcNews() throws IOException {
        String bbcWebsite = "https://www.bbc.co.uk";
        String bbcNews = "https://www.bbc.co.uk/news";
        String bbcHeadlineLinkClass = "gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor";
        String bbcNewsHeadlineClass = "gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text";

        Document document = Jsoup.connect(bbcNews).get();

        Element elementsForHeadlineLink = document.getElementsByClass(bbcHeadlineLinkClass).get(0);
        Element elementsForHeadline = document.getElementsByClass(bbcNewsHeadlineClass).get(0);

        String headlineArticleLink = bbcWebsite + elementsForHeadlineLink.attr("href");
        System.out.println(headlineArticleLink);

        String headlineArticleName = elementsForHeadline.attr("h3");

        System.out.println();
    }

}
