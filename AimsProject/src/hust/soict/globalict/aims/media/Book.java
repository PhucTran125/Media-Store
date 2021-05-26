package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;
public class Book extends Media{
	private String contentLength;
	private ArrayList<String> authors = new ArrayList<String>();
	private List<String> contentTokens;
	private TreeMap<String, Integer> wordFrequency;
	//Create constructor
	public Book(String title, String category, String contentLength, float cost) {
		super(title, category, cost);
		this.contentLength = contentLength;
//		processContent();
		System.out.println(contentLength);
	}

	// Method
	public void addAuthor (String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i) == authorName) {
				System.out.println("Threre is already author's name in the arraylist");
			}
			else {
				authors.set(authors.size(), authorName);
				System.out.println("Added successfully");
			}
		}
	}
	
	// Get detail
	public String getDetail() {
		StringTokenizer contLength = new StringTokenizer(getContentLength());
		String result = getId() + ".Book - [" + getTitle() + "] - [" + getCategory() + "] - [" + getContentLength() + "] - ["
					+ contLength.countTokens() + "]: [" + getCost() + "] $";
		result = result + "\nAll tokens in contentLength of book: ";
		for (Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
			result = result+  "\n[" + entry.getKey() + "]" + "->" + entry.getValue();
		}
		return result;
	}
	
	public void removeAuthor (String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i) == authorName) {
				authors.remove(i);
				System.out.println("Removed successfully");
			}
			else System.out.println("There is no name in arraylist");
		}
	}
	
	public String getContentLength() {
		return contentLength;
	}
//	need  to check
//	public void processContent() {
//		String[] arr = contentLength.split(" ");
//		for (String item: arr) {
//			contentTokens.add(item);
//		}
//		contentTokens.stream().sorted().collect(Collectors.toList());
//		for (int i = 0; i < contentTokens.size(); i++) {
//			String tmp = contentTokens.get(i);
//			int count = 0;
//			for (String item: contentTokens) {
//				if (item.equals(tmp)) count++;
//			}
//			wordFrequency.put(tmp, count);
//		}
//	}
}
