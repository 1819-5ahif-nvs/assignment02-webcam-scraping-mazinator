package at.htl.nvs;

import com.sun.jndi.toolkit.url.Uri;
import javafx.scene.media.VideoTrack;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import sun.rmi.runtime.Log;
import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main {
    public static String url = "https://webtv.feratel.com/webtv/?cam=5132";
    public static Logger logger = Logger.getLogger("MyLog");
    public static void main(String[] args) throws IOException, InterruptedException {
        FileHandler fh = new FileHandler("C:\\Users\\Daniel\\Desktop\\Schule\\5.Klasse\\NVS\\Stuetz\\Programme\\Git\\03.LinkWatcher\\assignment02-webcam-scraping-mazinator\\My_Log.log");
        logger.addHandler(fh);
        while(true){
            String vid = getVid();
            logger.info(vid);
            TimeUnit.SECONDS.sleep(10);
        }
    }

    public static String getVid() throws IOException {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .referrer("http://www.google.com")
                .get();
        Element element = doc.getElementById("fer_video");
        return element.select("source").first().attr("src");
    }
}
