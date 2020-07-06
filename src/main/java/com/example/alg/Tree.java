package com.example.alg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
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
		LinkedList<TreeNode> result = new LinkedList<TreeNode>();
		LinkedList<TreeNode> f = toSort(root,result,0);
		String string = mapper.writeValueAsString(bulid(f, "0"));
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
	
	/**
	 * 
	 * @Description: 排序
	 * @param list
	 * @param result
	 * @param father
	 * @return
	 * LinkedList<TreeNode>
	 */
	private static LinkedList<TreeNode> toSort(List<TreeNode> list,
			LinkedList<TreeNode> result, int father) {
		List<TreeNode> temp = new ArrayList<TreeNode>();
		// 最高层,临时存放
		for (int i = 0; i < list.size(); i++) {
			int par = Integer.parseInt(list.get(i).getParent());
			if (par == father) {
				temp.add(list.get(i));
			}
		}
 
		if (temp.size() < 1) {
			return result;
		} else { 
			// 删除最高层
			for (int j = 0; j < list.size(); j++) {
				int part = Integer.parseInt(list.get(j).getParent());
				if (part == father) {
					list.remove(j);
				}
			}
			// 对最高层排序
			for (int i = 0; i < temp.size() - 1; i++) {
				for (int j = i + 1; j < temp.size(); j++) {
					if (temp.get(i).getOrder() > temp.get(j).getOrder()) {
						TreeNode myTestTree = temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j, myTestTree);
					}
				}
			}
			// 递归
			for (int i = 0; i < temp.size(); i++) {
				result.add(temp.get(i));
				int keys = Integer.parseInt(temp.get(i).getKey());
				toSort(list, result, keys);
			}
			return result;
		}
 
	}
}
