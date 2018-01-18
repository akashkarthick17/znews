package io.zilker.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import io.zilker.bean.Item;
import io.zilker.bean.NewsChannel;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("servlet controller");

		List<Item> itemsList = new ArrayList<>();
		Item itemBean;
		NewsChannel newsChannel;

		String str = "";

		URL u;
		InputStream is = null;
		String s;

		u = new URL("https://news.google.com/news/rss/?ned=in&gl=IN&hl=en-IN");

		is = u.openStream();

		BufferedReader bb = new BufferedReader(new InputStreamReader(is));

		while ((s = bb.readLine()) != null) {

			str += s;

		}

		try {
			JSONObject xmlJSONObj = XML.toJSONObject(str);

			JSONObject rss = (JSONObject) xmlJSONObj.get("rss");

			JSONObject channel = (JSONObject) rss.get("channel");

			JSONArray item = (JSONArray) channel.get("item");
			
			System.out.println("item Length: "+item.length());
			
			

			for (int i = 0; i < item.length(); i++) {

				itemBean = new Item();

				JSONObject getItem = (JSONObject) item.get(i);
				
				System.out.println("get Item : "+i+" "+getItem);

				String title = (String) getItem.get("title");
				String link = (String) getItem.get("link");
				String category = (String) getItem.get("category");
				String description = (String) getItem.get("description");
				String pubDate = (String) getItem.get("pubDate");

				String html = description;

				org.jsoup.nodes.Document doc = Jsoup.parse(html);

				org.jsoup.nodes.Element imageLinkTag = doc.select("img").first();

				if (imageLinkTag != null) {

					String imageLink = imageLinkTag.attr("src");

					itemBean.setTitle(title);
					itemBean.setCategory(category);
					itemBean.setImageLink(imageLink);
					itemBean.setLink(link);
					itemBean.setPubDate(pubDate);

					List<org.jsoup.nodes.Element> newsChannelList = doc.select("li");

					System.out.println(title);
					System.out.println(imageLink);
					System.out.println(category);
					
					itemsList.add(itemBean);
/*
					for (int j = 0; j < newsChannelList.size(); j++) {

						newsChannel = new NewsChannel();

						org.jsoup.nodes.Element newChannel = newsChannelList.get(j).select("a").first();
						org.jsoup.nodes.Element newChannelname = newsChannelList.get(j).select("font").first();
						String newsLink = newChannel.attr("href");
						String newsTitle = newChannel.text();
						String channelName = newChannelname.text();

//						System.out.println(newsLink);
//						System.out.println(newsTitle);
//						System.out.println(channelName);

						newsChannel.setChannelName(channelName);
						newsChannel.setNewsLink(newsLink);
						newsChannel.setNewsTitle(newsTitle);

						itemBean.setNewsChannel(newsChannel);

//						System.out.print("-----------------------------------------------------------------");
//						System.out.println();

						itemsList.add(itemBean);

					}

//					System.out.print("****************************************************************");
//					System.out.println();
 * 
 *
 */

				}

			}

		} catch (JSONException je) {
			System.out.println(je.toString());
		}
		
		
		 request.setAttribute("Items", itemsList);
		
		 RequestDispatcher rd=request.getRequestDispatcher("/news.jsp");  
		 rd.forward(request, response); 

	}

}
