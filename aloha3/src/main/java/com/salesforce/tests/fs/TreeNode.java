package com.salesforce.tests.fs;

import java.util.TreeMap;

public class TreeNode {
	
	TreeMap<String, TreeNode> directories;
	TreeNode parent;
	String name;
	
	public TreeNode(TreeNode parent, String name) {
		this.name = name;
		this.parent = parent;
		directories = new TreeMap<String, TreeNode>(); //create sub-directory node
	}
}
