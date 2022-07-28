import java.util.List;

public class Operations {
	  	List<Lines>lines;
	    int startLine;
	    int endLine;
	    OperationType type;
	    
		public Operations(List<Lines> lines, int startLine, int endLine, OperationType type) {
			super();
			this.lines = lines;
			this.startLine = startLine;
			this.endLine = endLine;
			this.type = type;
		}
	    
}
