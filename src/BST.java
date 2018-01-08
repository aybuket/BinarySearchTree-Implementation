
public class BST {
	public BST(Node rootofnood) {
		root=rootofnood;
	}

	public Node root=null;
	public int numberofNodes=0;

	public Node root(){
		return root;
	}


	public void insert(String name, String surname, String number, int sortingNumber){
		Node insertingNode=new Node(name,surname,number);
		String sortingData=null;
		String sortingTreeData=null;
		Node currentNode=this.root();
		if (numberofNodes==0){
			root=insertingNode;
		}else{

			while (true){
				if (sortingNumber==1){
					sortingData=name;
					sortingTreeData=currentNode.getName();
				}else if (sortingNumber==2){
					sortingData=surname;
					sortingTreeData=currentNode.getSurname();
				}else{
					sortingData=number;
					sortingTreeData=currentNode.getPhone();
				}
				int c=0;
				while(sortingTreeData.charAt(c)==sortingData.charAt(c)){
					c++;
				}
				if (sortingTreeData.charAt(c)<sortingData.charAt(c)){
					if(currentNode.rightChild()==null){
						currentNode.setRight(insertingNode);
						insertingNode.setParent(currentNode);
						break;
					}else{
						currentNode=currentNode.rightChild();
					}

				}else{
					if(currentNode.leftChild()==null){
						currentNode.setLeft(insertingNode);
						insertingNode.setParent(currentNode);
						break;
					}else{
						currentNode=currentNode.leftChild();
					}
				}
			}
		}
		numberofNodes++;

	}
	public void inOrder(Node root){
		if (root.leftChild()!=null){
			inOrder(root.leftChild());
		}
		System.out.println("Name: "+root.getName().toString()+" Surname: "+root.getSurname()+" Phone: "+root.getPhone()+" Array ID: "+root.position());
		if (root.rightChild()!=null){
			inOrder(root.rightChild());
		}
	}
	public void delete(String name, String surname, String number, int sortingNumber){
		String sortingData=null;
		String sortingTreeData=null;
		Node currentNode=this.root();
		if (numberofNodes==0){
			System.out.println("There is no element to delete.");
		}else{
			while(true){
				if (sortingNumber==1){
					sortingData=name;
					sortingTreeData=currentNode.getName();
				}else if (sortingNumber==2){
					sortingData=surname;
					sortingTreeData=currentNode.getSurname();
				}else{
					sortingData=number;
					sortingTreeData=currentNode.getPhone();
				}
				if (sortingTreeData.equalsIgnoreCase(sortingData)){
					if (currentNode.has2Children()){
						Node swapping=currentNode.leftChild();
						while(swapping.hasRight()){
							swapping=swapping.rightChild();
						}
						swapping.setRight(currentNode.rightChild());
						currentNode.rightChild().setParent(swapping);
						if(currentNode.isRightChild()){
							currentNode.parent().setRight(swapping);
						}else{
							currentNode.parent().setLeft(swapping);
						}
						if(swapping.isRightChild()){
							swapping.parent().setRight(null);
							if(swapping.hasLeft()){
								Node left=swapping.leftChild();
								while(left.hasLeft()){
									left=swapping.leftChild();
								}
								left.setLeft(currentNode.leftChild());
								currentNode.leftChild().setParent(left);
							}
						}else{
							swapping.parent().setLeft(null);
							
						}
						swapping.setParent(currentNode.parent());

						currentNode.deleteNode();
					}else if(currentNode.hasRight()){
						if(currentNode.isRightChild()){
							currentNode.parent().setRight(currentNode.rightChild());
							currentNode.rightChild().setParent(currentNode.parent());
						}else{
							currentNode.parent().setLeft(currentNode.rightChild());
							currentNode.rightChild().setParent(currentNode.parent());
						}
					}else if(currentNode.hasLeft()){
						if(currentNode.isRightChild()){
							currentNode.parent().setRight(currentNode.leftChild());
							currentNode.leftChild().setParent(currentNode.parent());
						}else{
							currentNode.parent().setLeft(currentNode.leftChild());
							currentNode.leftChild().setParent(currentNode.parent());
						}
					}
					currentNode.deleteNode();
					break;
				}else{
					int c=0;
					while(sortingTreeData.charAt(c)==sortingData.charAt(c)){
						c++;
					}
					if (sortingTreeData.charAt(c)<sortingData.charAt(c)){
						currentNode=currentNode.rightChild();
					}else{
						currentNode=currentNode.leftChild();
					}
				}
			}
		}
		numberofNodes--;

	}


}
