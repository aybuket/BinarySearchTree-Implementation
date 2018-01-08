
public class Node {

	public Node parent=null;
	public Node leftChild=null;
	public Node rightChild=null;
	public String nodeName=null;
	public String nodeSurname=null;
	public String nodePhone=null;

	public Node(String name, String surname, String phonenumber) {
		nodeName=name;
		nodeSurname=surname;
		nodePhone=phonenumber;
		// TODO Auto-generated constructor stub
	}
	public String getName(){
		return nodeName;
	}
	public void setName(String newname){
		nodeName=newname;
	}
	public void setSurname(String newsurname){
		nodeSurname=newsurname;
	}
	public void setPhone(String newnumber){
		nodePhone=newnumber;
	}
	public String getSurname(){
		return nodeSurname;
	}
	public String getPhone(){
		return nodePhone;
	}
	public boolean has2Children(){
		if(this.hasRight() && this.hasLeft()){
			return true;
		}else{
			return false;
		}
	}
	public boolean hasRight(){
		if(rightChild==null){
			return false;
		}else{
			return true;
		}
	}
	public boolean hasLeft(){
		if(leftChild==null){
			return false;
		}else{
			return true;
		}
	}

	public Node parent() {
		return parent;
	}

	public boolean isLeftChild() {
		boolean result = false;
		if (parent.hasLeft()){
			if (this.equals(parent.leftChild())){
				result=true;
			}
		}
		return result;
	}

	public Node leftChild() {
		return leftChild;
	}

	public boolean isRightChild() {
		boolean result = false;
		if (parent.hasRight()){
			if (this.equals(parent.rightChild())){
				result=true;
			}
		}
		return result;
	}

	public Node rightChild() {
		return rightChild;
	}

	public void setLeft(Node left){
		leftChild=left;
	}

	public void setRight(Node right){
		rightChild=right;
	}

	public void setParent(Node parentofchild){
		parent=parentofchild;
	}
	public void deleteNode(){
		this.setParent(null);
		this.setRight(null);
		this.setLeft(null);
	}

	@SuppressWarnings("null")
	public int position(){
		if (parent==null){
			return 1;
		}else if (this.isLeftChild()){
			return 2*(parent.position());
		}else if (this.isRightChild()){
			return 2*(parent.position())+1;
		}else{
			return (Integer) null;
		}
	}


}
