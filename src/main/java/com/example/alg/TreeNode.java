package com.example.alg;

import java.util.List;

public class TreeNode<K, Item> {
	String key;
	int order;
	String parent;
	List<TreeNode> children;

	public void add(TreeNode node) {
		children.add(node);
	}

	public TreeNode() {
		this.key = key;
		this.parent = parent;
		this.order = order;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

}
