package com.example.alg;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class TreeTests {

	@Test
	void test_tree_01() throws JsonProcessingException {
		TreeNode treeNode1 = new TreeNode<String, Integer>();
		treeNode1.setKey("1");
		treeNode1.setOrder(1);
		treeNode1.setParent("0");
		
		TreeNode treeNode2 = new TreeNode<String, Integer>();
		treeNode2.setKey("2");
		treeNode2.setOrder(6);
		treeNode2.setParent("0");
		
		TreeNode treeNode3 = new TreeNode<String, Integer>();
		treeNode3.setKey("3");
		treeNode3.setOrder(10);
		treeNode3.setParent("0");
		
		TreeNode treeNode4 = new TreeNode<String, Integer>();
		treeNode4.setKey("4");
		treeNode4.setOrder(4);
		treeNode4.setParent("0");
		
		TreeNode treeNode5 = new TreeNode<String, Integer>();
		treeNode5.setKey("5");
		treeNode5.setOrder(3);
		treeNode5.setParent("0");
		
		Tree tree = new Tree<String, TreeNode>();
		tree.setRoot(Optional.ofNullable(treeNode1));
		tree.setRoot(Optional.ofNullable(treeNode2));
		tree.setRoot(Optional.ofNullable(treeNode3));
		tree.setRoot(Optional.ofNullable(treeNode4));
		tree.setRoot(Optional.ofNullable(treeNode5));
		
		System.out.println(tree.toJson());
	}
	
	@Test
	void test_tree_02() throws JsonProcessingException {
		TreeNode treeNode1 = new TreeNode<String,Integer>();
	
		treeNode1.setKey("1");
		treeNode1.setOrder(1);
		treeNode1.setParent("0");
		
		TreeNode treeNode2 = new TreeNode<String, Integer>();
		treeNode2.setKey("2");
		treeNode2.setOrder(11);
		treeNode2.setParent("1");
		
		TreeNode treeNode3 = new TreeNode<String, Integer>();
		treeNode3.setKey("3");
		treeNode3.setOrder(10);
		treeNode3.setParent("1");
		
		TreeNode treeNode4 = new TreeNode<String, Integer>();
		treeNode4.setKey("4");
		treeNode4.setOrder(4);
		treeNode4.setParent("3");
		
		
		Tree tree = new Tree<String, TreeNode>();
		tree.setRoot(Optional.ofNullable(treeNode1));
		tree.setRoot(Optional.ofNullable(treeNode2));
		tree.setRoot(Optional.ofNullable(treeNode3));
		tree.setRoot(Optional.ofNullable(treeNode4));
		
		System.out.println(tree.toJson());
	}

}
