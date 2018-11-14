package space.harbour.java.hw6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider implements Runnable
{
    final int maxThreads= 10;
    final String urlRegex = "((https?):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
    private Set<String> visited;
    private List<URL> pagesToVisit = new LinkedList<URL>();
    private ExecutorService executor;


    public void run()
    {
        while (!pagesToVisit.isEmpty())
        {
            crawl();
        }
    }
    public void crawl()
    {

        URL visit = pagesToVisit.get(0);
        pagesToVisit.remove(0);
        synchronized (visited)
        {
            visited.add(visit.toString());
        }
        String content = getContentOfWebPage(visit);
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(content);

        while (urlMatcher.find())
        {
            String Found = content.substring(urlMatcher.start(0), urlMatcher.end(0));
            try
            {
                synchronized (visited)
                {
                    if (!visited.contains(Found)) {
                        pagesToVisit.add(new URL(Found));
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static String getContentOfWebPage(URL url)
    {
        final StringBuilder content = new StringBuilder();
        try (InputStream is = url.openConnection().getInputStream();
             InputStreamReader in = new InputStreamReader(is, "UTF-8");
             BufferedReader br = new BufferedReader(in);)
        {
            String inputLine;
            while ((inputLine = br.readLine()) != null)
                content.append(inputLine);
        } catch (IOException e)
        {
            System.out.println("Failed to retrieve content of " + url.toString());
            e.printStackTrace();
        }

        return content.toString();
    }
    public void setQueue(List<URL> queue)
    {
        pagesToVisit = queue;
    }
    public void runParser() {
        for(int i = 0; i < 10; i ++) {
            executor.submit(this);
        }

        executor.shutdown();
    }

    public Set<String> getVisited() {
        synchronized (visited) {
            return visited;
        }
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}





