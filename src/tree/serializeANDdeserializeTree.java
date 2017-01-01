package tree;

import java.util.*;

public class serializeANDdeserializeTree {
    // Encodes a tree to a singe string.  Level-order
    public String serialize_level_order(TreeNode root) {
    	if (root == null) return "";
    	
    	StringBuilder res = new StringBuilder();
    	Deque<TreeNode> q = new LinkedList<TreeNode>();
    	
    	q.add(root);    	
    	while(!q.isEmpty()) {
    		TreeNode t = q.remove();
    		if (t != null) {
    			q.offer(t.left);
    			q.offer(t.right);
    			res.append(String.valueOf(t.val)+',');
    		} else {
    			res.append("#"+',');    			
    		}
    	}
   	
    	res.deleteCharAt(res.length()-1); // last comma 
    	System.out.println(res.toString());
    	return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_level_order(String data) {
    	if (data == null || data.length() == 0) return null;
    	
    	String[] c = data.split(",");
    	TreeNode root = new TreeNode(Integer.parseInt(c[0]));
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	
    	q.offer(root);
    	int i = 1;
    	while (!q.isEmpty()) {
    		TreeNode t = q.poll();
    		
    		if (t == null) continue;
    		
    		//left first
    		if (!c[i].equals("#")) {
    	    	t.left = new TreeNode(Integer.parseInt(c[i]));
    	    	q.offer(t.left);
    		} else {
    			t.left = null;
    	    	q.offer(null);
    		}
    		
    		i++;  //right then  
    		if (!c[i].equals("#")) {
    	    	t.right = new TreeNode(Integer.parseInt(c[i]));
    	    	q.offer(t.right);
    		} else {
    			t.right = null;
    	    	q.offer(null);
    		}    		
    		i++;
    	}
    	
    	return root;
    }
    
    private void PrintTree_level_order(TreeNode root){
    	if (root == null) return;
    	
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	
    	while(!q.isEmpty()) {
    		TreeNode tmp = q.poll();
    		if (tmp == null) {
    			System.out.print("#");
    			continue;
    		}
    		System.out.print(tmp.val);
    		q.offer(tmp.left);
    		q.offer(tmp.right);
    	}
    	System.out.println();
    	
    	return;
    }
    
    public String serialize_pre_order(TreeNode root) {
    	if (root == null) return "";
    	StringBuilder res = new StringBuilder();
    	serialize_pre_order_helper(root, res);
    	
    	res.deleteCharAt(res.length()-1); // last comma 
    	System.out.println(res.toString());
    	return res.toString();
    }
    
    
    private void serialize_pre_order_helper(TreeNode root, StringBuilder res){
    	if (root == null) {
    		res.append("#" + ",");
    		return;
    	}
    	res.append(String.valueOf(root.val) + ",");
    	serialize_pre_order_helper(root.left, res);
    	serialize_pre_order_helper(root.right, res);
    	return;
    }
    
    public TreeNode deserialize_pre_order(String data) {
    	if (data == null || data.length() == 0) return null;
    	
    	String[] s = data.split(",");  
    	int[] level = {0};
    	TreeNode root = deserialize_pre_order_helper(s, level);    	
    	return root;
    }
    
    private TreeNode deserialize_pre_order_helper(String[] s, int[] level) {
    	if (s[level[0]].equals("#")) return null; 	

    	TreeNode tmp = new TreeNode(Integer.parseInt(s[level[0]])); 
    	level[0] = level[0] + 1;
    	tmp.left = deserialize_pre_order_helper(s, level);
    	level[0] = level[0] + 1;
    	tmp.right = deserialize_pre_order_helper(s, level);
   
    	return tmp;
    }
    
    public String serialize_in_order(TreeNode root) {
    	if (root == null) return "";
    	StringBuilder res = new StringBuilder();
    	serialize_in_order_helper(root, res);
    	
    	res.deleteCharAt(res.length()-1); // last comma 
    	System.out.println(res.toString());
    	return res.toString();
    }

    private void serialize_in_order_helper(TreeNode root, StringBuilder res){
    	if (root == null) {
    		res.append("#" + ",");
    		return;
    	}
    	serialize_in_order_helper(root.left, res);
    	res.append(String.valueOf(root.val) + ",");
    	serialize_in_order_helper(root.right, res);
    	return;
    }
    
    public String serialize_in_order_non_recur(TreeNode root) {
    	if (root == null) return "";
    	StringBuilder res = new StringBuilder();

    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	TreeNode p = root;
    	while(p != null) {
    		stack.push(p);
    		p = p.left;
    	}
		res.append("#" + ",");
    	
    	while(!stack.isEmpty()) {
    		TreeNode t = stack.pop();
    		if (t != null) {
    			res.append(String.valueOf(t.val) + ",");
    			if (t.right != null) {
    		    	p = t.right;
    		    	while(p != null) {
    		    		stack.push(p);
    		    		p = p.left;
    		    	}
        			res.append("#" + ",");
    			} else {
        			res.append("#" + ",");
    			}
    		} 
    		
    	}
    	
    	res.deleteCharAt(res.length()-1); // last comma 
    	System.out.println(res.toString());
    	return res.toString();
    }

   
    public String serialize_post_order(TreeNode root) {
    	if (root == null) return "";
    	StringBuilder res = new StringBuilder();
    	serialize_post_order_helper(root, res);
    	
    	res.deleteCharAt(res.length()-1); // last comma 
    	System.out.println(res.toString());
    	return res.toString();
    }

    private void serialize_post_order_helper(TreeNode root, StringBuilder res){
    	if (root == null) {
    		res.append("#" + ",");
    		return;
    	}
    	serialize_post_order_helper(root.left, res);
    	serialize_post_order_helper(root.right, res);
    	res.append(String.valueOf(root.val) + ",");
    	return;
    }
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// level order test
		System.out.println("level order");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		serializeANDdeserializeTree test = new serializeANDdeserializeTree();
		test.PrintTree_level_order(root);		

		serializeANDdeserializeTree test2 = new serializeANDdeserializeTree();
		String serialied_res = test2.serialize_level_order(root);
				
		System.out.println();
		serializeANDdeserializeTree test4 = new serializeANDdeserializeTree();
		TreeNode aaa = test4.deserialize_level_order(test4.serialize_level_order(root));
		test4.PrintTree_level_order(aaa);

		
		// pre-order test
		System.out.println();
		System.out.println("pre order serialize");
		String pre_order_str = test2.serialize_pre_order(root);
		System.out.println("pre order deserialize");
		TreeNode pre_test = test2.deserialize_pre_order(pre_order_str);
		test2.serialize_pre_order(pre_test);
		
		test2.serialize_in_order_non_recur(root);
		
		return;
	}

}
