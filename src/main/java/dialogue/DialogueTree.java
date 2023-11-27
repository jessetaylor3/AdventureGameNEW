package dialogue;
import java.util.HashMap;
import java.util.Map;

public class DialogueTree {
	private Map<String, DialogueNode> nodes; //Maps node IDs to DialogueNode object
	private String startNodeId; //ID of the starting node
	
	public DialogueTree() {
		this.nodes = new HashMap<>();
	}
	
	public void setStartNodeId(String startNodeId) {
		this.startNodeId = startNodeId;
	}
	
	public void addNode(String nodeId, DialogueNode node) {
		nodes.put(nodeId, node);
	}
	
	public DialogueNode getNode(String nodeId) {
		return nodes.get(nodeId);
	}
	
	public String getStartNodeId() {
		return startNodeId;
	}

}
