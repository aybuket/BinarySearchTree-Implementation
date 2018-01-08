import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class project1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd=new BufferedReader (new FileReader("database.txt"));
		BST nameTree = new BST(null);
		BST surnameTree = new BST(null);
		BST phoneTree = new BST(null);
		String name=null;
		String surname=null;
		String number=null;
		while(true){
			String line=rd.readLine();
			if (line==null) break;
			StringTokenizer tokenizer=new StringTokenizer(line);
			name=tokenizer.nextToken();
			surname=tokenizer.nextToken();
			number=tokenizer.nextToken();
			nameTree.insert(name,surname,number,1);
			surnameTree.insert(name,surname,number,2);
			phoneTree.insert(name,surname, number,3);
		}
		rd.close();
		System.out.println("Name Tree:");
		nameTree.inOrder(nameTree.root());
		System.out.println("\n");
		System.out.println("Surname Tree:");
		surnameTree.inOrder(surnameTree.root());
		System.out.println("\n");
		System.out.println("Phone Tree:");
		phoneTree.inOrder(phoneTree.root());
		System.out.println("\n");
		BufferedReader rd2=new BufferedReader (new FileReader("query.txt"));
		while(true){
			String line=rd2.readLine();
			if (line==null) break;
			StringTokenizer tokenizer=new StringTokenizer(line);
			String token=tokenizer.nextToken();
			name=tokenizer.nextToken();
			surname=tokenizer.nextToken();
			number=tokenizer.nextToken();
			if (token.equalsIgnoreCase("insert")){
				nameTree.insert(name,surname,number,1);
				surnameTree.insert(name,surname,number,2);
				phoneTree.insert(name,surname,number,3);
			}else{
				nameTree.delete(name,surname,number,1);
				surnameTree.delete(name,surname,number,2);
				phoneTree.delete(name,surname,number,3);
			}
		}
		rd2.close();
		System.out.println("After inserting and deleting some nodes from the tree:\n");
		System.out.println("Name Tree:");
		nameTree.inOrder(nameTree.root());
		System.out.println("\n");
		System.out.println("Surname Tree:");
		surnameTree.inOrder(surnameTree.root());
		System.out.println("\n");
		System.out.println("Phone Tree:");
		phoneTree.inOrder(phoneTree.root());
		System.out.println("\n");
	}

}
