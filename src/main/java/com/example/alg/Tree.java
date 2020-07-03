package com.example.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		String string = mapper.writeValueAsString(root);
		return string;
	}
}
