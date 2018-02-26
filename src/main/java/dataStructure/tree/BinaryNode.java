package dataStructure.tree;

public class BinaryNode {
    String element;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(String element) {
        this.element = element;
    }

    public BinaryNode(String element, BinaryNode left, BinaryNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
