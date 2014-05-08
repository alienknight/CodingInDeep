	/* This problem can be divided into three steps: 
	 * 1. how to split the text String 2. how to count the occurrence of each word 3. how to get the n most frequent words
	 * For step 1, I assume the text String only contains English characters and punctuation and whitespace, and the valid 
	 * word only contains English characters. So it can be solved use regex and according java APT to split the String.
	 * For step 2, I choose the Trie structure to store the occurrence of each word. It can also be solved using BST or 
	 * HashTable, but the constructed BST may not be balanced, and HashTable's hash function may not be perfect for these 
	 * words, which may cause searching time complexity be O(n), n is the number of words. While using Trie, the searching 
	 * time complexity is O(m), m is the average length of these words.
	 * For step 3, In order to find the n most frequent words, the basic concept is to construct an n size Minheap. While 
	 * in java, we can use a PriorityQueue to solve it more conveniently, and we just need to redefine the Comparator of it. 
	 */
	
	// The Trie Node structure to store each word
	public static class TrieNode {
		boolean isEnd; // Whether the end of the word
		int frequency; // The frequency of the word
		boolean inQueue; // Whether the word already in PriorityQueue
		String word; // The word
		TrieNode[] children; // Next character of the word
		public TrieNode() {
			isEnd = false;
			frequency = 0;
			inQueue = false;
			children = new TrieNode[26]; // Slots between a-z
			for(int i=0;i<children.length;i++)
				children[i] = null;
		}
	}
	
	// insert each word into PriorityQueue
	public static void insertToQueue(PriorityQueue<TrieNode> queue, TrieNode root, int n) {
		if(root.inQueue) { // root already in queue, update the queue according to the root's frequency
			queue.remove(root);
			queue.add(root);
		}
		else if(queue.size()<n) { // PriorityQueue not reach limit size, store the root directly
			queue.add(root);
			root.inQueue = true;
		}
		else {
			if(root.frequency > queue.peek().frequency) { // PriorityQueue reach limit size, compare the root with the least 
				queue.poll().inQueue = false;             // frequency node in queue, to determine whether replace 
				queue.add(root);                          // the node with root
				root.inQueue = true;
			}
		}
	}
	
	// Add word into both Trie and PriorityQueue
	public static void addToTrie(TrieNode root, String s, String ori, PriorityQueue<TrieNode> queue, int n) {	
		if(s.length()==0){ // There are no more characters in word
			if(!root.isEnd) { // If word not present
				root.isEnd = true;
				root.frequency = 1;
			}else // If word already present, add frequency by 1
				root.frequency++;
			root.word = ori; // Record the word to root
			insertToQueue(queue, root, n); // insert word into PriorityQueue
			
		}else { // There are still more characters in word
			int index = s.charAt(0) - 'a';
			if(root.children[index]==null) // The prefix not present
				root.children[index] = new TrieNode();
			addToTrie(root.children[index], s.substring(1), ori, queue, n); // Recursively check each character in word
		}
	}
	
	// Create a PriorityQueue with a defined Comparator
	public static PriorityQueue<TrieNode> createQueue(int n){
		PriorityQueue<TrieNode> queue = new PriorityQueue<TrieNode> (n, new Comparator<TrieNode>(){
			public int compare(TrieNode a, TrieNode b) {
				if(a.frequency < b.frequency) return -1;
				else if(a.frequency > b.frequency) return 1;
				else return 0;
			}
		});
		return queue;
	}
	
	// The standard to split the text String
	// Assume words to be counted only contains English characters, from a-z.
	// Assume words to be counted are not case sensitive, so  "is" and "Is" and "IS" are treated as same word.
	// Assume the frequency of each word is unique, so there will not be two different words have the same frequency, or if the
	// the least frequency in the list can be applied to two or more words, the list will only contain the first word that reach
	// this frequency.
	public static String[] standardize(String s) {
		s = s.replaceAll("[\\p{Punct}]+", ""); // Discard all punctuation in String
		String[] res = s.split(" "); // Split String with whitespace
		int j = 0;
		for(int i=0;i<res.length;i++) {
			String temp = res[i].toLowerCase().trim(); // Update each String into lowerCase and discard the extra empty String
			if(temp.length()!=0)
				res[j++] = temp;
		}
		return Arrays.copyOfRange(res, 0, j); // The Strings to be counted
	}

	// main function
	public static List<String> FindNOccurence(String s, int n) {
		List<String> list = new ArrayList<String>();
		if(s==null || n<1) return list;
		String[] res = standardize(s); // Standardize text String
		TrieNode root = new TrieNode(); // Create a root node
		PriorityQueue<TrieNode> queue = createQueue(n); 
		for(String word : res)
			addToTrie(root, word, word, queue, n); // Add each word to Trie and PriorityQueue
		while(!queue.isEmpty())
			list.add(0,queue.poll().word); // Add n most frequent words to list by frequency
		return list;		
	}