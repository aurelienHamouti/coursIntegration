package metier;

public class Action {
  
	public static final int LOAD = 1, SEL = 2, ADD = 3, UPD = 4, DEL = 5;
  
	private int action;   /* L'action: une des valeurs ci-dessus */
	private int pos = -1; /* La position concernée */
  
	public Action(int action) { this.action = action; }
	public Action(int action, int pos) { this(action); this.pos = pos; }
  
	public int getAction() { return action; }
	public int getPos() { return pos; }
}