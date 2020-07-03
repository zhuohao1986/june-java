package com.example.alg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO add Code

public class Tree<K, Item> {
	List<TreeNode> root = new ArrayList<TreeNode>();

	public List<TreeNode> getRoot() {
		return root;
	}

	public void setRoot(Optional<TreeNode> treeNode) {
		root.add(treeNode.get());
	}

	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String string = mapper.writeValueAsString(bulid(root, ""));
		return string;
	}

	public <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {

		List<T> trees = new ArrayList<>();

		for (T treeNode : treeNodes) {

			if (root.equals(treeNode.getParent())) {
				trees.add(treeNode);
			}

			for (T it : treeNodes) {
				if (it.getParent() == treeNode.getKey()) {
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<>());
					}
					treeNode.add(it);
				}
			}
		}
		return trees;
	}
}
