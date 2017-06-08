import java.io.File;
import java.util.ArrayList;

public class Evaluator {
	private ArrayList<String> ignoreNames;
	private ArrayList<String> articles; 
	private ArrayList<String> UL;  // Ubiquitous Language
	private ArrayList<String> applyingList;
	
	public Evaluator(String address) {
		ignoreNames = new ArrayList<>();
		articles = new ArrayList<>();
		UL = new ArrayList<>();
		applyingList = new ArrayList<>();
		
		initIgnoreNames();
		initArticles();
		
		printFileList(address);
		
	}
	
	public void addClassNameToUL(String className) {
		
	}
	
	public void addDescriptionVocabularyToUl(String vocabulary) {
		
	}
	
	private void printFileList(String path){
		for (File s: new File(path).listFiles()) {
			if (!ignoreNames.contains(s.getName()))
				if (s.isDirectory()) {
					System.out.println("directory: " + s.getName().split(".java")[0] + "===========");
					printFileList(s.getAbsolutePath());
				}
				else 
					System.out.println(s.getName().split(".java")[0]);
		}
		System.out.println("-------------------");
	}
	
	private void initIgnoreNames() {
		ignoreNames.add(".settings");
		ignoreNames.add("bin");
		ignoreNames.add("src");
		ignoreNames.add(".git");
	}
	
	private void initArticles() {
		articles.add("to");
		articles.add("on");
		articles.add("at");
		articles.add("in");
		articles.add("from");
		articles.add("where");
		articles.add("on");
		articles.add("at");
		articles.add("a");
		articles.add("an");
	}
}
