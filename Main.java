// Demo Class
public class Main {
    public static void main(String[] args) {
	DeLinkedList<Integer> testList = new DeLinkedList<>();
	for (int i = 0; i < 10; i++) {
	    testList.add(i);
	}
	
	testList.add(10, 127);
	System.out.println(testList);
    }
}
