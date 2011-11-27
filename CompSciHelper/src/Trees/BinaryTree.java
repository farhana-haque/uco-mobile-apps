package Trees;

import android.graphics.Canvas;
import android.graphics.Paint;

import Shapes.Line;

public class BinaryTree {
	Node root;
	Line line;
	

	// ArrayList<Circle> list = null;
	public BinaryTree(Node c) {
		root = c;
	}

	public void addChild(Node CurrentNode, Node NewNode) {
		if (CurrentNode.getNumber() >= NewNode.getNumber()) {
			if (CurrentNode.getLeftChild() == null) {
				CurrentNode.setLeftChild(NewNode);
				NewNode.setX(CurrentNode.getX() - 150);
				NewNode.setY(CurrentNode.getY() + 200);
				CurrentNode.setLeftLine(new Line(CurrentNode.getX(),
						CurrentNode.getBottom(), NewNode.getX(), NewNode
								.getTop()));
			}
			else
				addChild(CurrentNode.getLeftChild(), NewNode);

		}
		if (CurrentNode.getNumber() < NewNode.getNumber()) {
			if (CurrentNode.getRightChild() == null) {
				CurrentNode.setRightChild(NewNode);
				NewNode.setX(CurrentNode.getX() + 150);
				NewNode.setY(CurrentNode.getY() + 200);
				CurrentNode.setRightLine(new Line(CurrentNode.getX(),
						CurrentNode.getBottom(), NewNode.getX(), NewNode
								.getTop()));
			}
			else
				addChild(CurrentNode.getRightChild(), NewNode);

		}
	}

	public Node getRoot() {
		return root;
	}

	/*
	 * public void resetList(){ list.clear(); }
	 */
	public void TraverseMove(Node node, float moveX, float moveY) {
		if (node.getLeftChild() != null) {
			TraverseMove(node.getLeftChild(), moveX, moveY);
			node.getLeftLine().moveLine(moveX, moveY);
		}
		if (node.getRightChild() != null) {
			TraverseMove(node.getRightChild(), moveX, moveY);
			node.getRightLine().moveLine(moveX, moveY);
		}
		node.setX(node.getX() + moveX);
		node.setY(node.getY() + moveY);
	}

	public void TraverseDraw(Node node, Canvas c, Paint p) {
		if (node.getLeftChild() != null)
			TraverseDraw(node.getLeftChild(), c, p);
		if (node.getRightChild() != null)
			TraverseDraw(node.getRightChild(), c, p);
		node.Draw(c, p);

		// TODO write traverse algo
	}
}