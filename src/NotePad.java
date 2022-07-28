import java.util.Scanner;

public class NotePad {
	public static void main(String[] args) {

		NotePadInventory notePadInv = new NotePadInventory();
		NotePadService notePadService = new NotePadService(notePadInv);
		Lines line = new Lines("Test line");
		Notes note = new Notes();
		note.addLine(line);

		notePadInv.notes.put("TestNote", note);
		int operation = -1;
		Scanner s = new Scanner(System.in);
		String demo = "TestNote";
		while (operation != 4) {
			operation = s.nextInt();
			switch (operation) {
			case 1:
				notePadService.display(demo);
				break;
			case 2:
				
				notePadService.writeLine(demo,"Test2",0);
				break;
			case 3:
				notePadService.undo(demo);
				break;
			default:
				break;

			}
		}
	}
}
