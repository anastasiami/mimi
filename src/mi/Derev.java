package mi;
public class Derev {
	  int amount;
	  char elem;
	  Derev lch;
	  Derev rch;
	  Derev(int value, char ch){
	    this.amount = value;
	    this.elem = ch;
	  }
	  public void left(Derev node) {
	    this.lch = node;
	  }
	  public void right(Derev node) {
	    this.rch = node;
	  }
	}