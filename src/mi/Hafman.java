package mi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hafman {

  public static void main(String[] args) {
    Scanner enter = new Scanner(System.in);
    String text = enter.nextLine();
    List<Derev> list = new ArrayList<Derev>();
    for(int i = 0; i < text.length(); i++) {
      final char ch = text.charAt(i);
      if(has(list, ch)) {
        for(int j = 0; j < list.size(); j++) {
          if(list.get(j).elem == ch) {
            list.get(j).amount++;
          }
         
        }
      }else {
        list.add(new Derev(1, ch));
      }
    }
    while(list.size()>1) {
      list = sort(list);
      Derev s = list.get(1);
      Derev f = list.get(0);
      list.remove(0);
      list.remove(0);
      Derev n = new Derev(f.amount+s.amount, '%');
      n.left(f);
      n.right(s);
      list.add(0, n);
    }
    Derev root = list.get(0);
    deep(root, "");
    enter.close();
      }
  public static List<Derev> sort(List<Derev> l) {
    for(int i = 0; i < l.size(); i++) {
      for(int j = 0; j < l.size()-1; j++) {
        if(l.get(j).amount > l.get(j+1).amount) {
          Derev node = l.get(j);
          l.set(j, l.get(j+1));
          l.set(j+1, node);
        }
      }
    }
    return l;
  }
  public static boolean has(List<Derev> l, char c) {
    for(int i = 0; i < l.size(); i++) {
      if(l.get(i).elem == c)
        return true;
    }
    return false;
  }
  public static void deep(Derev el, String res) {
    if(el.lch != null) {
      deep(el.lch, res+"0");
    }
    if(el.lch == null && el.rch == null) {
      System.out.println("\""+el.elem + "\" " + res);
      return;
    }
    if(el.rch != null) {
      deep(el.rch, res+"1");
    }
  }

}