package com.salesforce.tests.fs;

import java.util.List;

public class DoublyLinkedImpl {
	
	public TreeNode currDirectory;


    public DoublyLinkedImpl(){
        currDirectory = new TreeNode(null, "root");
    }

    public void getDir(List<String> answer){
        StringBuilder compact = new StringBuilder();
        StringBuilder open = new StringBuilder();

        /* Iterate TreeMap append key values*/
        currDirectory.directories.forEach((key,value) -> {
        	open.append(key + "    ");
        });
        
        TreeNode temp = currDirectory;
        
        /* if directory has parent directory*/
        
        while(temp.parent!=null){
            compact.insert(0, "\\"+temp.name);
            temp = temp.parent;
        }

        if(open.length() < 1 ) open.append("No subdirectories ");
        answer.add("Directory of root" + compact.toString()  + ": ");
        answer.add(open + " ");
        //System.out.println("Directory of root" + compact.toString()  + ": ");
        //System.out.println(open + " ");
    }

    /*
      when up command comes
     */
    public void goUp(List<String> answer){
        if(currDirectory.parent!=null) {
            currDirectory = currDirectory.parent;
        }else{
        	answer.add("Cannot move up from root directory");
                //System.out.println("Cannot move up from root directory");
           
        }
    }

    /*
      Create a child node under current Node. When sub-directory name not present then add to child node
     */
    public void createDir(String name,List<String> answer){
        TreeNode child = new TreeNode(currDirectory, name);
        if(!currDirectory.directories.containsKey(child.name)) {
        	currDirectory.directories.put(child.name, child);
        }else {
        	answer.add("Subdirectory already exists");
        	//System.out.println("Subdirectory already exists");
        }
        
        
    }

    /*
      Gets the desired folder 
     
     */
    public void cd(String name){
        if( currDirectory.directories!=null && currDirectory.directories.get(name)!=null)
            currDirectory = (TreeNode) currDirectory.directories.get(name);
    }


}
