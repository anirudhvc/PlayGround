import java.util.ArrayList;
import java.util.List;

public class Notes {
	List<Lines> lines;
	
	
	
    public Notes() {
		super();
		this.lines = new ArrayList<>();
	}
	Lines getLine(int i) {
    	return lines.get(i);
    }
    List<Lines> getLines(int i,int j){
    	return null;
    }
    void setLine(Lines lines,int index)
    {
    	if(index>this.lines.size())
    		this.lines.add(lines);
    	else
    		this.lines.set(index, lines);
    }
    void setLines(List<Lines> lines) {
    	
    }
    void updateLines(List<Lines> lines,int i, int j) {
    	
    }
    
    void removeLines(int i, int j) {
    	List<Lines>newLines = new ArrayList<>();
    	
    	for(int k=0;k<lines.size();k++) {
    		if(k<i || k>j)
    			newLines.add(this.lines.get(k));
    	}
    	this.lines = newLines;
    }
    
    void addLine(Lines line) {
    	this.lines.add(line);
    }
    
    void printLines() {
    	for(Lines l: this.lines) {
    		System.out.println(l.text);
    	}
    }
}
