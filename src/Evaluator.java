import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Evaluator {
	private ArrayList<String> ignoreNames; // UL에 들어가지 않을 names
	private ArrayList<String> articles; // 조사, 관사 등 문법적 어구
	private ArrayList<String> UL;  // Ubiquitous Language
	private ArrayList<String> applyingClasses;
	private String[] jsoupClasses = {"CharacterReader", "HtmlTreeBuilder", "Parser", "Tag", "TokenQueue"};
	private String[] csvClasses = {"CSVFormat", "CSVParser", "CSVPrinter", "CSVRecord"};
	private String[][] apis = {jsoupClasses, csvClasses};
	
	public Evaluator(String address, int whichClass) {
		ignoreNames = new ArrayList<>();
		articles = new ArrayList<>();
		UL = new ArrayList<>();
		applyingClasses = new ArrayList<>();
		if (whichClass == 0) { // jsoup
			Collections.addAll(applyingClasses, jsoupClasses);
		} else { // csv
			Collections.addAll(applyingClasses, csvClasses);
		}
		initIgnoreNames();
		initArticles();
		
		printFileList(address);
		System.out.println("ApplyingClasses: " + applyingClasses.stream().toString());
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
	
	private float IRI(int intendedMethodNames, int intendedParameterNames, int numberOfMethodNames, int numberOfParameterNames) {
		return (intendedMethodNames + intendedParameterNames + 1) 
				/ (numberOfMethodNames + numberOfParameterNames + 1);
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
	
	private void evaluateIRI(String className, float IRI) {
		System.out.println("class " + className + "'s evaluated IRI value(v): " + IRI);
	}
}
