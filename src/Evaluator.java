import java.io.File;
import java.util.ArrayList;

public class Evaluator {
	private ArrayList<String> ignoreFileNames;
	private ArrayList<String> UL;  // Ubiquitous Language
	private ArrayList<String> csvApplyingList;
	private ArrayList<String> jsoupApplyingList;
	
	public Evaluator(String address) {
		ignoreFileNames = new ArrayList<>();
		UL = new ArrayList<>();
		csvApplyingList = new ArrayList<>();
		jsoupApplyingList = new ArrayList<>();
		
		for (File s: new File(address).listFiles()) {
			if (s.isDirectory() && s.getName().compareTo(".settings") != 0 || s.getName().compareTo("bin") != 0 || s.getName().compareTo("src") != 0) System.out.println(s.getName());
		}
	}
	
	public void addClassName(String className) {
		
	}
	
	public void addDescriptionVocabulary(String vocabulary) {
		
	}
}
