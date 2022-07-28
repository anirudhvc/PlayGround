import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NotePadService {
	
	 	Map<String,Stack<Operations>>undoperations;
	    Map<String,Stack<Operations>>redoperations;
	    NotePadInventory inventory;
	      
	    public NotePadService(NotePadInventory inventory) {
			super();
			this.inventory = inventory;
			this.undoperations = new HashMap<>();
			this.redoperations = new HashMap<>();
		}
	    
	    void updateUndoStack(String noteName, Operations operation) {
	    	if(this.undoperations.get(noteName) == null)
				this.undoperations.put(noteName, new Stack<>());
			this.undoperations.get(noteName).push(operation);
	    }
	    
		void writeLine(String noteName, String text, int lineNumber) {
			Notes note = this.inventory.notes.get(noteName);
			Lines line= new Lines(text);
			note.setLine(line, lineNumber);
			List<Lines>lines = new ArrayList<Lines>();
			lines.add(line);
			Operations operation = new Operations(lines,lineNumber,-1,OperationType.WRITE);
			updateUndoStack(noteName, operation);
				
	    }
		
	    void deleteLine(String noteName, int lineStart, int lineEnd) {
	    	Notes note = this.inventory.notes.get(noteName);
	    	note.removeLines(lineStart, lineEnd);
	    	Operations operation = new Operations(note.lines,lineStart,lineEnd,OperationType.DELETE);
	    	updateUndoStack(noteName, operation);
	    }
	    void copyLine(String noteName, int lineStart, int lineEnd) {
	    	
	    }
	    void display(String noteName) {
	    	Notes note = this.inventory.notes.get(noteName);
	    	note.printLines();
	    	Operations operation = new Operations(note.lines,-1,-1,OperationType.PRINT);
	    	updateUndoStack(noteName, operation);
	    }
	    void undo(String noteName) {
	    	Operations operation = this.undoperations.get(noteName).peek();
	    	
	    	if(operation.type == OperationType.PRINT)
	    		System.out.println("Cant undo print");
	    	if(operation.type == OperationType.WRITE) {
	    		this.undoperations.get(noteName).pop();
	    		int lineNumber = operation.startLine;
	    		Lines line = operation.lines.get(0);
	    		Notes note = this.inventory.notes.get(noteName);
	    		note.setLine(line, lineNumber);
	    		this.inventory.notes.put(noteName, note);
	    	}
	    	
	    }
	    void redo(String noteName) {
	    	
	    }
}
