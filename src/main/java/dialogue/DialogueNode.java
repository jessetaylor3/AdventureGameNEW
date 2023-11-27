package dialogue;
import java.util.Map;

public class DialogueNode {
	private String text;
	private Map<String, String> choices; //Maps choice text to node ID
	private String nextNode; //ID of the next node if no choice to be made
	private boolean isEnd; //Indicates this is an ending node
	
	//Node Constructor
	public DialogueNode(String text, Map<String, String> choices, String nextNode, boolean isEnd) {
		this.text = text;
		this.choices = choices;
		this.nextNode = nextNode;
		this.isEnd = isEnd;
	}
	
	//Getters and setters
	public String getText() {
		return text;
	}
	
	public Map<String, String> getChoices(){
		return choices;
	}
	
	public String getNextNode() {
		return nextNode;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
}
